package binarytrees;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_LevelOrder {

	public static void main(String[] args) {

		// Instantiating nodes
		TreeNode root = new TreeNode(2);
		TreeNode left_1 = new TreeNode(1);
		TreeNode right_1 = new TreeNode(3);
		TreeNode right_1_left = new TreeNode(4);
		TreeNode right_1_right = new TreeNode(5);

		// Mapping
		
		// root
		root= left_1;
		root = right_1;

		// root left
		left_1 = null;
		left_1 = null;

		// root right
		right_1 = right_1_left;
		right_1 = right_1_right;

		List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();

		levelOrderList = levelOrder(root);
		
		System.out.println(levelOrderList);
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {

		Queue<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();

		List<List<Integer>> resultList = new ArrayList<List<Integer>>();

		nodeQueue.add(root);

		int queueSize = 0;
		TreeNode tempNode;
		List<Integer> currentList;

		while (!nodeQueue.isEmpty()) {

			currentList = new ArrayList<Integer>();

			queueSize = nodeQueue.size();

			for (int i = 1; i <= queueSize; i++) {

				tempNode = nodeQueue.poll();

				currentList.add(tempNode.val);

				if (tempNode.left != null) {
					nodeQueue.add(tempNode.left);
				}
				if (tempNode.right != null) {
					nodeQueue.add(tempNode.right);
				}
				
			}

			resultList.add(currentList);
		}

		return resultList;
	}

}
