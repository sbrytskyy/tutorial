package com.sb.lc.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

	class Node {
		private final Map<Character, Node> kids = new HashMap<>();
		private boolean endOfWord = false;

		public Map<Character, Node> getKids() {
			return kids;
		}

		public boolean isEndOfWord() {
			return endOfWord;
		}

		public void setEndOfWord(boolean endOfWord) {
			this.endOfWord = endOfWord;
		}

		public void printNode(String prefix) {
			if (isEndOfWord()) {
				System.out.println(prefix + "$");
			}
			for (char ch : kids.keySet()) {
				System.out.println(prefix + ch);
				kids.get(ch).printNode(prefix + "-");
			}
		}
	}

	private Node root = new Node();

	public void addWord(String word) {
		char[] cs = word.toCharArray();

		Node node = root;
		for (char ch : cs) {
			node = node.getKids().computeIfAbsent(ch, c -> new Node());
		}
		node.setEndOfWord(true);
	}

	public boolean hasWord(String word) {
		char[] cs = word.toCharArray();

		Node node = root;
		for (char ch : cs) {
			node = node.getKids().get(ch);
			if (node == null) {
				return false;
			}
		}
		return node.isEndOfWord();
	}

	void printTrie() {
		String prefix = "";

		root.printNode(prefix);
	}

	public static void main(String[] args) {
		testTrie0();
		testSuffixTree();
	}

	/*
	 *  https://en.wikipedia.org/wiki/Suffix_tree
	 */
	private static void testSuffixTree() {
		Trie t = new Trie();

		String word = "banana";

		for (int i = 0; i < word.length(); i++) {
			String suffix = word.substring(i);
			t.addWord(suffix);
		}

		t.printTrie();
	}

	private static void testTrie0() {
		Trie t = new Trie();

		List<String> wordDict = List.of("cats", "dog", "sand", "and", "cat");

		for (String word : wordDict) {
			t.addWord(word);
		}

		t.printTrie();
		assert t.hasWord("cats");
		assert t.hasWord("cat");
		assert t.hasWord("sand");
		assert t.hasWord("and");
		assert t.hasWord("dog");
		
		assert !t.hasWord("dogs");
		assert !t.hasWord("an");
		assert !t.hasWord("band");
	}
}
