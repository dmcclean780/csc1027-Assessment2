
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
    }

// Create exhibit selector with current exhibit and set event listenr to prevent invalid selections
function createExhibitSelector(id, i, j, hallNo, options) {
    const exhibit = document.createElement('div');
    const bottomBorder = (i % 11 == 0 && i != 0) ? "border-b-2 " : "";
    const rigntBorder = (j % (hallNo - 1) == 0 && j != 0) ? "border-r-2" : "border-r";
    const colour = (i % 2 == 1) ? "green" : "gray";
    exhibit.className = 'bg-' + colour + '-400 ' + bottomBorder + rigntBorder + ' pl-2 overflow-hidden'
    exhibit.innerHTML = `<select id='` + i + j + `', name='exhibit` + id + `', class='rounded-sm flex shrink'>` +
        options +
        `</select>`
    planGrid.appendChild(exhibit)
    document.getElementById("" + i + j).selectedIndex = -1;
    const selectElement = select = document.getElementById("" + i + j)
    selectElement.value=selectedExhibits[id] // Set current exhibit
    
    // Listen for change to diable exhibits that share artifacts
    selectElement.addEventListener('change', () => {
        preventDupes(i, hallNo)
    })



}

// Disable options that shre artifacts with selected exhibits in the same month
function preventDupes(i, hallNo) {
    const allSelects = [];

    // Get all select boxes in the same month
    for (let j = 0; j < hallNo; j++) {
        allSelects.push(document.getElementById("" + i + j));
    }

    // Iterate through all selects to update options dynamically
    allSelects.forEach((select) => {
        const selectedValues = allSelects.map(s => s.value);
        updateOptions(select, selectedValues);
    });
}

// Disable options where the exhibit shares artifacts with a selected exhibit
function updateOptions(selectElement, selectedValues) {
    const options = selectElement.options;
    for (let i = 0; i < selectedValues.length; i++) {
        if (selectedValues[i] != "") {
            const exhibitsThatShare = exhibitsSharingArtifacts[selectedValues[i]]
            for (let i = 0; i < options.length; i++) {
                if (exhibitsThatShare.includes(Number(options[i].value))  && selectElement.value !== options[i].value) {
                    options[i].disabled = true; // Disable exhibit that share artifacts
                } else {
                    options[i].disabled = false; // Re-enable non-duplicates
                }
            }
        }

    }
}