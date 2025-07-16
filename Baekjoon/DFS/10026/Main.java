import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static char[][] map;
    static char[][] colorBlindMap;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        read();

        int normalBlocks=0, colorBlindBlocks=0;

        //정상인
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!dfs(i,j, map[i][j])) continue;
                normalBlocks++;
            }
        }

        //색맹인
        map = colorBlindMap;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!dfs(i,j, map[i][j])) continue;
                colorBlindBlocks++;
            }
        }

        System.out.println(normalBlocks + " " + colorBlindBlocks);
    }

    static void read() throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        colorBlindMap = new char[N][N];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            //정상인 맵
            map[i] = line.toCharArray();
            //색맹인 맵 R->G
            colorBlindMap[i] = line.toCharArray();
            for(int j = 0; j < N; j++) {
                if(colorBlindMap[i][j] == 'R') {
                    colorBlindMap[i][j] = 'G'; // treat R and G as the same
                }
            }
        }
    }

    public static boolean dfs(int x, int y, char color) {
        //색이 다르거나 이미 방문한 경우
        if (map[x][y] != color || map[x][y] == 'X') {
            return false;
        }

        //방문 체크
        map[x][y] = 'X'; // mark as visited

        //4방향 탐색
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx<0 || nx>=N || ny<0 || ny>=N) continue;
            dfs(nx, ny, color);
        }
        return true;
    }
}
