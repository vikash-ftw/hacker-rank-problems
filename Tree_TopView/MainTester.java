package topViewTree;

public class MainTester {

	public static void main(String[] args) {
		
		BST b1 = new BST();
		
		b1.insert(1);
		b1.insert(14);
		b1.insert(3);
		b1.insert(7);
		b1.insert(4);
		b1.insert(5);
		b1.insert(15);
		b1.insert(6);
		b1.insert(13);
		b1.insert(10);
		b1.insert(11);
		b1.insert(2);
		b1.insert(12);
		b1.insert(8);
		b1.insert(9);
		
		b1.inOrder();
		b1.topView(b1.getRoot());
		

	}

}
