import java.io.*;

public class Main {
    static int N, tail = 0;
    static int[] A, record, longest;

    public static void main(String[] args) throws Exception {
        N = readInt();
        A = new int[N];
        record = new int[N];
        longest = new int[N];

        int firstVal = readInt();
        A[0] = firstVal;
        longest[0] = firstVal;
        record[0] = 0;

        for (int i = 1; i < N; i++) {
            int val = readInt();
            A[i] = val;

            if (longest[tail] < val) {
                longest[++tail] = val;
                record[i] = tail;
            } else {
                int l = 0, r = tail;
                while (l < r) {
                    int m = (l + r) >>> 1;
                    if (longest[m] >= val) r = m;
                    else l = m + 1;
                }
                longest[l] = val;
                record[i] = l;
            }
        }

        int[] result = new int[tail + 1];
        int currentTail = tail;
        for (int i = N - 1; i >= 0; i--) {
            if (record[i] == currentTail) {
                result[currentTail--] = A[i];
            }
        }
        
        writeInt(tail + 1);
        outBuf[outIdx - 1] = 10;
        for (int i = 0; i <= tail; i++) {
            writeInt(result[i]);
        }
        flush();
    }

    static int pos, len;
    static byte[] buf = new byte[1 << 16];

    static byte read() throws Exception {
        if (pos == len) {
            len = System.in.read(buf);
            if (len == -1) return 0;
            pos = 0;
        }
        return buf[pos++];
    }

    static int readInt() throws Exception {
        int c;
        while ((c = read()) <= 32 && c != 0);
        if (c == 0) return 0;
        boolean negative = c == 45;
        if (negative) c = read();
        int n = c & 15;
        while ((c = read()) > 47)
            n = (n << 3) + (n << 1) + (c & 15);
        return negative ? -n : n;
    }

    static int outIdx;
    static byte[] outBuf = new byte[1 << 16];

    static void writeInt(int n) {
        if (n < 0) {
            if (outIdx == outBuf.length) flush();
            outBuf[outIdx++] = 45; // '-'
            n = -n;
        }
        // 자리수 계산
        int l = n == 0 ? 1 : (int) Math.log10(n) + 1;
        if (outIdx + l + 1 >= outBuf.length) flush();
        
        outIdx += l;
        for (int i = 1; i <= l; i++) {
            outBuf[outIdx - i] = (byte) (n % 10 | 48);
            n /= 10;
        }
        outBuf[outIdx++] = 32;
    }

    static void flush() {
        System.out.write(outBuf, 0, outIdx);
        outIdx = 0;
    }
}