import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Scanner 대신 속도가 빠른 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 테스트 케이스 개수 입력
        int t = Integer.parseInt(br.readLine());
        
        // 출력 결과를 한 번에 모아서 출력하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            // 공백을 기준으로 문자열을 분리하기 위해 StringTokenizer 사용
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a의 1의 자리 숫자만 구함
            int base = a % 10; 
            
            // 1의 자리가 0인 경우는 항상 10번 컴퓨터
            if (base == 0) {
                sb.append(10).append("\n");
                continue;
            }

            // 지수 b는 4를 주기로 반복됨
            b = b % 4;
            if (b == 0) {
                b = 4; // 나머지가 0이면 4번째 패턴
            }

            int result = 1;
            // 주기만큼만 거듭제곱하여 1의 자리 숫자를 구함
            for (int j = 0; j < b; j++) {
                result = (result * base) % 10;
            }

            sb.append(result).append("\n");
        }

        // 결과 한 번에 출력
        System.out.print(sb);
    }
}