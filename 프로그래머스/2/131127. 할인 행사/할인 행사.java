import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap();
        int total=10;
        for(int i=0;i<want.length;i++){
            wantMap.put(want[i],number[i]);
        }
        for(int i=0;i<10;i++) {
            String s = discount[i];
            if(wantMap.get(s)!=null){
                wantMap.put(s,wantMap.get(s)-1);
                if(wantMap.get(s)>=0){
                    total--;
                }
            }
            if(total==0) answer++;
        }
        
        for(int i=10;i<discount.length;i++){
            String s = discount[i-10];
            String e = discount[i];
            if(wantMap.get(e)!=null){
                wantMap.put(e,wantMap.get(e)-1);
                if(wantMap.get(e)>=0){
                    total--;
                }
            }
            if(wantMap.get(s)!=null){
                wantMap.put(s,wantMap.get(s)+1);
                if(wantMap.get(s)>0){
                    total++;
                }
            }
            if(total==0) answer++;
        }
        return answer;
    }
}