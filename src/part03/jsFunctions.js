function navigate(pageTitle) {
    pageTitle = pageTitle.replace(" ", "_")
    window.location.href = "/" + pageTitle;

}

function showID(x, type) {
    if (x.checked) {
        document.getElementById("NameInputDIV").style.display = "none";
        document.getElementById("NameInputDIV").value = "";
        if (type == "artifact") {
            document.getElementById("TypeInputDIV").style.display = "none";
            document.getElementById("TimeInputDIV").style.display = "none";
            document.getElementById("TypeInputDIV").value = "";
            document.getElementById("TimeInputDIV").value = "";
        }
        document.getElementById("IDInputDIV").style.display = "block";
    }
}

function showName(x, type) {
    if (x.checked) {
        document.getElementById("IDInputDIV").style.display = "none";
        document.getElementById("IDInputDIV").value = "";
        if (type == "artifact") {
            document.getElementById("TypeInputDIV").style.display = "none";
            document.getElementById("TimeInputDIV").style.display = "none";
            document.getElementById("TypeInputDIV").value = "";
            document.getElementById("TimeInputDIV").value = "";
        }

        document.getElementById("NameInputDIV").style.display = "block";
    }
}

function showType(x) {
    if (x.checked) {
        document.getElementById("IDInputDIV").style.display = "none";
        document.getElementById("NameInputDIV").style.display = "none";
        document.getElementById("TimeInputDIV").style.display = "none";
        document.getElementById("IDInputDIV").value = "";
        document.getElementById("NameInputDIV").value = "";
        document.getElementById("TimeInputDIV").value = "";
        document.getElementById("TypeInputDIV").style.display = "block";
    }
}

function showTime(x) {
    if (x.checked) {
        document.getElementById("IDInputDIV").style.display = "none";
        document.getElementById("TypeInputDIV").style.display = "none";
        document.getElementById("NameInputDIV").style.display = "none";
        document.getElementById("IDInputDIV").value = "";
        document.getElementById("TypeInputDIV").value = "";
        document.getElementById("NameInputDIV").value = "";
        document.getElementById("TimeInputDIV").style.display = "block";
    }
}

function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

function filterFunction() {
    var input, filter, ul, li, a, i;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    div = document.getElementById("myDropdown");
    a = div.getElementsByTagName("a");
    for (i = 0; i < a.length; i++) {
        txtValue = a[i].textContent || a[i].innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            a[i].style.display = "";
        } else {
            a[i].style.display = "none";
        }
    }
}

let artifactNo = 0;

function addArtifact() {
    const artifactData = artifactManagementData;
    console.log(artifactData)
    let options = "";
    for (let i = 0; i < artifactData.length; i++) {
        const artifact = artifactData[i];
        options += `<option value='` + artifact.ID + `'>` + artifact.Name + `</option>`;
    }
    console.log(options)
    const exhibitRoute = document.getElementById('exhibitRoute');
    const newDiv = document.createElement('div');
    newDiv.innerHTML = `<div class = 'flex flex-row my-2 w-full id='step` + artifactNo + `'>
                                <div class='px-2 w-2/5'>
                                    <select id='artifact`+ artifactNo + `', name='artifact`+ artifactNo + `', class='rounded-sm'>` +
        options +
        `</select>
                                </div>
                                <input type='text' id='sign`+ artifactNo + `' name='sign` + artifactNo + `' required class='rounded-sm w-2/5 mx-2 px-1'>
                                
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

function preventDupes(select, index) {
    var options = select.options,
        len = options.length;
    while (len--) {
        options[len].disabled = false;
    }
    select.options[index].disabled = true;
    if (index === select.selectedIndex) {
        alert('You\'ve already selected the item "' + select.options[index].text + '".\n\nPlease choose another.');
        this.selectedIndex = 0;
    }
}