package homework6.service;

import homework6.model.Students;

import java.util.Arrays;

public class StudentService {

    private static final String PATH = "C:\\Users\\User\\Desktop\\Students\\src\\students.txt";

    public void create(Students[] s) throws Exception {

        String[] read = FileService.read(PATH);
        for (int i = 0; i < read.length; i++) {
            String[] student = read[i].split(",");
            String firstName = student[0];
            String lastName = student[1];
            int year = Integer.parseInt(student[2]);
            char gender = student[3].charAt(0);
            double mark = Double.parseDouble(student[4]);
            s[i].setFirstName(firstName);
            s[i].setLastName(lastName);
            s[i].setYear(year);
            s[i].setGender(gender);
            s[i].setMark(mark);
            System.out.println(s[i].toString());
        }
    }
    //Task 1: Print full names of students
    public void printFullNamesOfStudents(Students[] s){
        for (Students stud:s) {
            System.out.println("------------------------");
            System.out.println("First name: " + stud.getFirstName());
            System.out.println("Last name: " + stud.getLastName());
        }
    }

    //Task 2: Print all male students
    public void printAllMaleStudents(Students[] s){
        for (Students stud:s) {
            if(stud.getGender() == 'm'){
                System.out.println(stud.toString());
            }
        }
    }


    //Task 3: Print all female students who has mark greater then 50.4
    public void printAllFemaleStudentsWithHighMark(Students[] s){
        for (Students stud:s) {
            if(stud.getGender() == 'f' && stud.getMark()>50.4){
                System.out.println(stud.toString());
            }
        }
    }

    //Task 4: Print student information having the minimal mark
    public void printStudentInformationHavingTheMinimalMark(Students[] s) {
        Students minValue = s[0];

        for (int i = 1; i < s.length; i++) {
            if (s[i].getMark() < minValue.getMark()) {
                minValue = s[i];
            }
        }
        System.out.println(minValue);
    }

    //Task 5: Print biggest male student information
    public void printBiggestMaleStudentInformation(Students[] s) {
        Students maxValue = s[0];

        for (int i = 1; i < s.length; i++) {
            if (s[i].getMark() > maxValue.getMark() && s[i].getGender() =='m') {
                maxValue = s[i];
            }
        }
        System.out.println(maxValue);
    }

    //Task 6: Print students sorted by mark
    public void printStudentsSortedByMark(Students[] s) {
        System.out.println("Sorting by marks : ");
        boolean swappedForTask6 = true;
        while (swappedForTask6) {
            swappedForTask6 = false;
            for (int i = 1; i < s.length; i++) {
                if (s[i - 1].getMark() > s[i].getMark()) {
                    Students temp = s[i];
                    s[i] = s[i - 1];
                    s[i - 1] = temp;
                    swappedForTask6 = true;
                }
            }
        }
        for (Students stud : s) {
            System.out.println(stud.toString());
        }
    }

    //Task 7: Print female students sorted by year
    public void printFemaleStudentsSortedByYear(Students[] s){
        System.out.println("----------------------");
        System.out.println("Female students sorted by year : ");
        boolean swappedForTask7 = true;
        while (swappedForTask7) {
            swappedForTask7 = false;
            for (int i = 1; i < s.length; i++) {
                if (s[i - 1].getYear() > s[i].getYear() && s[i].getGender() == 'f') {
                    Students temp = s[i];
                    s[i] = s[i - 1];
                    s[i - 1] = temp;
                    swappedForTask7 = true;
                }
            }
        }
        for (Students stud : s) {
            System.out.println(stud.toString());
        }
    }
}

