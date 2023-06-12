import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        Queue<Integer> q = new LinkedList<>();
        int[] lengthCheck = new int[truck_weights.length];
        int truckIdx = 1;
        int totalWeigth = truck_weights[0];
        q.add(truck_weights[0]);
        
        while(!q.isEmpty()) {
            for(int i=0; i<truckIdx; i++) {
                if(lengthCheck[i]>=bridge_length) continue;
                else if(lengthCheck[i]==bridge_length-1) {
                    lengthCheck[i]++;
                    totalWeigth -= q.poll();
                }
                else lengthCheck[i]++;
            }
            
            
            if(truckIdx<truck_weights.length && totalWeigth+truck_weights[truckIdx]<=weight) {
                q.add(truck_weights[truckIdx]);
                totalWeigth+=truck_weights[truckIdx++];
            }         
                answer++;
        }
        return answer;
    }
}