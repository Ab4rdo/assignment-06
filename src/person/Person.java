package person;

import enums.Nation;
import pesel.PeselValidator;

import java.text.Collator;
import java.time.LocalDate;
import java.util.Locale;

public abstract class Person implements Comparable<Person>{

    public static final Locale locale = Nation.POLISH.getLocale();
    public static final Collator defCollator = Collator.getInstance(locale);

    private final String socialSecurityNumber;
    private final String firstName;
    private final String surname;
    private final LocalDate birthDate;
    private final Nation nation;

    public Person(String pesel, String firstName, String surname, LocalDate birthDate, Nation nation) {
        PeselValidator validator = new PeselValidator();
        if(!validator.validate(pesel)) { throw new IllegalArgumentException("Invalid PESEL"); }
        this.socialSecurityNumber = pesel;
        this.firstName = firstName;
        this.surname = surname;
        this.birthDate = birthDate;
        this.nation = nation;
    }

    @Override
    public int compareTo(Person o) {
        // birthDate compared in PESEL
        int f = defCollator.compare(this.firstName , o.getFirstName());
        if(f!=0) { return f; }
        int s = defCollator.compare(this.surname, o.getSurname());
        if(s!=0) { return s; }
        return this.nation.compareTo(o.getNation());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (socialSecurityNumber != null ? !socialSecurityNumber.equals(person.socialSecurityNumber) : person.socialSecurityNumber != null)
            return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (surname != null ? !surname.equals(person.surname) : person.surname != null) return false;
        if (birthDate != null ? !birthDate.equals(person.birthDate) : person.birthDate != null) return false;
        return nation == person.nation;
    }

    @Override
    public int hashCode() {
        int result = socialSecurityNumber != null ? socialSecurityNumber.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (nation != null ? nation.hashCode() : 0);
        return result;
    }

    public String toString() {
        return "PESEL: " + socialSecurityNumber + " | name: " + firstName + " | surname: " + surname +
                 " | age: " + this.getAge() + " | nationality: " + nation;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        return now.getYear() - birthDate.getYear();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Nation getNation() {
        return nation;
    }
}
