/*
스택을 이용하여 후위 표기법으로 변환

피연산자는 무조건 출력

스택이 비어있을 때
1. 연산자를 만나면 스택에 넣는다.
2. 여는 괄호를 만나면 스택에 넣는다

스택의 top에 연산자가 있을 때
1. 연산자를 만나면 우선순위를 비교한다.
   - 스택의 top에 있는 연산자의 우선순위가 현재 연산자의 우선순위보다 높거나 같으면 스택에서 pop하고 출력한다. top연산자의 우선순위가 더 낮을때까지 반복한다.
   - 그렇지 않으면 현재 연산자를 스택에 넣는다.
2. 여는 괄호를 만나면 스택에 넣는다
3. 닫는 괄호를 만나면 스택에서 pop하고 출력한다. 여는 괄호가 나올 때까지 반복한다. 여는 괄호는 출력하지 않는다.

스택의 top에 여는 괄호가 있을 때
1. 연산자를 만나면 스택에 넣는다.

입력이 끝났을때
1. 스택에 남아있는 연산자를 모두 pop하고 출력한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        String expression = reader.readLine(); // 입력받은 중위 표기법
        String postfix = infixToPostfix(expression);
        System.out.println(postfix);
    }

    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (Character.isLetter(ch)) {
                result.append(ch); // 피연산자 출력
            } else if (ch == '(') {
                stack.push(ch); // 여는 괄호 스택에 넣기
            } else if (ch == ')') {
                while (stack.peek() != '(') {
                    result.append(stack.pop()); // 닫는 괄호까지 pop하고 출력
                }
                stack.pop(); // 여는 괄호 제거
            } else { // 연산자
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    result.append(stack.pop()); // 우선순위가 높은 연산자 pop하고 출력
                }
                stack.push(ch); // 현재 연산자 스택에 넣기
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop()); // 남아있는 연산자 모두 pop하고 출력
        }

        return result.toString();
    }

    private static int precedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0;
        };
    }
}
