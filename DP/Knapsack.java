import java.util.*;

class Knapsack{
	
	public static int findProfit(int items,int c,int p[],int w[]){
		int s[][]=new int[items+1][c+1];
		for(int i=0;i<=items;i++){
			for(int j=0;j<=c;j++){
				if(i==0 || j==0)
					s[i][j]=0;
				else if(w[i-1]>j)
					s[i][j]=s[i-1][j];
				else
					s[i][j]=Math.max(s[i-1][j-w[i-1]]+p[i-1],s[i-1][j]);
			}
		}
		return s[items][c];
	}
	
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		int p[]=new int[i];
		int w[]=new int[i];
		for(int j=0;j<i;j++)
			p[j]=sc.nextInt();
		for(int j=0;j<i;j++)
			w[j]=sc.nextInt();
		int c=sc.nextInt();
		System.out.println(findProfit(i,c,p,w));
	}
}