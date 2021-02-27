package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BaekJoon_17219   {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		HashMap<String, String> map=new HashMap<String, String>();
		for (int i = 0; i < n; i++) {
			st=new StringTokenizer(br.readLine()," ");
			String site=st.nextToken();
			String pw=st.nextToken();
			map.put(site, pw);
		}
		for (int i = 0; i < m; i++) {
			st=new StringTokenizer(br.readLine()," ");
			String t=st.nextToken();
			System.out.println(map.get(t));
		}
		
	}
}
