import java.io.*;
import java.util.*;

public class Main {
	static int n, m, x, ans;
	static ArrayList<int[]>[] go, back;

	public static void main(String[] args) {
		input_1238();
		
		int dpGo[] = dijkstra(go); //각 정점에서 x로 가는 최소 거리
		int dpBack[] = dijkstra(back); //x에서 각 정점으로 가는 최소 거리
		
		for (int i = 0; i < n+1; i++) {
			ans = Math.max(ans, dpGo[i] + dpBack[i]);
		}
		System.out.println(ans);
	}

	private static int[] dijkstra(ArrayList<int[]>[] map) {
		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[x] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> o1[1] - o2[1]);
		pq.add(new int[] {x, 0});
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			for(int[] nxt : map[cur[0]]) {
				if(dp[nxt[0]] > dp[cur[0]] + nxt[1]) {
					dp[nxt[0]] = dp[cur[0]] + nxt[1];
					pq.add(new int[] {nxt[0], dp[nxt[0]]});
				}
			}
		}
//		System.out.println(Arrays.toString(dp));
		return dp;
	}

	private static void input_1238() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //마을 개수 = 학생 개수
		m = sc.nextInt(); //도로 개수
		x = sc.nextInt(); //레츠고 파티
		
		go = new ArrayList[n+1]; //1~n인덱스 사용
		back = new ArrayList[n+1];
		for (int i = 0; i < n+1; i++) {
			go[i] = new ArrayList<>();
			back[i] = new ArrayList<>();
		}
//		dpGo = new int[n+1];
//		dpBack = new int[n+1];
		
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int val = sc.nextInt();
			
			go[s].add(new int[] {e, val}); //각 정점에서 x로 가는 최소 거리
			back[e].add(new int[] {s, val}); //x에서 각 정점으로 가는 최소 거리
		}
	}

}
