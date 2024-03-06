package midtermlab1;
import java.util.Scanner;

public class MidtermLab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter test case number: ");
        int caseNum = scanner.nextInt();

        switch (caseNum) {
            case 1:
                case1();
                break;
            case 2:
                case2();
                break;
            case 3:
                case3();
                break;
            case 4:
                case4();
                break;
        }
    }

    private static void case1() {
        Student student = new Student("Jemar Jude", "Maranga", 17);
        System.out.println("Test Case 1: Student under 18");
        System.out.println(student);
    }

    private static void case2() {
        Student student = new Student("Jemar Jude", "Maranga", 17);
        student.increaseAge();
        System.out.println("Test Case 2: Increase age of student1");
        System.out.println(student);
    }

    private static void case3() {
        Student student = new Student("Jose", "Cruz", 19);
        System.out.println("Test Case 3: Student over 18");
        System.out.println(student);
    }
    private static void case4() {
        Student student = new Student("Arth Daryll", "Labbino", 19);
        System.out.println("Test Case 4: Student over 18");
        System.out.println(student);
    }
}


