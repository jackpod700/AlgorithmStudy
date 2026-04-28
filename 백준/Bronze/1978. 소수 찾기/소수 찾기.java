import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt(), count=0;
		for(int i=0;i<N;i++) {
			if(isPrime(sc.nextInt())) count++;
		}
		System.out.println(count);
		
	}
	
	static boolean isPrime(int num) {
		if(num==1)return false;
		if(num==2)return true;
		for(int i=2;i<num;i++) {
			if(num%i==0)return false;
		}
		return true;
	}
}
