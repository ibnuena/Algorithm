import java.util.*;

public class Solution {
    public int solution(int n) {
        
        return rec(n);
    }
    
    public int rec(int n){
        if(n==1)
            return 1;
        
        if(n%2==1) // n이 홀수라면
            return rec(n/2) + 1;
        else
            return rec(n/2);
    }
}

// n이 되기 위한 방법..
// 1. 점프 : k만큼 이동, k만큼 건전지 소모
// 2. 순간이동 : 현재위치*2만큼 이동, 건전지 소모 0