import java.awt.Point;
import java.awt.geom.Line2D;
import java.math.BigInteger;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastScanner in = new FastScanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		long var=System.currentTimeMillis();
		solver.solve(1, in, out);
	
		out.close();
	}
}
class Pair {
	int x,y,index;
	Pair(int x,int y,int index){
		this.x=x;
		this.y=y;
		this.index=index;
	}
	
}
class Edge{
	int u;
	int v;
	int time;
	public Edge(int u,int v){
		this.u=u;
		this.v=v;
		time=Integer.MAX_VALUE;
	}
	public int other(int x){
		if(u==x)return v;
		return u;
	}
}
class TaskC {
	static long mod=1000000007;

		public void solve(int testNumber, FastScanner in, PrintWriter out) throws IOException {
				int t=in.nextInt();
				for(int ii=0;ii<t;ii++){
					int a0=in.nextInt();
					int a1=in.nextInt();
					int c=in.nextInt();
					int n=in.nextInt();
					int a[]=new int[Math.max(n,2)];
						a[0]=a0;
						a[1]=a1;
						long mod=0;
					for(int i=0;i<n;i++){
						if(i>=2)
						a[i]=( a[i - 1]*c + a[i - 2] )%10;
						mod=(mod*10+a[i])%41;
					}
					if(mod==0){
						out.println("YES");
					}
					else
						out.println("NO");
					
					
				}
		}
		long pow(long x,long y,long mod){
			if(y<=0){
				return 1;
			}
			if(y==1){
				return x%mod;
			}
			long temp=pow(x,y/2,mod);
			if(y%2==0){
				return (temp*temp)%mod;
			}
			else{
				return (((temp*temp)%mod)*x)%mod;
			}
		}
		

		    static long greatestCommonDivisor (long m, long n){
		        	long x;
		        	long y;
		        	while(m%n != 0){
		        		x = n;
		        		y = m%n;
		        		m = x;
		        		n = y;
		        	}
		        	return n;
		        }
		    	int no_of_primes(int m,int n){
		    		int count=0,i,j;
		    		int primes []=new int[n-m+2];
		    		   if(m==1)    primes[0] = 1;
		    	        for(i=2; i<=Math.sqrt(n); i++)
		    	        {
		    	            j = m/i;    j *= i;
		    	            if(j<m)
		    	                j+=i;
		    	            for(; j<=n; j+=i)
		    	             {
		    	                 if(j!=i)
		    	                    primes[j-m] = 1;
		    	             }
		    	        }
 
		    	for(i=0; i<=n-m; i++)
		    	            if(primes[i]==0)
		    	                count++;
		    	return count;
		    	}
}
class SegTree {
	int n;
	long t[];
	SegTree(int n,long t[]){
		this.n=n;
		this.t=t;
		
	}
	
	void build() {  
 		
 		for (int i = n - 1; i > 0; --i)
 			t[i]=t[i<<1]+t[i<<1|1];
 	}
 
 	 void modify(int p, long value) {  
 	  for (t[p += n] = value; p > 1; p >>= 1) t[p>>1] = t[p] + t[p^1];
 	}
 
 	 long query(int l, int r) {  
 	  long res=0;
 			  
 	  for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
 		    if ((l&1)!=0) res=res+t[l++];
 		    if ((r&1)!=0) res=res+t[--r];
 		  }
 	  return res;
 	}
 
	
}
class FastScanner
{
 
	private InputStream stream;
	private byte[] buf = new byte[8192];
	private int curChar;
	private int snumChars;
	private SpaceCharFilter filter;
 
	public FastScanner(InputStream stream) {
		this.stream = stream;
	}
	
	public int snext() {
		if (snumChars == -1)
			throw new InputMismatchException();
		if (curChar >= snumChars) {
			curChar = 0;
			try {
				snumChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (snumChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}
	public int nextInt() {
		int c = snext();
		while (isSpaceChar(c))
			c = snext();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = snext();
		}
 
		int res = 0;
 
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = snext();
		} while (!isSpaceChar(c));
 
		return res * sgn;
	}
	
	public long nextLong() {
		int c = snext();
		while (isSpaceChar(c))
			c = snext();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = snext();
		}
 
		long res = 0;
 
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = snext();
		} while (!isSpaceChar(c));
 
		return res * sgn;
	}
	
	public String readString() {
		int c = snext();
		while (isSpaceChar(c))
			c = snext();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = snext();
		} while (!isSpaceChar(c));
		return res.toString();
	}
 
	public boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
 
	public interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}
 class UF {
 
    private int[] parent;  
    private byte[] rank;  
    private int count;     
    public UF(int N) {
        if (N < 0) throw new IllegalArgumentException();
        count = N;
        parent = new int[N];
        rank = new byte[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
 
    public int find(int p) {
        if (p < 0 || p >= parent.length) throw new IndexOutOfBoundsException();
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];    
            p = parent[p];
        }
        return p;
    }
    public int count() {
        return count;
    }
 
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
 
    public boolean union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return false;
 
       
        if      (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
        else if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
        else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
        return true;
    }
 
}
