import java.util.Scanner;

public class jisuan {
	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
		
		String num = scanner.nextLine();
		StringBuffer buffer = new StringBuffer(num);
		int flag = -1;
		for(int i=buffer.length()-1;i>=0;i--){
			if(flag == -1){
				if(buffer.charAt(i) == '*'){
					buffer.deleteCharAt(i);
				}else if(buffer.charAt(i) != '*'){
					flag = 1;
				}
			}else{
				if(buffer.charAt(i) == '*'){
					buffer.setCharAt(i, '0');
				}
			}
		}
		System.out.println(buffer.toString());
	}
}
