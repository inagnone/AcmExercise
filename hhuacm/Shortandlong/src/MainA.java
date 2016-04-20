package Shortandlong.src;

import java.util.Scanner;


public class MainA {
	class Path{
		int pre;
		int length;
		
		public Path(int p, int len) {
			// TODO Auto-generated constructor stub
			pre = p;
			length = len;
		}
		
	}
	
	public Path[] dij(int[][] graph,int start){
		//初始化path
		Path[] paths = new Path[graph.length];
		for(int i=0;i<paths.length;i++){
			paths[i] = new Path(start, graph[start][i]);
		}
		graph[start][start] = 1;
		int mv,minw,i,j,k;
		for(j=0;j<graph.length;j++){
			mv = -1;
			minw = Integer.MAX_VALUE;
			//寻找当前外节点链接的最短边
			for(i=0;i<paths.length;i++){
				if(graph[i][i] == 0 && paths[i].length<minw){
					mv = i;
					minw = paths[i].length;
				}
			}
			//找不到最短遍，方法结束
			if(mv == -1) return paths;
			graph[mv][mv] = 1;
			
			//更新路径
			for(i=0;i<paths.length;i++){
				if(graph[i][i] != 1 && graph[mv][i] + paths[mv].length > 0 && paths[i].length > graph[mv][i] + paths[mv].length ){
					paths[i].length = graph[mv][i] + paths[mv].length;
					paths[i].pre = mv;
				}
			}
		}
		return paths;		
	}
	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
		MainA demo = new MainA();
		while(scanner.hasNext()){
			int N,M;
			N = scanner.nextInt();
			M = scanner.nextInt();
			if(N  == 0 && N == M	){
				return ;
			}
			int[][]  g = new int[N][N];
			int start,end,weight;
			for(int i=0;i<M;i++){
				start = scanner.nextInt();
				end = scanner.nextInt();
				weight = scanner.nextInt();
				g[start-1][end-1] = weight;
				g[end-1][start-1] = weight;
			}
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(i != j && g[i][j] == 0){
						g[i][j] = Integer.MAX_VALUE;
					}
				}
			}
			Path[] paths = demo.dij(g, 0);
			System.out.println(paths[N-1].length);
			
		}
	}
}
