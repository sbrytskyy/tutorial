package com.sb.lc.common;

import com.sb.lc.common.TreeNode;

public class TreeTraversal {
	
	public TreeNode traversalTests(TreeNode root) {

		System.out.println("traversalLRV");
		traversalLRV(root);
		System.out.println();
		
		System.out.println("traversalLVR");
		traversalLVR(root);
		System.out.println();

		System.out.println("traversalVLR");
		traversalVLR(root);
		System.out.println();

		
		System.out.println("traversalRLV");
		traversalRLV(root);
		System.out.println();
		
		System.out.println("traversalVRL");
		traversalVRL(root);
		System.out.println();
		
		System.out.println("traversalRVL");
		traversalRVL(root);
		System.out.println();
		

		System.out.println("morrisTraversal");
		morrisTraversal(root);
		System.out.println();

		System.out.println("morrisTraversalPreorder");
		morrisTraversalPreorder(root);
		System.out.println();

		System.out.println("morrisTraversalPostorder");
		morrisTraversalPostorder(root);
		System.out.println();

		return root;
	}

	void traversalLVR(TreeNode root) {
		if (root != null) {
			traversalLVR(root.left);
			System.out.print(root.val + " ");
			traversalLVR(root.right);
		}
	}
	
	void traversalVLR(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			traversalVLR(root.left);
			traversalVLR(root.right);
		}
	}

	void traversalLRV(TreeNode root) {
		if (root != null) {
			traversalLRV(root.left);
			traversalLRV(root.right);
			System.out.print(root.val + " ");
		}
	}

	//
	void traversalRVL(TreeNode root) {
		if (root != null) {
			traversalRVL(root.right);
			System.out.print(root.val + " ");
			traversalRVL(root.left);
		}
	}

	void traversalRLV(TreeNode root) {
		if (root != null) {
			traversalRLV(root.right);
			traversalRLV(root.left);
			System.out.print(root.val + " ");
		}
	}

	void traversalVRL(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			traversalVRL(root.right);
			traversalVRL(root.left);
		}
	}

	// same as traversalLVR
	void morrisTraversal(TreeNode root) {
		TreeNode current, pre;

		if (root == null)
			return;

		current = root;
		while (current != null) {
			if (current.left == null) {
				System.out.print(current.val + " ");
				current = current.right;
			} else {
				/* Find the inorder predecessor of current */
				pre = current.left;
				while (pre.right != null && pre.right != current)
					pre = pre.right;

				/* Make current as right child of its inorder predecessor */
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				}

				/*
				 * Revert the changes made in if part to restore the original tree i.e.,fix the
				 * right child of predecssor
				 */
				else {
					pre.right = null;
					System.out.print(current.val + " ");
					current = current.right;
				} /* End of if condition pre->right == NULL */

			} /* End of if condition current->left == NULL */

		} /* End of while */
	}

	// same as traversalVLR
	// Preorder traversal without recursion and without stack
	void morrisTraversalPreorder(TreeNode node) {
		while (node != null) {

			// If left child is null, print the current node data. Move to
			// right child.
			if (node.left == null) {
				System.out.print(node.val + " ");
				node = node.right;
			} else {

				// Find inorder predecessor
				TreeNode current = node.left;
				while (current.right != null && current.right != node) {
					current = current.right;
				}

				// If the right child of inorder predecessor already points to
				// this node
				if (current.right == node) {
					current.right = null;
					node = node.right;
				}

				// If right child doesn't point to this node, then print this
				// node and make right child point to this node
				else {
					System.out.print(node.val + " ");
					current.right = node;
					node = node.left;
				}
			}
		}
	}

	// same as traversalRVL
	// Postorder traversal without recursion and without stack
	void morrisTraversalPostorder(TreeNode root) {
		TreeNode current, pre;

		if (root == null)
			return;

		current = root;
		while (current != null) {
			if (current.right == null) {
				System.out.print(current.val + " ");
				current = current.left;
			} else {
				/* Find the inorder predecessor of current */
				pre = current.right;
				while (pre.left != null && pre.left != current)
					pre = pre.left;

				/* Make current as left child of its inorder predecessor */
				if (pre.left == null) {
					pre.left = current;
					current = current.right;
				}

				/*
				 * Revert the changes made in if part to restore the original tree i.e.,fix the
				 * left child of predecessor
				 */
				else {
					pre.left = null;
					System.out.print(current.val + " ");
					current = current.left;
				} /* End of if condition pre->left == NULL */

			} /* End of if condition current->right == NULL */

		} /* End of while */
	}

	public static void main(String[] args) {
		TreeTraversal sol = new TreeTraversal();

		String st = null;
		TreeNode root = null;
		TreeNode r;

		System.out.println("[traversalTests]");
		st = "[5,2,13,1,2,3,4,5,6,7,8,9]";
		root = TreeNode.stringToTreeNode(st);
		TreeNode.prettyPrintTree(root);
		System.out.println("\n\n");

		r = sol.traversalTests(root);
//		TreeNode.prettyPrintTree(r);
		System.out.println("\n\n");
	}
}
