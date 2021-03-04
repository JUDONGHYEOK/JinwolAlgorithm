import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main17219 {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	HashMap<String, String> map = new HashMap<String, String>();
	while(n-- >0) {
		st= new StringTokenizer(br.readLine());
		map.put(st.nextToken(), st.nextToken());
	}
	while(m-- >0) {
		String key = br.readLine();
		System.out.println(map.get(key));
	}
}
}
