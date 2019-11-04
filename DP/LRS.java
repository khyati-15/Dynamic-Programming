import java.util.*;

class LongestRepeatedSubsequence{
	
	public static void findLRS(char x[]){
		
		int n=x.length;
		int s[][]=new int[n+1][n+1];
		for(int i=0;i<=n;i++){
			for(int j=0;j<=n;j++){
				if(i==0 || j==0)
					s[i][j]=0;
				else if(x[i-1]==x[j-1] && i!=j)
					s[i][j]=s[i-1][j-1]+1;
				else
					s[i][j]=Math.max(s[i-1][j],s[i][j-1]);
			}
		}
		int index=s[n][n];
		char result[]=new char[index+1];
		result[index]=' ';
		int i=n;
		int j=n;
		while(i>0 && j>0){
			if(s[i][j]==s[i-1][j-1]+1){
				result[index-1]=x[i-1];
				i--;
				j--;
				index--;
			}
			else if(s[i-1][j]==s[i][j])
				i--;
			else
				j--;
		}
		for(j=0;j<=s[n][n];j++)
			System.out.print(result[j]);
	}
	
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String a=sc.nextLine();
		char x[]=a.toCharArray();
		findLRS(x);
	}
}