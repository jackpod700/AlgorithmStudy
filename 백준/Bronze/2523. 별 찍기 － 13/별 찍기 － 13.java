import java.util.*;
public class Main {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		StringBuilder sb= new StringBuilder();
		recur(sb,1);
		System.out.print(sb);
	}
	public static void recur(StringBuilder sb,int i) {
		char[] c=new char[i];
		Arrays.fill(c, '*');
		String s= String.valueOf(c);
		sb.append(s.toString()+"\n");
		if(i==n)return;
		recur(sb,i+1);
		sb.append(s.toString()+"\n");
	}
}