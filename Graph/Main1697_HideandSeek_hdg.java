import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1697 {
	static int[] graph = new int[100001];
	static int k;
	static int[] move = {-1, 1, 2};

	static void bfs(int x) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(x);
		graph[x] = 1;
		while (!que.isEmpty()) {
			int y = que.poll();
			for (int i = 0; i < move.length; i++) {
				int ny;
				if (i != 2)
					ny = y + move[i];
				else
					ny = y * move[i];

				if (ny >= 0 && ny <= 100000) {
					if (graph[ny] == 0) {
						que.offer(ny);
						graph[ny] = graph[y] + 1;
					}
				}

				if (ny == k) {
					System.out.println(graph[ny] - 1);
					return;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		bfs(n);

	}
}
