import java.util.HashMap;
import java.util.Stack;

public class InfixPostFixAlgo {
    // could also have a string that contains operators and check if contains;
    public static HashMap<Character, Integer> operators = new HashMap<>();
    // only push to head if order higher
    public static Stack<Character> operatorStack = new Stack<Character>();
    public static StringBuilder postFixNotation = new StringBuilder();

    public InfixPostFixAlgo() {
        operators.put('^', 5);
        operators.put('/', 4);
        operators.put('*', 3);
        operators.put('+', 2);
        operators.put('-', 1);
    }

    private static String infixToPostfix(final String equation){
        int pointer = 0;
        char[] equationChars = equation.toCharArray();
        while (pointer < equationChars.length) {
            char currentChar = equationChars[pointer];
            if (currentChar == ' ') {
                pointer++;
                continue;
            }
            if (currentChar == '(') {
                operatorStack.add(currentChar);
            } else if (isOperator(currentChar)) {
                while(!operatorStack.isEmpty() && checkPrecedence(checkStack()) >= checkPrecedence(currentChar)) {
                    postFixNotation.append(operatorStack.pop());
                }
                operatorStack.add(currentChar);
            } else if (currentChar == ')'){
                while(!operatorStack.isEmpty() && checkStack() != '(') {
                    postFixNotation.append(operatorStack.pop());
                }
                operatorStack.pop();
            } else {
                postFixNotation.append(currentChar);
            }
            pointer++;
        }

        for (int i=0; i<= operatorStack.size(); i++) {
            postFixNotation.append(operatorStack.pop());
        }
        return postFixNotation.toString();
    }

    private static int checkPrecedence(final char value) {
        return operators.getOrDefault(value, -1);
    }

    private static boolean isOperator(final char value) {
        return operators.containsKey(value);
    }

    private static char checkStack() {
        if (!operatorStack.isEmpty()) {
            return operatorStack.peek();
        }
        return ' ';
    }

}
