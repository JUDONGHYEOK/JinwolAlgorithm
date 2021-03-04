
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main1302 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		while (n-- > 0) {
			String key = new String(br.readLine());
			if (!map.containsKey(key))
				map.put(key, 1);
			else
				map.put(key, map.get(key) + 1);
		}
		int max = 0;
		for (String s : map.keySet()) {
			max = Math.max(max, map.get(s));
		}

		ArrayList<String> ar = new ArrayList<String>(map.keySet());
		Collections.sort(ar);
		for (String s : ar) {
			if (map.get(s) == max) {
				System.out.println(s);
				break;
			}
		}
	}
}
