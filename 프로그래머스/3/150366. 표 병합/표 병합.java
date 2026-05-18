import java.util.*;

class Solution {
    static String[][] cells = new String[51][51];
    static int[][] P = new int[51][51];
    public String[] solution(String[] commands) {
        StringBuilder sb = new StringBuilder();
        for(int r=1;r<=50;r++){
            for(int c=1;c<=50;c++){
                cells[r][c]="";
                P[r][c]=r*100+c;
            }
        }
        for(int i=0;i<commands.length;i++){
            String[] command = commands[i].split(" ");
            // for(String s:command){
            //     System.out.print(s+" ");
            // }
            // System.out.println();
            switch(command[0])
            {
                case "UPDATE"-> {
                    if(command.length==4){
                        int r = Integer.parseInt(command[1]);
                        int c = Integer.parseInt(command[2]);
                        int parent = find(r,c);
                        int pr = parent/100;
                        int pc = parent%100;
                        String value = command[3];
                        cells[pr][pc]=value;
                    }
                    else{
                        String value1 = command[1];
                        String value2 = command[2];
                        for(int r=1;r<=50;r++){
                            for(int c=1;c<=50;c++){
                                if(P[r][c]==r*100+c&&cells[r][c].equals(value1)){
                                    cells[r][c]=value2;
                                }
                            }
                        }
                    }
                }
                case "MERGE"-> {
                    int r1 = Integer.parseInt(command[1]);
                    int c1 = Integer.parseInt(command[2]);
                    int r2 = Integer.parseInt(command[3]);
                    int c2 = Integer.parseInt(command[4]);
                    if(r1==r2&&c1==c2) continue;
                    union(r1,c1,r2,c2);
                    
                }
                case "UNMERGE"-> {
                    int umr = Integer.parseInt(command[1]);
                    int umc = Integer.parseInt(command[2]);
                    int parent = find(umr,umc);
                    String value = cells[parent/100][parent%100];
                    List<Integer> unmerges = new ArrayList<>();
                    for(int r=1;r<=50;r++){
                        for(int c=1;c<=50;c++){
                            if(find(r,c)==parent){
                                cells[r][c]="";
                                unmerges.add(r*100+c);
                                
                            }
                        }
                    }
                    cells[umr][umc]=value;
                    for(Integer cell : unmerges){
                        int r = cell/100;
                        int c = cell%100;
                        P[r][c]=r*100+c;
                    }
                    
                }
                case "PRINT"-> {
                    int r = Integer.parseInt(command[1]);
                    int c = Integer.parseInt(command[2]);
                    int parent = find(r,c);
                    int pr=parent/100;
                    int pc=parent%100;
                    if(cells[pr][pc].equals("")) sb.append("EMPTY ");
                    else sb.append(cells[pr][pc]).append(" ");
                }
                    
            }
        }
        
        return sb.toString().split(" ");
    }
    
    int find(int r, int c){
        if(P[r][c]==r*100+c) return P[r][c];
        return P[r][c] = find(P[r][c]/100,P[r][c]%100);
    }
    
    void union(int r1, int c1, int r2, int c2){
        int parent1 = find(r1,c1);
        int parent2 = find(r2,c2);
        if(parent1==parent2)return;
        int p1r = parent1/100;
        int p1c = parent1%100;
        int p2r = parent2/100;
        int p2c = parent2%100;
        if(cells[p1r][p1c].equals("")&&!cells[p2r][p2c].equals("")){
            P[p1r][p1c]=parent2;
        }
        else{
            P[p2r][p2c]=parent1;
        }
    }
    
    
}