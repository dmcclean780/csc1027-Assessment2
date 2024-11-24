package part02;

import java.lang.reflect.Method;

import part01.Artifact;

public class RunTests {
    public static void main(String[] args) {
        try {
            Method resetArtifact = Artifact.class.getDeclaredMethod("reset");
            resetArtifact.setAccessible(true); // Bypass Java access control
            resetArtifact.invoke(null);

            Method resetExhibit = Artifact.class.getDeclaredMethod("reset");
            resetExhibit.setAccessible(true); // Bypass Java access control
            resetExhibit.invoke(null);

            ArraysMethodsTester.main(args);

            UtilsTester.main(args);

            MonthsTester.main(args);

            MenuTester.main(args);

            SubMenuTester.main(args);

            ArtifactTester.main(args);
            resetArtifact.invoke(null);

            ExhibitTester.main(args);
            resetArtifact.invoke(null);
            resetExhibit.invoke(null);

            ExhibitionPlanTester.main(args);
            resetArtifact.invoke(null);
            resetExhibit.invoke(null);
            
            ArtifactManagementTester.main(args);
            resetArtifact.invoke(null);
        } catch (Exception e) {

        }

    }
}
