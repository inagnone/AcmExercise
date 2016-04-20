package icpc;

import java.util.ArrayList;
import java.util.Scanner;

public class MainAcandy {
	static ArrayList<Character> init(String str){
		ArrayList<Character> candys = new ArrayList<Character>();
		char now  = '0';
		for(int i=0;i<str.length();i++){
			char sc = str.charAt(i);
			if(sc != now){
				candys.add(sc);
				now = sc;
			}
		}
		return candys;
	}
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	int T;
	T = scanner.nextInt();
	while(T>0){
		String s ,t;
		s = scanner.next();
		t = scanner.next();
		ArrayList<Character> sc = init(s);
		ArrayList<Character> tc = init(t);
		boolean flag = true;
		if(sc.size()!=tc.size()){
			flag = false;
		}else{
			for(int i=0;i<sc.size();i++){
				if(sc.get(i) != tc.get(i)){
					flag = false;
					break;
				}
			}
		}
		if(flag){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
		
		
	
		T--;
	}
}
}
