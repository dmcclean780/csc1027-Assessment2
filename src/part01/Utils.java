package part01;

import java.util.ArrayList;

public class Utils {
    
    public static String[] concat(String[] a, String[] b) {
        String[] c = new String[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int i = a.length; i < b.length + a.length; i++) {
            c[i] = b[i - a.length];
        }
        return c;
    }

    public static boolean contains(int i, ArrayList<Integer> list){
        for (Integer integer : list) {
            if(i == integer){
                return true;
            }
        }
        return false;
    }

    
    
}
