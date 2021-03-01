package Hash;
//FashinKing 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BaekJoon_9375 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());		//케이스 수
		while(t-->0) {
			HashMap<String, Integer> map=new HashMap<String, Integer>();
			int n=Integer.parseInt(br.readLine());		//의상 수 
			
			//종류별 의상 숫자 +1 해서 * 하고 -1 해주면 총 가짓수
			while(n-->0) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			st.nextToken();
			String Cloth=st.nextToken();
			if(map.containsKey(Cloth)) {
				map.put(Cloth, map.get(Cloth)+1);
			}
			else
				map.put(Cloth, 1);
			}
			int result=1;
			for (int k :map.values()) {
				result*=(k+1);
			}
			System.out.println(result-1);
		}
		
		
	
		
	}
	
	

}
