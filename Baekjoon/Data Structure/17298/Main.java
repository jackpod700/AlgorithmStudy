/*
 * 스택을 이용
 * 1. 스택에 넣으려는 숫자 A와 스택의 가장 위 숫자 B의 크기를 비교한다.
 * 1.a A가 B보다 크다면 스택에서 B를 빼고 B의 NGE는 A가 된다
 * 1.b 스택이 비어있거나, A가 B보다 작다면 스택에 A를 넣는다
 * 2. 더이상 넣을 숫자가 없을때까지 1을 반복하고, 스택에 남아있는 숫자들은 NGE가 -1이 된다.
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    static int N;
    static Stack<Node> stack = new Stack<>();
    static List<Node> nodes = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        N = read();
        for(int i=0; i<N; i++) {
            int value = read();
            Node node = new Node(value);
            nodes.add(node);
            while (!stack.isEmpty() && stack.peek().value < value) {
                stack.pop().nge = value;
            }
            stack.push(node);
        }
        StringBuilder sb = new StringBuilder();
        for (Node node : nodes) {
            sb.append(node.nge).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}

class Node {
    public int value;
    public int nge;

    Node(int value) {
        this.value = value;
        this.nge = -1; // 초기값은 -1
    }
}
