import java.util.Scanner;

public class Runner {
    public Runner() {
        System.out.println("Calculator.\nEnter any number expression containing numbers, parenthesis and '+', '-', '*', '/' operations:\n\n");

        String expression = new Scanner(System.in).nextLine();

        System.out.println(new Calculator().calculate(expression));
    }
}
