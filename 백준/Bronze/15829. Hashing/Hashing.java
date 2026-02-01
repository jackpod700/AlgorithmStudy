import java.util.*;
import java.io.*;

public class Main {
	static final int r=31,M=1234567891;
	static int L;
	static String s;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L=Integer.parseInt(br.readLine());
		s=br.readLine();
		long H=0,cr=1;
		for(int i=0;i<L;i++) {
			H=(H+(s.charAt(i)-'a'+1)*cr)%M;
			cr=(cr*r)%M;
		}
		System.out.println(H);
	}
}