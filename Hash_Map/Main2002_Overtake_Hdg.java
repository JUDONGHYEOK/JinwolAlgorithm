import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main2002 {
	static int k = 1;

	public static String findkey(Map<String, Integer> map, int value) {
		for (String s : map.keySet()) {
			if (value == map.get(s)) {
				return s;
			}
		}
		return null;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		HashMap<String, Integer> daegun = new HashMap<String, Integer>();
		for (int i = 1; i <= n; i++) {
			daegun.put(br.readLine(), i);
		}

		HashMap<String, Integer> youngsik = new HashMap<String, Integer>();
		for (int i = 1; i <= n; i++) {
			youngsik.put(br.readLine(), i);
		}

		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			String tkey = findkey(youngsik, i);
			if (daegun.containsValue(k)) {
				if (findkey(daegun, k).equals(tkey)) {
					k++;
				} 
				else {
					cnt++;
					daegun.remove(tkey);
					}
			} 
			
			else {
				k++;
				i--;
			}

		}
		System.out.println(cnt);

	}
}
