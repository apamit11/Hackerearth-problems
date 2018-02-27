//Sherlock Holmes And The Temple Mystery
import java.util.*;
import java.io.*;
 
public class Sharlok {
	
public static void main(String args[])throws Exception{
		
		Scanner sc=new Scanner(System.in);
		int t =sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			sc.nextLine();
			String s = sc.nextLine();
			String ss[] = s.split(" ");
			int arr[]=new int[n];
			long sum=0;
			for(int i=0;i<n;i++){
				arr[i] = Integer.parseInt(ss[i]);
				sum+=arr[i];
			}
			if(sum%2!=0){
				System.out.println("NO");
				t--;
				continue;
			}
			int brr[][]=new int[n+1][(int)sum/2+1];
			for(int i=1;i<=n;i++)
			brr[i][0]=1;
			for(int i=1;i<=n;i++){
				for(int j=0;j<=sum/2;j++){
					if(j<arr[i-1]){
						if(brr[i-1][j]==1)
						brr[i][j]=1;
					}
					else{
						if(brr[i-1][j]==1||brr[i-1][j-arr[i-1]]==1)brr[i][j]=1;
					}					
				}
			}
			if(brr[n-1][(int)sum/2]==1)
			System.out.println("YES");
			else 
			System.out.println("NO");
		}
	}
}
