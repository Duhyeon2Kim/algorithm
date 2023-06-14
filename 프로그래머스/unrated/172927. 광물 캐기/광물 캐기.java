import java.util.*;

class Solution {
    static int[] picks;
    static int[] picksArr; 
    static int picksTotal = 0;
    static int answer = Integer.MAX_VALUE;
    static String[] minerals;    
    
    static void combination(int depth) {
        if(depth == picksTotal) {
            answer = Math.min(mining(picksArr),answer);
            return;
        }
        
        for(int i=0; i<3; i++) {
            if(picks[i]>0) {
                picks[i]--;
                picksArr[depth]=i;
                combination(depth+1);
                picks[i]++;
            }
        }
    }
    
    static int mining(int[] picksArr) {
        int sum =0; 
        for(int i=0; i<picksTotal; i++) {
            int nowPick = picksArr[i];
            for(int j=i*5; j<i*5+5; j++) {
                if(j>= minerals.length) break;
                if(nowPick==1 && minerals[j].equals("diamond")) sum+=5;
                else if(nowPick==2 && minerals[j].equals("iron")) sum+=5;
                else if(nowPick==2 && minerals[j].equals("diamond")) sum+=25;
                else sum+=1;
            }
            if(sum>=answer) return sum;
        }
        return sum;
    }
    
    public int solution(int[] inputPicks, String[] inputMinerals) {
        answer = Integer.MAX_VALUE;
        for(int i=0; i<3; i++) {
            picksTotal+=inputPicks[i];
        }
        picksArr = new int[picksTotal];
        picks = inputPicks.clone();
        minerals = inputMinerals.clone();
        combination(0);
        return answer;
        
    }
}