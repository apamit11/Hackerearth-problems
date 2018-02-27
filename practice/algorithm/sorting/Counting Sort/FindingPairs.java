import java.util.*;
 
class FindingPairs {
    public static void main(String args[] ) throws Exception {
 
        //Scanner
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        
        for (int t = 0; t < T; ++t)
        {
            int N = s.nextInt();
            int[] array = new int[2000002];
            long result = 0;
            
            for (int n = 0; n < N; ++n)
            {
                int number = s.nextInt();
                if (number < 0)
                {
                    number = -1 * number + 1000000;
                }
                
                array[number]++;
                result += array[number];
            }
            
            System.out.println(result);
        }
    }
}
