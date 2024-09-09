import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		List<Integer> plus = new ArrayList<>();
		List<Integer> minus = new ArrayList<>();
		List<Integer> gop = new ArrayList<>();
		boolean hasZero = false;
		
		int answer = 0;
		
		for (int i = 0; i < n; i++) {
			int input = sc.nextInt();
			
			if(input > 1) plus.add(input);
			else if(input == 1) answer += 1;
			else if(input < 0) minus.add(input);
			else hasZero = true;
		}
		
		Collections.sort(plus, Collections.reverseOrder());
		Collections.sort(minus);
		
		while(plus.size() > 1) {
			int tmp = plus.remove(0) * plus.remove(0);
			gop.add(tmp);
		}
		while(minus.size() > 1) {
			int tmp = minus.remove(0) * minus.remove(0);
			gop.add(tmp);
		}
		
		answer += plus.isEmpty() ? 0 : plus.get(0);
		
		for(int i=0; i<gop.size(); i++)
			answer += gop.get(i);
		
		if(!minus.isEmpty()) {
			if(!hasZero) answer += minus.get(0);
		}
		
		System.out.println(answer);
	}

}
