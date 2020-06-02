package com.sb.hackerrank.advanced;

import java.lang.reflect.Constructor;
import java.security.Permission;

public class Solution2 {

	public static void main(String[] args) throws Exception {
		DoNotTerminate.forbidExit();

		try {
			int num = 7;

			Object o;// Must be used to hold the reference of the instance of the class
						// Solution.Inner.Private

			Class<?> innerClass = Inner.class.getDeclaredClasses()[0];
			Constructor<?> ctor = innerClass.getDeclaredConstructors()[0];
			Inner inner = Inner.class.newInstance();
			ctor.setAccessible(true);
			Inner.Private p = (Inner.Private) ctor.newInstance(inner);
			o = p;
			System.out.println(String.format("%d is %s", num, p.powerof2(num)));

			System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

		} // end of try

		catch (DoNotTerminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
	}// end of main

	static class Inner {
		private class Private {
			private String powerof2(int num) {
				return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
			}
		}
	}// end of Inner

	private static class DoNotTerminate { // This class prevents exit(0)

		public static class ExitTrappedException extends SecurityException {

			private static final long serialVersionUID = 1L;
		}

		public static void forbidExit() {
			final SecurityManager securityManager = new SecurityManager() {
				@Override
				public void checkPermission(Permission permission) {
					if (permission.getName().contains("exitVM")) {
						throw new ExitTrappedException();
					}
				}
			};
			System.setSecurityManager(securityManager);
		}
	}

}// end of Solution
