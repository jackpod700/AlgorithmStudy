import java.io.*;
import java.util.*;

public class Main {
	static int[][] d;
	static String s1,s2;
	static StringBuilder result=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s1=br.readLine();
		s2=br.readLine();
		d=new int[s1.length()+1][s2.length()+1];
		int i=1,j=1;
		for(i=1;i<=s1.length();i++) {
			for(j=1;j<=s2.length();j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					d[i][j]=d[i-1][j-1]+1;
					continue;
				}
				d[i][j]=Math.max(d[i][j-1],d[i-1][j]);
			}
		}
		i=s1.length();
		j=s2.length();
		while(j!=0&&i!=0) {
			if(d[i][j]==d[i-1][j]) {
				i--;
				continue;
			}
			if(d[i][j]==d[i][j-1]) {
				j--;
				continue;
			}
			result.append(s1.charAt(i-1));
			i--;j--;
		}
		
		System.out.println(d[s1.length()][s2.length()]);
		System.out.print(result.reverse());
	}
}
