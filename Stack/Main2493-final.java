import java.io.*;
import java.util.*;
import java.util.Stack;
class Top{
	int num;
	int height;
	
	public Top(int num, int height) {
		this.num=num;
		this.height = height;
	}
}
public class Main2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Stack<Top> stk = new Stack<Top>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = 1;
		while (st.hasMoreTokens()) {
			int height = Integer.parseInt(st.nextToken());
			
			if (stk.isEmpty()) { // 처음 스택이 비어있을 때
				stk.push(new Top(num, height));
				sb.append(0).append(" ");
			} else {
				while (true) {
					Top peektop = stk.peek();
					if (peektop.height > height) {
						sb.append(peektop.num).append(" ");
						stk.push(new Top(num,height));
						break;
					} else
						stk.pop();
					
					if (stk.isEmpty()) {
						sb.append(0).append(" ");
						stk.push(new Top(num, height));
						break;
					}
				}
			}
			num++;
		}
		System.out.println(sb);
	}
}
