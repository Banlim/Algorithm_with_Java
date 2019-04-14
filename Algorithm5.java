// Kruskal's Algorithms
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Comparable;


class Edge implements Comparable<Edge>{
	private int startVertex;
	private int endVertex;
	private int weight;
	
	public Edge(int startVertex, int endVertex, int weight){
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
	public int compareTo(Edge edge) {
		return (this.weight - edge.weight);
	}
	
}
class nodeType {
	private int parent;
	private int depth;
	
	/*nodeType(){
		this.parent = parent;
		this.depth = depth;
	}*/
	
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
}

public class Algorithm5 {
	static Scanner scan;
	static Edge[] edge;
	
	static nodeType [] U;
	
	
	public Algorithm5(int n) {
		U = new nodeType[n+1];
		init(n);
	}
	private void makeSet(int index) {
		U[index].setDepth(0);
		U[index].setParent(index);
		
	}
	private void init(int n) {
		for(int i = 1; i <= n; i++) {
			U[i] = new nodeType();
			makeSet(i);
		}
	}
	
	private void edgeInput(int edgeCnt) {
		System.out.println("어떤 정점부터 어떤 정점까지 이어지는 가중치를 입력하시오.(vertex1 vertex2 edgeWeight)");
		System.out.println("(ex. 2 3 5 : 2번부터 3번까지 연결된 edge의 가중치는 5)");
		edge = new Edge[edgeCnt];
		
		int x;
		int y;
		int weight;
		for(int i = 0; i < edgeCnt; i++) {
			x = scan.nextInt();
			y = scan.nextInt();
			weight = scan.nextInt();
			edge[i] = new Edge(x,y,weight);
		}
		Arrays.sort(edge);
		
		
		
	}
	public int find(int i) {
		int j;
		j = i;
		while(U[j].getParent() != j) {
			j = U[j].getParent();
		}
		return j;
	}
	public boolean equal(int p, int q) {
		if(p == q)
			return true;
		else
			return false;
	}
	public void merge(int p, int q) {
		if(U[p].getDepth() == U[q].getDepth()) {
			U[p].setDepth(U[p].getDepth()+1);
			U[q].setParent(p);
		}
		else if(U[p].getDepth() < U[q].getDepth()) 
			U[p].setParent(q);
		else
			U[q].setParent(p);
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int weight = 0;
		int startV = 0;
		int endV = 0;
		int j = 0;
		
		int p;
		int q;
				
		System.out.println("vertex의 개수>>");
		int n = scan.nextInt();
		Algorithm5 Al5 = new Algorithm5(n);
		int [] F = new int[n];
		
		System.out.println("edge의 개수>>");
		int edgeCnt = scan.nextInt();
		Al5.edgeInput(edgeCnt);
		
		for(int i = 0; i < edgeCnt; i++) {
			
			weight = edge[i].getWeight();
			startV = edge[i].getStartVertex();
			endV = edge[i].getEndVertex();
			
			p = Al5.find(startV);
			q = Al5.find(endV);
	
			if(!Al5.equal(p, q)) {
				Al5.merge(p, q);
				F[j] = weight;	
				j++;
			}
			
		}
		
		int a = 0;
		System.out.print("F 집합 출력 >> ");
		while(F[a] != 0) {
			System.out.print(F[a] + " ");
			a++;
		}

	}
}
