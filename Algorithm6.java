// Dijkstra's Algorithm for Single-Source Paths

import java.util.Scanner;
class Weight{
	private int startVertex;
	private int endVertex;
	private int weight;
	
	public Weight(int startVertex, int endVertex, int weight){
		this.startVertex = startVertex;
		this.endVertex = endVertex;
		this.weight = weight;
	}
	public int getWeight() {
		return weight;
	}
	public int getStartVertex() {
		return startVertex;
	}
	public int getEndVertex() {
		return endVertex;
	}
}

public class Algorithm6 {
	static Scanner scan;
	private int [][] W;
	int [] F;
	static Weight [] edge;
	static int MAX = 100000;
	
	Algorithm6(int n){
		input(n);
	}
	
	private void input(int n) {
		W = new int[n+1][n+1];
		F = new int[n+1];
		System.out.println("edge의 개수를 입력하시오>>");
		int edgeCnt = scan.nextInt();
		
		System.out.println("어떤 정점부터 어떤 정점까지 이어지는 가중치를 입력하시오.(vertex1 vertex2 edgeWeight)");
		System.out.println("(ex. 2 3 5 : 2번부터 3번까지 연결된 edge의 가중치는 5)");
		edge = new Weight[edgeCnt];
		
		int x;
		int y;
		int weight;
		for(int i = 0; i < W.length; i++) {
			for(int j = 0; j <= n; j++) {
				if(i == j) {
					W[i][j] = 0;
					continue;
				}
				W[i][j] = MAX;
			}
		}
		for(int i = 0; i < edgeCnt; i++) {
			x = scan.nextInt();
			y = scan.nextInt();
			weight = scan.nextInt();
			edge[i] = new Weight(x,y,weight);
			
			W[x][y] = weight;
			
		}
		
		dijkstra(n);
	}
	
	private void dijkstra(int n) {
		int i, min;
		int vnear = 0;
		int []touch = new int[n+1];
		int [] length = new int[n+1];
		int j = 2;
		
		for(i = 0; i < length.length; i++)
			length[i] = MAX;
		
		for(i = 2; i <= n; i++) {
			touch[i] = 1;
			length[i] = W[1][i];
			
		}
		
		while(j < n+1) {
			min = MAX;
			
			for(i = 2; i<=n; i++) {
				if(length[i] == -1)
					continue;
				if(0<=length[i] && length[i] <= min) {
					min = length[i];
					vnear = i;
				}
			}
			
			F[vnear] = length[vnear];
			
			for(i = 2; i <= n; i++) {
				if(length[vnear] + W[vnear][i] < length[i])
				{
					length[i] = length[vnear]+W[vnear][i];
					touch[i] = vnear;
				}
			}
			length[vnear] = -1;
			j++;
		}
		System.out.print("F : ");
		for(i = 1; i <= n; i++) {
			System.out.print(F[i] + " ");
		}
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		System.out.println("vertex 개수 입력>>");
		int n = scan.nextInt();
		
		Algorithm6 Al6 = new Algorithm6(n);
	
	}

}
