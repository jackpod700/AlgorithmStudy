import java.util.*;
import java.io.*;

public class Main {
	static int[][] map = new int[19][19];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<19;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<19;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//0이 아닌 칸에 대하여 오른쪽,아래,우하/좌하/대각선 확인
		//만약 5개임이 확인되었다면 반대방향으로 하나 더 돌을 보고 같지 않으면 이긴것
		for(int r=0;r<19;r++) {
			for(int c=0;c<19;c++) {
				if(map[r][c]==0)continue;
				if(check(r,c)) return;
			}
		}
		System.out.println("0");
	}
	
	static boolean check(int r, int c) {
		if(check_row(r,c)||check_col(r,c)||check_Rdiag(r,c)) {
			System.out.println(map[r][c]);
			System.out.println((r+1)+" "+(c+1));
			return true;
		}
		if(check_Ldiag(r,c)) {
			System.out.println(map[r][c]);
			System.out.println((r+5)+" "+(c-3));
			return true;
		}
		return false;
	}

	static boolean check_row(int r, int c) {
		int curNum=map[r][c];
		for(int i=1;i<5;i++) {
			if(c+i>=19||curNum!=map[r][c+i]) return false;
		}
		if((c!=0&&curNum==map[r][c-1])) return false;
		if (c+5 < 19 && curNum == map[r][c + 5]) return false;
		return true;
	}
	static boolean check_col(int r, int c) {
		int curNum=map[r][c];
		for(int i=1;i<5;i++) {
			if(r+i>=19||curNum!=map[r+i][c]) return false;
		}
		if(r!=0&&curNum==map[r-1][c]) return false;
		if (r + 5 < 19 && curNum == map[r + 5][c]) return false;
		return true;
	}
	static boolean check_Rdiag(int r, int c) {
		int curNum=map[r][c];
		for(int i=1;i<5;i++) {
			if(r+i>=19||c+i>=19||curNum!=map[r+i][c+i]) return false;
		}
		if(r!=0&&c!=0&&curNum==map[r-1][c-1]) return false;
		if (r + 5 < 19 && c + 5 < 19 && curNum == map[r + 5][c + 5]) return false;
		return true;
	}
	static boolean check_Ldiag(int r, int c) {
		int curNum=map[r][c];
		for(int i=1;i<5;i++) {
			if(r+i>=19||c-i<0||curNum!=map[r+i][c-i]) return false;
		}
		if(r!=0&&c!=18&&curNum==map[r-1][c+1]) return false;
		if (r + 5 < 19 && c - 5 >= 0 && curNum == map[r + 5][c - 5]) return false;
		return true;
	}
}