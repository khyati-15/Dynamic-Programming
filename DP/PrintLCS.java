import java.util.*;

class PrintLongestCommonSubsequence{
	
	public static void findLCS(char x[],char y[],int m,int n){
		int s[][]=new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0 || j==0)
					s[i][j]=0;
				else if(x[i-1]==y[j-1])
					s[i][j]=s[i-1][j-1]+1;
				else
					s[i][j]=Math.max(s[i-1][j],s[i][j-1]);
			}
		}
		printLCS(s,x,y,m,n);
	}
	
	public static void printLCS(int s[][],char x[],char y[],int m,int n){
		int index=s[m][n];
		int temp=index;
		char result[]=new char[index+1];
		result[index]=' ';
		int i=m;
		int j=n;
		while(i>0 && j>0){
			if(x[i-1]==y[j-1]){
				result[index-1]=x[i-1];
				i--;
				j--;
				index--;
			}
			else if(s[i-1][j]>s[i][j-1])
				i--;
			else
				j--;
		}
		for(int k=0;k<=temp;k++)
			System.out.print(result[k]);
	}
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String a=sc.nextLine();
		String b=sc.nextLine();
		char x[]=a.toCharArray();
		char y[]=b.toCharArray();
		int m=x.length;
		int n=y.length;
		findLCS(x,y,m,n);
	}
}