import java.util.Scanner;

public class Main {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		Square s = new Square(n);
		for(int i=0;i<n;i++) {
			System.out.println(s.actualMap[i]);
		}
	}
	
}
class Square{
	int N;
	Square[][] map = new Square[3][3];
	char[][] actualMap;
	public Square(int N) {
		this.N=N;
		actualMap = new char[N][N];
		if(N>3) {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					map[i][j]=new Square(N/3);
				}
			}
		}
		fillMap();
	}
	
	public void fillMap() {
		if(N==3) {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					if(i!=1||j!=1) {
						actualMap[i][j]='*';
						continue;
					}
					actualMap[i][j]=' ';
				}
			}
			return;
		}
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(i!=1||j!=1) {
					char[][] downMap = map[i][j].actualMap;
					for(int k=0;k<map[i][j].N;k++) {
						for(int l=0;l<map[i][j].N;l++) {
							actualMap[i*N/3+k][j*N/3+l]=downMap[k][l];
						}
					}
					continue;
				}
				for(int k=0;k<N/3;k++) {
					for(int l=0;l<N/3;l++) {
						actualMap[i*N/3+k][j*N/3+l]=' ';
					}
				}
			}
		}
	}
}