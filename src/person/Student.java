package person;

import enums.Nation;

import java.time.LocalDate;

public class Student extends Person {

    private static int number;
    private final int studnetNumber;

    public Student(String p, String firstName, String surname, LocalDate birthDate, Nation nation) {
        super(p, firstName, surname, birthDate, nation);
        this.studnetNumber = getNumber();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        return studnetNumber == student.studnetNumber;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + studnetNumber;
        return result;
    }

    public String toString() {
        return "Student ID: " +studnetNumber + " | " + super.toString();
    }

    private static int getNumber() {
        return number++;
    }

    public int getStudnetNumber() {
        return studnetNumber;
    }

}
