import java.io.BufferedReader;
import java.io.IOException;
import java.util.Deque;
import java.util.Iterator;

public class Main {
    static int T;
    static TestCase testCase;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        T= Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();
            Deque<Byte> arr = new java.util.ArrayDeque<>();
            if(n > 0) {
                String[] elements = arrStr.substring(1, arrStr.length() - 1).split(",");
                for(String element : elements) {
                    arr.add(Byte.parseByte(element));
                }
            }
            testCase = new TestCase(p, n, arr);
            testCase.startTest();
        }
    }


}

class TestCase{
    public String p;
    public int n;
    public Deque<Byte> arr;
    public boolean isReversed = false;

    TestCase(String p, int n, Deque<Byte> arr) {
        this.p = p;
        this.n = n;
        this.arr = arr;
    }

    public void startTest(){
        for(char c : p.toCharArray()) {
            if(c == 'R') {
                isReversed = !isReversed;
                continue;
            }
            if(arr.isEmpty()) {
                System.out.println("error");
                return;
            }
            if(isReversed) arr.removeLast();
            else arr.removeFirst();
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator<Byte> iterator = isReversed ? arr.descendingIterator() :  arr.iterator();
        while(iterator.hasNext()) {
            sb.append(iterator.next());
            if(iterator.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(']');
        System.out.println(sb);
    }
}