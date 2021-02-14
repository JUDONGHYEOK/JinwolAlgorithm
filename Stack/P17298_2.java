package Stack;

import java.util.Scanner;

public class P17298_2 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int[] ar=new int[n];
		for (int i = 0; i < n; i++) {
			ar[i]=sc.nextInt();
		}
		int max=ar[0];
		for (int i = 0; i < ar.length; i++) {
			if(max<ar[i])
				max=ar[i];
		}
		for (int i = 0; i < ar.length-1; i++) {
			for (int j = i+1; j < ar.length; j++) {
				if(ar[i]<ar[j]) {
					ar[i]=ar[j];
					break;
				}
				
			}
			if(ar[i]==max)
				ar[i]=-1;
		}
		ar[n-1]=-1;
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i]+" ");
		}
		
	}
}
