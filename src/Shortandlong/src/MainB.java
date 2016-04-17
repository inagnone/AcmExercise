import java.util.Scanner;


public class MainB {
	//dfs搜索
//	static int hascircle(int[][] g,int start,int[] U,int length,int pre){
//		int result = 0;
//		if(U[start] == -1){
//			U[start] = 1;
//			for(int i=0;i<g.length;i++){
//				if(g[start][i] != Integer.MAX_VALUE){
//					if(i == start || i==pre){
//						continue;
//					}
//					pre = start;
//					length = length + g[start][i];
//					start = i;
//					int len = hascircle(g, start, (int[]) U.clone(), length,pre);
//					if(len == -1){
//						return len;
//					}else if(len> result){
//						result = len;
//					}
//				}
//			}
//		}else{
//			return -1;
//		}
//		if(result == 0){
//			return length;			
//		}else{
//			return result;
//		}
//	}
//	
	
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
				if(graph[i][i] != 1 && graph[mv][i]!= Integer.MAX_VALUE && paths[i].length > graph[mv][i] + paths[mv].length ){
					paths[i].length = graph[mv][i] + paths[mv].length;
					paths[i].pre = mv;
				}
			}
		}
		return paths;		
	}
	
	public static void main(String[] args) {
		
		
		MainB demo = new MainB();
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNext()){
			int n,m;
			n = scanner.nextInt();
			m = scanner.nextInt();
			int start,end,length;
			int[][] graph = new int[n][n];
			int vex[] = new int[n];
			for(int i=0;i<m;i++){
				start = scanner.nextInt();
				end = scanner.nextInt();
				length = -scanner.nextInt();
				graph[start-1][end-1] = length;
				graph[end-1][start-1] = length;
				vex[start-1]  += 1;
				vex[end-1] +=1;
			}
			//边数大于顶点数，必定成环
			if(m>n){
				System.out.println("YES");
				break;
			}
			for(int i=0;i<graph.length;i++){
				for(int j=0;j<graph.length;j++){
					if(i != j && graph[i][j] ==0){
						graph[i][j] = Integer.MAX_VALUE;
					}
				}
			}
			int num = n;
			while(num >= 1){
				boolean single = false;
				for(int i=0;i<n;i++){
					if(vex[i]<=1){
						single = true;
						vex[i] = -1;;
						for(int j=0;j<n;j++){
							if(graph[j][i] != Integer.MAX_VALUE && i!= j){
								vex[j]--;
								break;
							}
						}
						num --;
					}
				}
				if(single == false){
					System.out.println("YES");
					break;
				}
			}
			if(num == 0){
				int result = 0;
				for(int i=0;i<n;i++){
					Path[] paths = demo.dij(graph, i);	
					int leng = 0;
					for(int j=0;j<n;j++){
						if(paths[j].length<leng){
							leng = paths[j].length;
						}
					}
					if(-leng > result){
						result = -leng;
					}
				}
				System.out.println(result);
			}
			
//			int[] U = new int[graph.length];
//			for(int i=0;i<U.length;i++){
//				U[i] = -1;
//			}
//		
//				int circlelength = MainB.hascircle(graph, 0, U, 0,-1);		
//				if(circlelength == -1){
//					System.out.println("YES");
//				}else{
//					System.out.println(circlelength);
//				}	
		}
	}
}
