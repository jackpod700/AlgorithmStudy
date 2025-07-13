import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N,M,r,c,d;
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        r= Integer.parseInt(st.nextToken());
        c= Integer.parseInt(st.nextToken());
        d= Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for(int i=0; i<N; i++) {
            st= new StringTokenizer(br.readLine()," ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

        // Initialize the robot's position and direction
        int count = 0;
        while(true){
            // Check if the current position is clean
            if(map[r][c] == 0) {
                map[r][c] = 2; // Clean the current position
                count++;
            }

            // Check all four directions for cleaning
            if(map[r-1][c]!=0 && map[r][c+1]!=0 && map[r+1][c]!=0 && map[r][c-1]!=0) {
                r = r - dir[d][0];
                c = c - dir[d][1]; // Move back if all directions are blocked
                if(map[r][c]==1) break;
                continue;
            }
            for(int i=0; i<4; i++) {
                d = (d + 3) % 4; // Turn left
                int nr = r + dir[d][0];
                int nc = c + dir[d][1];

                if(map[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    break;
                }
            }
        }
        System.out.println(count); // Output the number of cleaned positions
    }
}

