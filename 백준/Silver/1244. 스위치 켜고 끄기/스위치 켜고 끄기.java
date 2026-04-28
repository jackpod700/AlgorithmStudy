import java.util.*;
import java.io.*;
public class Main {
	static int N,students;
	static boolean[] led;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		led=new boolean[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			if(Integer.parseInt(st.nextToken())==1) led[i]=true;
		}
		students = Integer.parseInt(br.readLine());
		for(int i=0;i<students;i++) {
			st = new StringTokenizer(br.readLine());
			int gender=Integer.parseInt(st.nextToken());
			int number=Integer.parseInt(st.nextToken());
			if(gender==1) {
				for(int j=number;j<=N;j+=number) {
					led[j]=!led[j];
				}
			}
			else {
				led[number]=!led[number];
				for(int size=1;;size++) {
					if(number-size==0||number+size==N+1) break;
					if(led[number+size]!=led[number-size])break;
					led[number-size]=led[number+size]=!led[number+size];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			if(led[i]) sb.append("1");
			else sb.append("0");
            if(i%20==0) sb.append("\n");
            else sb.append(" ");
            
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
