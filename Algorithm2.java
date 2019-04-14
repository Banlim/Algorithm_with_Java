//Floyd's Algorithm;

import java.util.Scanner;
public class Algorithm2 {
	
	private int[][] P;
	private int[][] W;
	private int[][] D;
	
	static Scanner scan;
	
	public Algorithm2(int n) {
		P = new int[n][n];
		W = new int[n][n];
		D = new int[n][n];
		input(n);
	}
	public int[][] getP(){
		return P;
	}
	public int[][] getD(){
		return D;
	}
	public int[][] getW(){
		return W;
	}
	
	public void path(int q, int r) {
		if(P[q][r] != 0) {
			path(q,P[q][r]-1);
			System.out.print("v" + (P[q][r]) + " ");
			path(P[q][r]-1, r);
		}
		
	}
	public void floyd2(int n, int [][]W, int [][]P, int [][]D) {
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if((D[i][k] + D[k][j] < D[i][j]) || D[i][j] == -1) {
						
						if(D[i][k] < 0 || D[k][j] < 0) {
							continue;
						}
						
						P[i][j] = k+1;
						D[i][j] = D[i][k] + D[k][j];
						
						}
				}
			}
		}
	
	}
	public void input(int n) {
		System.out.println("���� �� ����ġ �Է� >>");
		System.out.println("�������� ���� ��� -1 �Է� >>");
		
		for(int i=0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == j) {
					W[i][j] = 0;
					P[i][j] = 0;
					continue;
				}
				System.out.println("���� (" + (i+1) + ", " + (j+1) + ") : ");
				W[i][j] = scan.nextInt();
				P[i][j] = 0;
			}
			
			D=W;
		}
	
		
	}
	
	
	public static void main(String[] args) {
			
		scan = new Scanner(System.in);
		
		System.out.println("������ ���� >>");
		int n = scan.nextInt();
		
		Algorithm2 Al2 = new Algorithm2(n);
		
		
		Al2.floyd2(n, Al2.getW(), Al2.getP(), Al2.getD());
		
		System.out.println("������� ������ �Է�>>");
		int start = scan.nextInt();
		int end = scan.nextInt();
		
		System.out.print("v" + start + " ");
		Al2.path(start-1, end-1);
		System.out.print("v" + end);
	
		scan.close();

	}

}
