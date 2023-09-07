import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int[] countArr = new int[101]; 
            
        for(int x: arr) {
            int idx = 2;
            int count = 0;
            int limit = x;
            while(idx<=limit) {
                if(x%idx==0) {
                    count++; 
                    x=x/idx; 
                    continue;
                }
                countArr[idx]=Math.max(count,countArr[idx]);
                idx++;
                count=0;
            }
        }
        int answer = 1;
        for(int i=2; i<=100; i++) {
            if(countArr[i]==0) continue;
            answer = answer*(int)Math.pow(i,countArr[i]);
        }
        
        return answer;
    }
    
}