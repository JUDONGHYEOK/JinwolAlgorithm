import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Queue<Integer> que = new LinkedList<Integer>();
		for (int i = 1; i <= num; i++) {
			que.offer(i);
		}
		
		for (int i = 1; i <= num; i++) {
			if(que.size()==1)
				System.out.println(que.poll());
			else {
			que.poll();
			que.offer(que.poll());
			}
		}
	}
}
