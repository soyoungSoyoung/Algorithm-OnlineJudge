
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m; //정점 개수, 간선 개수
    static ArrayList<Node>[] al; //인접 리스트
    static int s, t; //시작점, 종착점
    static int[] dp; //최솟값 저장

    public static void main(String[] args) throws IOException {
        input_14284();

        System.out.println(dfs_14284(s, t));
    }

    private static int dfs_14284(int s, int t) {
        // 가중치가 작은 -> 큰 순으로 정렬하는 우선순위 큐 사용
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
        dp[s] = 0; // 시작점은 0으로 초기화
        pq.offer(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            // ** 다익스트라
            for (Node nxt : al[cur.node]) {
                if (dp[nxt.node] > nxt.value + dp[cur.node]) {
                    dp[nxt.node] = nxt.value + dp[cur.node];
                    pq.offer(new Node(nxt.node, dp[nxt.node]));
                }
            }
            // ** 혼돈의 카오스

        }

        return dp[t];
    }

    private static void input_14284() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //정점 개수
        m = Integer.parseInt(st.nextToken()); //간선 개수

        dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        al = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) -1;
            int b = Integer.parseInt(st.nextToken()) -1;
            int val = Integer.parseInt(st.nextToken());

            //무방향이므로 둘 다 add
            al[a].add(new Node(b, val));
            al[b].add(new Node(a, val));
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken()) -1;
        t = Integer.parseInt(st.nextToken()) -1;
    }
}

class Node {
    int node; //정점의 숫자
    int value; //node까지의 가중치

    public Node(int node, int value) {
        this.node = node;
        this.value = value;
    }
}