package com.sb.lc.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Weighted Union-Find class. Supports any integers
 * 
 * @author sbrytskyy
 *
 */
public class UF {

	final int[] parents;
	final int[] sizes;

	int index = 0;
	final Map<Integer, Integer> map = new HashMap<>();

	public UF(int len) {
		parents = new int[len];
		sizes = new int[len];

		for (int i = 0; i < len; i++) {
			parents[i] = i;
			sizes[i] = 1;
		}
	}

	public void union(int v, int w) {
		int vi = map.getOrDefault(v, -1);
		if (vi == -1) {
			vi = index++;
			map.put(v, vi);
		}

		int wi = map.getOrDefault(w, -1);
		if (wi == -1) {
			wi = index++;
			map.put(w, wi);
		}

		int pv = find(vi);
		int pw = find(wi);

		if (pv == pw) {
			return;
		}

		if (sizes[pv] < sizes[pw]) {
			parents[pv] = pw;
			sizes[pw] += sizes[pv];
		} else {
			parents[pw] = pv;
			sizes[pv] += sizes[pw];
		}
	}

	public boolean connected(int v, int w) {
		int vi = map.getOrDefault(v, -1);
		int wi = map.getOrDefault(w, -1);

		if (vi == -1 || wi == -1) {
			return false;
		}

		int pv = find(vi);
		int pw = find(wi);
		return pv == pw;
	}

	private int find(int v) {
		int p = parents[v];
		while (p != v) {
			v = p;
			p = parents[v];
		}
		return p;
	}

	public static void main(String[] args) {
		testUF();
	}

	private static void testUF() {
		UF u = new UF(10);

		u.union(2, 7);
		u.union(3, 4);

		assert u.connected(3, 7) == false;
		u.union(3, 7);
		assert u.connected(3, 7) == true;

		// assert u.find(7) == 7;
		assert u.connected(1, 7) == false;
		assert u.connected(2, 7) == true;

		u.union(2, 777);
		assert u.connected(2, 777) == true;
		assert u.connected(7, 777) == true;
		assert u.connected(1, 777) == false;
	}
}
