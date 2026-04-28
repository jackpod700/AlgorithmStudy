import java.util.*;

public class Main {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
        int c=1;
		for(int i=n-1;i>=0;i--) {
			System.out.println(" ".repeat(((1+(2*(n-1)))/2)-i)+"*".repeat(c+(2*i)));
		}
	}
}