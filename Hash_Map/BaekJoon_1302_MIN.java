package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class BaekJoon_1302 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		int max=0;
		for (int i = 0; i < n; i++) {
			String str=br.readLine();
			if(map.containsKey(str)) {
				map.put(str, map.get(str)+1);
			}else
				map.put(str, 1);
			if(max<map.get(str)) {
				max=map.get(str);
			}
		}
		LinkedList<String> list=new LinkedList<String>();
		for (String key : map.keySet()) {
			if(map.get(key)==max) {
				list.add(key);
			}
		}
		Collections.sort(list);
		
		System.out.println(list.get(0));
	}

}
