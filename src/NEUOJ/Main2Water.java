package NEUOJ;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

import NEUOJ.Main2Water.vex;


public class Main2Water {
	static ArrayDeque<vex> queue= new ArrayDeque<>();
	static class vex{
		int x;
		int y;
		public vex(int x,int y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
		}
	}
	static void addwater(int x,int y,int[][] g){
		if(g[x][y] != -1){
				g[x][y] = 0;
				sendwater(x-1,y,g,0,-1);
				sendwater(x, y-1, g,-1,0);
				sendwater(x+1, y, g,0,1);
				sendwater(x, y+1, g,1,0);
		}
	}
	
	static void sendwater(int x,int y,int[][] g,int right,int down){
		if(g[x][y] != -1){
			if(g[x][y] == 0){
				sendwater(x+down, y+right, g, right, down);
			}else if(g[x][y] <4){
				g[x][y]++;
			}else{
				g[x][y] = 0;
				queue.add(new vex(x, y));
			}			
		}
	}
	
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
						g[i][j] = Integer.valueOf(c+"");
					}
				}
			}
//			for(int i=0;i<n;i++){
//				for(int j=0;j<m;j++){
//					System.out.print(g[i][j]);
//				}
//				System.out.println();
//			}
			int x,y;
			for(int i=0;i<k;i++){
				x = scanner.nextInt();
				y = scanner.nextInt();
				
				if(g[x][y] != -1){
					if(g[x][y] <4){
						g[x][y] ++;
					}else{
						g[x][y] = 0;						
						sendwater(x-1,y,g,0,-1);
						sendwater(x, y-1, g,-1,0);
						sendwater(x+1, y, g,0,1);
						sendwater(x, y+1, g,1,0);
					}
			}
				while(!queue.isEmpty()){
					vex pop = queue.pop();
					addwater(pop.x, pop.y, g);
				}
			}
			for(int i=0;i<n;i++){
				StringBuilder builder = new StringBuilder();
				for(int j=0;j<m;j++){
					if(g[i]	[j] == -1){
						builder.append('#');
					}else{
						builder.append(g[i][j]);
					}
				}
				System.out.println(builder);
			}
		}
	}
}
