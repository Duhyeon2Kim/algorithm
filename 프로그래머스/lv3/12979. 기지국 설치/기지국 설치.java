class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start=1;
        int end=1;
        for(int i=0; i<stations.length; i++) {
            end= stations[i]-w-1;
            end= Math.min(end,n);
            if(end>=start && end>0) answer+=Math.ceil(((double)(end-start+1)/(double)(2*w+1)));
            start = Math.max(stations[i]+w+1,1);
        }
        if(start<=n) {
            answer+=Math.ceil(((double)(n-start+1)/(double)(2*w+1)));
        }

        
        return answer;
    }
}