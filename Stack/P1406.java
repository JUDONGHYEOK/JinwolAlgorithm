package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//에디터
public class P1406 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine(),"");
		int n=Integer.parseInt(br.readLine());
		Stack<String> stk=new Stack<String>();		//처음 문자가 들어오는 스택
		Stack<String> stk2=new Stack<String>();		//빼놓는 스택
		
		for (int i = 0; i < st.countTokens(); i++) {
			stk.push(st.nextToken());
		}
		
		for (int i = 0; i < n; i++) {
			String com=br.readLine();
			char c=com.charAt(0);
			switch(c){
				case 'L' : 						//stk2로 이동해서 커서이동
					if(!stk.isEmpty())
						stk2.push(stk.pop());
					
						break;
				case 'D' :
					if(!stk2.isEmpty())		//커서가 왼쪽으로 갈때 stk2로 문자가 이동하기 때문에
						stk.push(stk2.pop());	//다시 stk 로이동
				
						break;
				case 'B' :
					if(!stk.isEmpty())			//pop
						stk.pop();
				
						break;
				case 'P' :
					char a=com.charAt(2);		//입력받은 문자 추가
					stk.push(String.valueOf(a));
					
					break;
					
				default :
					break;
			}
		}
		while(!stk.isEmpty()) {
			stk2.push(stk.pop());			//stk에 있는 문자들을 stk2로 옮겨
		}
		for (int i = 0; i < stk2.size(); i++) {
			System.out.print(stk2.pop());	//LIFO 이기때문에 순서대로 출력가능
		}
		
	}

}
