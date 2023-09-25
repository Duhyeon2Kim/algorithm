import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        boolean flag = true;
        
        while(flag) {
            flag = false;
            int count = 0;
            for(int x: citations) {
                if(x>=answer) count++;
                if(count>=answer) {flag = true; answer++; break;}
            }
            if(!flag) answer--;
        }
        
        return answer;
    }
}