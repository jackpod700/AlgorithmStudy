import java.util.*;
import java.io.*;
public class Main {
    static int[] dr= {-1,0,0,1},dc= {0,-1,1,0};
    static int N,M;
    static char[][] map;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited=new boolean[N][M][64];
        Minsik m=null;
        for(int i=0;i<N;i++) {
            String s=br.readLine();
            for(int j=0;j<M;j++) {
                map[i][j]=s.charAt(j);
                if(map[i][j]=='0') {
                    m=new Minsik(i,j,0,0);
                    map[i][j]='.';
                }
            }
        }
        Queue<Minsik> queue=new ArrayDeque<>();
        queue.offer(m);
        visited[m.r][m.c][m.keys]=true;
        while(!queue.isEmpty()) {
            Minsik curM=queue.poll();
            for(int i=0;i<4;i++) {
                int nr=curM.r+dr[i];
                int nc=curM.c+dc[i];
                if(check(nr,nc,curM.keys)) {
                    if(map[nr][nc]=='1') {
                        System.out.println(curM.time+1);
                        return;
                    }
                    if(map[nr][nc]=='.'||(map[nr][nc]>='A'&&map[nr][nc]<='F')) {
                        queue.offer(new Minsik(nr,nc,curM.time+1,curM.keys));
                        visited[nr][nc][curM.keys]=true;
                    }
                    else {
                        int newkey=(curM.keys|(1<<(map[nr][nc]-'a')));
                        queue.offer(new Minsik(nr,nc,curM.time+1,newkey));
                        visited[nr][nc][newkey]=true;
                    }
                    
                }
            }
        }
        System.out.println(-1);
    }
    
    static boolean check(int nr,int nc,int keys) {
        if(nr>=0&&nr<N&&nc>=0&&nc<M) {
            char value=map[nr][nc];
            if(value=='#'||
            		visited[nr][nc][keys]||
            		(value>='A'&&value<='F'&&((keys&(1<<(value-'A')))==0)))return false;
            return true;
        }
        return false;
    }
    
    static class Minsik{
        int r=0,c=0,time,keys;
        public Minsik(int r,int c,int time,int keys) {
            this.r=r;
            this.c=c;
            this.time=time;
            this.keys=keys;
        }
    }
}