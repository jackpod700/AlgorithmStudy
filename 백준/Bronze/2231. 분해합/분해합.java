import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		for(int i=1;i<N;i++) {
			int sum=i;
			int divider=1000000;
			while(divider>1) {
				sum+=(i%divider)/(divider/10);
				divider/=10;
			}
			if(sum==N) {
				System.out.println(i);
				return;
			}
		}
		System.out.println("0");
	}
}
