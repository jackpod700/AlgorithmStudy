import java.util.*;
import java.io.*;

public class Main {
	static List<String> lines=new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		for(int i=0;i<N-1;i++) {
			String s="";
			if(i==0) {
				for(int j=0;j<N;j++) s+="*";
				for(int j=0;j<2*N-3;j++) s+=" ";
				for(int j=0;j<N;j++) s+="*";
			}
			else {
				for(int j=0;j<i;j++)s+=" ";
				s+="*";
				for(int j=0;j<N-2;j++)s+=" ";
				s+="*";
				for(int j=0;j<2*N-3-(2*i);j++)s+=" ";
				s+="*";
				for(int j=0;j<N-2;j++)s+=" ";
				s+="*";
			}
			lines.add(s);
		}
		for(int i=0;i<lines.size();i++) {
			System.out.println(lines.get(i));
		}
		String s="";
		for(int j=0;j<N-1;j++)s+=" ";
		s+="*";
		for(int j=0;j<N-2;j++)s+=" ";
		s+="*";
		for(int j=0;j<N-2;j++)s+=" ";
		s+="*";
		System.out.println(s);
		for(int i=lines.size()-1;i>=0;i--) {
			System.out.println(lines.get(i));
		}
	}
}
