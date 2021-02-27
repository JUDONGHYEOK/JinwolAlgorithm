package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;
import java.util.StringTokenizer;


public class BaekJoon_7785 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		Set<String> set=new HashSet<String>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			String name=st.nextToken();
			String inout=st.nextToken();
			if(inout.equals("enter")) {
				set.add(name);
			}
			else
				set.remove(name);
		}
		
		LinkedList<String> list=new LinkedList<String>(set);
		Collections.sort(list);
		
		ListIterator<String> iter = list.listIterator(list.size()); 
		
		while (iter.hasPrevious()) {
            System.out.println(iter.previous());
        }
	}

}
