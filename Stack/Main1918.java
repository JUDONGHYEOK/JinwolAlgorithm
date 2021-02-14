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

		Stack<String> total = new Stack<String>();// ��ü ���� ���� ����
		Stack <String> mid = new Stack<String>();// �����ڸ� ���� ����
		
		String s = br.readLine();
	
		for (int i = 0; i < s.length(); i++) {
			String tmp =s.substring(i,i+1);
			
			if(opr.containsKey(tmp)) { // �������϶�
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
					while( !mid.isEmpty() && opr.get(mid.peek()) <= opr.get(tmp)) // ������ �Ⱥ���ְ� ������ �켱���� �� (����Ǿ��°��� �� ���� �켱������ ������)
						total.push(mid.pop());
						
					mid.push(tmp); //���������, ������ �ִ°��� �켱���� ������  
					}
			}
			
			else // �����ڰ� �ƴ� ��ȣ�϶�
				total.add(tmp);
		
		}
		while(!mid.isEmpty()) // mid �� ������ �ϴ� ��������
			total.push(mid.pop());
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < total.size(); i++) {
			sb.append(total.get(i));
		}
		
		System.out.println(sb);
		
}
}
