import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Stack;

public class Main17298 {
	public static void main(String[] args) throws IOException {
		Stack<Integer> stk = new Stack<Integer>(); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int r = Integer.parseInt(br.readLine()); // ���� ũ��
		StringBuilder sb = new StringBuilder(); 
		String s = br.readLine(); // ���ڿ� �Է¹ޱ�
		String st[] = s.split(" "); // ���ڿ� ���� �������� �ɰ��� ���ڿ� �迭�� ����
		int ar[] = new int[r]; // ���ʿ� ū ���� �����ϱ� ���� �迭
		int i = 0;
		while (r-- > 0) { // ������ �� ���� �� ����
			int n = Integer.parseInt(st[r]); // �� ���� 
			if (stk.isEmpty()) { // ��ó�� ������ ������� ��
				ar[i] = -1; // �ڽ��� ���ʿ� ���� ���� ������ -1 ���
				i++; 
				stk.push(n); // ���ÿ� ���ֱ�
			} else { // ������ ������� ���� ��
				while (true) {
					int peeknum = stk.peek();
					if (peeknum > n) { // �ڱ⺸�� ���ÿ� ����� ��(���ʿ� �ִ� ��)�� ������
						ar[i] = peeknum; //���ʿ� ���� ����� �� �迭�� ����
						stk.push(n); // �ڱ� �ڽ� ���ÿ� push
						i++; // �迭�� �����߱� ������ �ε��� ����
						break;
					} else // �ڱ⺸�� ���ÿ� ����� ��(���ʿ� �ִ� ��)�� ���� ��
						stk.pop(); // ���pop

					if (stk.isEmpty()) { // pop �ϴٰ� ������ ��������� (�ڱ⺸�� ���ʿ� ū ���� ���� ��)
						ar[i] = -1; // -1 �迭�� ����
						stk.push(n); // �ڱ� �ڽ� ���ÿ� push
						i++;
						break;
					}
				}
			}
		}
		for (int j = ar.length - 1; j >= 0; j--) { // ���� ���ʺ��� ���߱� ������ �迭 ���ʺ��� ���ڿ��� ����
			sb.append(Integer.toString(ar[j])).append(" ");
		}

		System.out.println(sb);

	}
}
