
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] cards = new int[n];
		for(int i=0; i<n; i++)
			cards[i] = sc.nextInt();
		Arrays.sort(cards);
		
		int m = sc.nextInt();
		int[] f = new int[m];
		for(int i=0; i<m; i++)
			f[i] = sc.nextInt();
		
		int[] ans = new int[m];
		for(int pivot = 0; pivot<m; pivot++) { //f의 피봇
			int left = 0;
			int right = n-1;
			
			while(left <= right) {
				int mid = (left + right) / 2;
				if(cards[mid] < f[pivot]) {
					left = mid + 1;
				}
				else if(f[pivot] < cards[mid]){
					right = mid - 1;
				}
				else {
					ans[pivot] = 1;
					break;
				}
			}
		}
		
		//
		for(int i=0; i<m; i++)
			System.out.print(ans[i]+" ");
	}

}
