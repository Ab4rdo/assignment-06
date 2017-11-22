package university;

import person.Student;
import person.Teacher;

import java.util.List;

public class Subject implements Comparable<Subject>{

    private final String subjectName;
    private Department department;
    private Teacher lecturer;
    private StudentGroup students;

    public Subject(String subjectName, Department department, Teacher lecturer, StudentGroup students) {
        this.subjectName = subjectName;
        this.department = department;
        this.lecturer = lecturer;
        this.students = students;
    }

    @Override
    public int compareTo(Subject o) {
        if(subjectName==o.getSubjectName() &&
                department==o.getDepartment() &&
                lecturer==o.getLecturer() &&
                students==o.getStudents()) {
            return 0;
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (subjectName != null ? !subjectName.equals(subject.subjectName) : subject.subjectName != null) return false;
        if (department != null ? !department.equals(subject.department) : subject.department != null) return false;
        if (lecturer != null ? !lecturer.equals(subject.lecturer) : subject.lecturer != null) return false;
        return students != null ? students.equals(subject.students) : subject.students == null;
    }

    @Override
    public int hashCode() {
        int result = subjectName != null ? subjectName.hashCode() : 0;
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (lecturer != null ? lecturer.hashCode() : 0);
        result = 31 * result + (students != null ? students.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectName='" + subjectName + '\'' +
                ", department=" + department +
                ", lecturer=" + lecturer +
                ", students=" + students +
                '}';
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Department getDepartment() {
        return department;
    }

    public Teacher getLecturer() {
        return lecturer;
    }

    public StudentGroup getStudents() {
        return students;
    }
}
