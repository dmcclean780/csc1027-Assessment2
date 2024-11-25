package part01;

public enum Months {
    /**
     * Each month has a String name and an int ID
     */
    JAN("January", 0),
    FEB("February", 1),
    MAR("March", 2),
    APR("April", 3),
    MAY("May", 4),
    JUN("June", 5),
    JUL("July", 6),
    AUG("August", 7),
    SEP("September", 8),
    OCT("October", 9),
    NOV("November", 10),
    DEC("December", 11);

    private String month;
    private int id;

    private Months(String month, int id) {
        this.month = month;
        this.id = id;
    }

    public String toString() {
        return this.month;
    }

    public int getId() {
        return this.id;
    }

    /**
     * gets the enum of the month with name month
     * @param month String name of a month enum
     * @return mathing Months enum or null for an invalid String
     */
    public static Months get(String month) {
        for (Months m : values()) {
            if (m.toString().equals(month)) {
                return m;
            }
        }
        return null;
    }

    /**
     * gets the enum of the month with id month
     * @param month int id of a month enum
     * @return mathing Months enum or null for an invalid id
     */
    public static Months get(int month) {
        for (Months m : values()) {
            if (m.getId() == month) {
                return m;
            }
        }
        return null;
    }

    /**
     * gets an array of all the enums names
     */
    private static final String[] array;
    static {
        array = new String[Months.values().length];
        for (Months value : Months.values())
            array[value.ordinal()] = value.toString();
    }

    public static String[] toArray() {
        return array;
    }

}
