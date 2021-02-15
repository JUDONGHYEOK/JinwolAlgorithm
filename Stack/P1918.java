package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P1918 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		Stack<Character> stk=new Stack<Character>();
		Stack<Character> stk2=new Stack<Character>();
		for (int i = 0; i <str.length(); i++) {
			char c=str.charAt(i);
			if(c =='('||c==')') {
				break;
			}
			else if(c=='+'||c=='-'||c=='*'||c=='/') {
				stk2.push(c);
			}
			else
				stk.push(c);
		}
		StringBuilder sb=new StringBuilder();
		while(!stk.isEmpty()) {
			sb.append(stk.pop());
		}
				
		while(!stk2.isEmpty()) {
			sb.append(stk.pop());
		}
		System.out.println(sb);
		
	}

}
