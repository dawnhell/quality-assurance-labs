import java.util.Stack;

import static java.lang.Integer.parseInt;

public class Calculator {
    public int calculate(String expression) {
        Stack result     = new Stack();
        Stack operations = new Stack();

        for (int i = 0; i < expression.length() ; ++i) {
            if (!isDelimiter(expression.charAt(i))) {

                if (expression.charAt(i) == '(') {
                    operations.push('(');
                } else {
                    if (expression.charAt(i) == ')') {
                        while ((char) operations.peek() != '(') {
                            this.processOperation(result, (char) operations.pop());
                        }

                        operations.pop();
                    } else {
                        if (this.isOperation(expression.charAt(i))) {
                            while (!operations.empty() &&
                                getPriority((char) operations.peek()) >= getPriority(expression.charAt(i))) {
                                this.processOperation(result, (char) operations.pop());
                            }

                            operations.push(expression.charAt(i));
                        } else {
                            String number = "";
                            while (i < expression.length() && expression.charAt(i) > 47 && expression.charAt(i) < 58) {
                                number += expression.charAt(i);
                                ++i;
                            }

                            result.push(parseInt(number));
                            --i;
                        }
                    }
                }
            }
        }

        while (!operations.empty()) {
            this.processOperation(result, (char) operations.pop());
        }

        return (int) result.peek();
    }

    private boolean isDelimiter(char symbol) {
        return symbol == ' ';
    }

    private boolean isOperation(char symbol) {
        return (symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/');
    }

    private int getPriority(char operation) {
        switch (operation) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            default:
                return -1;
        }
    }

    private void processOperation(Stack result, char operation) {
        int second = (int) result.pop();
        int first  = (int) result.pop();

        switch (operation) {
            case '+':
                result.push(first + second);
                break;

            case '-':
                result.push(first - second);
                break;

            case '*':
                result.push(first * second);
                break;

            case '/':
                result.push(first / second);
                break;
        }
    }
}
