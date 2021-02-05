package com.sb.lc.common;

/**
 * Class to manipulate Java array of integers with O(1) space
 * 
 * TODO add NP, range and other checks
 * 
 * @author sbrytskyy
 *
 */
public class Array {

	private int[] nums;
	private int start;
	private int end;

	public Array(int[] nums) {
		this.nums = nums;
		this.start = 0;
		this.end = nums.length;
	}

	public int len() {
		return end - start;
	}

	public int get(int k) {
		return nums[start + k];
	}

	public int set(int k, int val) {
		return nums[start + k] = val;
	}

	public void swap(int i, int j) {
		nums[start + i] ^= nums[start + j];
		nums[start + j] ^= nums[start + i];
		nums[start + i] ^= nums[start + j];
	}

	public Array subarray(int beginIndex) {
		start += beginIndex;
		return this;
	}

	public Array subarray(int beginIndex, int endIndex) {
		int oldStart = start;
		start += beginIndex;
		end = oldStart + endIndex;
		return this;
	}

	public Array subarrayCopy(int beginIndex, int endIndex) {
		Array sub = new Array(this.nums);
		sub.start = this.start + beginIndex;
		sub.end = this.start + endIndex;
		return sub;
	}

	@Override
	public String toString() {
		if (nums == null)
			return "null";
		if (end < start)
			return "[]";

		StringBuilder b = new StringBuilder();
		b.append('[');
		for (int i = start; i < end; i++) {
			b.append(nums[i]);
			if (i < end - 1) {
				b.append(", ");
			}
		}
		return b.append(']').toString();
	}
}
