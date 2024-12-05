// Global navigate function available to all pages
function navigate(pageTitle) {
    pageTitle = pageTitle.replaceAll(" ", "_")
    window.location.href = "/" + pageTitle;

}


