import java.util.*;
import java.io.*;

public class Main{
	static int N;
	static int[] nums;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		nums=new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			nums[i]=Integer.parseInt(st.nextToken());
		}
		int s=0,e=N-1;
		int result=Integer.MAX_VALUE,ms=s,me=e;
		while(s!=e) {
			if(result>Math.abs(nums[s]+nums[e])) {
				result=Math.abs(nums[s]+nums[e]);
				ms=s;me=e;
			}
			if(nums[s]+nums[e]==0) {
				ms=s;me=e;
				result=0;
				break;
			}
			if(nums[s]+nums[e]<0) s++;
			else e--;
		}
		System.out.println(nums[ms]+" "+nums[me]);
	}
}
