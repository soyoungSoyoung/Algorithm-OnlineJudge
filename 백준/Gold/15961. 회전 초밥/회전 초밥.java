import java.io.*;
import java.util.*;

public class Main {
	static int n,d,k,c, dishes[], list[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); //접시 개수
		dishes = new int[n];
		
		d = sc.nextInt(); //초밥 가지수
		list = new int[d+1];
		
		k = sc.nextInt(); //연속 접시 수
		c = sc.nextInt(); //쿠폰 번호
		
		for(int i=0; i<n; i++) {
			dishes[i] = sc.nextInt();
		}
		
		list[c]++; //쿠폰은 먹이고 시작
		
		int ans = 0;
		for (int i = 0; i < k; i++) {
			list[dishes[i]]++;
		}
		for (int i = 0; i < list.length; i++) {
			if(list[i] > 0) ans++;
		}
		//
		
		int tmpCnt = ans;
		for (int startDish = 1; startDish < n; startDish++) {
			int prevCnt = tmpCnt;
			
			list[dishes[startDish-1]]--; //지울 거
			if(list[dishes[startDish-1]] == 0) prevCnt--;
			
			int end = startDish+k - 1; //더할 거
			if(end >= n) end = end%n;
			list[dishes[end]]++;
			if(list[dishes[end]] == 1) prevCnt++;
			
//			for(int i=0;i<list.length;i++) {
//				if(list[i]>0) System.out.print(i+" "+list[i]+" ");
//			}System.out.println("탬프엔서: "+prevCnt);
			
			ans = Math.max(ans, prevCnt);
			tmpCnt = prevCnt;
		}
		
		System.out.println(ans);
	}

}
