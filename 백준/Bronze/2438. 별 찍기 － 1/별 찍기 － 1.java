import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		for(int i=1;i<=a;i++) {
			String s = "*";
			System.out.println(s.repeat(i));
		}
	}
}