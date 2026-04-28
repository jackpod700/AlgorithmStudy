import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static double sum=0,max=0;
	static double[] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		v=new double[n];
		for(int i=0;i<n;i++) {
			v[i]=sc.nextInt();
			max=Math.max(max, v[i]);
		}
		for(int i=0;i<n;i++) {
			v[i] = v[i]*100/max;
			sum+=v[i];
		}
		System.out.println(sum/n);
	}
}
