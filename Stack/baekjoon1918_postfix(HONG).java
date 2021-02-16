import java.io.*;
import java.util.HashMap;
import java.util.Stack;

public class Main1918 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> opr = new HashMap<String, Integer>(); // 연산자의 우선순위를 부여하기 HashMap 이용 KEY : 연산자, Value : 우선순위 
		opr.put("+",2); // 덧셈, 뺄셈이 두번째로 우선순위가 높음
		opr.put("-",2);
		opr.put("*",1); // 곱셈 나눗셈이 가장 우선순위가 높음
		opr.put("/",1);
		opr.put("(",3); // 괄호는 여는 괄호는 닫는괄호를 만나야 pop되고 괄호 안의 어떤 연산자가 들어와도 pop되지 않아야하기 때문에 우선순위 가장 낮게 부여
		opr.put(")",3);

		Stack<String> total = new Stack<String>();// 전체 식을 담을 스택
		Stack <String> mid = new Stack<String>();// 연산자만 담을 스택
		
		String s = br.readLine();
	
		for (int i = 0; i < s.length(); i++) {
			String tmp =s.substring(i,i+1); // 입력받은 문자열 쪼개기
			
			if(opr.containsKey(tmp)) { // 연산자일때
				if("(".equals(tmp)) // 연산자중 여는괄호일때 push
					mid.push(tmp);
				
				else if(")".equals(tmp)) { // 연산자중 닫는 괄호일 때
					while(true) {
						String poptmp = mid.pop(); // 괄호안의 연산자들 poptmp 변수에 저장
						if("(".equals(poptmp)) // pop 하다가 여는 괄호 만날때 while 문 탈출, 탈출 조건을 주지않으면 여는괄호까지 스택에 push 되버린다.
							break; 
						total.push(poptmp); // 괄호안의 연산자들 stack에 push
					}
				}
				else  { // 연산자중 여는괄호도 아니고 닫는 괄호도 아닐때 +,-*,/
					while( !mid.isEmpty() && opr.get(mid.peek()) <= opr.get(tmp)) // 스택이 안비어있고 연산자 우선순위 비교 (저장되었는것이 더 높은 우선순위를 가질때)
						total.push(mid.pop()); // 연산자 스택에서 pop해서 전체 식 스택에 push
						
					mid.push(tmp); //스택이 비어있거나, 연산자 넣는것이 우선순위 높을때는 차례대로 연산자 스택에 push 
					}
			}
			
			else // 연산자가 아닌 기호일때 차례대로 push
				total.add(tmp);
		
		}
		while(!mid.isEmpty()) // 연산자 stack 에 남은것 전체식 stack에 싹다 가져오기
			total.push(mid.pop());
		
		StringBuilder sb = new StringBuilder(); // 출력하기 위한 문자열
		
		for (int i = 0; i < total.size(); i++) { // stack 0번째 칸에 있는 것부터 문자열에 차례대로 연결
			sb.append(total.get(i));
		}
		
		System.out.println(sb);
		
}
}
