import java.io.*;
import java.util.*;
import java.util.Stack;

public class Main2493 {
	public static int getkey(HashMap<Integer, Integer> m, int value) {
		for (int k : m.keySet()) {
			if (m.get(k) == value)
				return k;
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> tops = new HashMap<Integer, Integer>();

		Stack<Integer> stk = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = 1;
		while (st.hasMoreTokens()) {
			tops.put(num, Integer.parseInt(st.nextToken()));
			
			if (stk.isEmpty()) { // 처음 스택이 비어있을 때
				stk.push(tops.get(num));
				sb.append(0).append(" ");
			} else {
				while (true) {
					int peektop = stk.peek();
					if (peektop > tops.get(num)) {
						sb.append(getkey(tops, peektop)).append(" ");
						stk.push(tops.get(num));
						break;
					} else
						stk.pop();
					
					if (stk.isEmpty()) {
						sb.append(0).append(" ");
						stk.push(tops.get(num));
						break;
					}
				}
			}
			num++;
		}
		System.out.println(sb.toString());
		br.close();
	}
}
