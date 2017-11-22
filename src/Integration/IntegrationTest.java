package Integration;

import enums.Nation;
import extension.PersonExtension;
import extension.UniversityExtension;
import generators.PersonGenerator;
import generators.UniversityGenerator;
import org.junit.Test;
import parsers.ParseCSV;
import person.Person;
import person.Student;
import person.Teacher;
import university.Department;
import university.StudentGroup;
import university.Subject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IntegrationTest {

    final String namesPath = "names.csv";
    final String surnamesPath = "surnames.csv";
    final String studentGroupNamesPath = "groups.csv";
    final String departmentsPath = "departments.csv";
    final String subjectsNamesPath = "subjects.csv";

    // Obtaining people names and surnames from files
    final List<String> names = ParseCSV.parseFile(new File(namesPath));
    final List<String> surnames = ParseCSV.parseFile(new File(surnamesPath));
    final List<String> studentGroupNames = ParseCSV.parseFile(new File(studentGroupNamesPath));
    final List<String> departmentsNames = ParseCSV.parseFile(new File(departmentsPath));
    final List<String> subjectsNames = ParseCSV.parseFile(new File(subjectsNamesPath));


    @Test
    public void integration() {

        // Students
        // generating 100 students of random nationalities and random and valid PESELS
        List<Student> studentsBeforeExtension = PersonGenerator.generateStudents(names, surnames, 100);
        // delete duplicates of students
        PersonExtension<Student> studentExtension = new PersonExtension<>(studentsBeforeExtension);

        // StudentGroup
        // 12 student groups got from file
        List<StudentGroup> studentGroupsBeforeExtension = UniversityGenerator.generateStudentGroups(studentGroupNames, studentExtension.getSortedByLocaleList(), 10);
        UniversityExtension<StudentGroup> studentGroups = new UniversityExtension<StudentGroup>(studentGroupsBeforeExtension);

        // Teacher
        // generate 10 teachers of random nationalities
        List<Teacher> teachersBeforeExtension = PersonGenerator.generateTeachers(names, surnames, 10);
        // delete duplicated teachers
        PersonExtension<Teacher> teacherExtension = new PersonExtension<>(teachersBeforeExtension);

        // Departments
        // generate 3 departments
        List<Department> departmentsBeforeExtension = UniversityGenerator.generateDepartments(departmentsNames, createTeacherTeams(teacherExtension.getSortedByLocaleList()));
        UniversityExtension<Department> departmentExtension = new UniversityExtension<>(departmentsBeforeExtension);

        // Subjects
        // generate 10 subjects
        List<Subject> subjectsBeforeExtension = UniversityGenerator.generateSubjects(subjectsNames, departmentExtension.getList(), teacherExtension.getSortedByLocaleList(), studentGroups.getList());
        UniversityExtension<Subject> subjectExtension = new UniversityExtension<>(subjectsBeforeExtension);

        printList(studentExtension.getSortedByNation(Nation.UKRAINIAN));
//        printList(studentGroups.getList());
//        printList(teacherExtension.getSortedByLocaleList());
//        printList(departmentExtension.getList());
//        printList(subjectExtension.getList());


    }

    public void printList(List<? extends Object> list) {
        for(Object o : list) {
            System.out.println(o.toString());
        }
    }

    public List<List<Teacher>> createTeacherTeams(List<Teacher> teachers) {
        List<List<Teacher>> teams = new ArrayList<>();

        List<Teacher> team1 = teachers.subList(0,3);
        List<Teacher> team2 = teachers.subList(3,8);
        List<Teacher> team3 = teachers.subList(4,10);

        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        return teams;
    }

















}
