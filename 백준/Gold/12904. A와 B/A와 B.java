import java.util.*;
import java.io.*;

public class Main {
	static String S,T;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S=br.readLine();T=br.readLine();
		boolean reversed=false;
		while(S.length()!=T.length()) {
			if(!reversed) {
				if(T.charAt(T.length()-1)=='B') reversed=!reversed;
				T=T.substring(0,T.length()-1);
			}else {
				if(T.charAt(0)=='B')reversed=!reversed;
				T=T.substring(1);
			}
		}
		if(!reversed) {
			if(!S.equals(T)) {
				System.out.println(0);
				return;
			}
			System.out.println(1);
			return;
		}
		
		for(int i=0;i<S.length();i++) {
			if(S.charAt(i)!=T.charAt(T.length()-1-i)) {
				System.out.println(0);
				return;
			}
		}
		System.out.println(1);
	}
	
}