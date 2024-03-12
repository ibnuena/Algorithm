class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        answer[0] = -1;
        
        for(int i=1; i<s.length(); i++){
            int j=i-1;
            while(j!=-1){
                if(s.charAt(i)==s.charAt(j)){
                    answer[i] = i-j;
                    System.out.println("i : " +i + "  j : " + j);
                    break;
                }
                j--;
            }
            if(answer[i]==0)
                answer[i] = -1;
        }
        
        return answer;
    }
}