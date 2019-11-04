import java.util.*;

class PairFriends{
	
	public static int pair(int n){
		int s[]=new int[n+1];
		s[0]=0;
		s[1]=1;
		s[2]=2;
		for(int i=3;i<=n;i++){
			s[i]=s[i-1]+s[i-2]*(i-1);
		}
		return s[n];
	}
	
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		System.out.println(pair(i));
	}
}