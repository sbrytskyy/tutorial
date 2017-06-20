
public class CompareVersions {

	public String compareVersions(String v1, String v2) {
		String[] sa1 = v1.split("\\.");
		String[] sa2 = v2.split("\\.");

		int l1 = sa1.length;
		int l2 = sa2.length;

		int ml = l1 < l2 ? l1 : l2;

		String result = null;
		if (l1 > l2)
			result = v1;
		if (l2 > l1)
			result = v2;

		int index = 0;
		while (index < ml) {
			String s1 = sa1[index];
			String s2 = sa2[index];

			Integer i1 = Integer.valueOf(s1);
			Integer i2 = Integer.valueOf(s2);

			if (i1 > i2) {
				result = v1;
				break;
			}
			if (i2 > i1) {
				result = v2;
				break;
			}

			index++;
		}
		return result;
	}

	public void test() {
		String s1 = "1.4";
		String s2 = "1.2.3.4";
		
		String newest = compareVersions(s1, s2);
		System.out.println(newest);
	}
	
	public static void main(String[] args) {
		CompareVersions cv = new CompareVersions();
		cv.test();
	}

}
