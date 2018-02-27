import java.io.*;
import java.util.Arrays;
 
 
class DivideApple {
    public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        String[] s = br.readLine().split(" ");
        long[] a = new long[n];
        long sum=0;
        for(int i=0; i<n; i++)
        {
            a[i]=Long.parseLong(s[i]);
            sum+=a[i];
        }
        long avg=sum/n;
        long[] b=new long[n];
        for(int i=0; i<n-1; i++){
            b[i+1]=b[i]+a[i]-avg;
            }
            Arrays.sort(b);
            long m=-b[n/2];
            long val=0;
            for(int i=0; i<n; i++){
              val+=Math.abs(b[i]+m);  
            }
            System.out.println(val);
    }
}
