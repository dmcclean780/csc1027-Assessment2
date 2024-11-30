let artifactNo = 0;

function addArtifact() {
    const artifactListData = artifactManagementData;
    console.log(artifactListData)
    let options = "";
    for (let i = 0; i < artifactListData.length; i++) {
        const artifact = artifactListData[i];
        options += `<option value='` + artifact.ID + `'>` + artifact.Name + `</option>`;
    }
    console.log(options)
    const exhibitRoute = document.getElementById('exhibitRoute');
    const newDiv = document.createElement('div');
    newDiv.innerHTML = `<div class = 'flex flex-row my-2 w-full id='step` + artifactNo + `'>
                                <div class='px-2 w-1/2'>
                                    <select id='artifact`+ artifactNo + `', name='artifact`+ artifactNo + `', class='rounded-sm'>` +
        options +
        `</select>
                                </div>
                                <input type='text' id='sign`+ artifactNo + `' name='sign` + artifactNo + `' required class='rounded-sm w-1/2 mx-2 px-1'>
                                
                        </div>`
    exhibitRoute.appendChild(newDiv)
    artifactNo++;
    document.getElementById('artifactCount').value = artifactNo;
    document.getElementById(`artifact${artifactNo - 1}`).selectedIndex = -1;

    //if(artifactNo>1){
    const selectElement = select = document.getElementById(`artifact${artifactNo - 1}`)

    const allSelects = [];
    for (let i = 0; i < artifactNo; i++) {
        allSelects.push(document.getElementById(`artifact${i}`));
    }

    // Iterate through all selects to update options dynamically
    allSelects.forEach((select) => {
        const selectedValues = allSelects.map(s => s.value);
        updateOptions(select, selectedValues);
    });

    selectElement.addEventListener('change', () => {
        const allSelects = [];
        for (let i = 0; i < artifactNo; i++) {
            allSelects.push(document.getElementById(`artifact${i}`));
        }

        // Iterate through all selects to update options dynamically
        allSelects.forEach((select) => {
            const selectedValues = allSelects.map(s => s.value);
            updateOptions(select, selectedValues);
        });
    });
    // }

}

function updateOptions(selectElement, selectedValues) {
    const options = selectElement.options;
    for (let i = 0; i < options.length; i++) {
        if (selectedValues.includes(options[i].value) && selectElement.value !== options[i].value) {
            options[i].disabled = true; // Disable duplicate
        } else {
            options[i].disabled = false; // Re-enable non-duplicates
        }
    }

}

function removeArtifact() {
    var select = document.getElementById('exhibitRoute');
    select.removeChild(select.lastChild);
    artifactNo--;
    document.getElementById('artifactCount').value = artifactNo;
}

window.onload = function() {
    const artifacts = artifactData;
    const route = routeData;

    for(let i=0; i<artifacts.length; i++){
        addArtifact();
        console.log(artifacts[i]);
        document.getElementById(`artifact`+i).value=artifacts[i]
        document.getElementById(`sign`+i).value=route[i]
    }
  };