import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt(), b=sc.nextInt();
		if(a>b) {
			System.out.println(">");
		}
		else if(a<b) {
			System.out.println("<");
		}
		else {
			System.out.println("==");
		}
	}
}