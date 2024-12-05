
window.onload = () => {
    const hallInput = document.getElementById("hallNoInputHidden");

    let options = "";
    for (let i = 0; i < exhibitData.length; i++) {
        const exhibit = exhibitData[i];
        options += `<option value='` + exhibit.ID + `'>` + exhibit.Name + `</option>`;
    }

        const hallNo = parseInt(hallInput.value)

        //Update grid styling columns
        const planGrid = document.getElementById('planGrid')
        planGrid.className = 'grid grid-cols-[repeat('+(hallNo+1)+',minmax(0,max-content))] grid-rows-12  w-full'
        planGrid.replaceChildren() // empty grid

        // First Row
        const corner = document.createElement('div')
        corner.className = 'bg-green-500 border-t-2 border-l-2 border-r border-b'
        planGrid.appendChild(corner)
        for (let i = 0; i < hallNo; i++) { // Hall Titles
            const hallTitle = document.createElement('div');
            const rigntBorder = (i % (hallNo - 1) == 0 && i != 0) ? "border-r-2" : "border-r";
            hallTitle.className = 'flex grow font-bold bg-green-500 border-t-2 ' + rigntBorder + ' border-b pl-2'
            hallTitle.innerHTML = 'Hall ' + (i + 1)
            planGrid.appendChild(hallTitle)
        }
        id = 0 // ID of next exhibit box
        for (let i = 0; i < months.length; i++) { // Create each row
            // Create month title
            const month = document.createElement('div');
            const bottomBorder = (i % 11 == 0 && i != 0) ? "border-b-2 " : "";
            const colour = (i % 2 == 1) ? "green" : "gray";
            month.className = 'bg-' + colour + '-400 pl-2 flex grow font-bold border-l-2 border-r pr-2' + bottomBorder
            month.innerHTML = months[i]
            planGrid.appendChild(month)
            // Create exhibit for each hall
            for (let j = 0; j < hallNo; j++) {
                createExhibitSelector(id, i, j, hallNo, options)
                id++
            }
        }
        for (let i = 0; i < months.length; i++) { 
            preventDupes(i, hallNo)
        }
    }

// Create exhibit selector with current exhibit and set event listenr to prevent invalid selections
function createExhibitSelector(id, i, j, hallNo, options) {
    const exhibit = document.createElement('div');
    const bottomBorder = (i % 11 == 0 && i != 0) ? "border-b-2 " : "";
    const rigntBorder = (j % (hallNo - 1) == 0 && j != 0) ? "border-r-2" : "border-r";
    const colour = (i % 2 == 1) ? "green" : "gray";
    exhibit.className = 'bg-' + colour + '-400 ' + bottomBorder + rigntBorder + ' pl-2 overflow-hidden'
    exhibit.innerHTML = `<select id='` + id + `', name='exhibit` + id + `', class='rounded-sm flex shrink'>` +
        options +
        `</select>`
    planGrid.appendChild(exhibit)
    document.getElementById("" + id).selectedIndex = -1;
    const selectElement = select = document.getElementById("" + id)
    selectElement.value=selectedExhibits[id] // Set current exhibit
    // Listen for change to diable exhibits that share artifacts
    selectElement.addEventListener('change', () => {
        preventDupes(i, hallNo)
    })



}

// Disable options that shre artifacts with selected exhibits in the same month
function updateOptions(selectElement, selectedValues) {
    const options = selectElement.options;

    // Keep track of exhibits that should be disabled
    const disableMap = {};
    selectedValues.forEach(value => {
        if (value !== "") {
            exhibitsSharingArtifacts[value].forEach(sharedExhibit => {
                disableMap[sharedExhibit] = true;
            });
        }
    });

    // Iterate over options to disable/enable based on the disableMap
    for (let i = 0; i < options.length; i++) {
        const optionValue = Number(options[i].value);
        if (disableMap[optionValue] && selectElement.value != options[i].value) {
            options[i].disabled = true;
        } else {
            options[i].disabled = false;
        }
    }
}

// Ensure that preventDupes updates all selects consistently
function preventDupes(i, hallNo) {
    const allSelects = [];

    // Collect all select boxes in the same month
    for (let j = 0; j < hallNo; j++) {
        allSelects.push(document.getElementById("" + (j + i * hallNo)));
    }

    // Get currently selected values for all select boxes
    const selectedValues = allSelects.map(s => s.value);

    // Update options for each select box based on selectedValues
    allSelects.forEach(select => updateOptions(select, selectedValues));
}
