class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        int n = 1;
        int idx = 0;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                map[i][j] = n++;
            }
        }
        
        for(int i=0; i<queries.length; i++){
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            int temp = map[x1][y1];
            int min = temp;
            for(int j=x1; j<x2; j++){
                min = Math.min(min, map[j+1][y1]);
                map[j][y1] = map[j+1][y1];
            }
            for(int j=y1; j<y2; j++){
                min = Math.min(min, map[x2][j+1]);
                map[x2][j] = map[x2][j+1];
            }
            for(int j=x2; j>x1; j--){
                min = Math.min(min, map[j-1][y2]);
                map[j][y2] = map[j-1][y2];
            }
            for(int j=y2; j>y1; j--){
                min = Math.min(min, map[x1][j-1]);
                map[x1][j] = map[x1][j-1];
            }
            map[x1][y1+1] = temp;
            answer[idx] = min;
            idx++;
        }
        
        return answer;
    }
    
}
