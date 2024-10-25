
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int t=0; t<testcase; t++) {
			int n = sc.nextInt(); //편의점의 개수
			int[][] endPoint = new int[2][2]; //집,락페
			List<int[]> convens = new ArrayList<>();
			endPoint[0][0] = sc.nextInt();
			endPoint[0][1] = sc.nextInt(); //집 좌표
			
			for(int i=0; i<n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				convens.add(new int[] {x, y});
			}
			
			endPoint[1][0] = sc.nextInt();
			endPoint[1][1] = sc.nextInt(); //락페 좌표
			
			if(canGo(n, endPoint, convens) >= 0) System.out.println("happy");
			else System.out.println("sad");
			
//			while(!pq.isEmpty()) {
//				System.out.println(Arrays.toString(pq.poll()));
//			}
			
		}//
	}
	
	private static int canGo(int n, int[][] endPoint, List<int[]> convens) {
		Queue<Beer> q = new ArrayDeque<>();
		q.add(new Beer(endPoint[0], 0)); //좌표, 움직인 횟수
		while(!q.isEmpty()) {
			Beer cur = q.poll();
			
			if(canTmpGo(cur.point, endPoint[1]) > 0) {
				//다음 편의점 거치지 않고 갈 수 있으면
				return cur.move;
			}
			
			//남은 편의점 중에서, 50*20 이내 거리에 있는 편의점 집어 넣기
			for(int i=convens.size() - 1; i>=0; i--) {
				if(canTmpGo(cur.point, convens.get(i)) > 0) {
					q.add(new Beer(convens.get(i), cur.move + 1));
					convens.remove(i);
				}
			}
		}
		return -1; //못 가면 음수 출력
	}
	
	private static int canTmpGo(int[] start, int[] end) {
		return Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]) <= 1000 ? 1 : -1;
		
		//맥주가 최대로 찼을 떄, 최대 50*20 = 1000m 움직일 수 있음.
		//따라서 '거리'가 1000 이하이면 갈 수 있음
		
	}

}
class Beer {
	int[] point;
	int move;
	public Beer(int[] point, int move) {
		this.point = point;
		this.move = move;
	}
}
