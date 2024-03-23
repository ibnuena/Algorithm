import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        Queue<int[]> q = new LinkedList<>();
        int[] arr = {0,0,1};
        q.add(arr);
        maps[arr[0]][arr[1]] = 0;

        while(!q.isEmpty()){
            arr = q.poll();
            
            if(arr[0]==maps.length-1 && arr[1]==maps[0].length-1){
                answer = arr[2];
                break;
            }
            
            // 인접한 길 찾아 큐에 넣기
            if(isOK(arr[0]-1, arr[1], maps)){ // 상
                int[] temp = {arr[0]-1, arr[1], arr[2]+1};
                q.add(temp);
                maps[arr[0]-1][arr[1]] = 0;
            }
            if(isOK(arr[0]+1, arr[1], maps)){ // 하
                int[] temp = {arr[0]+1, arr[1], arr[2]+1};
                q.add(temp);
                maps[arr[0]+1][arr[1]] = 0;
            }
            if(isOK(arr[0], arr[1]-1, maps)){ // 좌
                int[] temp = {arr[0], arr[1]-1, arr[2]+1};
                q.add(temp);
                maps[arr[0]][arr[1]-1] = 0;
            }
            if(isOK(arr[0], arr[1]+1, maps)){ // 우
                int[] temp = {arr[0], arr[1]+1, arr[2]+1};
                q.add(temp);
                maps[arr[0]][arr[1]+1] = 0;
            }
        }
        
        return answer;
    }
    
    public boolean isOK(int x, int y, int[][] maps){
        if(x<0 || x>=maps.length || y <0 || y>=maps[0].length)
            return false;
        else if(maps[x][y]==1)
            return true;
        else
            return false;
    }
}