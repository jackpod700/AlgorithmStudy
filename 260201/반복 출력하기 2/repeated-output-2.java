import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        print(n);
    }
    public static void print(int n){
        if(n==0)return;
        System.out.println("HelloWorld");
        print(n-1);
    }
}