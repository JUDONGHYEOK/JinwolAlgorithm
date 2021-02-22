import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Stack;

public class Main17298 {
	public static void main(String[] args) throws IOException {
		Stack<Integer> stk = new Stack<Integer>(); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int r = Integer.parseInt(br.readLine()); // 수열 크기
		StringBuilder sb = new StringBuilder(); 
		String s = br.readLine(); // 문자열 입력받기
		String st[] = s.split(" "); // 문자열 띄어쓰기 기준으로 쪼개서 문자열 배열에 저장
		int ar[] = new int[r]; // 왼쪽에 큰 값을 저장하기 위한 배열
		int i = 0;
		while (r-- > 0) { // 수열을 다 비교할 때 까지
			int n = Integer.parseInt(st[r]); // 비교 기준 
			if (stk.isEmpty()) { // 맨처음 스택이 비어있을 때
				ar[i] = -1; // 자신의 왼쪽에 수가 없기 때문에 -1 출력
				i++; 
				stk.push(n); // 스택에 값넣기
			} else { // 스택이 비어있지 않을 때
				while (true) {
					int peeknum = stk.peek();
					if (peeknum > n) { // 자기보다 스택에 저장된 수(왼쪽에 있는 수)가 있을때
						ar[i] = peeknum; //왼쪽에 가장 가까운 수 배열에 저장
						stk.push(n); // 자기 자신 스택에 push
						i++; // 배열에 저장했기 때문에 인덱스 저장
						break;
					} else // 자기보다 스택에 저장된 수(왼쪽에 있는 수)가 없을 때
						stk.pop(); // 계속pop

					if (stk.isEmpty()) { // pop 하다가 스택이 비어있으면 (자기보다 왼쪽에 큰 수가 없을 때)
						ar[i] = -1; // -1 배열에 저장
						stk.push(n); // 자기 자신 스택에 push
						i++;
						break;
					}
				}
			}
		}
		for (int j = ar.length - 1; j >= 0; j--) { // 수열 뒤쪽부터 비교했기 때문에 배열 뒤쪽부터 문자열에 저장
			sb.append(Integer.toString(ar[j])).append(" ");
		}

		System.out.println(sb);

	}
}
