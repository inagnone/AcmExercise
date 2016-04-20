package icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class MainJWater {
	static class area{
		int width;
		int heigh;
		
		public area(int h, int w) {
			// TODO Auto-generated constructor stub
		this.width = w;
		this.heigh = h;
		}
	}
	
	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(
                new InputStreamReader(System.in)));
		while(in.nextToken() != StreamTokenizer.TT_EOF){
			int N = (int) in.nval;
			if(N == 0){
				System.out.println(1);
				continue;
			}
			area[] world = new area[N];
			int H,W;
			int heightest = 0;
			int leng = 0;
			for(int i=0;i<N;i++){
				in.nextToken();
				H =(int) in.nval;
				in.nextToken();
				W = (int) in.nval;
				if(H>heightest){
					heightest = H;
				}
				leng = leng+W;
				world[i] = new area(H, W);
			}
			
			long time = 0;
			int city = 0;
			for(int i=0;i<N;i++){
				time = world[i].width * (heightest+1 - world[i].heigh) + time;		
			}
		
			System.out.println(time);
		}
		
		
	}
}
