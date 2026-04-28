import java.io.*;
public class Main {
	static int N,wordlength;
	static String[] words;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		words=new String[N];
		for(int i=0;i<N;i++)words[i]=br.readLine();
		wordlength=words[0].length();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<wordlength;i++) {
			char c=words[0].charAt(i);
			boolean allSame=true;
			for(int j=0;j<N;j++) {
				if(c!=words[j].charAt(i)) {
					allSame=false;
					break;
				}
			}
			if(allSame)sb.append(c);
			else sb.append('?');
		}
		System.out.println(sb);
	}
}
