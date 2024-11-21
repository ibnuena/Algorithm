import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Queue<Character> q = new LinkedList<>();
        
        for(int i=0; i<s.length(); i++){
            q.add(s.charAt(i));
        }
        
        // 큐로 앞에부터 하나씩 뺌, 닫는거 여는거 갯수 세
        
        int open = 0;
        int close = 0;
        
        // 만약 open이 0인데 close, 또는 open < close면 글렀음
        
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