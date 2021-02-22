import java.io.*;
import java.util.*;

class data { // 프린터 안에 있는 문서
	int index; // 인덱스
	int importace; // 중요도

	public data(int index, int importance) {
		this.index = index;
		this.importace = importance;
	}
}

public class Main1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine()); // 테스트 케이스 
		Queue<data> printer = new LinkedList<data>();

		while (t-- > 0) { // 테스트 케이스
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 문서 개수
			int m = Integer.parseInt(st.nextToken()); // 몇번째 문서

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				printer.offer(new data(i, Integer.parseInt(st.nextToken()))); // 프린터에 데이터들 담기
			}
			int cnt = 1; // 몇번째에 출력되는지 


			while (!printer.isEmpty()) {
				data first = printer.poll(); // 프린터에 저장된 첫번째  데이터
				boolean check = true; // 첫번째 데이터가 우선순위가 가장 높은지 체크할 변수

				Iterator itr = printer.iterator(); // 큐에 저장된 데이터를 참조하기 위한 iterator
				while (itr.hasNext()) {
					data back = (data) itr.next(); // 아까 뽑은 첫번째 데이터 이외의 뒤에 있는 데이터들
					if (first.importace < back.importace) { // 뽑아놓은 데이터보다 우선순위가 높은 데이터가 있을때
						check = false; // 체크할 변수 false로 바꿈
						break; // 하나라도 발견시 탈출
					}
				}


				if (!check) // 가장 높은 우선순위가 아니였다면 프린터 뒤에 다시 저장
					printer.offer(first);

				else { // 가장 높은 우선순위라면
					if (first.index == m) {// 알고싶은 인덱스인 데이터일때만 출력
						sb.append(cnt).append("\n");
						break;
					}
					else
						cnt++;
				}
			}
			
			if(!printer.isEmpty())
				printer.clear();
			
		}
		System.out.println(sb);

	}
}
