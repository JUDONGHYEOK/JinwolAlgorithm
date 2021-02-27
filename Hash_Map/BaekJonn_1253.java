package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJonn_1253 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] ar = new int[n];
		int cnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ar);
		for (int i = 2; i < n; i++) {
			
				for (int j = 0; j < i - 1; j++) {
					for (int j2 = j+1; j2 < i; j2++) {
						
						if (ar[i] == ar[j] + ar[j2]) {
							cnt++;
							break;
						}
						
					}
				}
			

		}
		System.out.println(cnt);

	}

}
