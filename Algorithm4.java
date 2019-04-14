// Optimal Binary Search Trees
import java.util.Scanner;
import java.math.BigDecimal;

public class Algorithm4 {
	static Scanner scan;
	public float[] P;
	public int [][] R;
	
	public Algorithm4(int n){
		P = new float[n+1];
		input(n);
	}
	public void input(int n) {
		System.out.println("각 키가 탐색될 확률 입력>>");
		for(int i = 1; i <= n; i++) {
			P[i] = scan.nextFloat();
		}
	}
	

	public float optSearchTree(int n, float []P) {
		R = new int[n+2][n+1];
		float [][] A = new float[n+2][n+1];
		
		int j;
		float sum = 0;
		int res = 0;
		float min = 0;
		float temp = 0;
		
		for(int i = 1; i <= n; i++) {
			A[i][i-1] = 0;
			A[i][i] = P[i];
			R[i][i] = i;
			R[i][i-1] = 0;
		}
		A[n+1][n] = 0; 
		R[n+1][n] = 0;
		
		for(int diagonal = 1; diagonal <= n-1; diagonal++) {
			for(int i = 1; i <= n-diagonal; i++) {
				j = i + diagonal;
				BigDecimal bd1 = new BigDecimal(String.valueOf(P[i]));
				for (int b = i+1; b <= j; b++) {
					bd1 = bd1.add(new BigDecimal(String.valueOf(P[b])));
				}
				sum = bd1.floatValue();
				min = A[i][i-1] + A[i+1][j];
				res = i;
				for(int k = i; k <= j; k++) {
					temp = A[i][k-1] + A[k+1][j];
					if(temp < min) {
						min = temp;
						res = k;
					}
					
				}
				A[i][j] = min + sum;
				R[i][j] = res;
				sum = 0;
				
			}
		}
		return A[1][n];
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		System.out.println("키의 개수 입력>>");
		int n = scan.nextInt();
		
		Algorithm4 Al4 = new Algorithm4(n);
		
		float result = Al4.optSearchTree(n, Al4.P);
		
		System.out.println("최소 평균 >> " + result);
		scan.close();
	}

}
