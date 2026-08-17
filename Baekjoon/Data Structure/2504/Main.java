/*
()()이면 더하고, (())이면 곱하고
재귀함수


*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[] input;
    static int size, curPosition;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        input = reader.readLine().toCharArray();
        size = input.length;
        curPosition=0;

        System.out.println(start());
    }

    static int start(){
        int value = 0;
        while(curPosition<size){
            if(input[curPosition]=='('||input[curPosition]=='['){
                value += mul(input[curPosition++]);
            }
            else{
                return 0;
            }
        }
        return value;
    }

    static int mul(char parentheses) {
        int value=1;

        return value;
    }

    static int add(char parentheses){

    }
}

