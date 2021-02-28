import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main9375 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		HashMap<String, Integer> clothes = new HashMap<String, Integer>();

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			while (n-- > 0) { // 해시맵 입력받기
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String key = st.nextToken();

				if (!clothes.containsKey(key))
					clothes.put(key, 1);
				else
					clothes.put(key, clothes.get(key) + 1);
			}
			int sum = 1;

			for (String s : clothes.keySet()) {
				sum *= clothes.get(s) + 1;
			}
			System.out.println(--sum);
			clothes.clear();
		}

	}
}
