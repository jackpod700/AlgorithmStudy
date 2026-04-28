import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		if(n%400==0||(n%4==0&&n%100!=0)) {
			System.out.println("1");
			return;
		}
		System.out.println("0");
		
	}
}
