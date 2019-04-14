// Strassen's Algorithm

import java.util.Scanner;

public class Algorithm1 {
	
	public int [][] add(int [][]A, int [][]B){
		int n = A.length;
		int R[][] = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				R[i][j] = A[i][j] + B[i][j];
			}
		}
		return R;
	}
	
	public int [][] sub(int [][]A, int [][]B){
		int n = A.length;
		int [][] R = new int [n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				R[i][j] = A[i][j] - B[i][j];
			}
		}
		
		return R;
	}
	
	public int[][] partition(int [][]A, int [][]APart, int k){
		int n = APart.length;
		
		switch(k) {
		case 1:
			for(int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					APart[i][j] = A[i][j];
				}
			}
			break;
		case 2:
			for(int i = 0; i < n; i++) {
				for(int j = 0, j2 = n; j < n; j++, j2++) {
					APart[i][j] = A[i][j2];
				}
			}
			break;
		case 3:
			for(int i = 0, i2 = n; i < n; i++, i2++) {
				for(int j = 0; j < n; j++) {
					APart[i][j] = A[i2][j];
				}
			}
			break;
		case 4:
			for(int i = 0, i2 = n; i < n; i++, i2++) {
				for(int j = 0, j2 = n; j < n; j++, j2++) {
					APart[i][j] = A[i2][j2];
				}
			}
			break;
		}
		
		
		return APart;
	}
	
	public void combine(int [][]C, int[][] C11, int[][] C12, int[][] C21, int[][] C22){
		int n = C.length;
		
		for(int i = 0, i2 = n/2; i < n/2; i++, i2++) {
			for(int j = 0, j2 = n/2; j < n/2; j++, j2++) {
				C[i][j] = C11[i][j];
				C[i][j2] = C12[i][j];
				C[i2][j] = C21[i][j];
				C[i2][j2] = C22[i][j];
			}
		}
	}
	
	
	public int [][] mult(int [][]A, int [][]B){
		int n = A.length;
		int [][]C = new int [n][n];
		
		if(n == 1) {
			C[0][0] = A[0][0]*B[0][0];
		}
		
		else {	
			int [][]A11 = new int [n/2][n/2];
			int [][]A12 = new int [n/2][n/2];
			int [][]A21 = new int [n/2][n/2];
			int [][]A22 = new int [n/2][n/2];
		
			int [][]B11 = new int [n/2][n/2];
			int [][]B12 = new int [n/2][n/2];
			int [][]B21 = new int [n/2][n/2];
			int [][]B22 = new int [n/2][n/2];
		
			A11 = partition(A, A11, 1);
			A12 = partition(A, A12, 2);
			A21 = partition(A, A21, 3);
			A22 = partition(A, A22, 4);
			
			B11 = partition(B, B11, 1);
			B12 = partition(B, B12, 2);
			B21 = partition(B, B21, 3);
			B22 = partition(B, B22, 4);
		
			int [][] M1 = mult(add(A11, A22),add(B11,B22));
			int [][] M2 = mult(add(A21, A22),B11);
			int [][] M3 = mult(A11,sub(B12,B22));
			int [][] M4 = mult(A22,sub(B21,B11));
			int [][] M5 = mult(add(A11, A12), B22);
			int [][] M6 = mult(sub(A21, A11), add(B11, B12));
			int [][] M7 = mult(sub(A12, A22), add(B21, B22));
			
			int [][]C11 = add(sub(add(M1, M4), M5), M7);
			int [][]C12 = add(M3, M5);
			int [][]C21 = add(M2, M4);
			int	[][]C22 = add(sub(add(M1, M3), M2), M6);
			
			combine(C, C11, C12, C21, C22);
		}
		
		return C;
	}


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int [][] A;
		int [][] B;
		int [][] C;
		
		Algorithm1 al = new Algorithm1();
		
		System.out.println("행렬 size 입력>> ");
		int n = scan.nextInt();
		A = new int [n][n];
		B = new int [n][n];
		C = new int [n][n];
		
		System.out.println("행렬 A 입력>>");
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				A[i][j] = scan.nextInt();
			}
		}
		
		System.out.println("행렬 B 입력>> ");
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				B[i][j] = scan.nextInt();
			}
		}
		
		C = al.mult(A, B);
		
		System.out.println("Answer>> ");
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}
		scan.close();

	}

}
