package tests;

import enums.Nation;
import extension.PersonExtension;
import generators.PersonGenerator;
import org.junit.Test;
import parsers.ParseCSV;
import person.Student;

import java.io.File;
import java.util.List;

public class ExtensionTest {

    final String namesPath = "names.csv";
    final String surnamesPath = "surnames.csv";

    // Obtaining people names and surnames from files
    final List<String> names = ParseCSV.parseFile(new File(namesPath));
    final List<String> surnames = ParseCSV.parseFile(new File(surnamesPath));


    @Test
    public void StudentExtensionTest() {

        List<Student> studentsBefore = PersonGenerator.generateStudents(names, surnames, 60);

        PersonExtension<Student> studentExtension = new PersonExtension<>(studentsBefore);

        List<Student> studentsDefaultSort = studentExtension.getSortedByLocaleList();

        for(Student s : studentsDefaultSort) {
            System.out.println(s);
        }
    }

    @Test
    public void StudentExtensionSortedByUkraininaLoclae() {
        List<Student> studentsBefore = PersonGenerator.generateStudents(names, surnames, 60);

        PersonExtension<Student> studentExtension = new PersonExtension<>(studentsBefore);

        List<Student> studentsDefaultSort = studentExtension.getSortedByNation(Nation.UKRAINIAN);

        for(Student s : studentsDefaultSort) {
            System.out.println(s);
        }


    }





}
