import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
				
		int A=Integer.parseInt(st.nextToken()), B=Integer.parseInt(st.nextToken());
		int gcd = GCD(A,B);
		System.out.println(gcd);
		System.out.println(A*B/gcd);
	}
	
	private static int GCD(int A, int B) {
		if(A==B) return A;
		if(A>B) return GCD(A-B,B);
		return GCD(B-A,A);
	}
}