function navigate(pageTitle){
    pageTitle= pageTitle.replace(" ", "_")
    window.location.href = "/"+pageTitle;

}

function showID(x){
    if (x.checked) {
        document.getElementById("NameInputDIV").style.display = "none";
        document.getElementById("TypeInputDIV").style.display = "none";
        document.getElementById("TimeInputDIV").style.display = "none";
        document.getElementById("NameInputDIV").value = "";
        document.getElementById("TypeInputDIV").value = "";
        document.getElementById("TimeInputDIV").value = "";
        document.getElementById("IDInputDIV").style.display = "block";
    }
}

function showName(x){
    if (x.checked) {
        document.getElementById("IDInputDIV").style.display = "none";
        document.getElementById("TypeInputDIV").style.display = "none";
        document.getElementById("TimeInputDIV").style.display = "none";
        document.getElementById("IDInputDIV").value = "";
        document.getElementById("TypeInputDIV").value = "";
        document.getElementById("TimeInputDIV").value = "";
        document.getElementById("NameInputDIV").style.display = "block";
    }
}

function showType(x){
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

function showTime(x){
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