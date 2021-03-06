import java.util.Stack;

public class BinaryTreeNode {

    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }
	
    public BinaryTreeNode insertLeft(int leftValue) {
		//give the left node a value
        this.left = new BinaryTreeNode(leftValue);
        return this.left;
    }

    public BinaryTreeNode insertRight(int rightValue) {
        this.right = new BinaryTreeNode(rightValue);
        return this.right;
    }
}

/*
A binary search tree is a binary tree in which, for each node:

The node's value is greater than all values in the left subtree.
The node's value is less than all values in the right subtree.
*/

public BinarySearchTreeChecker{
	
	private static class NodeBounds{
		BinaryTreeNode node;
		int lowerBound;
		int upperBound;
		
	    NodeBounds(BinaryTreeNode node, int lowerBound, int upperBound){
			this.node = node;
			this.lowerBound = lowerBound;
			this.upperBound = upperBound;
		}
	}
	
	//non-recursive
	public static boolean isBinarySearchTree(BinaryTreeNode root){
		Stack<NodeBounds> nodeAndBoundsStack = new Stack<>();
		nodeAndBoundsStack.push(new NodeBounds(root, 
			Integer.MIN_VALUE, Integer.MAX_VALUE));
		//depth-first
		while(!nodeAndBoundsStack.empty()){
			NodeBounds nb = nodeAndBoundsStack.pop();
			BinaryTreeNode node = nb.node;
			int lowerBound = nb.lowerBound;
			int upperBound = nb.upperBound;
			//if node is invalid
			if(node.value <= lowerBound || node.value >= upperBound){
				return false;
			}
			//if node has left child
			if(node.left != null){
				//traverse to the left
				nodeAndBoundsStack.push(new NodeBounds(node.left, 
					lowerBound, node.value));
			}
			if(node.right != null){
				//traverse to the right
				nodeAndBoundsStack.push(new NodeBounds(node.right, 
					node.value, upperBound));
			}
		}
		return true;
		
	}//end method
	
	//recursive
	public static boolean isBinarySearchTreeRecursive(BinaryTreeNode root){
		return isBinarySearchTreeRecursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private static boolean isBinarySearchTreeRecursive(BinaryTreeNode root, 
		int lowerBound, int upperBound){
			if(root == null){
				return true;
			}
			if(root.value >= upperBound || root.value <= lowerBound){
				return false;
			}
			return isBinarySearchTreeRecursive(root.left, lowerBound, root.value)
				&& isBinarySearchTreeRecursive(root.right, root.value, upperBound);
	}
	//end method
}