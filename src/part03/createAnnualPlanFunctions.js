let id = 0

window.onload = () => {
    const hallInput = document.getElementById("hallNoInput");
    
    let options = "";
    for (let i = 0; i < exhibitData.length; i++) {
        const exhibit = exhibitData[i];
        options += `<option value='` + exhibit.ID + `'>` + exhibit.Name + `</option>`;
    }

    hallInput.addEventListener('change', () => {

        const hallNo = parseInt(hallInput.value)
        document.getElementById('hallNoInputHidden').value = hallNo
        const planGrid = document.getElementById('planGrid')
        planGrid.className = 'grid grid-cols-[repeat('+(hallNo+1)+',minmax(0,max-content))] grid-rows-12  w-full'
        planGrid.replaceChildren()
        const corner = document.createElement('div')
        corner.className = 'bg-green-500 border-t-2 border-l-2 border-r border-b'
        planGrid.appendChild(corner)
        for (let i = 0; i < hallNo; i++) {
            const hallTitle = document.createElement('div');
            const rigntBorder = (i % (hallNo - 1) == 0 && i != 0) ? "border-r-2" : "border-r";
            hallTitle.className = 'font-bold bg-green-500 border-t-2 ' + rigntBorder + ' border-b pl-2'
            hallTitle.innerHTML = 'Hall ' + (i + 1)
            planGrid.appendChild(hallTitle)
        }
        id = 0
        for (let i = 0; i < months.length; i++) {
            const month = document.createElement('div');
            const bottomBorder = (i % 11 == 0 && i != 0) ? "border-b-2 " : "";
            const colour = (i % 2 == 1) ? "green" : "gray";
            month.className = 'bg-' + colour + '-400 px-2 font-bold border-l-2 border-r ' + bottomBorder
            month.innerHTML = months[i]
            planGrid.appendChild(month)
            for (let j = 0; j < hallNo; j++) {
                createExhibitSelector(id, i, j, hallNo, options)
                id++
            }
        }
    })
    
};

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
    document.getElementById(""+id).selectedIndex = -1;
    console.log(document.getElementById(""+id))
    const selectElement = select = document.getElementById(""+id)

    selectElement.addEventListener('change', () => {
        preventDupes(i, hallNo)
    })



}

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