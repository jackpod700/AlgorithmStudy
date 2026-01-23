import java.util.*;

public class Main{
    static int n;
    static int[][] star;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        star=new int[n][2*n-1];
        StringBuilder sb = new StringBuilder();
        star(0,0,n);
        for(int i=0;i<n;i++){
            for(int j=0;j<2*n-1;j++){
                sb.append(star[i][j]==1?"*":" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    private static void star(int r, int c, int n){
        if(n==3){
            star[r][c+2]=1;
            star[r+1][c+1]=1;
            star[r+1][c+3]=1;
            for(int i=0;i<5;i++)star[r+2][c+i]=1;
        }
        else{
            star(r,c+n/2,n/2);
            star(r+n/2,c,n/2);
            star(r+n/2,c+n,n/2);
        }
    }
}