import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main7785 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();

		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String exist = st.nextToken();

			if ("enter".equals(exist))
				map.put(name, true);
			else
				map.put(name, false);
		}
		TreeMap<String, Boolean> sortmap = new TreeMap<String, Boolean>(map);
		Iterator<String> itr = sortmap.descendingKeySet().iterator();

		while (itr.hasNext()) {
			String key = itr.next();
			if (map.get(key))
				System.out.println(key);
		}

	}
}
