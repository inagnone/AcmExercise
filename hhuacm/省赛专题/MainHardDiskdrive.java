package 省赛专题;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MainHardDiskdrive {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int Case = 0;
	int T = scanner.nextInt();
	String str;
	String[] unit = {"B","KB","MB","GB","TB","PB","EB","ZB","YB"};
	while(T>0){
		Case++;
		str = scanner.next();
		int preindex = str.indexOf("[");
		int num = Integer.valueOf(str.substring(0, preindex));
		String u = str.substring(preindex+1,str.length()-1);
		int level = -1;
		for(int i = unit.length-1;i>=0;i--){
			if(unit[i].equals(u)){
				level = i;
				break;
			}
		}
		double harddiskb =  (num* (Math.pow(1000, level)));
		double osb = (num*(Math.pow(1024, level)));
		DecimalFormat df = new DecimalFormat("0");
		String result = df.format((1-harddiskb/osb)*100);
		System.out.println("Case #"+Case+": "+result+"%");
		T--;
	}
}
}
