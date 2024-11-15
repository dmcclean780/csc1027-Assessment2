package part01;

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
}
