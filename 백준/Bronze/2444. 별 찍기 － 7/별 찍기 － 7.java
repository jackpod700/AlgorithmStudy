import java.util.*;

public class Main {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
        int c=1;
		for(int i=0;i<n;i++) {
			System.out.println(" ".repeat(((1+(2*(n-1)))/2)-i)+"*".repeat(c+(2*i)));
		}
		for(int i=n-2;i>=0;i--) {
			System.out.println(" ".repeat(((1+(2*(n-1)))/2)-i)+"*".repeat(c+(2*i)));
		}
	}
}