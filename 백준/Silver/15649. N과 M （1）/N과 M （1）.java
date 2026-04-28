import java.util.*;

public class Main {
	static boolean[] visited;
	static int n,m;
	static int[] nums;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt(); m=sc.nextInt();
		visited=new boolean[n];
		nums=new int[m];
		perm(0);
	}
	
	private static void perm(int cnt) {
		if(cnt==m) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<m;i++) {
				sb.append(nums[i]);
				if(i!=m-1)sb.append(" ");
			}
			System.out.println(sb);
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(visited[i]==true)continue;
			visited[i]=true;
			nums[cnt]=i+1;
			perm(cnt+1);
			visited[i]=false;
		}
	}
}
