import java.util.Arrays;
import java.util.Scanner;
 
public class OldKeyPadInForeignLand {
 
    public static void main(String args[]) throws Exception {
 
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int l[] = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = s.nextInt();
        }
        int keysizes = s.nextInt();
        int eachKey[] = new int[keysizes];
        for (int i = 0; i < keysizes; i++) {
            eachKey[i] = s.nextInt();
        }
        Arrays.sort(l);
        int total = 0, exit = 0, t = 1;
        int i = l.length - 1;
        while (exit == 0) {
            int count = 0;
            for (int j = 0; j < eachKey.length; j++) {
                if (eachKey[j] != 0) {
                    count++;
                    eachKey[j]--;
                }
            }
            if (count > 0) {
                for (; i >= 0&&count>0;count--,i-- ) {
                    total = total + (l[i] * t);
                }
            } else {
                exit++;
            }
            t++;
        }
        if(i<0) {
            System.out.println(total);
        } else {
            System.out.println("-1");
        }
    }
}
