import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main12798_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> que = new LinkedList<Integer>(); // 원래의 줄
		for (int i = 0; i < n; i++) {
			que.offer(Integer.parseInt(st.nextToken()));
		}
		Stack<Integer> stk = new Stack<Integer>(); // 임시저장할 스택

		int cnt = 1;
		while (cnt <= n) {
			if (!que.isEmpty()) {
				int temp = que.peek();
				if (temp == cnt) {
					cnt++;
					que.poll();
				} else if (!stk.isEmpty() && (stk.peek() == cnt)) {
					stk.pop();
					cnt++;
				} else {
					stk.push(temp);
					que.poll();
				}
			}

			else if (!stk.isEmpty()) {
				if (cnt == stk.peek()) {
					stk.pop();
					cnt++;
				} else
					break;
			}
		}

		if (stk.isEmpty())
			System.out.println("Nice");
		else
			System.out.println("Sad");

	}
}
