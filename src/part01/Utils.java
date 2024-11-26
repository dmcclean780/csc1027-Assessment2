package part01;

import java.util.ArrayList;

public class Utils {
    
    /**
     * Prevents Instatiation
     */
    private Utils(){}

    /**
     * joins two arrays
     * @param a first array
     * @param b second array
     * @return array a then array b as one array
     */
    public static String[] concat(String[] a, String[] b) {
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        String[] c = new String[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int i = a.length; i < b.length + a.length; i++) {
            c[i] = b[i - a.length];
        }
        return c;
    }

    /**
     * Checks if an ArrayList contains a given value
     * @param i value to look for
     * @param list to look in
     * @return true if found
     */
    public static boolean contains(int i, ArrayList<Integer> list){
        if(list == null ){
            return false;
        }
        for (Integer integer : list) {
            if(integer != null && i == integer){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if an array contains a value
     * @param i value to look for
     * @param list array to look in
     * @return true if found
     */
    public static boolean contains(int i, int[] list){
        if(list == null ){
            return false;
        }
        for (int integer : list) {
            if(i == integer){
                return true;
            }
        }
        return false;
    }

    
    
}
