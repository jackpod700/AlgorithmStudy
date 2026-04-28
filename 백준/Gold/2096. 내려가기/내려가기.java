import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Reader rd = new Reader();
        int n = rd.nextInt();

        // 현재 행의 최소/최대 점수를 저장할 배열
        int[] minDP = new int[3];
        int[] maxDP = new int[3];

        for (int i = 0; i < n; i++) {
            int v1 = rd.nextInt();
            int v2 = rd.nextInt();
            int v3 = rd.nextInt();

            if (i == 0) {
                minDP[0] = maxDP[0] = v1;
                minDP[1] = maxDP[1] = v2;
                minDP[2] = maxDP[2] = v3;
                continue;
            }

            // 이전 상태 보관 (nmin 계산 시 참조)
            int[] prevMin={minDP[0],minDP[1],minDP[2]};
            int[] prevMax={maxDP[0],maxDP[1],maxDP[2]};

            // 최소값 갱신
            minDP[0] = v1 + Math.min(prevMin[0], prevMin[1]);
            minDP[1] = v2 + Math.min(Math.min(prevMin[0], prevMin[1]), prevMin[2]);
            minDP[2] = v3 + Math.min(prevMin[1], prevMin[2]);

            // 최대값 갱신
            maxDP[0] = v1 + Math.max(prevMax[0], prevMax[1]);
            maxDP[1] = v2 + Math.max(Math.max(prevMax[0], prevMax[1]), prevMax[2]);
            maxDP[2] = v3 + Math.max(prevMax[1], prevMax[2]);
        }

        int maxResult = Math.max(maxDP[0], Math.max(maxDP[1], maxDP[2]));
        int minResult = Math.min(minDP[0], Math.min(minDP[1], minDP[2]));

        System.out.println(maxResult + " " + minResult);
    }
}
class Reader {
	  private final int SIZE = 1 << 13;
	  private byte[] buffer = new byte[SIZE];
	  private int index, size;
	  int nextInt() throws Exception {
	    int lis = 0;
	    byte c;
	    boolean isMinus = false;
	    while ((c = read()) <= 32);
	    if (c == 45) { c = read(); isMinus = true; }
	    do lis = (lis << 3) + (lis << 1) + (c & 15);
	    while (isnumber(c = read()));
	    return isMinus ? ~lis + 1 : lis;
	  }
	  String readLine() throws Exception{
	    StringBuilder sb = new StringBuilder();
	    byte c;
	    c = read();
	    do sb.appendCodePoint(c);
	    while ((c = read())!=10);
	    return sb.toString();
	  }
	  String nextString() throws Exception {
	    StringBuilder sb = new StringBuilder();
	    byte c;
	    while ((c = read()) <= 32);
	    do sb.appendCodePoint(c);
	    while (isAlphabet(c = read())||isnumber(c));
	    return sb.toString();
	  }
	  String nextWord() throws Exception {
	    StringBuilder sb = new StringBuilder();
	    byte c;
	    while ((c = read()) <= 32);
	    do sb.appendCodePoint(c);
	    while ((c = read())!=32&&c!=10);
	    return sb.toString();
	  }

	  char nextChar() throws Exception {
	    char ch = ' ';
	    byte c;
	    while ((c = read()) <= 32);
	    do ch = (char)c;
	    while (isAlphabet(c = read()));
	    return ch;
	  }

	  long nextLong() throws Exception {
	    long lis = 0;
	    byte c;
	    boolean isMinus = false;
	    while ((c = read()) <= 32);
	    if (c == 45) { c = read(); isMinus = true; }
	    do lis = (lis << 3) + (lis << 1) + (c & 15);
	    while (isnumber(c = read()));
	    return isMinus ? ~lis + 1 : lis;
	  }

	  double nextDouble() throws Exception {
	    double lis = 0, div = 1;
	    byte c;
	    boolean isMinus = false;
	    while ((c = read()) <= 32);
	    if (c == 45) { c = read(); isMinus = true; }
	    else if (c == 46) { c = read(); }
	    do lis = (lis * 10) + (c & 15);
	    while (isnumber(c = read()));
	    if (c == 46) { while (isnumber(c = read())){ lis += (c - 48) / (div *= 10); }}
	    return isMinus ? -lis : lis;
	  }

	  private boolean isAlphabet(byte c){
	    return (64 < c && c < 91) || (96 < c && c < 123);
	  }

	  private boolean isnumber(byte c) {
	    return 47 < c && c < 58;
	  }

	  private byte read() throws Exception {
	    if (index == size) {
	      size = System.in.read(buffer, index = 0, SIZE);
	      if (size < 0) buffer[0] = -1;
	    }
	    return buffer[index++];
	  }
	}
