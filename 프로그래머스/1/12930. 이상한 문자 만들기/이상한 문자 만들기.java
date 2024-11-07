import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 0; // 단어 체크 인덱스
        for(int i=0; i<s.length(); i++){
            // 공백이면 단어 체크 인덱스 초기화
            if(s.charAt(i) == ' '){
                idx = 0;
                answer += " ";
            }
            
            // 공백이 아니면 홀/짝 번호 체크 후 변경
            else{
                if(idx%2 == 0) // 짝수번째 -> 대문자로
                    answer += Character.toUpperCase(s.charAt(i));
                else
                    answer += Character.toLowerCase(s.charAt(i));
                
                idx++;
            }
        }
        
        return answer;
    }
}