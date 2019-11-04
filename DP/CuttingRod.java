import java.util.*;

class CuttingRod{
	
	public static int cutrod(int a[],int n){
		int s[]=new int[n+1];
		for(int i=0;i<=n;i++)
			s[i]=0;
		for(int i=1;i<=n;i++){
			int max=-1;
			for(int j=0;j<i;j++){
				max=Math.max(max,a[j]+s[i-j-1]);
			}
			s[i]=max;
		}
		
		return s[n];
	}
	
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int p[]=new int[n];
		for(int j=0;j<n;j++)
			p[j]=sc.nextInt();

		System.out.println(cutrod(p,n));
	}
}