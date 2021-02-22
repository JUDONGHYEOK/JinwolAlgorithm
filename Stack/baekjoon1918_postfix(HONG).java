import java.io.*;
import java.util.HashMap;
import java.util.Stack;

public class Main1918 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> opr = new HashMap<String, Integer>(); // �������� �켱������ �ο��ϱ� HashMap �̿� KEY : ������, Value : �켱���� 
		opr.put("+",2); // ����, ������ �ι�°�� �켱������ ����
		opr.put("-",2);
		opr.put("*",1); // ���� �������� ���� �켱������ ����
		opr.put("/",1);
		opr.put("(",3); // ��ȣ�� ���� ��ȣ�� �ݴ°�ȣ�� ������ pop�ǰ� ��ȣ ���� � �����ڰ� ���͵� pop���� �ʾƾ��ϱ� ������ �켱���� ���� ���� �ο�
		opr.put(")",3);

		Stack<String> total = new Stack<String>();// ��ü ���� ���� ����
		Stack <String> mid = new Stack<String>();// �����ڸ� ���� ����
		
		String s = br.readLine();
	
		for (int i = 0; i < s.length(); i++) {
			String tmp =s.substring(i,i+1); // �Է¹��� ���ڿ� �ɰ���
			
			if(opr.containsKey(tmp)) { // �������϶�
				if("(".equals(tmp)) // �������� ���°�ȣ�϶� push
					mid.push(tmp);
				
				else if(")".equals(tmp)) { // �������� �ݴ� ��ȣ�� ��
					while(true) {
						String poptmp = mid.pop(); // ��ȣ���� �����ڵ� poptmp ������ ����
						if("(".equals(poptmp)) // pop �ϴٰ� ���� ��ȣ ������ while �� Ż��, Ż�� ������ ���������� ���°�ȣ���� ���ÿ� push �ǹ�����.
							break; 
						total.push(poptmp); // ��ȣ���� �����ڵ� stack�� push
					}
				}
				else  { // �������� ���°�ȣ�� �ƴϰ� �ݴ� ��ȣ�� �ƴҶ� +,-*,/
					while( !mid.isEmpty() && opr.get(mid.peek()) <= opr.get(tmp)) // ������ �Ⱥ���ְ� ������ �켱���� �� (����Ǿ��°��� �� ���� �켱������ ������)
						total.push(mid.pop()); // ������ ���ÿ��� pop�ؼ� ��ü �� ���ÿ� push
						
					mid.push(tmp); //������ ����ְų�, ������ �ִ°��� �켱���� �������� ���ʴ�� ������ ���ÿ� push 
					}
			}
			
			else // �����ڰ� �ƴ� ��ȣ�϶� ���ʴ�� push
				total.add(tmp);
		
		}
		while(!mid.isEmpty()) // ������ stack �� ������ ��ü�� stack�� �ϴ� ��������
			total.push(mid.pop());
		
		StringBuilder sb = new StringBuilder(); // ����ϱ� ���� ���ڿ�
		
		for (int i = 0; i < total.size(); i++) { // stack 0��° ĭ�� �ִ� �ͺ��� ���ڿ��� ���ʴ�� ����
			sb.append(total.get(i));
		}
		
		System.out.println(sb);
		
}
}
