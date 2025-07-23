/*
스택 사용
1. 스택에 탑 A를 넣을때
1.a 스택이 비어있으면 A의 수신탑은 0이 되고 스택에 넣는다.
1.b 스택이 비어있지 않으면 스택의 탑과 비교한다
1.b.1 만약 스택의 탑이 A보다 작으면 스택의 탑을 pop하고 다시 비교한다.
1.b.2 만약 스택의 탑이 A보다 크거나 같으면 A의 수신탑은 스택의 탑의 인덱스가 되고 A를 스택에 넣는다.
* */

import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            Node a = new Node(read(), i + 1);
            while(!stack.isEmpty() && stack.peek().value < a.value) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                sb.append("0 ");
                stack.push(a);
            } else {
                sb.append(stack.peek().index).append(" ");
                stack.push(a);
            }
        }
        System.out.println(sb.toString().trim());
    }
    static class Node {
        int value;
        int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
