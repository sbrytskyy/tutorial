
public class DeadLockMain {

	static class Friend {
		private final String name;

		public Friend(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}

		public synchronized void bow(Friend f) {
			//System.out.format("%s: %s" + "  has bowed to me!%n", this.name, f.getName());
			System.out.println(this.name+ ": " + f.getName() + "  has bowed to me!%n");
			f.bowBack(this);
		}

		public synchronized void bowBack(Friend f) {
			System.out.format("%s: %s" + " has bowed back to me!%n", this.name, f.getName());
		}
	}

	public static void main(String[] args) {
		final Friend a = new Friend("A");
		final Friend b = new Friend("B");

		new Thread(new Runnable() {
			public void run() {
				a.bow(b);
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				b.bow(a);
			}
		}).start();
	}
}
