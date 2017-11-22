package university;

import person.Teacher;

import java.util.List;

public class Department implements Comparable<Department>{

    private final String deptName;
    private final List<Teacher> employees;

    public Department(String deptName, List<Teacher> employees) {
        this.deptName = deptName;
        this.employees = employees;
    }

    @Override
    public int compareTo(Department o) {
        return deptName.compareTo(o.getDeptName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (deptName != null ? !deptName.equals(that.deptName) : that.deptName != null) return false;
        return employees != null ? employees.equals(that.employees) : that.employees == null;
    }

    @Override
    public int hashCode() {
        int result = deptName != null ? deptName.hashCode() : 0;
        result = 31 * result + (employees != null ? employees.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptName='" + deptName + '\'' +
                ", employees=" + employees +
                '}';
    }

    public String getDeptName() {
        return deptName;
    }

    public List<Teacher> getEmployees() {
        return employees;
    }
}
