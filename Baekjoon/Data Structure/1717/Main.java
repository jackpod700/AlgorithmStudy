/*
 * Union-Find알고리즘
 */

import java.io.IOException;
import java.util.Arrays;

public class Main {

    static int[] root;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        int n=read(),m=read();
        root = new int[n+1];
        rank = new int[n+1];
        Arrays.fill(root, -1);

        for(int i=0;i<m;i++){
            int c=read(), a=read(),b=read();
            if(c==0) {
                union(a, b);
            } else {
                if(find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

    }

    static int read() throws IOException {
        int c,n = System.in.read()&15;
        while((c=System.in.read())>32)
            n=(n<<3)+(n<<1)+(c&15);
        return n;
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return; // They are already in the same set
        // Union by rank
        if (rank[rootA] < rank[rootB]) {
            root[rootA] = rootB;
        } else {
            root[rootB] = rootA;
            if(rank[rootA] == rank[rootB]) {
                rank[rootA]++;
            }
        }
    }

    static int find(int x) {
        return root[x]==-1 ? x : (root[x] = find(root[x]));
    }
}
