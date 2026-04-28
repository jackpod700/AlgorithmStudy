import java.util.*;
import java.io.*;

public class Main {
    static int N,result=0,score=0,out=0,index=0;
    static int[][] scores;
    static int stat=0;
    static int[] bats= {4,6,7,7};//1루타,2루타,3루타,홈런 쳤을때 득점하는 곳
    static int[] sequence= {2,3,4,5,6,7,8,9};
    static int[] sequence_1= {2,3,4,1,5,6,7,8,9};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        scores = new int[N][9];
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++) {
                scores[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        do {
            result = Math.max(result,play());
        }while(np(sequence.length-1));
        System.out.println(result);
    }

    static int play() {
        // TODO Auto-generated method stub
        score=0;index=0;
        for(int inning=0;inning<N;inning++) {
        	stat=0;
        	out=0;
            while(out!=3) {
            	int player = sequence_1[index]-1;
                int bat=scores[inning][player];
                if(bat==0)out++;
                else {
                	score += Integer.bitCount(stat & bats[bat-1]);
                	stat=(stat<<bat)|(1<<(bat-1))&7;
                    if(bat==4) score+=1;
	            }

	            index=(index+1)%9;
            }
        }
        return score;
    }

	static boolean np(int size) {
	    int i=size;
	    while(i>0&&(sequence[i-1]>sequence[i]))i--;
	    if(i==0)return false;
	    int j=size;
	    while(sequence[i-1]>sequence[j])j--;
	    int temp=sequence[i-1];
	    sequence[i-1]=sequence[j];
	    sequence[j]=temp;
	    int k=size;
	    while(i<k) {
	        temp=sequence[i];
	        sequence[i]=sequence[k];
	        sequence[k]=temp;
	        i++;k--;
	    }
	    for(i=0;i<9;i++) {
	    	if(i<3) {
	    		sequence_1[i]=sequence[i];
	    		continue;
	    	}
	    	if(i==3) {
	    		sequence_1[i]=1;
	    		continue;
	    	}
	    	if(i>3) {
	    		sequence_1[i]=sequence[i-1];
	    	}
	    }
	    return true;
	}
}

