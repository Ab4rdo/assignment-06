package generators;

import person.Student;
import person.Teacher;
import university.Department;
import university.StudentGroup;
import university.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UniversityGenerator {

    private static Random random = new Random();

    // for each department generate random teachers group
    public static List<Department> generateDepartments(List<String> deptNames, List<List<Teacher>> teams) {

        List<Department> depts = new ArrayList<>();
        int teamSize = teams.size();

        for(int i =0 ; i< deptNames.size();i++) {
            int team = random.nextInt(teamSize-1);
            depts.add(new Department(deptNames.get(i), teams.get(team)));
        }

        return depts;
    }

    // create groupName.size() StudentGroups
    public static List<StudentGroup> generateStudentGroups(List<String> groupName, List<Student> students, int groupsSize) {

        List<StudentGroup> groups = new ArrayList<>();
        List<Student> groupStud;
        int studentSize = students.size();
        int stud;

        for(String g : groupName) {

            groupStud = new ArrayList<>(groupsSize);
            for (int i = 0; i < groupsSize; i++) {
                stud = random.nextInt(studentSize-1);
                groupStud.add(students.get(stud));
            }

            groups.add(new StudentGroup(g, groupStud));
        }

        return groups;
    }

    // create subjectName.size() subjects
    public static List<Subject> generateSubjects(List<String> subjectName, List<Department> depts, List<Teacher> lecturers, List<StudentGroup> students) {

        List<Subject> subjects = new ArrayList<>();
        Department rDept;
        Teacher rTeacher;
        StudentGroup rGroup;
        int deptSize = depts.size();
        int lectureSize = lecturers.size();
        int studentSize = students.size();

        for(String sub : subjectName) {
            rDept = depts.get(random.nextInt(deptSize-1));
            rTeacher = lecturers.get(random.nextInt(lectureSize-1));
            rGroup = students.get(random.nextInt(studentSize-1));

            subjects.add(new Subject(sub, rDept, rTeacher, rGroup));
        }
        return subjects;
    }

}
