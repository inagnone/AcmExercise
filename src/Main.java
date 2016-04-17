import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	class Tree{
		
		int[] childrens;
		int parant;
		int value;
		
		public Tree(int v){
			value = v;
		}
		
	}
	Tree[] initTree(int n){
		Tree[] Tree = new Tree[n];
		for(int i=0;i<n;i++){
			Tree[i] = new Tree(scanner.nextInt());
		}
		for(int i=0;i<n;i++){
			int k= scanner.nextInt();
			if(k != 0){
				Tree[i].childrens = new int[k];
				for(int j=0;j<k;j++){
					Tree[i].childrens[j] = scanner.nextInt();
					Tree[Tree[i].childrens[j]-1].parant = i;
				}
			}
		}
		Tree[0].parant = 0;
		return Tree;
	}
	
	
	public static void main(String[] args) {
		Main demo = new Main();
		while(scanner.hasNext()){
			
			int n,m;
			
			n = scanner.nextInt();
			m = scanner.nextInt();
			int subn = 0;
			Tree[] tree = demo.initTree(n);
			Tree[] subtree = demo.initTree(m);
			
			Stack<Tree> stack = new Stack<>();
			Tree subpoint = subtree[subn];
			for(int i=0;i<tree.length;i++){
				if(tree[i].value == subpoint.value  ){
					if(tree[tree[i].parant].value == subtree[subpoint.parant].value){
						stack.push(subpoint);
						if(tree[i].childrens != null && subpoint.childrens != null){
							for(int j=0;j<tree[i].childrens.length;j++){
								if(tree[tree[i].childrens[j]-1].value != subtree[subpoint.childrens[j]-1].value){
									stack.pop();
									break;
								}
							}											
						}
					}
				}
				if(!stack.isEmpty() && stack.peek().equals(subpoint)){
					subn++;
					if(subn<subtree.length){
						subpoint = subtree[subn];					
					}
				}
				if(stack.size() == subtree.length){
					System.out.println("YES");
					break;
				}
			}
			System.out.println("NO");
		}
	}
}
