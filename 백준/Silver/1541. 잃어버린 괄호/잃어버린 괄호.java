import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		int result=0,in;
		String num="";
		boolean isMinus=false;
		while((in=System.in.read())!=-1) {
			if(in>47&&in<58) {
				num = num+(char)in;
				continue;
			}
			Integer curNum=Integer.parseInt(num);
			num="";
			
			if(isMinus)result-=curNum;
			else result+=curNum;
			
			if(in==45&&!isMinus) {// '-'
				isMinus=!isMinus;
			}
			continue;
		}
		System.out.println(result);
	}
}