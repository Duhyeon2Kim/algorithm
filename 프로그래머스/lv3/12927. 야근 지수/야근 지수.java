import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x: works) {
            pq.add(x);
        }
        while(n>0) {
            int temp = pq.poll();
            if(temp==0) return 0;
            pq.add(temp-1);
            n--;
        }
        while(!pq.isEmpty()) {
            answer+=Math.pow(pq.poll(),2);
        }
        return answer;
    }
}