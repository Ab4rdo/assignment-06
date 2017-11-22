package person;

import enums.Degree;
import enums.Nation;

import java.time.LocalDate;

public class Teacher extends Person {

    private Degree degree;

    public Teacher(String p, String firstName, String surname, LocalDate birthDate, Nation nation, Degree degree) {
        super(p, firstName, surname, birthDate, nation);
        this.degree = degree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Teacher teacher = (Teacher) o;

        return degree == teacher.degree;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (degree != null ? degree.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + " | degree: " + degree;
    }

    public Degree getDegree() {
        return degree;
    }
}
