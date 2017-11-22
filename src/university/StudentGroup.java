package university;

import person.Student;

import java.util.List;

public class StudentGroup implements Comparable<StudentGroup>{

    private final String groupName;
    private final List<Student> students;

    public StudentGroup(String groupName, List<Student> students) throws IllegalArgumentException {
        if(students.size() < 8 || students.size() > 10) { throw new IllegalArgumentException(); }
        this.groupName = groupName;
        this.students = students;
    }

    @Override
    public int compareTo(StudentGroup o) {
        return groupName.compareTo(o.getGroupName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentGroup that = (StudentGroup) o;

        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        return students != null ? students.equals(that.students) : that.students == null;
    }

    @Override
    public int hashCode() {
        int result = groupName != null ? groupName.hashCode() : 0;
        result = 31 * result + (students != null ? students.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "groupName='" + groupName + '\'' +
                ", students=" + students +
                '}';
    }

    public String getGroupName() {
        return groupName;
    }

    public List<Student> getStudents() {
        return students;
    }

}
