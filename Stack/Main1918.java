import java.io.*;
import java.util.HashMap;
import java.util.Stack;

public class Main1918 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> opr = new HashMap<String, Integer>();
		opr.put("+",2);
		opr.put("-",2);
		opr.put("*",1);
		opr.put("/",1);
		opr.put("(",3);
		opr.put(")",3);

		Stack<String> total = new Stack<String>();// 전체 식을 담을 스택
		Stack <String> mid = new Stack<String>();// 연산자만 담을 스택
		
		String s = br.readLine();
	
		for (int i = 0; i < s.length(); i++) {
			String tmp =s.substring(i,i+1);
			
			if(opr.containsKey(tmp)) { // 연산자일때
				if("(".equals(tmp))
					mid.push(tmp);
				
				else if(")".equals(tmp)) {
					while(true) {
						String poptmp = mid.pop();
						if("(".equals(poptmp))
							break;
						total.push(poptmp);
					}
				}
				else  { 
					while( !mid.isEmpty() && opr.get(mid.peek()) <= opr.get(tmp)) // 스택이 안비어있고 연산자 우선순위 비교 (저장되었는것이 더 높은 우선순위를 가질때)
						total.push(mid.pop());
						
					mid.push(tmp); //비어있을때, 연산자 넣는것이 우선순위 높을때  
					}
			}
			
			else // 연산자가 아닌 기호일때
				total.add(tmp);
		
		}
		while(!mid.isEmpty()) // mid 에 남은것 싹다 가져오기
			total.push(mid.pop());
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < total.size(); i++) {
			sb.append(total.get(i));
		}
		
		System.out.println(sb);
		
}
}
