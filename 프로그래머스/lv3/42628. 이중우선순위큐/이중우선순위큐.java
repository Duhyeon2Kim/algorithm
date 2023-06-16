import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2) {
                return Integer.compare(o2,o1);
            }
        });
        
        int size=0;
        int removeCnt=0;
        for(String operation : operations) {
                String[] order = operation.split(" ");
            if(order[0].equals("I")) {
                size++;
                maxQueue.add(Integer.parseInt(order[1]));
            }
            else if(order[0].equals("D") && size>=1) {
                if(order[1].equals("1")) maxQueue.remove();
                else if(order[1].equals("-1")) removeCnt++;
                size--;
            }
            
        }
        if(size==0) {
            return answer;
        }
        answer[0] = maxQueue.peek();
        while(maxQueue.size()>removeCnt+1) {
            maxQueue.remove();
        }
        answer[1] = maxQueue.peek();
        return answer;
    }
}