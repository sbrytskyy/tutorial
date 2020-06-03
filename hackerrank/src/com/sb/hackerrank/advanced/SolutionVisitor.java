package com.sb.hackerrank.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum Color {
	RED, GREEN
}

abstract class Tree {

	private int value;
	private Color color;
	private int depth;

	public Tree(int value, Color color, int depth) {
		this.value = value;
		this.color = color;
		this.depth = depth;
	}

	public int getValue() {
		return value;
	}

	public Color getColor() {
		return color;
	}

	public int getDepth() {
		return depth;
	}

	@Override
	public String toString() {
		return String.format("%d, %s, %d", value, color, depth);
	}

	public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

	private ArrayList<Tree> children = new ArrayList<>();

	public TreeNode(int value, Color color, int depth) {
		super(value, color, depth);
	}

	@Override
	public void accept(TreeVis visitor) {
		visitor.visitNode(this);

		for (Tree child : children) {
			child.accept(visitor);
		}
	}

	public void addChild(Tree child) {
		children.add(child);
	}
}

class TreeLeaf extends Tree {

	public TreeLeaf(int value, Color color, int depth) {
		super(value, color, depth);
	}

	@Override
	public void accept(TreeVis visitor) {
		visitor.visitLeaf(this);
	}
}

abstract class TreeVis {
	public abstract int getResult();

	public abstract void visitNode(TreeNode node);

	public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {

	int result = 0;

	@Override
	public int getResult() {
		return result;
	}

	@Override
	public void visitNode(TreeNode node) {
	}

	@Override
	public void visitLeaf(TreeLeaf leaf) {
		result += leaf.getValue();
	}
}

class ProductOfRedNodesVisitor extends TreeVis {

	long result = 1;

	private final int M = 1000000007;

	@Override
	public int getResult() {
		return (int) result;
	}

	@Override
	public void visitNode(TreeNode node) {
		if (node.getColor() == Color.RED) {
			result = (result * node.getValue()) % M;
		}
	}

	@Override
	public void visitLeaf(TreeLeaf leaf) {
		if (leaf.getColor() == Color.RED) {
			result = (result * leaf.getValue()) % M;
		}
	}
}

class FancyVisitor extends TreeVis {

	int sum1 = 0;
	int sum2 = 0;

	@Override
	public int getResult() {
		return Math.abs(sum1 - sum2);
	}

	@Override
	public void visitNode(TreeNode node) {
		if (node.getDepth() % 2 == 0) {
			sum1 += node.getValue();
		}
	}

	@Override
	public void visitLeaf(TreeLeaf leaf) {
		if (leaf.getColor() == Color.GREEN) {
			sum2 += leaf.getValue();
		}
	}
}

public class SolutionVisitor {

	public static Tree solve() {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		int[] values = new int[n];
		int[] colors = new int[n];

		for (int i = 0; i < n; i++) {
			values[i] = scanner.nextInt();
		}
		for (int i = 0; i < n; i++) {
			colors[i] = scanner.nextInt();
		}

		List<Integer>[] rel = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			rel[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			int u1 = scanner.nextInt();
			int u2 = scanner.nextInt();

			rel[u1 - 1].add(u2 - 1);
			rel[u2 - 1].add(u1 - 1);
		}
		scanner.close();

		boolean[] visited = new boolean[n];

		Tree root = createNodes(0, values, colors, rel, visited, 0);
		return root;
	}

	private static Tree createNodes(int index, int[] values, int[] colors, List<Integer>[] rel, boolean[] visited,
			int depth) {
		Tree node;
		visited[index] = true;
		if (rel[index].size() == 0) {
			node = new TreeLeaf(values[index], colors[index] == 0 ? Color.RED : Color.GREEN, depth);
		} else {
			node = new TreeNode(values[index], colors[index] == 0 ? Color.RED : Color.GREEN, depth);

			int childsCount = 0;
			for (int childIndex : rel[index]) {
				if (!visited[childIndex]) {
					Tree child = createNodes(childIndex, values, colors, rel, visited, depth + 1);
					if (child != null) {
						childsCount++;
						((TreeNode) node).addChild(child);
					}
				}
			}
			if (childsCount == 0) {
				node = new TreeLeaf(values[index], colors[index] == 0 ? Color.RED : Color.GREEN, depth);
			}
		}

		return node;
	}

	public static void main(String[] args) {
		Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
		ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
		FancyVisitor vis3 = new FancyVisitor();

		root.accept(vis1);
		root.accept(vis2);
		root.accept(vis3);

		int res1 = vis1.getResult();
		int res2 = vis2.getResult();
		int res3 = vis3.getResult();

		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
	}
}
