import java.util.*;
import java.io.*;

public class Main{
	static int N,M;
	static int[] list;
	static int[] nums;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		list=new int[N];
		nums=new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			list[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);
		perm(0,0);
	}
	
	static void perm(int depth,int start) {
		if(depth==M) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<M;i++) {
				sb.append(nums[i]+" ");
			}
			sb.setLength(sb.length()-1);
			System.out.println(sb);
			return;
		}
		for(int i=start;i<N;i++) {
			if(nums[depth]==list[i])continue;
			nums[depth]= list[i];
			if(depth!=M-1) {
				nums[depth+1]=0;
			}
			perm(depth+1,i);
		}
	}
}
