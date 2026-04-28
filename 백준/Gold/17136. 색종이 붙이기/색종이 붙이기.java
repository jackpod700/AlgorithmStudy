import java.util.*;
import java.io.*;

public class Main{
    static int[][] map = new int[10][10];
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    static void dfs(int r, int c, int cnt) {
        if (cnt >= min) return;
        if (c == 10) {
            dfs(r + 1, 0, cnt);
            return;
        }

        if (r == 10) {
            min = Math.min(min, cnt);
            return;
        }

        if (map[r][c] == 0) {
            dfs(r, c + 1, cnt);
            return;
        }

        for (int size = 5; size >= 1; size--) {
            if (paper[size] > 0 && isAttachable(r, c, size)) {
                attach(r, c, size, 0);
                paper[size]--;

                dfs(r, c + 1, cnt + 1);

                attach(r, c, size, 1);
                paper[size]++;
            }
        }
    }

    static boolean isAttachable(int r, int c, int size) {
        if (r + size > 10 || c + size > 10) return false;

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (map[i][j] == 0) return false;
            }
        }
        return true;
    }

    static void attach(int r, int c, int size, int state) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                map[i][j] = state;
            }
        }
    }
}