package part02;

import part01.Artifact;

public class ArraysMethods {
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
            }
            if(arr1[i].length != arr2[i].length){
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

    public static String deepToString(int[][] arr){
        if(arr == null ){
            return "null";
        }
        if(arr.length == 0){
            return "[]";
        }
        String str = "[ ";
        for (int[] subArr : arr) {
            if(subArr.length==0){
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

    public static String deepToString(String[][] arr){
        if(arr == null ){
            return "null";
        }
        if(arr.length == 0){
            return "[]";
        }
        String str = "[";
        for (String[] subArr : arr) {
            if(subArr.length == 0){
                str+="[], ";
                continue;
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
