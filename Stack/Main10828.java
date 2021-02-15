import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.*;

public class StackTest {
	public static void main(String[] args) throws IOException {
		Stack<Integer> stk = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt= Integer.parseInt(st.nextToken());
		for (int i = 0; i < cnt; i++) {
			String key = new String(br.readLine());
			if(key.contains("push")) {
				stk.push(Integer.parseInt(key.substring(5)));
			}
			else if(key.equals("pop")) {
				System.out.println(stk.empty()?-1:stk.pop());
			}
			else if(key.equals("size")) {
				System.out.println(stk.size());
			}
			else if(key.equals("empty")) {
				System.out.println(stk.isEmpty()?1:0);
			}
			else if(key.equals("top")) {
				System.out.println(stk.empty()?-1:stk.peek());
			}
		}
	}
}
