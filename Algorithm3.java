//Chained Matrix Multiplication

import java.util.Scanner;

public class Algorithm3 {
	private int [] d;
	private int [][]P;
	static Scanner scan;
	
	public Algorithm3(int n) {
		d = new int[n+1];
		P = new int[n+1][n+1];
		input(n);
	}
	public void input(int n) {
		int k = 2;
		for(int i = 0; i < n; i++) {
			System.out.println((i+1) + "번째 행렬 사이즈 입력>>");
			System.out.println("행렬 사이즈는 숫자 두개로 표현(ex : 5X4 이면, 5 4 로 입력)");
			int sizeM = scan.nextInt();
			int sizeN = scan.nextInt();
			
			if(i == 0) {
				d[0] = sizeM;
				d[1] = sizeN;
			}
			else {
				d[k] = sizeN;
				k++;
			}
		}
	}
	public void order(int i, int j) {
		int k;
		if(i == j) {
			System.out.print("A" + i);
		}
		else {
			k = P[i][j];
			System.out.print("(");
			order(i, k);
			order(k+1, j);
			System.out.print(")");
			
		}
	}
	public int minMult(int n, int []d, int [][]P) {
		int i, j, k, diagonal;
		
		int [][] M = new int [n+1][n+1];
		int temp = 0;
		
		for(i = 1; i <= n; i++) {
			M[i][i] = 0;
		}
		
		for(diagonal = 1; diagonal <= n-1; diagonal++) {
			for(i = 1; i <= (n - diagonal); i++) {
				j = i + diagonal;
				
				for(k = i; k <= j-1; k++) {
					M[i][j] = M[i][k] + M[k+1][j] + d[i-1]*d[k]*d[j];
					if(i == k) {
						temp = M[i][j];
						P[i][j] = k;
					}
					else if(temp < M[i][j]){
						M[i][j] = temp;
					}
					else {
						temp = M[i][j];
						P[i][j] = k;
					}
				}
			}
		}
		return M[1][n];
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		System.out.println("행렬의 개수 입력>>");
		int n = scan.nextInt();
		
		Algorithm3 Al3 = new Algorithm3(n);
		
		int result = Al3.minMult(n, Al3.d, Al3.P);
		
		System.out.println("행렬 곱셈 최적 순서 >>");
		Al3.order(1, n);
		
		System.out.println();
		System.out.println("행렬 곱셈 횟수 : " + result);
		scan.close();

	}

}
