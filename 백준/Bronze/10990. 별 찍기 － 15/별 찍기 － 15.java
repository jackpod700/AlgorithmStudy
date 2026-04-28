import java.util.*;
public class Main {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<n;i++) {
			char[] c=new char[n+i];
			Arrays.fill(c, ' ');
			c[c.length-1]='*';
			c[n-1-i]='*';
			String s=String.valueOf(c);
			sb.append(s+"\n");
		}
		System.out.print(sb);
	}
}
