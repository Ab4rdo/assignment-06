package enums;

import java.util.Random;

public enum  Degree {

    BSc("Bachelor of Science"),
    BA("Bachelor of Arts"),
    MSc("Master of Science"),
    MA("Master of Arts"),
    MBA("Master of Buissnes Administration"),
    PhD("Doctor of Philosophy"),
    DSc("Doctor of Science");

    private final String fullName;
    private static Random random;

    static {
        random = new Random();
    }

    Degree(String fullName) {
        this.fullName = fullName;
    }

    public static Degree getRandomDegree() {
        Degree[] degrees = Degree.values();
        int index = random.nextInt(degrees.length);
        return degrees[index];
    }

    public String toString() {
        return fullName;
    }

}
