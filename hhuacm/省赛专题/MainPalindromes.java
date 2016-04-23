package 省赛专题;

import java.util.Scanner;

public class MainPalindromes {

static int countpalindromes(String str,int n){
	int count = 0;
	/**
	 * 字串中心是两个字符，计算往两边套能否形成回文
	 */
	if(str.charAt(n) == str.charAt(n+1)){
		count++;
		for(int i=1;n-i>=0 && n+1+i<=str.length()-1;i++){
			if(str.charAt(n-i) != str.charAt(n+1+i)){
				break;
			}
			count++;
		}
	}
	/**
	 * 字串中心是单个字符，计算往两边套能否形成回文
	 */
	for(int i=1;n-i>=0 && n+i<=str.length()-1;i++){
		if(str.charAt(n-i) != str.charAt(n+i)){
			break;
		}
		count++;
	}
	return count;
}
	
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String str;
	int count;
	while(scanner.hasNext()){
		str = scanner.next();
		count = 0;
		for(int n=0;n<str.length()-1;n++){
			count +=countpalindromes(str, n);
		}
		System.out.println(count+str.length());
	}
}
}
