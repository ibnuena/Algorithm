import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long min = 0;
        long max = (long)n*(long)times[times.length-1];
        long mid = 0;
        
        while(max>=min){
            long people = 0;
            mid = (min + max)/2;
            // mid시간에 n명 처리 가능하면
            for(int i=0; i<times.length; i++){
                people += mid/(long)times[i];
            }
            
            if(people >= (long)n){ // 더 적은 시간으로 가능한지 탐색
                answer = mid;
                max = mid-1;
            }
            else if(people < (long)n){
                min = mid+1;
            }
            
        }
        
        return answer;
    }
}