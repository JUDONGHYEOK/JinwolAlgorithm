package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
//��ū��
public class P17298 {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());		//�� ��
		int[] ar=new int[n];									//�迭 ����
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for (int i = 0; i <n; i++) {
			ar[i]=Integer.parseInt(st.nextToken());	//�迭�� �� �Է�
		}
		Stack<Integer> stk=new Stack<Integer>();	
		for (int i = 0; i < n; i++) {
			
			/*������ ������� �ʰ� ���� �� ���� ���� ������ ������
			 * �� ���� ���������� �����ϰ� ���ÿ� �ε����� Ǫ��
			 */
			while(!stk.isEmpty()&&ar[stk.peek()]<ar[i]) {
				ar[stk.pop()]=ar[i];
			}
			stk.push(i);
		}
		while(!stk.isEmpty()) {
			ar[stk.pop()]=-1;		//���ÿ� ����ִ� ���� -1�� ����
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(ar[i]).append(' ');
		}
		
		System.out.println(sb);
		
	}
}
