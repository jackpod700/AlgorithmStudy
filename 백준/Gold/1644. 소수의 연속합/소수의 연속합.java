import java.io.*;
public class Main {
	static int[] primes;
	static int N,size,SIZE=283147;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		getPrimes();
		int s=0,e=0,count=0,sum=primes[0];
		while(e<size) {
			if(sum>N) {
				sum-=primes[s++];
				continue;
			}
			if(sum==N) count++;	
			sum+=primes[++e];
		}
		System.out.println(count);
	}
	 static void getPrimes() {
		int prev, i, j;
		boolean[] notPrime;
		
		primes = new int[SIZE];
		primes[0] = 2;
		prev = 2;
		size = 1;
		notPrime = new boolean[N + 1];
		for (i = 3; i <= N; i += 2) {
			if (notPrime[i]) {
				continue;
			}
			if (prev + i > N) {
				if ((N & 1) == 1 && !notPrime[N]) {
					primes[size++] = N;
				}
				break;
			}
			primes[size++] = prev = i;
			for (j = i << 1; j <= N; j += i) {
				notPrime[j] = true;
			}
		}
	}
}
