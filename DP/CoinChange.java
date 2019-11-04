import java.util.*;

class CoinChange{
	
	public static int findCoins(int a[],int sum,int n){
		int s[][]=new int[n+1][sum+1];
		for(int i=0;i<=n;i++){
			for(int j=0;j<=sum;j++){
				if(j==0)
					s[i][j]=1;
				else if(i==0)
					s[i][j]=0;
				else if(a[i-1]>j)
					s[i][j]=s[i-1][j];
				else{
					s[i][j]=s[i][j-a[i-1]] + s[i-1][j];
				}
			}
		}
		return s[n][sum];
	}
	
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int p[]=new int[n];
		for(int j=0;j<n;j++)
			p[j]=sc.nextInt();
		int sum=sc.nextInt();
		System.out.println(findCoins(p,sum,n));
	}
}