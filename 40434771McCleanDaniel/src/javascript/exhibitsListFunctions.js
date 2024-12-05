
// Controls visibilty of text input for searching exhibits
function showID(x) {
    if (x.checked) {
        document.getElementById("NameInputDIV").style.display = "none";
        document.getElementById("NameInputDIV").value = "";
        document.getElementById("IDInputDIV").style.display = "block";
    }
}

function showName(x) {
    if (x.checked) {
        document.getElementById("IDInputDIV").style.display = "none";
        document.getElementById("IDInputDIV").value = "";

        document.getElementById("NameInputDIV").style.display = "block";
    }
}