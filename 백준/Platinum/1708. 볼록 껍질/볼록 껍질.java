import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static P basePoint=new P(Integer.MAX_VALUE,Integer.MAX_VALUE);
	static P[] points;
	static Stack<P> stack=new Stack<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		points=new P[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			P newP = new P(x,y);
			if(y<basePoint.y||(y==basePoint.y&&x<basePoint.x)) basePoint=newP;
			points[i]=newP;
		}
		Arrays.sort(points);
		P p3;
		stack.add(points[0]);
		stack.add(points[1]);
		for(int i=2;i<N;i++) {
			p3=points[i];
			while (stack.size() >= 2 && CCW(stack.get(stack.size() - 2), stack.peek(), p3) <= 0) {
                stack.pop();
            }
			stack.add(p3);
		}
		System.out.println(stack.size());
	}
	
	static class P implements Comparable<P>{
		long x,y;
		public P(long x,long y) {
			this.x=x;
			this.y=y;
		}
		
		long dist(P p) {
			long dx=Math.abs(this.x-p.x);
			long dy=Math.abs(this.y-p.y);
			return dx*dx+dy*dy;
		}
		
		@Override
		public int compareTo(P o) {
			// TODO Auto-generated method stub
			long ccw=CCW(basePoint,this,o);
			if(ccw>0) return -1;
			else if(ccw<0)return 1;
			else return Long.compare(basePoint.dist(this), basePoint.dist(o));
		}
	}
	
	static long CCW(P p1,P p2,P p3) {
		return (p2.x-p1.x)*(p3.y-p1.y)-(p2.y-p1.y)*(p3.x-p1.x);
	}
}
