function navigate(pageTitle){
    pageTitle= pageTitle.replace(" ", "_")
    window.location.href = "/"+pageTitle;

}