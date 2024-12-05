let artifactNo = 0; // Global count of the total number of artifacts added

//Function for adding artifact selcto and route text
function addArtifact() {
    const artifactListData = artifactManagementData;
    // Create artifact slecect options
    let options = "";
    for (let i = 0; i < artifactListData.length; i++) {
        const artifact = artifactListData[i];
        options += `<option value='` + artifact.ID + `'>` + artifact.Name + `</option>`;
    }

    const exhibitRoute = document.getElementById('exhibitRoute');

    // Add ne artifact select and sign text input
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
    // Set hidden artifcatNo input in the form
    document.getElementById('artifactCount').value = artifactNo;
    
    // Ensure no artifact selected by default
    const selectElement = select = document.getElementById(`artifact${artifactNo - 1}`)
    selectElement.selectedIndex = -1;

    // Get all the artifact select boxes
    const allSelects = [];
    for (let i = 0; i < artifactNo; i++) {
        allSelects.push(document.getElementById(`artifact${i}`));
    }

    // Iterate through all selects to update options dynamically to disable selected artifacts
    allSelects.forEach((select) => {
        const selectedValues = allSelects.map(s => s.value);
        updateOptions(select, selectedValues);
    });

    // Update the diasbled items every time the select box changes value
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

// iterate through all the options and disable thos that are selected in anouther box
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

// Rove the last artifact and sign created
function removeArtifact() {
    var select = document.getElementById('exhibitRoute');
    select.removeChild(select.lastChild);
    artifactNo--;
    document.getElementById('artifactCount').value = artifactNo;
}

// For updating, create and assign values to artifact and signs for each in the exhibit
window.onload = function() {
    const artifacts = artifactData;
    const route = routeData;

    for(let i=0; i<artifacts.length; i++){
        addArtifact();
        document.getElementById(`artifact`+i).value=artifacts[i]
        document.getElementById(`sign`+i).value=route[i]
    }
  };