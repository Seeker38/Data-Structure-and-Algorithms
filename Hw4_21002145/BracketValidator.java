package Hw4_21002145;

import java.util.Scanner;

public class BracketValidator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();
        input.close();
        boolean check = isValid(expression);
        if (check) {
            System.out.println("bieu thuc hop le ve dau ngoac");
            System.out.println(evaluateExpression("Output: " + expression));
        } else {
            System.out.println("bieu thuc khong hop le ve dau ngoac");
        }
        // evaluateExpression(expression);

    }

    public static boolean isValid(String expression) {
        ArrayStack<Character> stack = new ArrayStack<>(expression.length());
        // LinkedListStack<Character> stack = new LinkedListStack<>();

        boolean isValid = true;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                char top = stack.top();
                if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')) {
                    stack.pop();
                } else {
                    isValid = false;
                    return isValid;
                }
            }
        }

        if (isValid && stack.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    private static double evaluateExpression(String expression) {
        LinkedListStack<Double> operands = new LinkedListStack<>();
        LinkedListStack<Character> operators = new LinkedListStack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                double num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                i--;
                operands.push(num);
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (operators.top() != '(') {
                    double b = operands.pop();
                    double a = operands.pop();
                    char op = operators.pop();
                    double result = Operation(a, b, op);
                    operands.push(result);
                }
                operators.pop();
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && precedence(c) <= precedence(operators.top())) {
                    double b = operands.pop();
                    double a = operands.pop();
                    char op = operators.pop();
                    double result = Operation(a, b, op);
                    operands.push(result);
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            double b = operands.pop();
            double a = operands.pop();
            char op = operators.pop();
            double result = Operation(a, b, op);
            operands.push(result);
        }

        return operands.top();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int precedence(char op) {
        switch (op) {
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    private static double Operation(double a, double b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
