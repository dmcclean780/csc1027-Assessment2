package part03;

import java.util.ArrayList;

import part01.Exhibit;

public class Utility {
    
    /**
     *  Checks if two exhibit share any artifacts
     * @param a
     * @param b
     * @return if they share any artifacts
     */
    public static boolean checkForDuplicates(Exhibit a, Exhibit b){
        ArrayList<Integer> aArtifacts = a.getArtifactsID();
        ArrayList<Integer> bArtifacts = b.getArtifactsID();
        for (Integer i : aArtifacts) {
            for (Integer j : bArtifacts) {
                if(i==j){
                    return true;
                }
            }
        }
        return false;
    }
}
