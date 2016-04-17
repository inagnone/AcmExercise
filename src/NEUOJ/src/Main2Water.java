import java.util.Scanner;


public class Main2Water {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		int n,m,k;
		for(int casenum = 0;casenum<T;casenum++)	{
			n = scanner.nextInt();
			m = scanner.nextInt();
			k = scanner.nextInt();
			int[][] g = new int[n][m];
			
			for(int i=0;i<n;i++){
				String line = scanner.next();
				for(int j = 0;j<m;j++){
					char c = line.charAt(j);
					if(c == '#'){
						g[i][j] = -1;
					}else{
						g[i][j] = c;
					}
				}
			}
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					System.out.print(g[i][j]);
				}
				System.out.println();
			}
			
			
		}
	}
}
