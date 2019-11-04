import java.util.*;

class TilingProblem{
	
	public static int tile(int n){
		int s[]=new int[n+1];
		s[0]=1;
		s[1]=1;
		for(int i=2;i<=n;i++){
			s[i]=s[i-1]+s[i-2];
		}
		return s[n];
	}
	
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		System.out.println(tile(i));
	}
}