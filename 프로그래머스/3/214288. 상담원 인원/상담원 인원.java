import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    static int[] counselers;
    static int n,k, reqs[][];
    
    public int solution(int K, int N, int[][] Reqs) {
        k=K; n=N; reqs = Reqs;
        
        init();
        
        //
        // sunjobu(k,n);
        
        return sunjobu(1,n);
    }
    
    //중복 때문에 시간초과가 나는 거 같음. 
    static int sunjobu(int depth,int remainCouns) {
        if(depth==k+1&&remainCouns==0){
            return waiting();
        }
        if(depth==k+1){
            return Integer.MAX_VALUE;
        }
        
        for(int i=1;i<=remainCouns; i++){
            counselers[depth]=i;
            answer=Math.min(answer,sunjobu(depth+1,remainCouns-i));
        }
        return answer;
    }
    
    //
    static int waiting() {
        PriorityQueue<Integer>[] pq = new PriorityQueue[k+1];
        for(int i=0; i<k+1; i++) pq[i] = new PriorityQueue<>();
        
        int time = 0;
        for(int[] req : reqs) {
            int start = req[0];
            int during = req[1];
            int type = req[2];
            
            if(pq[type].size() < counselers[type])
                pq[type].add(start+during);
            else {
                int end = pq[type].poll();
                
                if(end > start) {
                    time += end - start;
                    pq[type].add(end + during);
                } else {
                    pq[type].add(start + during);
                }
            }
        }
        return time;
    }
    
    //
    static void init() {
        counselers = new int[k+1]; //상담 유형별로 배정된 상담사 수 저장
        for(int i=1; i<k+1; i++) counselers[i]++; //1명씩 무조건 배정~
    }
}
