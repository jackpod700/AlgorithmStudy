import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int sum=0;
		for(int i=1;i<=5;i++) {
			sum+=Math.pow(sc.nextInt(),2);
		}
		System.out.println(sum%10);
	}
}
