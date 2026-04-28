import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

// 값과 원래 인덱스를 함께 저장하기 위한 클래스
class Element implements Comparable<Element> {
    int value;
    int index;

    public Element(int value, int index) {
        this.value = value;
        this.index = index;
    }

    // 정렬 기준 정의
    @Override
    public int compareTo(Element other) {
        if (this.value == other.value) {
            // 값이 같을 경우, 원래 인덱스가 작은 것이 앞으로 오도록 (안정 정렬)
            return this.index - other.index;
        }
        // 기본적으로 값을 기준으로 오름차순 정렬
        return this.value - other.value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        // 입출력 속도 향상을 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Element[] arr = new Element[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            // 입력받은 값과 현재의 인덱스(i)를 Element 객체로 생성하여 배열에 저장
            arr[i] = new Element(Integer.parseInt(st.nextToken()), i);
        }

        // Element 클래스에 정의된 compareTo 기준에 따라 배열 정렬
        Arrays.sort(arr);

        // 결과를 저장할 배열 P
        int[] P = new int[N];
        
        // 정렬된 배열을 순회하며, 원래 인덱스 위치에 현재 순위(i)를 기록
        for (int i = 0; i < N; i++) {
            P[arr[i].index] = i;
        }

        // 빠른 출력을 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(P[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}