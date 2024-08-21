import java.util.*;
import java.io.*;

public class Main {
	static int[] dp = new int[100001];
	static int a,b;
	static final int inf = 987654;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        Arrays.fill(dp, inf);
        
        dp[a] = 0;
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(a);
        
        while(!q.isEmpty()) {
        	int cur = q.poll();
        	
//        	System.out.println(cur+" "+dp[7]+" "+dp[8]);
        	
//        	if(cur == b) {
//        		break;
//        	}
        	
        	if(cur-1 >= 0 && dp[cur-1] == inf) {
        		dp[cur-1] = dp[cur] + 1;
        		q.add(cur-1);
        	}
        	
        	if(cur+1 < 100001 && dp[cur+1] == inf) {
        		dp[cur+1] = dp[cur] + 1;
        		q.add(cur+1);
        	}
        	
        	if(cur*2 < 100001 && dp[cur*2] == inf) {
        		dp[cur*2] = dp[cur] + 1;
        		q.add(cur*2);
        	}
        }
        
        System.out.println(dp[b]);
    }
    
}
