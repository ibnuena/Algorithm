import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<prices.length; i++){
            while(!s.empty() && prices[s.peek()] > prices[i]){
                int n = s.pop();
                answer[n] = i - n;
            }
            s.push(i);
        }
        
        while(!s.empty()){
            int n = s.pop();
            answer[n] = prices.length - n - 1;
        }        
        
        return answer;
    }
}