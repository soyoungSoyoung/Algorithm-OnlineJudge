import java.util.*;

class Solution {
    static List<Integer>[] al;
    static int answer;
    
    public int solution(int n, int[][] lighthouse) {
        init(n, lighthouse);
        
        dfs(1,0); //현재 노드, 이전 노드
        
        
        return answer;
    }
    
    static int dfs(int cur,int prev) {
        //끄면 1 켜면 0
        
        if(al[cur].size() == 1) { //맨 끝
           //2개가 서로만 연결됐을 땐 둘 중 하나는 켜야 함 (=무조건 끄는 게 아니라는 얘기)
           //그래서 prev를 확인해서, prev와 al[cur]에 붙어있는 애가 같을 때만 끔
           if((al[cur].get(0) == prev)) {
               return 1;
           }
        }
        
        //여러 개 연결 => 주변 다 확인해서 
        //하나라도 꺼져 있으면(=al.size보다 작다면) 켜야 함
        int aroundSum = 0;
        for(int nxt : al[cur]) {
            if(prev == nxt) continue;
            aroundSum += dfs(nxt, cur);
        }
        
        //주변이 다 0을 리턴=다 켜져있음 => 여기는 끄면 됨
        if(aroundSum == 0)
            return 1;
        
        //그렇지 않다면=주변에 하나라도 꺼진 게 있다면 => 켜야 함
        answer ++;
        return 0;
    }
    
    static void init(int n, int[][] lighthouse) {
        al = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) {
            al[i] = new ArrayList<>();
        }
        
        
        for(int i=0; i<lighthouse.length; i++) {
            int a = lighthouse[i][0];
            int b = lighthouse[i][1];
            al[a].add(b);
            al[b].add(a);
        }
    }
}