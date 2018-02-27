import java.io.*;
import java.util.*;


public class Decode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String s = br.readLine();

            String out_ = decode(s);
            System.out.println(out_);
         }

         wr.close();
         br.close();
    }
    static String decode(String s){
        int i;
        int l=s.length();
        String str="";
        for(i=l-2;i>=0;i=i-2)
        {
            str=str+s.charAt(i);
        }
        if(l%2==0)
        {
            for(i=1;i<l;i=i+2)
            str=str+s.charAt(i);
        }
        else
        {
            for(i=0;i<l;i=i+2)
            str=str+s.charAt(i);
        }
        return str;
    }
}
