import java.util.Scanner;

public class Main单调递增最长子序列 {
	static int LIS(String str){
		int d[] = new int[str.length()];
		int len = 0;
		for(int i=0;i<str.length();i++){
			d[i] = 1;
			for(int j=0;j<i;j++){
				if(str.charAt(j)< str.charAt(i) && d[j]+1 > d[i]){
					d[i] = d[j]+1;
				}
			}
			if(len < d[i]){
				len = d[i];
			}
		}
		return len;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		String str;
		while(n>0){
			str = scanner.next();
			int result = LIS(str);
			System.out.println(result);
			n--;
		}
	}
}
