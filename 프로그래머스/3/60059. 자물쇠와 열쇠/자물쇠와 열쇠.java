class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int l = lock.length+(key.length-1)*2;
        int[][] lock2 = new int[l][l];

                
        for(int i=0; i<l-key.length+1; i++){
            for(int j=0; j<l-key.length+1; j++){
                for(int k=0; k<4; k++){
                    lock2 = newLock(lock, key, l);
                    if(isPossible(i, j, key, lock2, lock.length, k))
                        return true;
                }
            }
        }
        
        // for(int i=0; i<lock2.length; i++){
        //     for(int j=0; j<lock2.length; j++){
        //         System.out.print(lock2[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        return answer;
    }
    
    public int[][] newLock(int[][] lock, int[][] key, int l){
        int[][] lock2 = new int[l][l];

        for(int i=0; i<lock.length; i++){ // 배열 확장
            for(int j=0; j<lock.length; j++){
                lock2[i+key.length-1][j+key.length-1] = lock[i][j];
            }
        }
        return lock2;
    }
    
    public boolean isPossible(int x, int y, int[][] key, int[][] lock2, int l, int k){
        for(int i=0; i<key.length; i++){
            for(int j=0; j<key.length; j++){
                if(k==0)
                    lock2[i+x][j+y] += key[i][j];
                else if(k==1) { 
                    lock2[i+x][j+y] += key[j][key.length - i - 1];
                } else if(k==2) { 
                    lock2[i+x][j+y] += key[key.length - i - 1][key.length - j - 1];
                } else { 
                    lock2[i+x][j+y] += key[key.length - j - 1][i];
                }
            }
        }
        for(int i=0; i<l; i++){
            for(int j=0; j<l; j++){
                if(lock2[i+key.length-1][j+key.length-1]!=1)
                    return false;
            }
        }
        return true;
    }
}