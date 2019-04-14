// The Hamiltonian Circuits Problem

import java.util.Scanner;

public class Algorithm9 {
	private static Scanner scan;
	private int [][] W;
	private int [] Vindex;
	Algorithm9(int n){
		input(n);
	}
	public void input(int n) {
		W = new int [n+1][n+1];
		Vindex = new int [n+1];
		Vindex[0] = 1;
		System.out.println("���� ���� >> ");
		int wCnt = scan.nextInt();
		
		System.out.println("� �������� � �������� ������ ������ 1�� �Է��Ͻÿ�.(vertex1 vertex2 (1 or 0))");
		System.out.println("(ex. 2 3 1 : 2�� �������� 3�� ���� ���̿� ������ �����Ѵ�.)");
		
		for(int i = 1; i <= wCnt; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			int weight = scan.nextInt();
			W[x][y] = weight;
			W[y][x] = weight;
		}
		
		hamiltonian(0, n, Vindex, W);
	}
	public void hamiltonian(int k, int n, int [] Vindex, int [][] W) {
		int j;
	
		if(promising(k, n, Vindex, W)) {
			if(k == n-1) {
				for(int i = 0; i <= n-1; i++) {
					System.out.print(Vindex[i] + " ");
				}
				System.out.println();
			}		
			else {
				for(j = 2; j <= n; j++) {
					Vindex[k+1] = j;
					hamiltonian(k+1, n, Vindex, W);
				}
			}
		}	
	}
	public boolean promising(int k, int n, int [] Vindex, int [][] W) {
		int j;
		boolean Switch;
		
		if(k == n-1 && W[Vindex[n-1]][Vindex[0]] != 1)
			Switch = false;
		else if(k>0 && W[Vindex[k-1]][Vindex[k]] != 1)
			Switch = false;
		else {
			Switch = true;
			j = 1;
			while(j < k && Switch) {
				if(Vindex[k] == Vindex[j])
					Switch = false;
				j++;
			}
		}
		return Switch;
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		System.out.println("n >> ");
		int n = scan.nextInt();
		Algorithm9 Al9 = new Algorithm9(n);

		scan.close();
	}
}
