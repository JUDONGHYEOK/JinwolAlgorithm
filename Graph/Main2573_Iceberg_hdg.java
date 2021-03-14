import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Position {
	int x;
	int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main2573 {
	static int n, m;
	static int[][] graph; // 그래프
	static boolean[][] visited; // 한 타임 녹을때 방문처리할 배열
	static boolean[][] visited2; // 빙하가 연결되었을때 방문처리할 배열
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int count; // 동서남북 0이 몇개인지
	static int startx;
	static int starty;

	static void time() {
		Queue<Position> q = new LinkedList<Position>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] != 0) {
					q.offer(new Position(i, j));
					visited[i][j] = true;
				}
			}
		}
		while (!q.isEmpty()) {
			Position p = q.poll();
			count = 0;
			for (int i = 0; i < dx.length; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (graph[nx][ny] == 0 && !visited[nx][ny])
						count++;
				}
			}
			if (graph[p.x][p.y] < count)
				graph[p.x][p.y] = 0;
			else
				graph[p.x][p.y] -= count;
		}

	}

//	static boolean dfs(int x, int y) { //dfs로 특정 노드를 방문하고 연결된 모든 노드들도 방문
//		if (x <= -1 || x >= m || y <= -1 || y >= n) // 주어진 범위를 벗어나는 경우
//			return false;
//		if (graph[x][y] != 0 && !visited2[x][y]) { // 노드가 0이 아니고 방문하지 않았을때
//			visited2[x][y]=true; // 방문 처리
//			dfs(x - 1, y); //상
//			dfs(x + 1, y);//하
//			dfs(x, y - 1); // 좌
//			dfs(x, y + 1);//우
//			return true;
//		}
//		return false;
//	}
	
	static void bfs(int x, int y) {
		Queue<Position> que = new LinkedList<Position>();
		que.offer(new Position(x, y));
		visited2[x][y]=true;
			while(!que.isEmpty()) {
			Position p = que.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx= p.x+dx[i];
				int ny =p.y+dy[i];
				if(nx>0 && nx<n-1 && ny>0 && ny<m-1) {
					if(!visited2[nx][ny] && graph[nx][ny]!=0) {
						que.offer(new Position(nx, ny));
						visited2[nx][ny]=true;
					}
				}
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 행 개수
		m = Integer.parseInt(st.nextToken()); // 열 개수
		graph = new int[n][m];
		visited = new boolean[n][m];
		visited2 = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken()); // 그래프 입력받기
			}
		}

		int check = 0; // 최초의 시간
		int cnt; // 0이 아닌 개수 체크

		while (true) {
			cnt = 0;
			time(); // 한 타임 지나감
			check++;
						
			int find = 0; // startx, starty 구하고 그래프 다 0인지 확인하기위해
			for (int i = 1; i < n - 1; i++) {
				for (int j = 1; j < m - 1; j++) {
					if (find == 0 && graph[i][j] != 0) {
						startx = i;
						starty = j;
						find++;
						break;
					}
				}
			}
			if (find == 0)
				break;

//			for (int i = 1; i < n-1; i++) {
//				for (int j = 1; j < m-1; j++) {
//					if (dfs(i, j))
//						cnt ++;
//				}
//			}
			
			
			for (int i = 1; i < n-1; i++) {
				for (int j = 1; j < m-1; j++) {
					if(graph[i][j] != 0 && !visited2[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			
			if (cnt >= 2 )
				break;

			// 한 바퀴 돌면 해야할 것들
			for (int i = 0; i < visited.length; i++) {
				Arrays.fill(visited[i], false);
				Arrays.fill(visited2[i], false);
			}
		}

		if (cnt != 0)
			System.out.println(check);
		else
			System.out.println(0);

	}
}
