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
		int N=Integer.parseInt(st.nextToken());		//큐의 크기
		int M=Integer.parseInt(st.nextToken());		//뽑아내려는 수의 갯수
		st=new StringTokenizer(br.readLine()," ");
		LinkedList<Integer> link=new LinkedList<Integer>();
		for (int i = 1; i <=N; i++) {
			link.add(i);						//순서대로 입력
		}
		int cnt=0;
		int t,idx;
		for (int i = 0; i < M; i++) {
			 t=Integer.parseInt(st.nextToken());	//뽑아내려는 수
			 idx=link.indexOf(t);			//수의 인덱스값
			if(idx<=link.size()/2) {			//찾는수가 가운데보다 앞에있을때
				for (int j = 0; j < idx; j++) {
					int tmp=link.pop();
					link.add(tmp);
					cnt++;
				}
			}
			else {
				for (int j = 0; j < link.size()-idx; j++) {	//찾는수가 가운데보다 뒤에있을때
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
