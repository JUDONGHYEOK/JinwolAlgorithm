import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Stack;

public class Main17298 {
	public static void main(String[] args) throws IOException {
		Stack<Integer> stk = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int r = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String s = br.readLine(); // 문자열 입력받기
		String st[] = s.split(" ");
		int ar[] = new int[r];
		int i = 0;
		while (r-- > 0) {
			int n = Integer.parseInt(st[r]);
			if (stk.isEmpty()) {
				ar[i] = -1;
				i++;
				stk.push(n);
			} else {
				while (true) {
					int peeknum = stk.peek();
					if (peeknum > n) {
						ar[i] = peeknum;
						stk.push(n);
						i++;
						break;
					} else
						stk.pop();

					if (stk.isEmpty()) {
						ar[i] = -1;
						stk.push(n);
						i++;
						break;
					}
				}
			}
		}
		for (int j = ar.length - 1; j >= 0; j--) {
			sb.append(Integer.toString(ar[j])).append(" ");
		}

		System.out.println(sb);

	}
}
