package topViewTree;

import java.util.Map;
import java.util.TreeMap;

public class BST {
	private Node root;
	
	BST(){
		root = null;
	}
		
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public boolean insert(int data) {
		Node newNode = new Node(data);
		if(newNode == null) {
			return false;
		}
		if(root == null) {
			root = newNode;
			return true;
		}
		
		Node temp = root;
		while(true) {
			if(data == temp.getData()) {
				return false;
			}
			if(data < temp.getData()) {
				if(temp.getLeft() == null) {
					temp.setLeft(newNode);
					return true;
				}
				temp = temp.getLeft();
			}
			else {
				if(temp.getRight() == null) {
					temp.setRight(newNode);
					return true;
				}
				temp = temp.getRight();
			}
		}
		
	}
	
	public void preOrder() {
		if(root == null) {
			return;
		}
		Node[] s = new Node[100];
		Node temp = root;
		int top = -1;
		System.out.print("PreOrder: ");
		while(temp != null || top != -1) {
			while(temp != null) {
				s[++top] = temp;
				System.out.print(temp.getData() + " ");
				temp = temp.getLeft();
			}
			temp = s[top--];
			temp = temp.getRight();
		}
		System.out.println();
	}
	
	public void inOrder() {
		if(root == null) {
			return;
		}
		System.out.print("InOrder: ");
		Node[] s = new Node[100];
		int top = -1;
		Node temp = root;
		while(temp != null || top != -1) {
			while(temp != null) {
				s[++top] = temp;
				temp = temp.getLeft();
			}
			temp = s[top--];
			System.out.print(temp.getData() + " ");
			temp = temp.getRight();
		}
		System.out.println();
	}
	
	public void postOrder() {
		class Pair{
			public Node node;
			public char flag;
		}
		
		if(root == null) {
			return;
		}
		System.out.print("PostOrder: ");
		Node temp = root;
		Pair[] s = new Pair[100];
		int top=-1;
		while(temp != null || top != -1) {
			while(temp != null) {
				Pair pair = new Pair();
				pair.node = temp; //20
				pair.flag = 'L';
				s[++top] = pair;
				temp = temp.getLeft();
			}
			Pair p = s[top--]; // 20 , R
			if(p.flag == 'L') {
				p.flag = 'R';
				s[++top] = p;  // push 20, R 
				temp = p.node.getRight(); //20
			}
			else {
				System.out.print(p.node.getData() + " ");  // 20.getdata(20)
			}	
		}
		System.out.println();
	}
	

	
	
//	public void topView(Node root) {
//		Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
//		Node temp ;
//		Node curVertex;
//		Node[] q = new Node[500];
//		int rear,front;
//		front = rear = -1;
//		
//		temp = root;
//		temp.setLvl(0);
//		
//		q[++rear] = temp;
//		++front;
//		while(front <= rear) {
//			curVertex = q[front++];
//			// add level + data to map
//			System.out.println(curVertex.getLvl());
//			System.out.println(curVertex.getData());
//			map.putIfAbsent(curVertex.getLvl(),curVertex.getData());
//			if(curVertex.getLeft() != null) {
//				curVertex.getLeft().setLvl(curVertex.getLvl() - 1);
//				q[++rear] = curVertex.getLeft();
//			}
//			if(curVertex.getRight() != null) {
//				curVertex.getRight().setLvl(curVertex.getLvl() + 1);
//				q[++rear] = curVertex.getRight();
//			}
//			
//		}
//		for(Map.Entry<Integer, Integer> e : map.entrySet()) {
//			System.out.print(e.getValue() + " ");
//		}
//	}
	
	
	public void topView(Node root) {
		class Pair{
			Node node;
			int level;
			Pair(){}; // paraLess constructor
			Pair(Node n, int l){ // parametrized constructor
				node = n;
				level = l;
			}
		}
		//TreeMap to display sorted keys -- as it stores stored data based on key
		//key -> Level (Integer), Value -> Node's Date(Integer)
		Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
		Pair temp = new Pair();
		Pair curVertex = new Pair();
		Pair[] q = new Pair[500];
		int rear,front;
		front = rear = -1;
		
		temp.node = root;
		temp.level = 0;
		// using BFS - level order traversal algorithm
		q[++rear] = temp; // enqueue starting node i.e Root
		++front;
		while(front <= rear) {
			curVertex = q[front++];
			// putting node's level and its data on Map
			//ifAbsent --- do not update existing key value
			map.putIfAbsent(curVertex.level,curVertex.node.getData());
			if(curVertex.node.getLeft() != null) { // adding current node's left on queue
				q[++rear] = new Pair(curVertex.node.getLeft(),curVertex.level - 1);
			}
			if(curVertex.node.getRight() != null) {// adding current node's right on queue
				q[++rear] = new Pair(curVertex.node.getRight(),curVertex.level + 1);
			}
			
		}
		// iterating over map using values() which return Collection view of values
		// so our for each is iterating over that Collection returned by Map
		for(Integer d : map.values()) { 
			System.out.print(d + " ");
		}
		System.out.println();
	}
	
	
	
		
	
}
