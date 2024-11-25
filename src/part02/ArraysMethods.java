package part02;

import part01.Artifact;
import part01.Exhibit;

public class ArraysMethods {

    /**
     * converts a String[] to a String
     * @param array
     * @return String form
     */
    public static String toString(String[] array){
        if(array == null ){
            return "null";
        }
        if(array.length == 0){
            return "[]";
        }
        String str = "[";
        for (String string : array) {
            if(string != null){
                str+="\""+string+"\", ";
            }
            else{
                str+=string+", ";
            }
            
        }
        return str.substring(0,str.length()-2)+']';
    }

    /**
     * converts a Artifact[] to a String
     * @param array
     * @return String form
     */
    public static String toString(Artifact[] array){
        if(array == null ){
            return "null";
        }
        if(array.length == 0){
            return "[]";
        }
        String str = "[";
        for (Artifact a : array) {
            if(a != null){
                str+="{"+a.toString()+"}, ";
            }
            else{
                str+=a+", ";
            }
            
        }
        return str.substring(0,str.length()-2)+']';
    }

    /**
     * converts a Exhibit[] to a String
     * @param array
     * @return String form
     */
    public static String toString(Exhibit[] array){
        if(array == null ){
            return "null";
        }
        if(array.length == 0){
            return "[]";
        }
        String str = "[";
        for (Exhibit a : array) {
            if(a != null){
                str+="{"+a.toString()+"}, ";
            }
            else{
                str+=a+", ";
            }
            
        }
        return str.substring(0,str.length()-2)+']';
    }

    /**
     * converts a int[] to a String
     * @param array
     * @return String form
     */
    public static String toString(int[] array){
        if(array == null ){
            return "null";
        }
        if(array.length == 0){
            return "[]";
        }
        String str = "[";
        for (int integer : array) {
            str+=integer+", ";
        }
        return str.substring(0,str.length()-2)+']';
    }

    /**
     * compares if 2 String[] are identiacal
     * @param arr1
     * @param arr2
     * @return true if equal
     */
    public static boolean equals(String[] arr1, String[] arr2){
        if(arr1 == null || arr2 == null){
            if(arr1 == null && arr2==null){
                return true;
            }
            return false;
        }
        if(arr1.length != arr2.length){
            return false;
        }
        boolean equal = true;
        for (int i=0; i<arr1.length; i++) {
            if(arr1[i]==null){
                equal &= arr1[i]==arr2[i];
            }
            else{
                equal &= arr1[i].equals(arr2[i]);
            }
            
        }
        return equal;
    }

    /**
     * compares if 2 int[] are identiacal
     * @param arr1
     * @param arr2
     * @return true if equal
     */
    public static boolean equals(int[] arr1, int[] arr2){
        if(arr1 == null || arr2 == null){
            if(arr1 == null && arr2==null){
                return true;
            }
            return false;
        }
        if(arr1.length != arr2.length){
            return false;
        }
        boolean equal = true;
        for (int i=0; i<arr1.length; i++) {
            equal &= arr1[i] == arr2[i];
            
        }
        return equal;
    }

    /**
     * compares if 2 Artifact[] are identiacal
     * @param arr1
     * @param arr2
     * @return true if equal
     */
    public static boolean equals(Artifact[] arr1, Artifact[] arr2){
        if(arr1 == null || arr2 == null){
            if(arr1 == null && arr2==null){
                return true;
            }
            return false;
        }
        if(arr1.length != arr2.length){
            return false;
        }
        boolean equal = true;
        for (int i=0; i<arr1.length; i++) {
            if(arr1[i] == null || arr2[i] == null){
                if(arr1[i] == null && arr2[i]==null){
                    equal &=true;
                    continue;
                }
                return false;
            }
            boolean idEqual = arr1[i].getID() == arr2[i].getID();
            boolean nameEqual = arr1[i].getName().equals(arr2[i].getName());
            boolean typeEqual = arr1[i].getType().equals(arr2[i].getType());
            boolean timeEqual = arr1[i].getEngagementTime() == arr2[i].getEngagementTime();
            equal &= idEqual;
            equal &= nameEqual;
            equal &= typeEqual;
            equal &= timeEqual;
            
        }
        return equal;
    }

    /**
     * compares if 2 Exhibit[] are identiacal
     * @param arr1
     * @param arr2
     * @return true if equal
     */
    public static boolean equals(Exhibit[] arr1, Exhibit[] arr2){
        if(arr1 == null || arr2 == null){
            if(arr1 == null && arr2==null){
                return true;
            }
            return false;
        }
        if(arr1.length != arr2.length){
            return false;
        }
        boolean equal = true;
        for (int i=0; i<arr1.length; i++) {
            if(arr1[i] == null || arr2[i] == null){
                if(arr1[i] == null && arr2[i]==null){
                    equal &=true;
                    continue;
                }
                return false;
            }
            boolean idEqual = arr1[i].getID() == arr2[i].getID();
            boolean nameEqual = arr1[i].getName().equals(arr2[i].getName());
            boolean artifactsEqual = arr1[i].getArtifactsID().equals(arr2[i].getArtifactsID());
            boolean routeEqual = arr1[i].getRoute() == arr2[i].getRoute();
            equal &= idEqual;
            equal &= nameEqual;
            equal &= artifactsEqual;
            equal &= routeEqual;
            
        }
        return equal;
    }

    /**
     * compares if 2 int[][] are identiacal
     * @param arr1
     * @param arr2
     * @return true if equal
     */
    public static boolean deepEquals(int[][] arr1, int[][] arr2){
        if(arr1 == null || arr2 == null){
            if(arr1 == null && arr2==null){
                return true;
            }
            return false;
        }
        if(arr1.length != arr2.length){
            return false;
        }
        for (int i=0; i<arr1.length; i++) {
            if(arr1[i] == null || arr2[i] == null){
                if(!(arr1[i] == null && arr2[i] ==null)){
                    return false;
                }
            }
            if(arr1[i].length != arr2[i].length){
                return false;
            }
            for(int j=0; j<arr1[i].length; j++){
                if(arr1[i][j] != arr2[i][j]){
                    return false;
                }
            }
            
        }
        return true;
    }

    /**
     * compares if 2 String[][] are identiacal
     * @param arr1
     * @param arr2
     * @return true if equal
     */
    public static boolean deepEquals(String[][] arr1, String[][] arr2){
        if(arr1 == null || arr2 == null){
            if(arr1 == null && arr2==null){
                return true;
            }
            return false;
        }
        if(arr1.length != arr2.length){
            return false;
        }
        for (int i=0; i<arr1.length; i++) {
            if(arr1[i] == null || arr2[i] == null){
                if(!(arr1[i] == null && arr2[i] ==null)){
                    return false;
                }
                continue;
            }
            else if(arr1[i].length != arr2[i].length){
                return false;
            }
            for(int j=0; j<arr1[i].length; j++){
                if(!arr1[i][j].equals(arr2[i][j])){
                    return false;
                }
            }
            
        }
        return true;
    }

    /**
     * converts an int[][] to a String
     * @param arr1
     * @param arr2
     * @return String form
     */
    public static String deepToString(int[][] arr){
        if(arr == null ){
            return "null";
        }
        if(arr.length == 0){
            return "[]";
        }
        String str = "[ ";
        for (int[] subArr : arr) {
            if( subArr == null ||subArr.length==0 ){
                if(subArr == null){
                    str+="null, ";
                    continue;
                }
                str+="null, ";
                if(subArr.length == 0){
                    str+="[], ";
                    continue;
                }
                
            }
            str+="[";
            for (int i : subArr) {
                str += i+", ";
            }
            str = str.substring(0,str.length()-2)+"], ";
        }
        return str.substring(0,str.length()-2)+']';
    }

    /**
     * converts a String[][] to a String
     * @param arr
     * @return String form
     */
    public static String deepToString(String[][] arr){
        if(arr == null ){
            return "null";
        }
        if(arr.length == 0){
            return "[]";
        }
        String str = "[";
        for (String[] subArr : arr) {
            if( subArr == null ||subArr.length==0 ){
                if(subArr == null){
                    str+="null, ";
                    continue;
                }
                str+="null, ";
                if(subArr.length == 0){
                    str+="[], ";
                    continue;
                }
                
            }
            str+="[";
            for (String i : subArr) {
                str += i+", ";
            }
            str = str.substring(0,str.length()-2)+"], ";
        }
        return str.substring(0,str.length()-2)+']';
    }
}
