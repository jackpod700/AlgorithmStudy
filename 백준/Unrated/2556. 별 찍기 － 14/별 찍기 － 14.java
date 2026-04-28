import java.util.*;
public class Main {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		char[] c=new char[n];
		Arrays.fill(c, '*');
		String s=String.valueOf(c);
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(s+"\n");
		}
		System.out.print(sb);
	}
}