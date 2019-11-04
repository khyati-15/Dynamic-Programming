import java.util.*;

class PrintSubsetSum{
	
	public static void printSubsets(boolean s[][],int sum,int i,ArrayList<Integer> p,int arr[])
	{
		if(i==0 && sum!=0 && s[0][sum]){
			p.add(arr[i]);
			System.out.println(p);
			p.clear();
			return;
		}
		else if(i==0 && sum==0){
			System.out.println(p);
			p.clear();
			return;
		}
		 if (s[i-1][sum]) 
        { 
            ArrayList<Integer> b = new ArrayList<>(); 
            b.addAll(p); 
            printSubsets(s,sum,i-1, p,arr); 
        } 
       
      
        if (sum >= arr[i-1] && s[i-1][sum-arr[i-1]]) 
        { 
            p.add(arr[i-1]); 
            printSubsets(s,sum-arr[i-1], i-1, p,arr); 
        } 
			
	}
	public static void subsetSum(int a[],int sum,int n){
		boolean s[][]=new boolean[n+1][sum+1];
		for(int i=0;i<=n;i++){
			for(int j=0;j<=sum;j++){
				if(j==0)
					s[i][j]=true;
				else if(i==0)
					s[i][j]=false;
				else if(a[i-1]>j)
					s[i][j]=s[i-1][j];
				else
					s[i][j]=s[i-1][j-a[i-1]] || s[i-1][j];
			}
		}
		if(s[n][sum]==false)
			System.out.println("There are no such subsets");
		else{
			ArrayList<Integer> p=new ArrayList<>();
			printSubsets(s,sum,n,p,a);
		}
	}
	
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int p[]=new int[n];
		for(int j=0;j<n;j++)
			p[j]=sc.nextInt();
		int sum=sc.nextInt();
		subsetSum(p,sum,n);
	}
}