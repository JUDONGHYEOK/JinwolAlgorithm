package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P2493 {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		Stack<Integer> stk=new Stack<Integer>();
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i <n; i++) {
			int t=Integer.parseInt(st.nextToken());
			if(stk.isEmpty()) {
				stk.push(t);
				sb.append(0).append(' ');
			}
			else if(!stk.isEmpty()&&stk.peek()<t) {
				sb.append(0).append(' ');
				stk.push(t);
			}
			else if(!stk.isEmpty()&&stk.peek()>t) {
				sb.append(i).append(' ');
				
			}
		}
	}

}
