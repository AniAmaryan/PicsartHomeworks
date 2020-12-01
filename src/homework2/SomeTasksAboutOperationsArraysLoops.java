package homework2;

public class SomeTasksAboutOperationsArraysLoops {
    public static void main(String[] args) {
        SomeTasksAboutOperationsArraysLoops someTasks = new SomeTasksAboutOperationsArraysLoops();
        someTasks.task1();
        someTasks.task2();
        someTasks.task3();
        someTasks.task4();
        someTasks.task5();
        someTasks.task6();
        someTasks.task7();
        someTasks.nonRepeating();
    }

    //Task 1
    //Create an array and fill it with 2 number.
    public void task1() {
        int[] arrayForTaskOne = new int[10];
        for (int i = 0; i < arrayForTaskOne.length; i++) {
            arrayForTaskOne[i] = 2;
            System.out.print(arrayForTaskOne[i] + " ");
        }
    }

    //Task 2
    //Create an array and fill it with numbers from 1:1000.
    public void task2() {
        int[] arrayForTaskTwo = new int[1000];
        for (int i = 0; i < arrayForTaskTwo.length; i++) {
            arrayForTaskTwo[i] = i + 1;
            System.out.println(arrayForTaskTwo[i]);
        }
    }

    //Task 3
    //Create an array and fill it with odd numbers from -20:20
    public void task3() {
        int[] arrayForTaskThree = new int[20];
        for (int i = 0, j = -19; i < arrayForTaskThree.length; i++, j += 2) {
            arrayForTaskThree[i] = j;
            System.out.print(arrayForTaskThree[i] + " ");
        }
    }

    //Task 4
    //Create an array and fill it. Print all elements which can be divided by 5.
    public void task4() {
        int[] arrayForTaskFour = {1, 56, 78, 4, 20, 0, 6, 5};
        for (int i = 0; i < arrayForTaskFour.length; i++) {
            if (arrayForTaskFour[i] % 5 == 0) {
                System.out.print(arrayForTaskFour[i] + " ");
            }
        }
    }

    //Task 5
    //Create an array and fill it. Print all elements which are between 24.12 and 467.23.
    public void task5() {
        double[] arrayForTaskFive = new double[500];
        for (int i = 0; i < arrayForTaskFive.length; i++) {
            if (i >= 24.12 && arrayForTaskFive[i] <= 467.23) {
                arrayForTaskFive[i] = i;
                System.out.println(arrayForTaskFive[i]);
            }
        }
    }

    //Task 6
    //Create an array and fill it. Print count of elements which can be divided by 2.
    public void task6() {
        int countOfElements = 0;
        int[] arrayForTaskSix = new int[10];
        for (int i = 0; i < arrayForTaskSix.length; i += 2) {
            countOfElements++;
            arrayForTaskSix[i] = i;
            System.out.print(arrayForTaskSix[i] + " ");
        }
        System.out.println(countOfElements);
    }

    //Task 7
    //Given an integer, 0< N < 21 , print its first 10 multiples.
    //Each multiple N x i (where 0<i<11)
    //should be printed on a new line in the
    //form: N x i = result.
    public void task7() {
        int n;
        for (n = 1; n < 21; n++) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(n + " x " + i + " = " + i * n);
            }
            System.out.println("____________");
        }
    }

    public void nonRepeating() {
        int[] arr = {9, 4, 9, 6, 4, 4};
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j;
            for (j = 0; j < n; j++)
                if (i != j && (arr[i] ^ arr[j]) == 0)
                    break;
            if (j == n)
                System.out.print(arr[i] + " ");
        }
    }
}
