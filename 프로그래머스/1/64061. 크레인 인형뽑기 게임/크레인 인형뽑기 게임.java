import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer=0;
		
		Stack<Integer> stack = new Stack<>();
		
	    
	    for(int j=0; j<moves.length; j++){
	        int i = 0;
	        do{
	            if(board[i][moves[j]-1]!=0) {  
	            	if(stack.empty()==false && stack.peek()==board[i][moves[j]-1]) {
	            		stack.pop();
	            		answer = answer + 2;
	            	}
	            	else {
		            	stack.push(board[i][moves[j]-1]); // 맨위값과 같지 않고 0이 아니면 스택에 넣음
	            	}
                    board[i][moves[j]-1] = 0;  // 그 자리를 0으로 바꿈
	            	break;
	            }
	            else
	            	i++;                    // 0이면 아래칸으로
	        }while(i<board.length); 
        }
        return answer;
    }
}