import java.util.*;

public class Main {
	static String s1,s2;
	static int[][] d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s1=sc.nextLine();
		s2=sc.nextLine();
		d=new int[s2.length()+1][s1.length()+1];
		
		for(int i=1;i<s2.length()+1;i++) {
			for(int j=1;j<s1.length()+1;j++) {
				char curChar=s2.charAt(i-1);
				if(curChar==s1.charAt(j-1)) {
					d[i][j]=d[i-1][j-1]+1;
				}
				else {
					d[i][j]=Math.max(d[i-1][j], d[i][j-1]);
				}
			}
		}
		System.out.println(d[s2.length()][s1.length()]);
	}
}