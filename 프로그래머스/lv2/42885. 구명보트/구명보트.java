import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Integer[] peopleArr = new Integer[people.length];
        for(int i=0; i<people.length; i++) {
            peopleArr[i]= people[i];
        }
        Arrays.sort(peopleArr, Collections.reverseOrder());
        int right = people.length-1;
        int answer = 0;
        for(int i=0; i<people.length; i++) {
            if(i>right) break;
            int sum = peopleArr[i]+peopleArr[right];
            if(sum <= limit) right--;
            answer++;
            
        }
        
        
        return answer;
    }
}