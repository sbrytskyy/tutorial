package com.sb.lc.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + (this.next != null ? this.next.val : "null") + "]";
	}

	public String toStringFullObject() {
		List<Integer> l = new ArrayList<>();
		ListNode node = this.next;
		while (node != null) {
			l.add(node.val);
			node = node.next;
		}

		String s = l.stream().map(i -> i.toString()).collect(Collectors.joining(", "));

		return "ListNode [val=" + val + ", next=" + s + "]";
	}

	public static void prettyPrintLinkedList(ListNode node) {
		while (node != null && node.next != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}

		if (node != null) {
			System.out.println(node.val);
		} else {
			System.out.println("Empty LinkedList");
		}
	}

	public static String createPrettyPrintLinkedList(ListNode node) {
		StringBuilder sb = new StringBuilder();
		while (node != null && node.next != null) {
			sb.append(node.val + "->");
			node = node.next;
		}

		if (node != null) {
			sb.append(node.val);
		} else {
			sb.append("");
		}
		return sb.toString();
	}

	public static String listNodeToString(ListNode node) {
		String result = "";
		while (node != null) {
			result += Integer.toString(node.val) + ", ";
			node = node.next;
		}
		return result.substring(0, result.length() - 2);
	}

	public static ListNode stringToListNode(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return null;
		}

		String[] parts = input.split(",");
		String item = parts[0];
		ListNode root = new ListNode(Integer.parseInt(item));

		ListNode node = root;
		int index = 1;
		while (index < parts.length) {
			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int num = Integer.parseInt(item);
				node.next = new ListNode(num);
				node = node.next;
			}
		}
		return root;
	}

	public static String toArrayString(final ListNode head) {
		StringBuilder sb = new StringBuilder("[");
		ListNode node = head;
		while (node != null) {
			sb.append(node.val);
			if (node.next != null) {
				sb.append(",");
			}
			node = node.next;
		}
		sb.append("]");
		return sb.toString();
	}

	public static ListNode createFromString(final String s) {
		String str = s.replaceAll("[\\[\\]\s+]", "");
		String[] sa = str.split(",");

		ListNode head = new ListNode(Integer.valueOf(sa[0]));

		ListNode node = head;
		for (int i = 1; i < sa.length; i++) {
			ListNode newNode = new ListNode(Integer.valueOf(sa[i]));
			node.next = newNode;
			node = newNode;
		}

		return head;
	}
}
