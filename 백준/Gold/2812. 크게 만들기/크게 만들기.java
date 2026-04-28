import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        int finalLength = N - K;
 
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            while (K > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < current) {
                sb.deleteCharAt(sb.length() - 1);
                K--;
            }
            sb.append(current);
        }

        System.out.println(sb.substring(0, finalLength));
    }
}