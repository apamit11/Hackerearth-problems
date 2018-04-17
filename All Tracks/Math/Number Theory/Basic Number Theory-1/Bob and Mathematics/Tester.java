import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
public class Tester 
{
 
	private static long mod = (long) 1e9+7;
	private static long nCr[][] = new long[1002][1002];
	private static boolean primeSieve[] = new boolean[1000001]; 
	public static void main(String[] args) throws IOException 
	{
	
		int primes = 0;
		int arr[];
		InputReader reader = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		sieve();
		nCr_func();
		int t = reader.nextInt();
		while(t-->0)
		{
			primes = 0;
			int n = reader.nextInt();
			arr = new int[n];
			for(int i=0;i<n;i++)
			{
				arr[i] = reader.nextInt();
				if(primeSieve[arr[i]])
					primes++;
			}
			
			
			long mul = modularPower(2,n-primes,mod-1);
			long ans = 1;
			
			for(int i=0;i<=primes;i++)
			{
				ans *= (modularPower(i+2,(nCr[primes][i]*mul)% (mod-1),mod)) %mod;
				ans%=mod;
			}
			out.println(ans);
		}
		out.close();
	}
	
	public static void nCr_func()
	{
		nCr[0][0] = 1;
		for(int i=1;i<=1000;i++)
		{
			nCr[i][0] = 1;
			for(int j=1;j<=i;j++)
				nCr[i][j] = (nCr[i-1][j-1]+nCr[i-1][j]) % (mod-1);
		}
	}
	
	public static void sieve()
	{
		for(int i=0;i<1000001;i++)
			primeSieve[i] = true;
		primeSieve[1] = false;
		for(int i=2;i*i<=1000000;i++)
		{
			if(primeSieve[i])
			{
				for(int j=i*i;j<=1000000;j+=i)
					primeSieve[j] = false;
			}
		}
	}
	
	public static long modularPower(long x,long y,long mod)
	{
		long result = 1;
		if(y == 0) return 1;
		while(y>0)
		{
			if(y%2==1)
				result = (result*x) % mod;
			
			y = y/2;
			x = (x*x) % mod;
		}
		return result;
	}
}
class InputReader {
	 
	private InputStream stream;
	private byte[] buf = new byte[8192];
	private int curChar;
	private int snumChars;
	private SpaceCharFilter filter;
 
	public InputReader(InputStream stream) {
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
