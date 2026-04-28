import java.util.*;

public class Main {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
        int c=1;
		for(int i=n-2;i>=0;i--) {
			System.out.println("*".repeat(((1+(2*(n-1)))/2)-i)+" ".repeat(2*(c+i))+"*".repeat(((1+(2*(n-1)))/2)-i));
		}
		System.out.println("*".repeat(2*n));
		
		for(int i=0;i<n;i++) {
			System.out.println("*".repeat(((1+(2*(n-1)))/2)-i)+" ".repeat(2*(c+i))+"*".repeat(((1+(2*(n-1)))/2)-i));
		}

	}
}