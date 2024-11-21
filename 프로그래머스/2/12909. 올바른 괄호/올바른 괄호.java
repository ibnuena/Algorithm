import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int open = 0;
        int close = 0;
        
        Queue<Character> q = new LinkedList<>();
        
        for(int i=0; i<s.length(); i++){
            q.add(s.charAt(i));
        }
                
        for(int i=0; i<s.length(); i++){
            if(open < close){
                return false;
            }
            
            if(q.poll() == '('){
                open++;
            }
            else{
                close++;
            }
            
            if(open == close){
                open = close = 0;
            }
        }
        
        if(open != close)
            return false;
        
        return answer;
    }
}