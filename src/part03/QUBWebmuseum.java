package part03;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import part01.Artifact;
import part01.ArtifactManagement;
import part01.DefaultData;
import part01.ExhibitManagement;
import part01.ExhibitionPlan;
import web.Response;
import web.WebInterface;
import web.WebRequest;

public class QUBWebmuseum {

    private ArtifactManagement artifactManagement; // Manages all direct interactions with artifacts from a museum
                                                   // object
    private ExhibitManagement exhibitManagement; // Manages all direct interactions with exhibits from a museum object
    private ExhibitionPlan exhibitionPlan; // Stores the annual plan for the museum

    public static void main(String[] args) {
        QUBWebmuseum museum = new QUBWebmuseum();
        museum.popArtifacts();
        //museum.popExhibits();
        //museum.popPlan();
        museum.launchMuseumWebsite("QUB Museum");
    }
    
    /**
     * populate artifactManagement with the default artifacts
     */
    private void popArtifacts() {
        try {
            this.artifactManagement = new ArtifactManagement(DefaultData.populateArtifacts());
        } catch (Exception e) {
            System.err.println("null in artifacts");
        }
    }

    /**
     * populate exhibitManagement with the default exhibits
     */
    private void popExhibits() {
        try {
            this.exhibitManagement = new ExhibitManagement(DefaultData.populateExhibits());
        } catch (Exception e) {
            System.err.println("null in artifacts");
        }
    }

    /**
     * Populate exhibitionPlan with the default exhibits
     */
    private void popPlan() {
        try {
            this.exhibitionPlan = new ExhibitionPlan(DefaultData.populateExhibitionPlan(), exhibitManagement);
        } catch (Exception e) {
            System.out.println("Bad Data");
        }
    }
    
    
    public void launchMuseumWebsite(String title) {
        final String ROOT = "./";
        WebInterface winterface = new WebInterface(9990);
        ArrayList<WebRequest> wqueue = new ArrayList<WebRequest>();

        WebInterface.launchBrowser("http://localhost:9990");

        while (true) {
            winterface.getQueue(wqueue);
            for (int i = 0; i < wqueue.size(); i++) {
                WebRequest wr = wqueue.get(i);
                System.out.println(wr.path);

                if (wr.path.equals("")) {

                    String[] menuOptions = {"Manage Artifacts", "Manage Exhibits", "Manage Annual Plan"};
                    Menu mainMenu = new Menu(menuOptions, "");
                    Page page = new Page(title, mainMenu.toString(), "Main Menu", "");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if(wr.path.equalsIgnoreCase("manage_artifacts")){

                    String[] menuOptions = {"Add Artifact", "View Artifact", "Update Artifact", "Delete Artifact"};
                    Menu mainMenu = new Menu(menuOptions, "manage_artifacts");
                    Page page = new Page(title, mainMenu.toString(), "Artifact Management", "");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if(wr.path.equalsIgnoreCase("manage_artifacts/add_artifact")){

                    ArtifactForm artifactForm = new ArtifactForm();
                    Page page = new Page(title, artifactForm.toString(), "Add Artifact", "manage_artifacts");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if(wr.path.equalsIgnoreCase("manage_artifacts/add_artifact/create_artifact")){

                    String uri = "/manage_artifacts/add_artifact";
					
					String myName = wr.parms.get("myNameInForm");
					String myType = wr.parms.get("myTypeInForm");
                    int myTime = Integer.valueOf(wr.parms.get("myTimeInForm"));
					
                    artifactManagement.addArtifact(myName, myType, myTime);
					
					wr.r = new Response( WebRequest.HTTP_REDIRECT, WebRequest.MIME_HTML,
							   "<html><body>Redirected: <a href=\"" + uri + "\">" +
							   uri + "</a></body></html>");
					wr.r.addHeader( "Location", uri );

                } else if(wr.path.equalsIgnoreCase("manage_artifacts/view_artifact")){

                    ArtifactsList artifactsList = new ArtifactsList(artifactManagement, "manage_artifacts/view_artifact");
                    Page page = new Page(title, artifactsList.toString(), "View Artifact", "manage_artifacts");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if(wr.path.equalsIgnoreCase("manage_artifacts/search_artifact")){

                    String uri = wr.parms.get("currentPage");
					
					int searchCriteria = Integer.valueOf(wr.parms.get("criteriaChoice"));

					String SearchValue = wr.parms.get("textInputInForm") + wr.parms.get("numberInputInForm");
					
                    artifactManagement.searchArtifacts(searchCriteria, SearchValue);
					
					wr.r = new Response( WebRequest.HTTP_REDIRECT, WebRequest.MIME_HTML,
							   "<html><body>Redirected: <a href=\"" + uri + "\">" +
							   uri + "</a></body></html>");
					wr.r.addHeader( "Location", uri );

                } else if(wr.path.startsWith("manage_artifacts/view_artifact/")){
                    int artifactID = Integer.parseInt(wr.path.substring("manage_artifacts/view_artifact/".length()));

                    Page page = new Page(title, "", "View Artifact", "manage_artifacts/view_artifact");
                    try{
                        Artifact artifact = artifactManagement.findArtifact(artifactID);
                        ArtifactView artifactView = new ArtifactView(artifact);
                        page = new Page(title, artifactView.toString(), artifact.getName(), "manage_artifacts/view_artifact");
                    } catch(Exception e){

                    }

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());
                
                } else if(wr.path.equalsIgnoreCase("manage_exhibits")){

                    String[] menuOptions = {"Add Exhibit", "View Exhibit", "Update Exhibit", "Delete Exhibit"};
                    Menu mainMenu = new Menu(menuOptions, "manage_exhibits");
                    Page page = new Page(title, mainMenu.toString(), "Exhibit Management", "");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if(wr.path.equalsIgnoreCase("manage_annual_plan")){

                    String[] menuOptions = {"Create Annual Plan", "View Annual Plan", "Update Annual Plan", "Delete Annual Plan"};
                    Menu mainMenu = new Menu(menuOptions, "manage_annual_plan");
                    Page page = new Page(title, mainMenu.toString(), "Annual Plan Management", "");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                }
                
                else {
                    // This code will look on disk for a file, change the ROOT variable to load
                    // files from a different directory
                    File f = new File(ROOT + wr.path);
                    if (f.exists()) {
                        try {
                            long maxlen = f.length();
                            FileInputStream fis = new FileInputStream(f);

                            // This range and offset code enables a webserver to request part of a file,
                            // this supports applications like streaming video
                            long startFrom = 0;
                            long endat = -1;
                            long rangebytes = -1;
                            String resulttype = WebRequest.HTTP_OK;
                            String range = wr.parms.get("Range");
                            String rangeend = null;
                            if (range != null) {
                                System.out.println(range);
                                if (range.startsWith("bytes=")) {
                                    resulttype = WebRequest.HTTP_PARTIAL;
                                    range = range.substring("bytes=".length());
                                    int minus = range.indexOf('-');
                                    if (minus > 0) {
                                        rangeend = range.substring(minus + 1);
                                        range = range.substring(0, minus);
                                    }
                                    try {
                                        startFrom = Long.parseLong(range);
                                        endat = Long.parseLong(rangeend);
                                    } catch (NumberFormatException nfe) {
                                        rangebytes = 512 * 1024;
                                        if (rangebytes > (maxlen - startFrom)) {
                                            resulttype = WebRequest.HTTP_OK;
                                            rangebytes = (maxlen - startFrom);
                                        } else {
                                            resulttype = WebRequest.HTTP_PARTIAL;
                                        }
                                    }

                                }
                                if (endat != -1) {
                                    rangebytes = endat - startFrom;
                                } else {
                                    rangebytes = (maxlen - startFrom);
                                }
                            } else {
                                long chunk = 100 * 1024 * 1024;
                                rangebytes = maxlen - startFrom;
                                if (rangebytes > chunk) {
                                    rangebytes = chunk;
                                    resulttype = WebRequest.HTTP_PARTIAL;
                                }
                            }

                            try {
                                fis.skip(startFrom);
                            } catch (Exception e) {
                                System.out.println(e.toString());
                            }

                            String mime = WebRequest.getMimeType(wr.path);

                            wr.r = new Response(resulttype, mime, rangebytes, fis);
                            wr.r.addHeader("Content-length", "" + (rangebytes));
                            wr.r.addHeader("Content-range", "bytes " + startFrom + "-" +
                                    (startFrom + rangebytes - 1) + "/" + maxlen);
                        } catch (Exception e) {
                            wr.r = new Response(WebRequest.HTTP_NOTFOUND, WebRequest.MIME_HTML, "");
                        }
                    } else {
                        wr.r = new Response(WebRequest.HTTP_NOTFOUND, WebRequest.MIME_HTML, "");
                    }
                }

                Thread t = new Thread(wr);
                t.setDaemon(true);
                t.start();
            }

            try {
                wqueue.clear();
                Thread.sleep(10);
            } catch (Exception e) {

            }
        }
    }
}
