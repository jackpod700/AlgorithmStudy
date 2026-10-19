import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            long[] a = new long[k + 1];
            long[] b = new long[k + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= k; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= k; i++) {
                b[i] = Long.parseLong(st.nextToken());
            }

            while (q-- > 0) {
                long d = Long.parseLong(br.readLine());

                int left = 0, right = k;

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (a[mid] < d) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                int r = left;

                if (a[r] == d) {
                    sb.append(b[r]).append(' ');
                    continue;
                }

                int l = r - 1;

                long time = b[l]
                        + (d - a[l]) * (b[r] - b[l])
                        / (a[r] - a[l]);

                sb.append(time).append(' ');
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }
}