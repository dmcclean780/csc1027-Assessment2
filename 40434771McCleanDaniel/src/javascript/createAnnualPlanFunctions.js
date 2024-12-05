// Create a listenr to create the select boxes for the annual plan when the hallNo input changes value
window.onload = () => {
    const hallInput = document.getElementById("hallNoInput");
    
    let options = "";

    // options for the exhibit select boxes using the exhibitsJSON data 
    for (let i = 0; i < exhibitData.length; i++) {
        const exhibit = exhibitData[i];
        options += `<option value='` + exhibit.ID + `'>` + exhibit.Name + `</option>`;
    }

    // listener to create the plan input boxes when hallNo changes
    hallInput.addEventListener('change', () => {
        // get new value and set hidden input to this value
        const hallNo = parseInt(hallInput.value)
        document.getElementById('hallNoInputHidden').value = hallNo
        // change grid column number
        const planGrid = document.getElementById('planGrid')
        planGrid.className = 'grid grid-cols-[repeat('+(hallNo+1)+',minmax(0,max-content))] grid-rows-12  w-full'
        // Clear Grid
        planGrid.replaceChildren()

        // First Row
        const corner = document.createElement('div')
        corner.className = 'bg-green-500 border-t-2 border-l-2 border-r border-b'
        planGrid.appendChild(corner)
        // Hall Titles
        for (let i = 0; i < hallNo; i++) {
            const hallTitle = document.createElement('div');
            const rigntBorder = (i % (hallNo - 1) == 0 && i != 0) ? "border-r-2" : "border-r";
            hallTitle.className = 'font-bold bg-green-500 border-t-2 ' + rigntBorder + ' border-b pl-2'
            hallTitle.innerHTML = 'Hall ' + (i + 1)
            planGrid.appendChild(hallTitle)
        }
        
        // Content Rows: Month exhibit*hallNo
        // id for the next exhibit box
        id = 0
        for (let i = 0; i < months.length; i++) {
            // Create month box
            const month = document.createElement('div');
            const bottomBorder = (i % 11 == 0 && i != 0) ? "border-b-2 " : "";
            const colour = (i % 2 == 1) ? "green" : "gray";
            month.className = 'bg-' + colour + '-400 px-2 font-bold border-l-2 border-r ' + bottomBorder
            month.innerHTML = months[i]
            planGrid.appendChild(month)

            // Create an exhibit select for each hall
            for (let j = 0; j < hallNo; j++) {
                createExhibitSelector(id, i, j, hallNo, options)
                id++
            }
        }
    })
    
};

// Create a new select tag for all the exhibits
function createExhibitSelector(id, i, j, hallNo, options) {
    const exhibit = document.createElement('div');
    const bottomBorder = (i % 11 == 0 && i != 0) ? "border-b-2 " : "";
    const rigntBorder = (j % (hallNo - 1) == 0 && j != 0) ? "border-r-2" : "border-r";
    const colour = (i % 2 == 1) ? "green" : "gray";
    exhibit.className = 'bg-' + colour + '-400 ' + bottomBorder + rigntBorder + ' px-2 py-1 overflow-hidden'
    exhibit.innerHTML = `<select id='` + id + `', name='exhibit` + id + `', class='rounded-sm'>` +
        options +
        `</select>`
    planGrid.appendChild(exhibit)

    const selectElement = select = document.getElementById(""+id)
    selectElement.selectedIndex = -1; // Ensure no exhibit selected by default

    // Add a listenr on each dropdown to prevent exhibits that share artifacts being in the same Month
    selectElement.addEventListener('change', () => {
        preventDupes(i, hallNo)
    })



}

// Disables all options that share artifacts with other exhibits in the same month
function preventDupes(i, hallNo) {
    const allSelects = [];
    for (let j = 0; j < hallNo; j++) {
        allSelects.push(document.getElementById("" + i + j));
    }

    // Iterate through all selects to update options dynamically
    allSelects.forEach((select) => {
        const selectedValues = allSelects.map(s => s.value);
        updateOptions(select, selectedValues);
    });
}

// Checks each option in the select against the other selected values 
// in  other selects and diables duplicte artifact exhibits
function updateOptions(selectElement, selectedValues) {
    const options = selectElement.options;
    for (let i = 0; i < selectedValues.length; i++) { //For all the selected values
        if (selectedValues[i] != "") { // if a value is selected
            const exhibitsThatShare = exhibitsSharingArtifacts[selectedValues[i]] // get the exhibit IDs that share artifacts with this exhibit
            for (let i = 0; i < options.length; i++) { // Check every option if it is not the selected 
                                                       // one for this box and is in the list of exhibits that share artifacts
                if (exhibitsThatShare.includes(Number(options[i].value))  && selectElement.value !== options[i].value) {
                    options[i].disabled = true; // Disable exhibit that share artifacts
                } else {
                    options[i].disabled = false; // Re-enable non-duplicates
                }
            }
        }

    }
}