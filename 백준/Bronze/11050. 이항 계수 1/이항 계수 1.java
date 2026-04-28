import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt(),K=sc.nextInt();
		int result=1;
		if(K==0) {
			System.out.println(1); return;
		}
		for(int i=1;i<=K;i++) {
			result*=N-i+1;
			result/=i;
		}
		System.out.println(result);
	}
}