package part03;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import part01.Artifact;
import part01.ArtifactManagement;
import part01.DefaultData;
import part01.Exhibit;
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
        museum.popExhibits();
        museum.popPlan();
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
        final String ROOT = "src/";
        WebInterface winterface = new WebInterface(9990);
        ArrayList<WebRequest> wqueue = new ArrayList<WebRequest>();

        WebInterface.launchBrowser("http://localhost:9990");

        while (true) {
            winterface.getQueue(wqueue);
            for (int i = 0; i < wqueue.size(); i++) {
                WebRequest wr = wqueue.get(i);
                System.out.println(wr.path);

                if (wr.path.equals("")) {

                    String[] menuOptions = { "Manage Artifacts", "Manage Exhibits", "Manage Annual Plan" };
                    Menu mainMenu = new Menu(menuOptions, "");
                    Page page = new Page(title, mainMenu.toString(), "Main Menu", "");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.equalsIgnoreCase("manage_artifacts")) {
                    artifactManagement.refreshArtifactArray();
                    String[] menuOptions = { "Add Artifact", "View Artifact", "Update Artifact", "Delete Artifact" };
                    Menu mainMenu = new Menu(menuOptions, "manage_artifacts");
                    Page page = new Page(title, mainMenu.toString(), "Artifact Management", "");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.equalsIgnoreCase("manage_artifacts/add_artifact")) {

                    AddArtifact artifactForm = new AddArtifact();
                    Page page = new Page(title, artifactForm.toString(), "Add Artifact", "manage_artifacts");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.equalsIgnoreCase("manage_artifacts/add_artifact/create_artifact")) {
                    
                    String url = "/manage_artifacts/add_artifact";

                    String myName = wr.parms.get("myNameInForm");
                    String myType = wr.parms.get("myTypeInForm");
                    int myTime = Integer.valueOf(wr.parms.get("myTimeInForm"));

                    String image = wr.parms.get("image");
                    System.out.println(image);
                    Path source = FileSystems.getDefault().getPath(image);
                    Path target = FileSystems.getDefault().getPath(ROOT, "images", "artifacts",
                            Artifact.getNextID() + ".jpeg");
                    try {
                        Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
                        FileUtils.cleanDirectory(new File(ROOT + "images/temp"));
                    } catch (Exception e) {

                    }
                    artifactManagement.addArtifact(myName, myType, myTime);
                    artifactManagement.refreshArtifactArray();
                    wr.r = new Response(WebRequest.HTTP_REDIRECT, WebRequest.MIME_HTML,
                            "<html><body>Redirected: <a href=\"" + url + "\">" +
                                    url + "</a></body></html>");
                    wr.r.addHeader("Location", url);

                } else if (wr.path.equalsIgnoreCase("manage_artifacts/view_artifact")) {

                    ArtifactsList artifactsList = new ArtifactsList(artifactManagement,
                            "manage_artifacts/view_artifact");
                    Page page = new Page(title, artifactsList.toString(), "View Artifact", "manage_artifacts");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.startsWith("manage_artifacts/view_artifact/")) {
                    int artifactID = Integer.parseInt(wr.path.substring("manage_artifacts/view_artifact/".length()));

                    Page page = new Page(title, "", "View Artifact", "manage_artifacts/view_artifact");
                    try {
                        Artifact artifact = artifactManagement.findArtifact(artifactID);
                        ViewArtifact artifactView = new ViewArtifact(artifact);
                        page = new Page(title, artifactView.toString(), artifact.getName(),
                                "manage_artifacts/view_artifact");
                    } catch (Exception e) {

                    }

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.equalsIgnoreCase("manage_artifacts/update_artifact")) {

                    ArtifactsList artifactsList = new ArtifactsList(artifactManagement,
                            "manage_artifacts/update_artifact");
                    Page page = new Page(title, artifactsList.toString(), "Update Artifact", "manage_artifacts");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.equalsIgnoreCase("manage_artifacts/update_artifact/update")) {

                    int ID = Integer.parseInt(wr.parms.get("ID"));
                    String myName = wr.parms.get("myNameInForm");
                    String myType = wr.parms.get("myTypeInForm");
                    String myTime = wr.parms.get("myTimeInForm");

                    String url = "/manage_artifacts/update_artifact";

                    String image = wr.parms.get("image");

                    if (!image.startsWith(ROOT + "images/temp/_")) {
                        Path source = FileSystems.getDefault().getPath(image);
                        Path target = FileSystems.getDefault().getPath(ROOT, "images", "artifacts",
                                ID + ".jpeg");
                        try {
                            Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
                            FileUtils.cleanDirectory(new File(ROOT + "images/temp"));
                        } catch (Exception e) {

                        }
                    }

                    artifactManagement.updateArtifactByID(myName, myType, myTime, ID);
                    artifactManagement.refreshArtifactArray();
                    wr.r = new Response(WebRequest.HTTP_REDIRECT, WebRequest.MIME_HTML,
                            "<html><body>Redirected: <a href=\"" + url + "\">" +
                                    url + "</a></body></html>");
                    wr.r.addHeader("Location", url);

                } else if (wr.path.startsWith("manage_artifacts/update_artifact/")) {

                    int artifactID = Integer.parseInt(wr.path.substring("manage_artifacts/update_artifact/".length()));

                    Page page = new Page(title, "", "Update Artifact", "manage_artifacts/update_artifact");
                    try {
                        Artifact artifact = artifactManagement.findArtifact(artifactID);
                        UpdateArtifact updateArtifact = new UpdateArtifact(artifact);
                        page = new Page(title, updateArtifact.toString(), artifact.getName(),
                                "manage_artifacts/update_artifact");
                    } catch (Exception e) {

                    }

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.equalsIgnoreCase("manage_artifacts/delete_artifact")) {

                    ArtifactsList artifactsList = new ArtifactsList(artifactManagement,
                            "manage_artifacts/delete_artifact");
                    Page page = new Page(title, artifactsList.toString(), "Delete Artifact", "manage_artifacts");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.startsWith("manage_artifacts/delete_artifact/")) {
                    int artifactID = Integer.parseInt(wr.path.substring("manage_artifacts/delete_artifact/".length()));
                    String artifactName = "";
                    try {
                        artifactName = artifactManagement.findArtifact(artifactID).getName();
                    } catch (Exception e) {

                    }
                    DeletedArtifact deletedArtifact = new DeletedArtifact(artifactName);
                    Page page = new Page(title, deletedArtifact.toString(), "Delete Artifact",
                            "manage_artifacts/delete_artifact");
                    artifactManagement.removeArtifact(artifactID);
                    artifactManagement.refreshArtifactArray();
                    exhibitManagement.removeArtifactsWithID(artifactID);
                    exhibitManagement.refreshExhibitArray();

                    File image = new File(ROOT + "images/artifacts/" + artifactID + ".jpeg");
                    try {
                        Files.deleteIfExists(image.toPath());
                    } catch (Exception e) {
                        System.err.println("No Such File Found");
                    }

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.equalsIgnoreCase("manage_artifacts/search_artifact")) {

                    String url = wr.parms.get("currentPage");
                    url = url.replace("manage_artifacts/", "");
                    int searchCriteria = Integer.valueOf(wr.parms.get("criteriaChoice"));

                    String SearchValue = wr.parms.get("IDInput") + wr.parms.get("NameInput") + wr.parms.get("TypeInput")
                            + wr.parms.get("TimeInput");
                    if (!SearchValue.equals("")) {
                        artifactManagement.searchArtifacts(searchCriteria, SearchValue);
                    }
                    wr.r = new Response(WebRequest.HTTP_REDIRECT, WebRequest.MIME_HTML,
                            "<html><body>Redirected: <a href=\"" + url + "\">" +
                                    url + "</a></body></html>");
                    wr.r.addHeader("Location", url);

                } else if (wr.path.equalsIgnoreCase("manage_artifacts/clear_search")) {

                    String url = wr.parms.get("currentPage");
                    url = url.replace("manage_artifacts/", "");
                    artifactManagement.refreshArtifactArray();

                    wr.r = new Response(WebRequest.HTTP_REDIRECT, WebRequest.MIME_HTML,
                            "<html><body>Redirected: <a href=\"" + url + "\">" +
                                    url + "</a></body></html>");
                    wr.r.addHeader("Location", url);

                } else if (wr.path.equalsIgnoreCase("manage_exhibits")) {
                    exhibitManagement.refreshExhibitArray();
                    String[] menuOptions = { "Add Exhibit", "View Exhibit", "Update Exhibit", "Delete Exhibit" };
                    Menu mainMenu = new Menu(menuOptions, "manage_exhibits");
                    Page page = new Page(title, mainMenu.toString(), "Exhibit Management", "");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.equalsIgnoreCase("manage_exhibits/add_exhibit")) {

                    AddExhibit exhibitForm = new AddExhibit(artifactManagement);
                    Page page = new Page(title, exhibitForm.toString(), "Add Exhibit", "manage_exhibits");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.equalsIgnoreCase("manage_exhibits/add_exhibit/create_exhibit")) {
                    System.out.println(wr.parms);
                    String url = "/manage_exhibits/add_exhibit";

                    String myName = wr.parms.get("myNameInForm");
                    int noArtifacts = Integer.parseInt(wr.parms.get("artifcatCount"));
                    ArrayList<Integer> artifacts = new ArrayList<>();
                    ArrayList<String> route = new ArrayList<>();
                    for (int j = 0; j < noArtifacts; j++) {
                        int artifact = Integer.parseInt(wr.parms.get("artifact" + j));
                        String sign = wr.parms.get("sign" + j);
                        artifacts.add(artifact);
                        route.add(sign);
                    }
                    String image = wr.parms.get("image");

                    System.out.println(image);
                    Path source = FileSystems.getDefault().getPath(image);
                    Path target = FileSystems.getDefault().getPath(ROOT, "images", "exhibits",
                            Exhibit.getNextID() + ".jpeg");
                    try {
                        Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
                        FileUtils.cleanDirectory(new File(ROOT + "images/temp"));
                    } catch (Exception e) {

                    }
                    exhibitManagement.addExhibit(myName, artifacts, route);
                    exhibitManagement.refreshExhibitArray();
                    wr.r = new Response(WebRequest.HTTP_REDIRECT, WebRequest.MIME_HTML,
                            "<html><body>Redirected: <a href=\"" + url + "\">" +
                                    url + "</a></body></html>");
                    wr.r.addHeader("Location", url);

                } else if (wr.path.equalsIgnoreCase("manage_exhibits/view_exhibit")) {

                    ExhibitsList exhibitsList = new ExhibitsList(exhibitManagement, "manage_exhibits/view_exhibit");
                    Page page = new Page(title, exhibitsList.toString(), "View Exhibits", "manage_exhibits");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.startsWith("manage_exhibits/view_exhibit/")) {
                    int exhibitID = Integer.parseInt(wr.path.substring("manage_exhibits/view_exhibit/".length()));

                    Page page = new Page(title, "", "View Exhibit", "manage_exhibits/view_exhibit");
                    try {
                        Exhibit exhibit = exhibitManagement.findExhibit(exhibitID);
                        ViewExhibit viewExhibit = new ViewExhibit(exhibit, artifactManagement);
                        page = new Page(title, viewExhibit.toString(), exhibit.getName(),
                                "manage_exhibits/view_exhibit");
                    } catch (Exception e) {

                    }

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.equalsIgnoreCase("manage_exhibits/update_exhibit")) {

                    ExhibitsList artifactsList = new ExhibitsList(exhibitManagement,
                            "manage_exhibits/update_exhibit");
                    Page page = new Page(title, artifactsList.toString(), "Update Exhibit", "manage_exhibits");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.equalsIgnoreCase("manage_exhibits/update_exhibit/update")) {

                    int ID = Integer.parseInt(wr.parms.get("exhibitID"));
                    String myName = wr.parms.get("myNameInForm");
                    System.out.println(myName);
                    int noArtifacts = Integer.parseInt(wr.parms.get("artifcatCount"));
                    ArrayList<Integer> artifacts = new ArrayList<>();
                    ArrayList<String> route = new ArrayList<>();
                    for (int j = 0; j < noArtifacts; j++) {
                        int artifact = Integer.parseInt(wr.parms.get("artifact" + j));
                        String sign = wr.parms.get("sign" + j);
                        artifacts.add(artifact);
                        route.add(sign);
                    }

                    String image = wr.parms.get("image");

                    if (!image.startsWith(ROOT + "images/temp/_")) {
                        Path source = FileSystems.getDefault().getPath(image);
                        Path target = FileSystems.getDefault().getPath(ROOT, "images", "exhibits",
                                ID + ".jpeg");
                        try {
                            Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
                            FileUtils.cleanDirectory(new File(ROOT + "images/temp"));
                        } catch (Exception e) {

                        }
                    }

                    String url = "/manage_exhibits/update_exhibit";

                    exhibitManagement.updateExhibitByID(myName, artifacts, route, ID);
                    exhibitManagement.refreshExhibitArray();
                    wr.r = new Response(WebRequest.HTTP_REDIRECT, WebRequest.MIME_HTML,
                            "<html><body>Redirected: <a href=\"" + url + "\">" +
                                    url + "</a></body></html>");
                    wr.r.addHeader("Location", url);

                } else if (wr.path.startsWith("manage_exhibits/update_exhibit/")) {

                    int exhibitID = Integer.parseInt(wr.path.substring("manage_exhibits/update_exhibit/".length()));

                    Page page = new Page(title, "", "Update Exhibit", "manage_exhibits/update_exhibit");
                    try {
                        Exhibit exhibit = exhibitManagement.findExhibit(exhibitID);
                        UpdateExhibit updateExhibit = new UpdateExhibit(exhibit, artifactManagement);
                        page = new Page(title, updateExhibit.toString(), exhibit.getName(),
                                "manage_exhibits/update_exhibit");
                    } catch (Exception e) {

                    }

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.equalsIgnoreCase("manage_exhibits/delete_exhibit")) {

                    ExhibitsList exhibitsList = new ExhibitsList(exhibitManagement,
                            "manage_exhibits/delete_exhibit");
                    Page page = new Page(title, exhibitsList.toString(), "Delete Exhibit", "manage_exhibits");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.startsWith("manage_exhibits/delete_exhibit/")) {
                    int exhibitID = Integer.parseInt(wr.path.substring("manage_exhibits/delete_exhibit/".length()));
                    String exhibitName = "";
                    try {
                        exhibitName = exhibitManagement.findExhibit(exhibitID).getName();
                    } catch (Exception e) {

                    }
                    DeletedExhibit deletedExhibit = new DeletedExhibit(exhibitName);
                    Page page = new Page(title, deletedExhibit.toString(), "Delete Exhibit",
                            "manage_exhibits/delete_exhibit");
                    exhibitManagement.removeExhibit(exhibitID);
                    exhibitManagement.refreshExhibitArray();

                    File image = new File(ROOT + "images/exhibits/" + exhibitID + ".jpeg");
                    try {
                        Files.deleteIfExists(image.toPath());
                    } catch (Exception e) {
                        System.err.println("No Such File Found");
                    }

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.equalsIgnoreCase("manage_exhibits/search_exhibit")) {

                    String url = wr.parms.get("currentPage");
                    url = url.replace("manage_exhibits/", "");
                    int searchCriteria = Integer.valueOf(wr.parms.get("criteriaChoice"));

                    String searchValue = wr.parms.get("IDInput") + wr.parms.get("NameInput");
                    if (!searchValue.equals("")) {
                        exhibitManagement.searchExhibits(searchCriteria, searchValue);
                    }
                    wr.r = new Response(WebRequest.HTTP_REDIRECT, WebRequest.MIME_HTML,
                            "<html><body>Redirected: <a href=\"" + url + "\">" +
                                    url + "</a></body></html>");
                    wr.r.addHeader("Location", url);

                } else if (wr.path.equalsIgnoreCase("manage_exhibits/clear_search")) {

                    String url = wr.parms.get("currentPage");
                    url = url.replace("manage_exhibits/", "");
                    exhibitManagement.refreshExhibitArray();

                    wr.r = new Response(WebRequest.HTTP_REDIRECT, WebRequest.MIME_HTML,
                            "<html><body>Redirected: <a href=\"" + url + "\">" +
                                    url + "</a></body></html>");
                    wr.r.addHeader("Location", url);

                } else if (wr.path.equalsIgnoreCase("manage_annual_plan")) {

                    String[] menuOptions = { "Create Annual Plan", "View Annual Plan", "Update Annual Plan"};
                    Menu mainMenu = new Menu(menuOptions, "manage_annual_plan");
                    Page page = new Page(title, mainMenu.toString(), "Annual Plan Management", "");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.equalsIgnoreCase("manage_annual_plan/create_annual_plan")) {
                    CreateAnnualPlan createAnnualPlan = new CreateAnnualPlan(exhibitManagement);
                    Page page = new Page(title, createAnnualPlan.toString(), "View Annual Plan", "manage_annual_plan");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.equalsIgnoreCase("manage_annual_plan/create_annual_plan/create")) {
                    
                    int halls = Integer.valueOf(wr.parms.get("hallNoInput"));
                    int[][] exhibitPlan = new int[12][halls];
                    int id=0;
                    for(int j=0; j<12; j++){
                        for(int k=0; k<halls; k++){
                            exhibitPlan[j][k]=Integer.valueOf(wr.parms.get("exhibit"+id));
                            id++;
                        }
                    }
                    
                    try{
                        exhibitionPlan = new ExhibitionPlan(exhibitPlan, exhibitManagement);
                    } catch(Exception e){
                        System.out.println(e);
                    }

                    

                    String url = "/manage_annual_plan/view_annual_plan";

                   
                    wr.r = new Response(WebRequest.HTTP_REDIRECT, WebRequest.MIME_HTML,
                            "<html><body>Redirected: <a href=\"" + url + "\">" +
                                    url + "</a></body></html>");
                    wr.r.addHeader("Location", url);

                } else if (wr.path.equalsIgnoreCase("manage_annual_plan/view_annual_plan")) {

                    String[] menuOptions = { "Entire Plan", "Entire Month", "Entire Hall"};
                    Menu mainMenu = new Menu(menuOptions, "manage_annual_plan/view_annual_plan");
                    Page page = new Page(title, mainMenu.toString(), "View Annual Plan", "manage_annual_plan");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.equalsIgnoreCase("manage_annual_plan/view_annual_plan/entire_plan")) {

                    String[][] planNames = exhibitionPlan.getExhibitNames(exhibitManagement);
                    ViewEntirePlan viewEntirePlan = new ViewEntirePlan(planNames);
                    Page page = new Page(title, viewEntirePlan.toString(), "View Entire Plan", "manage_annual_plan/view_annual_plan");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.equalsIgnoreCase("manage_annual_plan/view_annual_plan/entire_month")) {
                    String[][] planNames = exhibitionPlan.getExhibitNames(exhibitManagement);
                    ViewEntireMonth viewEntireMonth = new ViewEntireMonth(planNames);
                    Page page = new Page(title, viewEntireMonth.toString(), "View Entire Plan", "manage_annual_plan/view_annual_plan");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());
 
                } else if (wr.path.equalsIgnoreCase("manage_annual_plan/view_annual_plan/entire_hall")) {
                    String[][] planNames = exhibitionPlan.getExhibitNames(exhibitManagement);
                    ViewEntireHall viewEntireHall = new ViewEntireHall(planNames);
                    Page page = new Page(title, viewEntireHall.toString(), "View Entire Plan", "manage_annual_plan/view_annual_plan");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.equalsIgnoreCase("manage_annual_plan/update_annual_plan")) {
                    UpdateAnnualPlan updateAnnualPlan = new UpdateAnnualPlan(exhibitManagement, exhibitionPlan);
                    Page page = new Page(title, updateAnnualPlan.toString(), "View Annual Plan", "manage_annual_plan");

                    wr.r = new Response(WebRequest.HTTP_OK, WebRequest.MIME_HTML, page.toString());

                } else if (wr.path.equalsIgnoreCase("manage_annual_plan/update_annual_plan/update")) {
                    int halls = Integer.valueOf(wr.parms.get("hallNoInput"));
                    int[][] exhibitPlan = new int[12][halls];
                    int id=0;
                    for(int j=0; j<12; j++){
                        for(int k=0; k<halls; k++){
                            exhibitPlan[j][k]=Integer.valueOf(wr.parms.get("exhibit"+id));
                            id++;
                        }
                    }
                    
                    try{
                        exhibitionPlan = new ExhibitionPlan(exhibitPlan, exhibitManagement);
                    } catch(Exception e){
                        System.out.println(e);
                    }

                    

                    String url = "/manage_annual_plan/view_annual_plan";

                   
                    wr.r = new Response(WebRequest.HTTP_REDIRECT, WebRequest.MIME_HTML,
                            "<html><body>Redirected: <a href=\"" + url + "\">" +
                                    url + "</a></body></html>");
                    wr.r.addHeader("Location", url);

                }

                else {
                    // This code will look on disk for a file, change the ROOT variable to load
                    // files from a different directory
                    File f = new File(ROOT + wr.path);
                    System.out.println(f.exists());
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
