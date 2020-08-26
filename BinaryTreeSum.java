// Sum of all children on left of root node, sum of all children on right of root node 
// find which is larger

class Node {
	int value;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

public class TreeSum {

	static int leftsum = 0;
	static int rightsum = 0;

	public static void main(String args[]) {
		Node n1 = null;
		Node n2 = new Node(5);

		Node n = new Node(5);

		n.left = new Node(8);
		n.left.left = new Node(2);
		n.left.right = new Node(3);
		n.left.right.right = new Node(3);

		n.right = new Node(9);
		n.right.left = new Node(1);
		n.right.right = new Node(2);
		n.right.right.left = new Node(2);
		n.right.right.right = new Node(2);
		n.right.right.right.right = new Node(2);

		if (n == null || n.left == null || n.right == null) {
			// do nothing
		} else {
			printleftsum(n.left);
			printrightsum(n.right);

		}
		System.out.println("leftsum: " + leftsum);
		System.out.println("rightsum: " + rightsum);
		if (leftsum > rightsum) {
			System.out.println("left");
		} else if (leftsum < rightsum) {
			System.out.println("right");
		} else {
			System.out.println("none");
		}
	}

	public static void printleftsum(Node node) {
		if (node == null)
			return;
		printleftsum(node.left);
		printleftsum(node.right);
		leftsum = leftsum + node.value;

	}

	public static void printrightsum(Node node) {
		if (node == null)
			return;
		printrightsum(node.left);
		printrightsum(node.right);
		rightsum = rightsum + node.value;
	}
}
