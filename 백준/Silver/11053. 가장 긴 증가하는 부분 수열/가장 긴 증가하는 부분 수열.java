import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] arr; 
	static int[] dp; // arr[n] 보다 작은 arr값들의 개수
	static int maxCnt = 1;
	
	static int dp(int n) {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				
				maxCnt = Math.max(maxCnt, dp[i]);
			}
			
		}
		
		return maxCnt;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1; // 길이가 1일때도 무조건 1이니까 기본값을 1로 설정
		}
		
		System.out.println(dp(n));
	}
	
}
