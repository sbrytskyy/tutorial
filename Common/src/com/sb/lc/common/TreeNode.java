package com.sb.lc.common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + "]";
	}

	public static TreeNode stringToTreeNode(String input) {
	    input = input.trim();
	    input = input.substring(1, input.length() - 1);
	    if (input.length() == 0) {
	        return null;
	    }

	    String[] parts = input.split(",");
	    String item = parts[0];
	    TreeNode root = new TreeNode(Integer.parseInt(item));
	    Queue<TreeNode> q = new LinkedList<>();
	    q.add(root);

	    int index = 1;
	    while(!q.isEmpty()) {
	        TreeNode node = q.remove();

	        if (index == parts.length) {
	            break;
	        }

	        item = parts[index++];
	        item = item.trim();
	        if (!item.equals("null")) {
	            int leftNumber = Integer.parseInt(item);
	            node.left = new TreeNode(leftNumber);
	            q.add(node.left);
	        }

	        if (index == parts.length) {
	            break;
	        }

	        item = parts[index++];
	        item = item.trim();
	        if (!item.equals("null")) {
	            int rightNumber = Integer.parseInt(item);
	            node.right = new TreeNode(rightNumber);
	            q.add(node.right);
	        }
	    }
	    return root;
	}
	
	public static String treeNodeToString(TreeNode root) {
		if (root == null) {
			return "[]";
		}

		StringBuilder sb = new StringBuilder("[");

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		int lastIndex = sb.length();

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node == null) {
					sb.append("null");
				} else {
					sb.append(node.val);
					lastIndex = sb.length();
					q.offer(node.left);
					q.offer(node.right);
				}
				sb.append(",");
			}
		}

		sb.delete(lastIndex, sb.length());

		sb.append(']');
		return sb.toString();
	}

	public static void prettyPrintTree(TreeNode node, String prefix, boolean isLeft) {
		if (node.right != null) {
			prettyPrintTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
		}

		System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.val);

		if (node.left != null) {
			prettyPrintTree(node.left, prefix + (isLeft ? "    " : "│   "), true);
		}
	}

	public static void prettyPrintTree(TreeNode node) {
		prettyPrintTree(node, "", true);
	}

	public static void traverse(TreeNode node) {
		if (node == null)
			return;
		System.out.println(node.val);
		traverse(node.left);
		traverse(node.right);
	}
}