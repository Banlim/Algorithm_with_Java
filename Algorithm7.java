// The Sum-of-Subset Problem
import java.util.Scanner;

public class Algorithm7 {
	static Scanner scan;
	private int W;
	private int [] subWeight;
	private String [] Include;
	private int total;
	public Algorithm7(int n)
	{
		input(n);
	}
	public void input(int n) {
		System.out.println("Weight W >>");
		W = scan.nextInt();
		subWeight = new int[n+2];
		Include = new String[n+1];
		total = 0;
		int weight = 0;
		
		for(int i = 1; i <= n; i++)
		{
			System.out.println("W" + i);
			subWeight[i] = scan.nextInt();
			total += subWeight[i];
		}
	}
	public int getTotal() {
		return total;
	}
	public void sum_of_subset(int k, int weight, int total) {
	
		if(promising(k, weight, total)) {
			if(weight == W) {
				for(int i = 0; i < Include.length-1; i++) {
					System.out.print(Include[i] + " ");
				}
			}
			else {
				Include[k] = "yes";
				sum_of_subset(k+1, weight+subWeight[k+1], total- subWeight[k+1]);
				
				Include[k] = "No";
				sum_of_subset(k+1, weight, total - subWeight[k+1]);
			}
		}
	}
	public boolean promising(int k, int weight, int total) {
		if(k+1 < subWeight.length)
			return (weight + total >= W) && (weight == W || weight + subWeight[k+1] <= W);
		else
			return false;
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		System.out.println("n >> ");
		int n = scan.nextInt();
		Algorithm7 Al7 = new Algorithm7(n);
		Al7.sum_of_subset(0, 0, Al7.getTotal());
		scan.close();
	}
}