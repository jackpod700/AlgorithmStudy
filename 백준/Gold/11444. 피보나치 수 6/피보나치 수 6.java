import java.util.*;
import java.io.*;
//a_(2m+1)=(a_(m+1))^2+(a_m)^2
//a_2m=(a_(m+1)*a_m)+(a_m*a_(m-1))
public class Main {
	static final int DIV=1_000_000_007;
	static HashMap<Long, Long> map = new HashMap<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(f(Long.parseLong(br.readLine())));
	}
	
	static long f(long n) {
		if(n==0)return 0;
		if(n==1)return 1;
		if(n==2)return 1;
		if(map.get(n)!=null)return map.get(n);
		if(n%2!=0) {
			long a_mp1=f(n/2 + 1);
			long a_m=f(n/2);
			map.put(n, ((a_mp1*a_mp1)%DIV + (a_m*a_m)%DIV)%DIV);
		}
		else {
			long a_mp1=f(n/2 + 1);
			long a_m=f(n/2);
			long a_mm1=f(n/2 - 1);
			map.put(n, ((a_mp1*a_m)%DIV + (a_m*a_mm1)%DIV)%DIV);
		}
		return map.get(n);
	}
}
