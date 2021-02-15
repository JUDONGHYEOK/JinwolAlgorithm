package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
//오큰수
public class P17298 {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());		//총 수
		int[] ar=new int[n];									//배열 선언
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for (int i = 0; i <n; i++) {
			ar[i]=Integer.parseInt(st.nextToken());	//배열에 수 입력
		}
		Stack<Integer> stk=new Stack<Integer>();	
		for (int i = 0; i < n; i++) {
			
			/*스택이 비어있지 않고 스택 픽 값이 다음 값보다 작을때
			 * 그 값을 다음값으로 변경하고 스택에 인덱스값 PUSH
			 */
			while(!stk.isEmpty()&&ar[stk.peek()]<ar[i]) {
				ar[stk.pop()]=ar[i];
			}
			stk.push(i);
		}
		while(!stk.isEmpty()) {
			ar[stk.pop()]=-1;		//스택에 들어있는 값은 -1로 변경
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(ar[i]).append(' ');
		}
		
		System.out.println(sb);
		
	}
}
