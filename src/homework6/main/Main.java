package homework6.main;

import homework6.model.Students;
import homework6.service.StudentService;

public class Main {

    public static void main(String[] args) throws Exception {
        Students student1 = new Students();
        Students student2 = new Students();
        Students student3 = new Students();
        Students[] students = {student1, student2, student3};

        StudentService studentService = new StudentService();
        studentService.create(students);
        //task1
        studentService.printFullNamesOfStudents(students);
        //task2
        studentService.printAllMaleStudents(students);
        //task3
        studentService.printAllFemaleStudentsWithHighMark(students);
        //task4
        studentService.printStudentInformationHavingTheMinimalMark(students);
        //task5
        studentService.printBiggestMaleStudentInformation(students);
        //task6
        studentService.printStudentsSortedByMark(students);
        //task7
        studentService.printFemaleStudentsSortedByYear(students);
    }
}
