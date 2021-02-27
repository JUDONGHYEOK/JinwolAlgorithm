package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BaekJoon_2002 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] ar=new int[n];
		int cnt=0;
		HashMap<String, Integer> car=new HashMap<String, Integer>();
		for (int i = 0; i < n; i++) {
			String str=br.readLine();
			car.put(str, i);
		}
		for (int i = 0; i < n; i++) {
			String str=br.readLine();
			ar[i]=car.get(str);
		}
		for (int i = 0; i < n+1; i++) {
			for (int j = i+1; j < n; j++) {
				if(ar[i]>ar[j]) {
					cnt++;
					break;
				}
			}
		}
		
		System.out.println(cnt);
		
	}

}
