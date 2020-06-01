import java.util.Stack;

public class EvaluatePostFix {
    public static String operators = "+-^*/";

    public static void main(String[] args){
        System.out.println(evaluatePostFix("6 2 3 + - 3 8 2 / + * 2 ^ 3 +"));
    }

    private static int evaluatePostFix(final String infix) {
        Stack<Integer> numberStack = new Stack<>();
        String[] infixCharacters = infix.split("");
        for (String i: infixCharacters) {
            if (i.equals(" ")) {
                continue;
            } else if (isOperator(i)) {
                if (numberStack.size() >=2) {
                    int operand2 = numberStack.pop();
                    int operand1 = numberStack.pop();
                    int operatorActioned = actionOperator(operand1, operand2, i);
                    if (operatorActioned != Integer.MIN_VALUE) {
                        numberStack.add(operatorActioned);
                    }
                }
            } else {
                numberStack.add(Integer.parseInt(i));
            }
        }
        return numberStack.pop();
    }

    private static int actionOperator(int operand1, int operand2, String operator) {
        switch (operator) {
            case("+"):
                return operand1 + operand2;
            case("-"):
                return operand1 - operand2;
            case("^"):
                return (int) Math.pow(operand1, operand2);
            case("*"):
                return operand1 * operand2;
            case("/"):
                if (operand2 == 0) {
                    return Integer.MIN_VALUE;
                }
                return operand1 / operand2;
            default:
                return Integer.MIN_VALUE;
        }
    }

    private static boolean isOperator(String i) {
        return operators.contains(i);
    }
}
