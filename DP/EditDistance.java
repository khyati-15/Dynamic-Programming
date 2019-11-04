import java.util.*;

class EditDistance{
	
	public static int findDist(char x[],char y[],int m,int n){
		int s[][]=new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0)
					s[i][j]=j;
				else if(j==0)
					s[i][j]=i;
				else if(x[i-1]==y[j-1])
					s[i][j]=s[i-1][j-1];
				else
					s[i][j]=1+Math.min(s[i-1][j-1],Math.min(s[i-1][j],s[i][j-1]));
			}
		}
		
		return s[m][n];
	}
	
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String a=sc.nextLine();
		String b=sc.nextLine();
		char x[]=a.toCharArray();
		char y[]=b.toCharArray();
		int m=x.length;
		int n=y.length;
		System.out.println("Edit Distance :"+findDist(x,y,m,n));
	}
}