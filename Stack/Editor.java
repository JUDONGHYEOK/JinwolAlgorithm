package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//������
public class P1406 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine(),"");
		int n=Integer.parseInt(br.readLine());
		Stack<String> stk=new Stack<String>();		//ó�� ���ڰ� ������ ����
		Stack<String> stk2=new Stack<String>();		//������ ����
		
		for (int i = 0; i < st.countTokens(); i++) {
			stk.push(st.nextToken());
		}
		
		for (int i = 0; i < n; i++) {
			String com=br.readLine();
			char c=com.charAt(0);
			switch(c){
				case 'L' : 						//stk2�� �̵��ؼ� Ŀ���̵�
					if(!stk.isEmpty())
						stk2.push(stk.pop());
					
						break;
				case 'D' :
					if(!stk2.isEmpty())		//Ŀ���� �������� ���� stk2�� ���ڰ� �̵��ϱ� ������
						stk.push(stk2.pop());	//�ٽ� stk ���̵�
				
						break;
				case 'B' :
					if(!stk.isEmpty())			//pop
						stk.pop();
				
						break;
				case 'P' :
					char a=com.charAt(2);		//�Է¹��� ���� �߰�
					stk.push(String.valueOf(a));
					
					break;
					
				default :
					break;
			}
		}
		while(!stk.isEmpty()) {
			stk2.push(stk.pop());			//stk�� �ִ� ���ڵ��� stk2�� �Ű�
		}
		for (int i = 0; i < stk2.size(); i++) {
			System.out.print(stk2.pop());	//LIFO �̱⶧���� ������� ��°���
		}
		
	}

}
