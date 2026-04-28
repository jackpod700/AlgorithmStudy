/*
 * kmp알고리즘을 이용하여 폭발 문자열을 찾고, 문자열을 붙인다
 * 새로 만들어진 문자열에 대해 현재 위치에서 폭발문자열의 길이만큼 다시 앞으로가서 kmp 알고리즘을 계속 진행한다
 * */

import java.io.BufferedReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==bomb.charAt(bomb.length()-1) && stack.size()>=bomb.length()-1){
                boolean isBomb = true;
                for(int j=0;j<bomb.length()-1;j++){
                    if(stack.get(stack.size()-1-j)!=bomb.charAt(bomb.length()-2-j)){
                        isBomb = false;
                        break;
                    }
                }

                if(isBomb){
                    for(int j=0;j<bomb.length()-1;j++){
                        stack.pop();
                    }
                    continue;
                }
            }
            stack.push(str.charAt(i));

        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String result = sb.reverse().toString();
        if(result.isEmpty()) {
            System.out.println("FRULA");
        } else {
            System.out.println(result);
        }

    }
}
