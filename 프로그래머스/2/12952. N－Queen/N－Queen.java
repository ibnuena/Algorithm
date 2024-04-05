import java.util.*;

class Solution {
    static int answer = 0;
    public int solution(int n) {
        int[] map = new int[n];
        
        dfs(n, 0, map);
        
        return answer;
    }
    
    public void dfs(int depth, int level, int[] map){
        if(depth==level){
            answer++;
            return;
        }
        
        for(int i=0; i<depth; i++){
            map[level] = i;
            if(isOk(level, map)==true) // 다음 위치에 놓을 수 있는지
                dfs(depth, level+1, map);
        }
        
    }
    
    public boolean isOk(int level, int[] map){
        for(int i=0; i<level; i++){
            if(map[i]==map[level]) // 같은 열에 있는경우
                return false;
            if(Math.abs(level - i)==Math.abs(map[level] - map[i]))
                return false;
        }
        return true;
    }
}