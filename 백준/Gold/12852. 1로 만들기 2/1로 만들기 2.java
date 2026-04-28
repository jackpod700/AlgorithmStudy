import java.util.*;

public class Main{
	static int d[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		d=new int[n+1][2];
		
		System.out.println(dp(n));
		StringBuilder sb=new StringBuilder();
		while(n>0) {
			sb.append(n+" ");
			n=d[n][1];
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	static int dp(int i) {
		if(d[i][0]!=0||i==1)return d[i][0];
		if((i%3==0&&i/3==1)||(i%2==0&&i/2==1)||i-1==1) {
			d[i][0]=d[i][1]=1;
			return d[i][0];
		}
		int _1=Integer.MAX_VALUE,_1i=0,_2=Integer.MAX_VALUE,_2i=0,_3=Integer.MAX_VALUE,_3i=0;
		int min=Integer.MAX_VALUE,mini=0;
		if(i%3==0) {
			_3=dp(i/3);
			_3i=i/3;
			if(min>_3) {
				min=_3;
				mini=_3i;
			}
		}
		if(i%2==0) {
			_2=dp(i/2);
			_2i=i/2;
			if(min>_2) {
				min=_2;
				mini=_2i;
			}
		}
		_1=dp(i-1);
		_1i=i-1;
		if(min>_1) {
			min=_1;
			mini=_1i;
		}
		
		d[i][0]=min+1;d[i][1]=mini;
		return d[i][0];
	}
}
