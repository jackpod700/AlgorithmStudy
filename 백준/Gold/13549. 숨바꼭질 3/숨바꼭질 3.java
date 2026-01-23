import java.util.*;
public class Main {
	static int n,k,max;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();k=sc.nextInt();
		max=k+2;
		if(n>=k) {
			System.out.println(n-k);
			return;
		}
		
		Queue<Branch> queue = new PriorityQueue<Branch>();
		queue.add(new Branch(n,0));
		visited = new boolean[max];
		while(!queue.isEmpty()) {
			Branch b = queue.poll();
			visited[b.cur]=true;
			if(b.cur==k) {
				System.out.println(b.stat);
				return;
			}
			for(int i=2;i*b.cur<max;i*=2) {
				if(b.cur==0)break;
				if(visited[i*b.cur]==false) queue.add(b.moveDouble(i));
			}
			if(b.cur+1<max&&visited[b.cur+1]==false) queue.add(b.moveBackward());
			if(b.cur-1>0&&visited[b.cur-1]==false) queue.add(b.moveForward());
		}
	}
	
}

class Branch implements Comparable<Branch>{
	Integer cur, stat;
	
	public Branch(int cur, int stat) {
		this.cur = cur;
		this.stat = stat;
	}

	public Branch moveDouble(int n) {
		// TODO Auto-generated method stub
		return new Branch(cur*n,stat);
	}

	public Branch moveForward() {
		// TODO Auto-generated method stub
		return new Branch(cur-1,stat+1);
	}

	public Branch moveBackward() {
		// TODO Auto-generated method stub
		return new Branch(cur+1,stat+1);
	}
	
	@Override
	public int compareTo(Branch o) {
		// TODO Auto-generated method stub
		return this.stat.compareTo(o.stat);
	}
}