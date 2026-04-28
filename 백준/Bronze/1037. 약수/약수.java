import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] divisors = new int[n];
        for (int i = 0; i < n; i++) {
            divisors[i] = sc.nextInt();
        }
        Arrays.sort(divisors);
        int answer = divisors[0] * divisors[n - 1];
        System.out.println(answer);
    }
}