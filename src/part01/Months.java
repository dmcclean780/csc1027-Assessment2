package part01;

public enum Months {
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

    public static Months get(String month) {
        for (Months m : values()) {
            if (m.toString().equals(month)) {
                return m;
            }
        }
        return null;
    }

    public static Months get(int month) {
        for (Months m : values()) {
            if (m.getId() == month) {
                return m;
            }
        }
        return null;
    }

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
