import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {

    static int N,M;
    static int[][] arr;
    static Stack<Integer[]> checkStack = new Stack<>(); // 스택을 사용하여 확인해야할 좌표를 저장
    static int round=0;
    static int total,ripeCount=0;

    public static void main(String[] args) throws IOException {

        read();

        while(!checkStack.isEmpty()) {
            Stack<Integer[]> tempStack = new Stack<>();
            while(!checkStack.isEmpty()){
                Integer[] current = checkStack.pop();
                int x = current[0];
                int y = current[1];

                if (x > 0 && arr[x - 1][y] == 0){
                    arr[x - 1][y] = 1; // 익은 토마토로 변경
                    ripeCount++;
                    tempStack.push(new Integer[]{x - 1, y});
                }
                if (x < N - 1 && arr[x + 1][y] == 0){
                    arr[x + 1][y] = 1; // 익은 토마토로 변경
                    ripeCount++;
                    tempStack.push(new Integer[]{x + 1, y});
                }
                if (y > 0 && arr[x][y - 1] == 0){
                    arr[x][y - 1] = 1; // 익은 토마토로 변경
                    ripeCount++;
                    tempStack.push(new Integer[]{x, y - 1});
                }
                if (y < M - 1 && arr[x][y + 1] == 0){
                    arr[x][y + 1] = 1; // 익은 토마토로 변경
                    ripeCount++;
                    tempStack.push(new Integer[]{x, y + 1});
                }
            }
            if(tempStack.isEmpty()) break; // 더 이상 탐색할 곳이 없으면 종료
            checkStack.addAll(tempStack); // 다음 라운드에 탐색할 좌표를 스택에 추가
            round++; // 라운드 증가
        }
        if(total==ripeCount) System.out.println(round);
        else System.out.println(-1); // 만약 모든 토마토가 익지 않았다면 -1 출력
    }

    static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M= Integer.parseInt(st.nextToken());
        N= Integer.parseInt(st.nextToken());
        total = N*M;
        arr = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    checkStack.push(new Integer[]{i, j}); // 1인 좌표를 스택에 추가
                    ripeCount++; // 익은 토마토 개수 증가
                }
                else if(arr[i][j] == -1) {
                    total--; // -1인 좌표는 총 개수에서 제외
                }
            }
        }
    }
}
