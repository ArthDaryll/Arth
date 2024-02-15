
package arth;
import java.util.Scanner;

public class Arth {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the message: ");
        String input = scanner.nextLine();
        capitalizedMessage(input);
    }
    public static void capitalizedMessage(String input) {
        int hasMisplacedCapital = 0; 
        for (int i = 1; i < input.length(); i++) {
            if(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z' && input.charAt(i - 1) >= 'a' && input.charAt(i - 1) <= 'z') {
                hasMisplacedCapital = 1; break; } 
} if(hasMisplacedCapital == 1) { System.out.println("JEJE!"); } else { System.out.println("uWu"); }
    }
}