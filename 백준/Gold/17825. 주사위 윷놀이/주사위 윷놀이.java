import java.util.*;
import java.io.*;
public class Main{
	static int result;
	static int[] moves=new int[10];
	static int[] area0= {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,-1};
	static int[] area1= {10,13,16,19,25};
	static int[] area2= {20,22,24,25};
	static int[] area3= {30,28,27,26,25};
	static int[] area4= {25,30,35,40};
	static List<int[]> areas = new ArrayList<>();
	static horse[] horses = new horse[5];
	
	public static void main(String[] args) throws IOException{
		areas.add(area0);areas.add(area1);areas.add(area2);areas.add(area3);areas.add(area4);
		for(int i=1;i<=4;i++)horses[i]=new horse(i);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<10;i++) moves[i]=Integer.parseInt(st.nextToken());
		System.out.println(bt(0));
	}
	
	static int bt(int depth) {
		if(depth==10) return result;
		int maximum=0;
		int curMove = moves[depth];
		if(depth==0) {
			result+=horses[1].move(curMove);
			maximum=Math.max(maximum, bt(depth+1));
		}
		else {
			for(int i=1;i<=4;i++) {
				if(!horses[i].available)continue;
				int moveResult = horses[i].move(curMove);
				if(moveResult==-1) continue;
				result+=moveResult;
				maximum=Math.max(maximum, bt(depth+1));
				horses[i].unmove();
				result-=moveResult;
			}
		}
		return maximum;
	}
	
	static class horse {
	    int area, index, horseNum, logCount;
	    int[] areaLog, indexLog;
	    boolean available;

	    public horse(int horseNum) {
	        this.logCount = this.area = this.index = 0;
	        this.available = true; // true면 이동 중, false면 도착 완료
	        this.areaLog = new int[11];
	        this.areaLog[0] = area;
	        this.indexLog = new int[11];
	        this.indexLog[0] = index;
	        this.horseNum = horseNum;
	    }
	    
	    public void unmove() {
	        this.area = this.areaLog[--this.logCount];
	        this.index = this.indexLog[this.logCount];
	        this.available = true; // 되돌릴 때는 무조건 다시 윷판에 올라옴
	    }

	    public int move(int moves) {
	        this.index += moves;
	        
	        // --- 1. 영역 및 인덱스 계산 ---
	        if (this.area == 0) {
	            // 도착 지점 통과
	            if (this.index > 20) {
	                this.available = false;
	                this.areaLog[++this.logCount] = this.area;
	                this.indexLog[this.logCount] = this.index;
	                return 0;
	            }
	            // 10, 20, 30 지점 파란색 화살표 전환 
	            // 🚨 버그 수정: index가 20(40 지점)일 때는 전환되면 안 됨!
	            if (this.index % 5 == 0 && this.index > 0 && this.index < 20) {
	                this.area = this.index / 5;
	                this.index = 0;
	            }
	        } 
	        else if (this.area == 4) {
	            // 중앙 경로에서 도착 지점 통과
	            if (this.index > 3) {
	                this.available = false;
	                this.areaLog[++this.logCount] = this.area;
	                this.indexLog[this.logCount] = this.index;
	                return 0;
	            }
	        } 
	        else { // 파란색 경로 (area 1, 2, 3)
	            int pathLength = areas.get(this.area).length;
	            if (this.index >= pathLength - 1) {
	                this.index -= (pathLength - 1); // 중앙 경로에 맞게 인덱스 조정
	                this.area = 4; // area 4(중앙 25 지점)로 전환
	                
	                // 🚨 에러 수정: 중앙 경로 합류 직후 너무 멀리 가서 도착해버린 경우 검사
	                if (this.index > 3) {
	                    this.available = false;
	                    this.areaLog[++this.logCount] = this.area;
	                    this.indexLog[this.logCount] = this.index;
	                    return 0;
	                }
	            }
	        }
	        
	        // --- 2. 다른 말과 충돌하는지 확인 ---
	        if (!check(moves)) {
	            // 이동할 수 없으면 현재 상태 복구 (이동 실패이므로 logCount는 건드리지 않음)
	            this.area = this.areaLog[this.logCount];
	            this.index = this.indexLog[this.logCount];
	            return -1;
	        }
	        
	        // --- 3. 이동 확정 및 점수 반환 ---
	        this.areaLog[++this.logCount] = this.area;
	        this.indexLog[this.logCount] = this.index;
	        return areas.get(this.area)[this.index];
	    }
	    
	    private boolean check(int moves) {
	        for (int i = 1; i <= 4; i++) {
	            if (i == this.horseNum) continue; // 자기 자신은 제외
	            if (!horses[i].available) continue; // 🚨 이미 도착한 말과는 겹쳐도 상관없음!
	            
	            // 일반적인 충돌: 영역과 인덱스가 완전히 일치하는 경우
	            // (작성하신 영역 전환 로직 덕분에 10, 20, 30, 25 교차점은 여기서 자동으로 걸러집니다)
	            if (horses[i].area == this.area && horses[i].index == this.index) {
	                return false;
	            }
	            
	            // 🚨 특수 충돌 판정: 40 지점 (윷판에서는 하나지만, 배열에서는 area0과 area4 두 군데 존재)
	            boolean thisIs40 = (this.area == 0 && this.index == 20) || (this.area == 4 && this.index == 3);
	            boolean otherIs40 = (horses[i].area == 0 && horses[i].index == 20) || (horses[i].area == 4 && horses[i].index == 3);
	            
	            if (thisIs40 && otherIs40) {
	                return false;
	            }
	        }
	        return true;
	    }
	}
}
