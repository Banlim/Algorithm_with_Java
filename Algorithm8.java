// Graph Coloring

import java.util.Scanner;

public class Algorithm8 {
	static Scanner scan;
	private int mCnt;
	
	public Algorithm8(int n) {
		input(n);
	}
	public void input(int n) {
		int [][] W = new int[n+1][n+1];
		int [] vColor = new int [n+1];
		System.out.println("m(��) ���� >> ");
		mCnt = scan.nextInt();
		System.out.println("w(����) ���� >> ");
		int wCnt = scan.nextInt();
		
		System.out.println("� �������� � �������� ������ ������ 1�� �Է��Ͻÿ�.(vertex1 vertex2 (1 or 0))");
		System.out.println("(ex. 2 3 1 : 2�� �������� 3�� ���� ���̿� ������ �����Ѵ�.)");
		for(int i = 1; i <= wCnt; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			int TF = scan.nextInt();
			W[x][y] = TF;
			W[y][x] = TF;
		}
		m_coloring(0, vColor, W, n);
	}
	public void m_coloring(int k, int[] vColor, int [][] W, int n) {
		int color;
		if(promising(k, vColor, W)) {
			if(k == n) {
				for(int i = 1; i <= n; i++) {
					System.out.print(vColor[i] + " ");
				}
				System.out.println();
			}
			else {
				for(color = 1; color <= mCnt; color++) {
					vColor[k+1] = color;
					m_coloring(k+1, vColor, W, n);
				}
			}
		}
	}
		
	public boolean promising(int k, int [] vColor, int [][]W) {
		int j;
		boolean Switch = true;
		j = 1;
		
		while (j<k && Switch) {
			if(W[k][j] == 1 && (vColor[k] == vColor[j]))
				Switch = false;
			j++;
		}
		return Switch;
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		System.out.println("v ���� >> ");
		int vCnt = scan.nextInt();
		Algorithm8 Al8 = new Algorithm8(vCnt);
		
		scan.close();
	}
}