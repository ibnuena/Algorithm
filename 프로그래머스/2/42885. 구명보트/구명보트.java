import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int max = people.length - 1;
        int min = 0;
       
        Arrays.sort(people);
        
        while(min <= max){
            if(people[min] + people[max] <= limit){
                min++;
                max--;
                answer++;
            }
            else{
                max--;
                answer++;
            }
        }
        
        return answer;
    }
}
// min + max가 초과하는지 계산
        // 초과하면 max 이전값과 계산
        // 반복, 초과하지 않으면 answer++하고 제거시킴