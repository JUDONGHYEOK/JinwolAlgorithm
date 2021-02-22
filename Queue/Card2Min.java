package Que;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Card2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		Deque<Integer> qu=new LinkedList<Integer>();
		for (int i = 1; i <=n; i++) {
			qu.offer(i);
		}
		while(qu.size()!=1) {
			int num;
			qu.poll();
			num=qu.peek();
			qu.offer(num);
			qu.poll();
		
		}
		System.out.println(qu.peek());
	}

}
