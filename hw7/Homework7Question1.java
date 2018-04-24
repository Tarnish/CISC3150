/* Ryan Gadalkin : HW7Q1
   Reference/Citation - https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
                      - https://www.tutorialspoint.com/java/java_stack_class.htm
                      - http://www.vogella.com/tutorials/JavaRegularExpressions/article.html
                      - https://stackoverflow.com/questions/5633533/regular-expression-for-matching-parentheses
                      - https://stackoverflow.com/questions/35914209/infix-to-postfix-conversion-in-java
**/

import java.util.Stack;

class AlgebraFailException extends IllegalArgumentException {
    String e;
    public AlgebraFailException() {}
    public AlgebraFailException(String e) { this.e = e; }
    public String toString() { return e; }
}

class QuitMashingOnYourKeyboardException extends IllegalArgumentException {
    String e;
    public QuitMashingOnYourKeyboardException() {}
    public QuitMashingOnYourKeyboardException(String e) { this.e = e; }
    public String toString() { return e; }
}

class UserIsADumbassException extends IllegalArgumentException {
    String e;
    public UserIsADumbassException() {}
    public UserIsADumbassException(String e) { this.e = e; }
    public String toString() { return e; }
}

class DivideByZeroException extends ArithmeticException {
    String e;
    public DivideByZeroException() {}
    public DivideByZeroException(String e) { this.e = e; }
    public String toString() { return e; }
}

class InputChecker {
    InputChecker() {}

    public boolean isValidInput(String[] input) throws AlgebraFailException, QuitMashingOnYourKeyboardException, UserIsADumbassException {
        boolean isValid = true;
        try {
            if      (input.length == 0) throw new UserIsADumbassException("No input detected!");
            else if (input.length > 1)  throw new UserIsADumbassException("Too much input detected!");
            else {
                boolean isOperandTurn = false; // Cannot be operand first unless parentheses
                String[] split = input[0].split(" ");

                for (String splitString : split) {
                    if (splitString.matches("[)(]")) { // Skip checking as it can be first or last
                        continue;
                    }
                    if (isNumber(splitString) && !isOperandTurn) { // Expected operand but got unexpected
                        isOperandTurn = true;
                    }
                    else if (splitString.matches("[-+*/%]") && isOperandTurn) { // Expected number but got unexpected
                        isOperandTurn = false;
                    }
                    else if (!isOperandTurn) {
                        throw new AlgebraFailException("Expected a number but found : " + splitString);
                    }
                    else {
                        throw new QuitMashingOnYourKeyboardException("Expected an operand ( ) * / % + -  but found : " + splitString);
                    }
                }

            }
        } catch (UserIsADumbassException | QuitMashingOnYourKeyboardException | AlgebraFailException e) {
            isValid = false;
            System.err.println("[ERROR] : " + e);
        }

        return isValid; // Logical and ready to be changed into postfix notation
    }

    // https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
    // Regex may be faster/better but this works fine (without outside library)
    public static boolean isNumber(String s) {
        try {
            double placeholder = Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

class Calculation {
    Calculation() {}

    public String toPostfix(String[] input){
        Stack<String> stack = new Stack<String>();
        String postfix = "";

        for (String anInput : input) {
            if (InputChecker.isNumber(anInput)) {
                postfix = postfix + anInput + " ";
            }
            else if (anInput.equals("(")) {
                stack.push(anInput);
            }
            else if (anInput.equals(")")) {
                while (!stack.peek().equals("(")) {
                    postfix = postfix + stack.pop() + " ";
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && !(stack.peek().equals("(")) && opPrecedence(anInput) <= opPrecedence(stack.peek())) {
                    postfix = postfix + stack.pop() + " ";
                }
                stack.push(anInput);
            }
        }
        while (!stack.isEmpty()) {
            postfix = postfix + stack.pop() + " ";
        }
        return postfix;
    }

    private int opPrecedence(String str) {
        if (str.matches("[+-]")) { // [+-] "<" [*/%]
            return 0;
        }
        else if (str.matches("[*/%]")) { // [*/%] ">" [+ -]
            return 1;
        }
        return -1;
    }

    public double calculate(String input) throws DivideByZeroException {
        String[] split = input.split(" ");
        Stack<Double> op = new Stack<Double>();
        double a, b;
        for (String aSplit : split) {
            if (aSplit.matches("[-+*/%]")) {
                b = op.pop();
                a = op.pop();
                switch (aSplit) {
                    case "+": {
                        op.push(a + b);
                        break;
                    }
                    case "-": {
                        op.push(a - b);
                        break;
                    }
                    case "*": {
                        op.push(a * b);
                        break;
                    }
                    case "/": {
                        if (b == 0) {
                            throw new DivideByZeroException("Cannot divide by 0");
                        } else {
                            op.push(a / b);
                            break;
                        }
                    }
                    case "%": {
                        if (b == 0) {
                            throw new DivideByZeroException("Cannot divide by 0");
                        } else {
                            op.push(a % b);
                            break;
                        }
                    }
                }
            } else {
                op.push(Double.parseDouble(aSplit));
            }
        }
        return op.pop();
    }
}

public class Homework7Question1 {

    public static void main(String[] args) {
        InputChecker input = new InputChecker();
        System.out.println("Input was: " + args[0]);

        if (input.isValidInput(args)) {
            Calculation s = new Calculation();
            try {
                System.out.println(s.calculate(s.toPostfix(args[0].split(" "))));
            } catch (DivideByZeroException e) {
                System.err.println("[ERROR] : " + e);
            }
        }
    }
}
