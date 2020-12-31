package topViewTree;

public class Node {
	private int data;
	private Node left,right;
//	private int level;
	
	Node(int data){
		this.data = data;
		left = right = null;
//		level = 0;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
//	public int getLvl() {
//		return level;
//	}
//	public void setLvl(int l) {
//		level = l;
//	}
//	
	
}
