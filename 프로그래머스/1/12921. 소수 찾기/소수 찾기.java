class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] prime = new int[n+1];
        
        prime[0] = prime[1] = 0;
        
        for(int i=2; i<=n; i++){
            prime[i] = i;
        }
        
        for(int i=2; i<=n; i++){
            if(prime[i]!=0){ 
                for(int j=i*2; j<=n; j+=i){
                    prime[j] = 0;
                }
            }
        }
        
        for(int i=0; i<=n; i++){
            if(prime[i]!=0)
                answer++;
        }
        
        return answer;
    }
}