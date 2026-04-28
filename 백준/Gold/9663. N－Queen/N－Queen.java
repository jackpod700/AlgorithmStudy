import java.io.*;

public class Main {
    static int N, count;
    static int limit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        limit = (1 << N) - 1;

        for (int i = 0; i < N / 2; i++) {
            int bit = (1 << i);
            solve(bit, bit << 1, bit >>> 1);
        }
        count *= 2;

        if (N % 2 == 1) {
            int bit = (1 << (N / 2));
            solve(bit, bit << 1, bit >>> 1);
        }

        System.out.println(count);
    }

    static void solve(int col, int ld, int rd) {
        if (col == limit) {
            count++;
            return;
        }

        int possibilities = ~(col | ld | rd) & limit;

        while (possibilities != 0) {

            int bit = possibilities & -possibilities;

            possibilities -= bit;
            solve(col | bit, (ld | bit) << 1, (rd | bit) >>> 1);
        }
    }
}