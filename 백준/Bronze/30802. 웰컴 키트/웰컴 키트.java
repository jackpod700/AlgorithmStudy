import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt(), Tshirt=0;
		int[] sizes = new int[6];
		for(int i=0;i<6;i++) {
			sizes[i]=sc.nextInt();
		}
		int T=sc.nextInt(),P=sc.nextInt();
		for(int i=0;i<6;i++) {
			Tshirt+=(sizes[i]/T);
			if(sizes[i]%T!=0) Tshirt++;
		}
		System.out.println(Tshirt);
		System.out.println(N/P+" "+N%P);
		
	}
}
