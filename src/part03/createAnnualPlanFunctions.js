let id = 0

window.onload = () => {
    const hallInput = document.getElementById("hallNoInput");

    let options = "";
    console.log(exhibitData)
    for (let i = 0; i < exhibitData.length; i++) {
        const exhibit = exhibitData[i];
        options += `<option value='` + exhibit.ID + `'>` + exhibit.Name + `</option>`;
    }

    hallInput.addEventListener('change', () => {

        const hallNo = parseInt(hallInput.value)
        document.getElementById('hallNoInputHidden').value = hallNo
        const planGrid = document.getElementById('planGrid')
        planGrid.className = 'grid grid-rows-13 grid-cols-' + (hallNo + 1) + ' bg-gray-400 p-4 rounded-lg'
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
            month.className = 'bg-' + colour + '-400 pl-2 font-bold border-l-2 border-r ' + bottomBorder
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
    exhibit.className = 'bg-' + colour + '-400 ' + bottomBorder + rigntBorder + ' pl-2'
    exhibit.innerHTML = `<select id='` + i + j + `', name='exhibit` + id + `', class='rounded-sm'>` +
        options +
        `</select>`
    planGrid.appendChild(exhibit)
    document.getElementById("" + i + j).selectedIndex = -1;
    const selectElement = select = document.getElementById("" + i + j)

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
            console.log(typeof exhibitsThatShare[0])
            for (let i = 0; i < options.length; i++) {
                console.log(typeof options[i].value)
                console.log(exhibitsThatShare.includes(Number(options[i].value)))
                if (exhibitsThatShare.includes(Number(options[i].value))  && selectElement.value !== options[i].value) {
                    options[i].disabled = true; // Disable exhibit that share artifacts
                } else {
                    options[i].disabled = false; // Re-enable non-duplicates
                }
            }
        }

    }
}