package part01;

public class ArraysMethods {
    public static String toString(String[] array){
        if(array.length == 0){
            return "[]";
        }
        String str = "[";
        for (String string : array) {
            str+=string+", ";
        }
        return str.substring(0,str.length()-2)+']';
    }

    public static String toString(int[] array){
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
        if(arr1.length != arr2.length){
            return false;
        }
        boolean equal = true;
        for (int i=0; i<arr1.length; i++) {
            equal &= arr1[i].equals(arr2[i]);
        }
        return equal;
    }
}
