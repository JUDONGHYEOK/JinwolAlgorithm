import java.io.*;
import java.util.*;
import java.util.Stack;
class Top{ //Top Ŭ���� 
	int num; // Top �� ��ȣ(�ε���)
	int height; // Top �� ����
	
	public Top(int num, int height) { // Top ������
		this.num=num;
		this.height = height;
	}
}
public class Main2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Stack<Top> stk = new Stack<Top>(); //Top Ŭ������ Ÿ������ �� Stack ����
		StringBuilder sb = new StringBuilder(); // ����ϱ� ���� ���ڿ� (String�� �ٸ��� ��ȯ ����)
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = 1; // ž��ȣ
		while (st.hasMoreTokens()) { // ���̻� �Է��� ž�� ����������
			int height = Integer.parseInt(st.nextToken()); // ���ÿ� ���ʴ�� ���� ž�� ����(�� ����)
			
			if (stk.isEmpty()) { // ó�� ������ ������� ��
				stk.push(new Top(num, height)); //ù��° ž ��ü push
				sb.append(0).append(" ");// ù��° ž���� ���ʿ� �ִ� ž�� �����Ƿ� 0���
			} else { // ������ ������� ������ (�ι�° ž���� �ش�)
				while (true) { 
					Top peektop = stk.peek(); //���ÿ� ������ ž peek
					if (peektop.height > height) { // �ڱ⺸�� ���ʿ� ���� ž�� ������
						sb.append(peektop.num).append(" "); // �ڱ⺸�� ���� ���ʿ� ����� ž ��ȣ ���
						stk.push(new Top(num,height)); // �񱳱��� ž push
						break;
					} else // �ڱ⺸�� ���ʿ� ���� ž�� ������ 
						stk.pop(); //  �ڱ⺸�� ���ʿ� �ִ� ž�� �߿� �������� ž���� ���ʴ�� pop
					
					if (stk.isEmpty()) { // ���ʿ� ���� ž�� �ϳ��� ���� ��� pop �� stack�� ���� 
						sb.append(0).append(" "); // 0���
						stk.push(new Top(num, height)); // �񱳱��� ž push 
						break;
					}
				}
			}
			num++; // ž ��ȣ 1,2,3,4... ���ʴ�� �ο��ϱ� ���� ������ while ���� �� �� ����ɶ����� ����
		}
		System.out.println(sb); // ����ϱ� ���� ���ڿ� ���
	}
}
