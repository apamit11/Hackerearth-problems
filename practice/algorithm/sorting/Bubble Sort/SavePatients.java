    import java.util.*;
     
     
    class SavePatients {
        public static void main(String args[] ) throws Exception {
           
     
            //Scanner
            Scanner s = new Scanner(System.in);
            int N = s.nextInt();
            int need[]=new int[N];
            int med[]=new int[N];
            for (int i = 0; i < N; i++) {
                med[i]=s.nextInt();
            }
            
            for(int i=0;i<N;i++){
                need[i]=s.nextInt();
            }
            Arrays.sort(med);
            Arrays.sort(need);
            boolean status=true;
            for(int i=0;i<N;i++){
                if(med[i]>=need[i]){
                    status=true;
                }else{
                    status=false;
                    break;
                }
            }
            if(status){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
