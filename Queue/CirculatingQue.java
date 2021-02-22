package Que;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class CirculatingQue {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken());		//ť�� ũ��
		int M=Integer.parseInt(st.nextToken());		//�̾Ƴ����� ���� ����
		st=new StringTokenizer(br.readLine()," ");
		LinkedList<Integer> link=new LinkedList<Integer>();
		for (int i = 1; i <=N; i++) {
			link.add(i);						//������� �Է�
		}
		int cnt=0;
		int t,idx;
		for (int i = 0; i < M; i++) {
			 t=Integer.parseInt(st.nextToken());	//�̾Ƴ����� ��
			 idx=link.indexOf(t);			//���� �ε�����
			if(idx<=link.size()/2) {			//ã�¼��� ������� �տ�������
				for (int j = 0; j < idx; j++) {
					int tmp=link.pop();
					link.add(tmp);
					cnt++;
				}
			}
			else {
				for (int j = 0; j < link.size()-idx; j++) {	//ã�¼��� ������� �ڿ�������
					int tmp=link.pollLast();
					link.push(tmp);
					cnt++;
				}
			}
			
			link.pop();
			
		}
	
		System.out.println(cnt);
	
	
	
	}
}
