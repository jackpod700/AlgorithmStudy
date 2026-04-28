import java.util.*;
import java.io.*;

public class Main {
    static int[][] map = new int[9][9];
    static int[] row = new int[9];
    static int[] col = new int[9];
    static int[] square = new int[9];
    static ArrayList<int[]> blanks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                int val = s.charAt(j) - '0';
                map[i][j] = val;
                
                if (val != 0) {
                    int bit = 1 << val;
                    row[i] |= bit;
                    col[j] |= bit;
                    square[(i / 3) * 3 + j / 3] |= bit;
                } else {
                    blanks.add(new int[]{i, j});
                }
            }
        }
        bt(0);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static boolean bt(int idx) {
        if (idx == blanks.size()) {
            return true;
        }
        int[] pos = blanks.get(idx);
        int r = pos[0];
        int c = pos[1];
        int sqIdx = (r / 3) * 3 + c / 3;
        
        for (int k = 1; k <= 9; k++) {
            int bit = 1 << k;

            if ((row[r] & bit) != 0 || (col[c] & bit) != 0 || (square[sqIdx] & bit) != 0) {
                continue;
            }

            map[r][c] = k;
            row[r] |= bit;
            col[c] |= bit;
            square[sqIdx] |= bit;
            
            if (bt(idx + 1)) return true;
            
            row[r] &= ~bit;
            col[c] &= ~bit;
            square[sqIdx] &= ~bit;
        }
        
        map[r][c] = 0;
        return false;
    }
}