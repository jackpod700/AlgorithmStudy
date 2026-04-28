import java.io.*;

public class Main {
	static String in;
	static boolean[][] able;//[시작][끝]의 범위가 팰린드롬인지
	static int[] cnt;//[위치]까지의 팰린드롬 개수
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		in=br.readLine();
		able=new boolean[in.length()][in.length()];
		for(int i=0;i<in.length();i++) able[i][i]=true;
		cnt=new int[in.length()+1];
		cnt[0]=0;
		cnt[1]=1;
		for(int size=1;size<in.length();size++) {
			for(int start=0;start<in.length()-size;start++) {
				int end=start+size;
				if(in.charAt(start)==in.charAt(end)) {
					if(size==1||able[start+1][end-1])able[start][end]=true;
				}
			}
		}
		for(int i=2;i<=in.length();i++) {
			cnt[i]=cnt[i-1]+1;
			for(int start=i;start>0;start--) {
				if(able[start-1][i-1]) cnt[i]=Math.min(cnt[i], cnt[start-1]+1);
			}
		}
		System.out.println(cnt[in.length()]);
	}
}
