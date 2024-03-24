class Solution {
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(numbers.length, 0, target, numbers, 0);
    
        return answer;
    }
    
    public void dfs(int depth, int start, int target, int[] numbers, int total){
        if(depth==start){
            if(target==total)
                answer++;
            return;
        }
        
        for(int i=0; i<2; i++){
            if(i==0)
                dfs(depth, start+1, target, numbers, total + numbers[start]);
            else
                dfs(depth, start+1, target, numbers, total - numbers[start]);
        }
            
    }
}