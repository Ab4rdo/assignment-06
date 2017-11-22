package generators;

import enums.Degree;
import enums.Nation;
import person.Student;
import person.Teacher;
import pesel.PeselValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonGenerator {

    private static Random random = new Random();
    private static PeselValidator validator = new PeselValidator();
    private static PeselGenerator generator = new PeselGenerator();


    public static List<Student> generateStudents(List<String> names, List<String> surnames, int number) {
        if(names.isEmpty()) { names.add("Jan"); }
        if(surnames.isEmpty()) { surnames.add("Kowalski"); }

        List<Student> studnets = new ArrayList<>(number);
        String pesel;
        boolean gender;
        int randomNameI, randomSurnameI;
        int namesSize = names.size();
        int surnamesSize = surnames.size();

        for(int i=0 ; i < number ; i++) {
            randomNameI = random.nextInt(namesSize);
            randomSurnameI = random.nextInt(surnamesSize);
            gender = isMale(names.get(randomNameI));
            pesel = generator.generatePesel(gender);
            studnets.add(i, new Student(pesel, names.get(randomNameI), surnames.get(randomSurnameI), validator.getDateFromPesel(pesel), Nation.getRandomNation()));
        }

        return studnets;
    }


    public static List<Teacher> generateTeachers(List<String> names, List<String> surnames, int number) {
        if(names.isEmpty()) { names.add("Jan"); }
        if(surnames.isEmpty()) { surnames.add("Kowalski"); }

        List<Teacher> teachers = new ArrayList<>(number);
        String pesel;
        boolean gender;
        int randomNameI, randomSurnameI;
        int namesSize = names.size();
        int surnamesSize = surnames.size();

        for(int i=0 ; i < number ; i++) {
            randomNameI = random.nextInt(namesSize);
            randomSurnameI = random.nextInt(surnamesSize);
            gender = isMale(names.get(randomNameI));
            pesel = generator.generatePesel(gender);
            teachers.add(i, new Teacher(pesel, names.get(randomNameI), surnames.get(randomSurnameI), validator.getDateFromPesel(pesel), Nation.getRandomNation(), Degree.getRandomDegree()));
        }

        return teachers;
    }





    private static boolean isMale(String name) {
        return (name.charAt(name.length()-1)=='a');
    }


}
