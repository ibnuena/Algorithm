class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        
        for(int i=0; i<stations.length; i++){
            int end = stations[i]-w;
            if(end>start){
                answer += count(end-start, w*2+1);
            }
            start = stations[i]+w+1;
        }
        
        if(start <= n)
            answer += count(n-start+1, w*2+1);
        
        return answer;
    }
    
    public int count(int n1, int n2){
        if(n1%n2==0)
            return n1/n2;
        else
            return n1/n2+1;
    }
}