import java.io.*;
import java.util.*;
import java.util.Stack;
class Top{ //Top 클래스 
	int num; // Top 의 번호(인덱스)
	int height; // Top 의 높이
	
	public Top(int num, int height) { // Top 생성자
		this.num=num;
		this.height = height;
	}
}
public class Main2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Stack<Top> stk = new Stack<Top>(); //Top 클래스를 타입으로 한 Stack 생성
		StringBuilder sb = new StringBuilder(); // 출력하기 위한 문자열 (String과 다르게 변환 가능)
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = 1; // 탑번호
		while (st.hasMoreTokens()) { // 더이상 입력할 탑이 없을때까지
			int height = Integer.parseInt(st.nextToken()); // 스택에 차례대로 넣을 탑의 높이(비교 기준)
			
			if (stk.isEmpty()) { // 처음 스택이 비어있을 때
				stk.push(new Top(num, height)); //첫번째 탑 객체 push
				sb.append(0).append(" ");// 첫번째 탑보다 왼쪽에 있는 탑은 없으므로 0출력
			} else { // 스택이 비어있지 않을때 (두번째 탑부터 해당)
				while (true) { 
					Top peektop = stk.peek(); //스택에 저장한 탑 peek
					if (peektop.height > height) { // 자기보다 왼쪽에 높은 탑이 있을때
						sb.append(peektop.num).append(" "); // 자기보다 가장 왼쪽에 가까운 탑 번호 출력
						stk.push(new Top(num,height)); // 비교기준 탑 push
						break;
					} else // 자기보다 왼쪽에 높은 탑이 없을때 
						stk.pop(); //  자기보다 왼쪽에 있는 탑들 중에 높지않은 탑들을 차례대로 pop
					
					if (stk.isEmpty()) { // 왼쪽에 높은 탑이 하나도 없어 모두 pop 해 stack이 빈경우 
						sb.append(0).append(" "); // 0출력
						stk.push(new Top(num, height)); // 비교기준 탑 push 
						break;
					}
				}
			}
			num++; // 탑 번호 1,2,3,4... 차례대로 부여하기 위해 맨위의 while 문이 한 번 실행될때마다 증가
		}
		System.out.println(sb); // 출력하기 위한 문자열 출력
	}
}
