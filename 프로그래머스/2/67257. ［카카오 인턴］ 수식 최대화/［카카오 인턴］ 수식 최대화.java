import java.util.*;
import java.util.ArrayList;

class Solution {
    static long result = 0;
    public long solution(String expression) {
        long answer = 0;
        List<String> list = new ArrayList<>();
        List<String> exp = new ArrayList<>();
        String temp = "";
        
        exp = containExp(expression, exp);
        
        for(int i=0; i<expression.length(); i++){
            if(!isExp(expression.charAt(i)))  // 숫자
                temp += expression.charAt(i);
            else // 연산자
                list.add(Character.toString(expression.charAt(i)));
            if(i==expression.length()-1 || isExp(expression.charAt(i+1))){ 
                list.add(temp);
                temp = "";
            }
        }
       
        permutation(exp, 0, exp.size(), list);

        return result;
    }
    
    public boolean isExp(char c){ // 연산자인지 확인
        if(c=='+' || c=='-' || c=='*')
            return true;
        else 
            return false;
    }
    
    public List<String> containExp(String s, List<String> list){
        if(s.contains("+")) list.add("+");
        if(s.contains("-")) list.add("-");
        if(s.contains("*")) list.add("*");
        return list;
    }
    
    public long calculate(List<String> list, List<String> exp){
        List<String> list2 = new ArrayList<>(list);
        int i = 0;
        long n = 0;
        while(i<exp.size()){            
            while(list2.contains(exp.get(i))){ // -일때
                int idx = list2.indexOf(exp.get(i));
                n = cal(list2.get(idx-1), list2.get(idx+1), exp.get(i));
                
                for(int k=0; k<3; k++)
                    list2.remove(idx-1);
                
                list2.add(idx-1, Long.toString(n));
            }
            i++;
        }
        return n;
    }
    
    public long cal(String s1, String s2, String exp){
        long n1 = Long.parseLong(s1);
        long n2 = Long.parseLong(s2);
        if(exp.equals("-"))
            return n1 - n2;
        else if(exp.equals("+"))
            return n1 + n2;
        else
            return n1 * n2;
    }
    
    public void permutation(List<String> exp, int depth, int n, List<String> list) {
        if (depth == n) {
            result = Math.max(Math.abs(calculate(list, exp)), result);
            return;
        }
 
        for (int i=depth; i<n; i++) {
            swap(exp, depth, i);
            permutation(exp, depth + 1, n, list);
            swap(exp, depth, i);
        }
    }
     
    static void swap(List<String> list, int depth, int i) {
        String temp = list.get(depth);
        list.set(depth, list.get(i));
        list.set(i, temp);
    }
}