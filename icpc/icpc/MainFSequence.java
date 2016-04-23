package icpc;

import java.util.ArrayList;
import java.util.Scanner;

public class MainFSequence {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	int T = scanner.nextInt();
	int n,temp;
	while(T >0){
		n = scanner.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		int dis;
		int smalldis = Integer.MAX_VALUE;
		int bigindex = -1;
		int bignum = -1;
		while(n>0){
			temp = scanner.nextInt();
			if(list.isEmpty()){
				list.add(temp);
				n--;
				continue;
			}
			smalldis = Integer.MAX_VALUE;
			bigindex = -1;
			bignum = -1;
			for(int i=0;i<list.size();i++){
				int tar = list.get(i);
				if((dis = temp-tar)>0){
					if(dis<smalldis){
						smalldis = dis;
						bigindex = list.indexOf(tar);
						bignum = temp;
					}
				}
			}
			if(smalldis != Integer.MAX_VALUE){
				list.set(bigindex, bignum);
			}	else{
				list.add(temp);
			}
			n--;
		}
		System.out.println(list.size());
		T--;
	}
}
}
