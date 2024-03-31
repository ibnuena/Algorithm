import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		int size = 0;
		int[] start = new int[2];
		int[] end = new int[2];
		int[][] direction = {{1,2}, {1,-2}, {-1,2}, {-1,-2}, {2,1}, {2,-1}, {-2,1}, {-2,-1}};
		
		for(int i=0; i<t; i++) {
            Queue<int[]> q = new LinkedList<>();
			int answer = 0;
			size = sc.nextInt();
			int[][] map = new int[size][size];
			start[0] = sc.nextInt();
			start[1] = sc.nextInt();
			end[0] = sc.nextInt();
			end[1] = sc.nextInt();
			
			q.add(new int[]{start[0], start[1], 0});
			
			while(!q.isEmpty()) {
				
				int[] current = q.poll();
				start[0] = current[0];
				start[1] = current[1];
				answer = current[2];
				
				if(start[0]==end[0] && start[1]==end[1]) {
					System.out.println(answer);
					break;
				}
				
				for(int j=0; j<direction.length; j++) {
					int x = start[0] + direction[j][0];
					int y = start[1] + direction[j][1];
					
					if(x>=0 && y>=0 && x<size && y<size && map[x][y]==0) {
						map[x][y] = 1;
						q.add(new int[]{x, y, answer+1});
					}
				}
			}
		}
	}
}