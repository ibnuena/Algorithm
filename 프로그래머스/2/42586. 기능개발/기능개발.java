import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[100];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<speeds.length; i++){
            int remain = 100 - progresses[i]; // 남은 작업량
            q.add(remain%speeds[i]==0 ? remain/speeds[i] : remain/speeds[i]+1); // 작업일수 
        }

        int j=0;
        answer[0] = 1;
        int temp2 = answer[0];
        while(q.size()>=2){
            int temp1 = q.poll();
            temp2 = temp2>temp1 ? temp2 : temp1;
            if(temp2<q.peek()){
                j++;
            }
            answer[j]++;
        }
        return Arrays.copyOfRange(answer, 0, j+1);
    }
}