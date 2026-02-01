import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		int[] level0= {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		for(int i=0;i<t;i++) {
			int k=Integer.parseInt(br.readLine()),n=Integer.parseInt(br.readLine())-1;
			int[] under=level0,current=new int[n+1];
			for(int level=0;level<k;level++) {
				for(int num=0;num<=n;num++) {
					if(num==0) {
						current[num]=1;
						continue;
					}
					current[num]=current[num-1]+under[num];
				}
				under=current;
			}
			System.out.println(current[n]);
		}
	}
}