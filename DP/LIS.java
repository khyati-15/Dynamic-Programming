import java.util.*;

class LIS{
	
	public static int findLIS(int arr[],int n){
		int lis[]=new int[n];
		for(int i=0;i<n;i++)
			lis[i]=1;
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(arr[i]>arr[j] && lis[i]<lis[j]+1){
					lis[i]=lis[j]+1;
				}
			}
		}
		int max=1;
		for(int i=0;i<n;i++)
			if(max<lis[i])
				max=lis[i];
		return max;
	}
	
//	public static int findLIS(int arr[],int n){
//		int lis[]=new int[n];
//		for(int i=0;i<n;i++)
//			lis[i]=1;
//		for(int i=n-2;i>=0;i--){
//			for(int j=i+1;j<n;j++){
//				if(arr[j]>arr[i] && lis[i]<lis[j]+1)
//					lis[i]=lis[j]+1;
//			}
//		}
//		int max=1;
//		for(int i=0;i<n;i++)
//			if(max<lis[i])
//				max=lis[i];
//		return max;
//		
//	}
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int p[]=new int[n];
		for(int j=0;j<n;j++)
			p[j]=sc.nextInt();
		System.out.println(findLIS(p,n));
	}
}