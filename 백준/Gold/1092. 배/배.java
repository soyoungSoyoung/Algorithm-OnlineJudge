import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //배 개수
		int[] ships = new int[n];
		for (int i = 0; i < ships.length; i++) {
			ships[i] = sc.nextInt();
		}
		Arrays.sort(ships);
		
		ArrayList<Integer>[] cargoes = new ArrayList[n+1]; //배보다 작은 애들 
		for(int i=0; i<n+1; i++) {
			cargoes[i] = new ArrayList<>();
		}
		
		int m = sc.nextInt(); //화물 개수
//		int[] cargoes1 = new int[m];
//		for (int i = 0; i < cargoes.length; i++) {
//			cargoes[i] = sc.nextInt();
//		}
		for(int i = 0; i < m; i++) {
			int cargo = sc.nextInt();
//			cargoes1[i] = cargo;
			boolean canLift = false;
			for(int j=0; j<n; j++) {
				if(ships[j] >= cargo) {
					cargoes[j].add(cargo);
					canLift = true;
					break;
				}
			}
			if(!canLift) cargoes[n].add(cargo);
		}
		
//		Arrays.sort(cargoes1);
		//
		
		int answer = 0;
		if(cargoes[n].size() > 0)
			System.out.println(-1);
		else {
			int cnt = 0;
			while(true) {
				if(cnt == m) break;
				answer ++;
				
				boolean used[] = new boolean[n];
				for(int i=n-1; i>=0; i--) {
					if(cargoes[i].size() > 0) {
						cargoes[i].remove(0);
						cnt++;
						used[i] = true;
					}
					else {
						for(int j=i-1; j>=0; j--) {
							if(cargoes[j].size() > 0) {
								cargoes[j].remove(0);
								cnt++;
								used[i]= true;
								break;
							}
						}
					}
				}
			}
			
			System.out.println(answer);
		}
		
	}

}
