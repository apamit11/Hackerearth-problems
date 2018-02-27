import java.util.*;
import java.io.*;
 
class TestClass {
    public static void main(String args[] ) throws Exception 
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a[] = new int[N];
        int b[] = new int[N];
        int c[] = new int[N];
        int x,y,ans=0;
        for(int i=0;i<N;i++)
        {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();

            if(((b[i]*b[i])-(4*a[i]*c[i])) >=0)
                ans++;
        }
        System.out.println(ans);
    }
}
