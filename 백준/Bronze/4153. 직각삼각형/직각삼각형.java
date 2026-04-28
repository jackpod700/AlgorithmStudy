import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int a=1,b=1,c=1;
		while(true) {
			a=(int) Math.pow(sc.nextInt(),2);
			b=(int) Math.pow(sc.nextInt(),2);
			c=(int) Math.pow(sc.nextInt(),2);
			if(a==0&&b==0&&c==0) break;
			int max = Math.max(Math.max(a, b),c);
			if(Math.abs(max-(a+b+c))==max) System.out.println("right");
			else System.out.println("wrong");
		}
		
	}
}
