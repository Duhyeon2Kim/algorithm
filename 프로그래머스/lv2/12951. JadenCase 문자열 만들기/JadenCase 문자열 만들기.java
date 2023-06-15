import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++) {
            if(i==0) {
                if(arr[0]>='a' && arr[0]<='z') arr[0]-=32;
            }
            else {
                if(arr[i-1]==' ' && arr[i]!=' ') {
                    if(arr[i]>='a' && arr[i]<='z') arr[i]-=32;
                }
                else {
                    if(arr[i]>='A' && arr[i]<='Z') arr[i]+=32;
                }
            }
            answer+=arr[i];
        }
        
        return answer;
    }
}