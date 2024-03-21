import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = 0;
		int answer = 0;
		int n = sc.nextInt();
		String s = Integer.toString(n);
		
		for(int i=0; i<9; i++) {
			String num = Integer.toString(i);
			String temp = s;
			
			if(i==6) 
				temp = temp.replace("9", "");
			
			temp = temp.replace(num, "");
			length = s.length() - temp.length();
			
			if(i==6) 
				length = length/2 + length%2;
			
			answer = Math.max(answer, length);
		}
		
		System.out.print(answer);
		
	}
}
