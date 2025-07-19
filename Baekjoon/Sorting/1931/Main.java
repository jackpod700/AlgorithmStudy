//들어갈 수 있는 회의 중 회의가 끝나는 시간이 가장 빠른 회의를 넣는다.
public class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            int start = read();
            int end = read();
            meetings[i] = new Meeting(start, end);
        }
        // 끝나는 시간을 기준으로 오름차순 정렬
        java.util.Arrays.sort(meetings);
        int currentEnd = 0; // 현재 회의가 끝나는 시간
        int count = 0; // 회의 개수
        for (Meeting meeting : meetings) {
            if (meeting.start >= currentEnd) { // 현재 회의가 끝나는 시간 이후에 시작하는 회의
                count++;
                currentEnd = meeting.end; // 현재 회의가 끝나는 시간을 갱신
            }
        }
        System.out.println(count); // 회의 개수 출력
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}

class Meeting implements Comparable<Meeting> {
    int start, end;

    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.end == o.end) {
            return this.start - o.start; // 끝나는 시간이 같으면 시작 시간으로 정렬
        }
        return this.end - o.end; // 끝나는 시간 기준으로 오름차순 정렬
    }
}