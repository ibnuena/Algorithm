import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int sameFrequency = 0;
        int frequency = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<array.length; i++){
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(frequency == entry.getValue()){
                sameFrequency = frequency;
            }
            
            if(frequency < entry.getValue()){
                answer = entry.getKey();
                frequency = entry.getValue();
            }
        }
        
        if(frequency == sameFrequency){
            return -1;
        }
        
        return answer;
    }
}