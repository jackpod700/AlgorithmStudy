import java.util.*;
import java.io.*;

public class Main {
	static final int r=31,M=123457891;
	static int L;
	static String s;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L=Integer.parseInt(br.readLine());
		s=br.readLine();
		int H=0;
		for(int i=0;i<s.length();i++) {
			H+=(s.charAt(i)-'a'+1)*Math.pow(r, i);
		}
		System.out.println(H%M);
	}
}
