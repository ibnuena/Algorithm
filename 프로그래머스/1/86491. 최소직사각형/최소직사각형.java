import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxWidth = 0;
        int maxHeight = 0;
        
        for(int i=0; i<sizes.length; i++){
            Arrays.sort(sizes[i]);
            maxWidth = Math.max(maxWidth, sizes[i][0]);
            maxHeight = Math.max(maxHeight, sizes[i][1]);
        }
        
        return maxWidth*maxHeight;
    }
}