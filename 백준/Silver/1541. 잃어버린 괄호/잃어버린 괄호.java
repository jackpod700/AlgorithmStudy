import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("-");
        int ans = 0;
        for(int i = 0; i < str.length; i++) {
            String[] sum = str[i].split("\\+");
            int cnt = 0;
            for(int j = 0; j < sum.length; j++) {
                cnt += Integer.parseInt(sum[j]);
            }

            if(i==0) ans += cnt;
            else ans -= cnt;
        }
        System.out.println(ans);
    }
}