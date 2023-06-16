import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int level = triangle.length;
        for(int i=1; i<level; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                int max = 0;
                if(j==0) max = triangle[i-1][0];
                else if(j==triangle[i].length-1) max = triangle[i-1][triangle[i].length-2];
                else {
                    max = Math.max(triangle[i-1][j-1],triangle[i-1][j]);
                }
                triangle[i][j]+= max;
            } 
        }
        Arrays.sort(triangle[level-1]);
        int answer=triangle[level-1][level-1];
        return answer;
    }
}