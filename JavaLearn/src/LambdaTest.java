import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaTest {

	Map<String, String> map = new HashMap<String, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -7262264238882844089L;

		{
			put("key1", "val1");
			put("key2", "val2");
			put("key3", "val3");
			
			System.out.println("LambdaTest: new map");
		}
	};

	{
		System.out.println("LambdaTest: new instance");
	}

	static {
		System.out.println("LambdaTest: static");
	}

	public LambdaTest() {
		System.out.println("LambdaTest: constructor");
	}

	private static List<Person> roster = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("LambdaTest: main");

		LambdaTest lt = new LambdaTest();

		prepareData();

		Person.printPersons(roster, testMale25(), mapper(), action());

		// roster.stream().filter(testMale25()).map(mapper()).forEach(action());

		Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);

		Arrays.sort(rosterAsArray, (Person a, Person b) -> {
			return a.getBirthday().compareTo(b.getBirthday());
		});

		Arrays.sort(rosterAsArray, (Person p1, Person p2) -> {
			return p1.getBirthday().compareTo(p2.getBirthday());
		});

		Arrays.sort(rosterAsArray, (a, b) -> Person.compareByAge(a, b));

		Arrays.sort(rosterAsArray, Person::compareByAge);

		ComparisonProvider myComparisonProvider = new ComparisonProvider();
		Arrays.sort(rosterAsArray, myComparisonProvider::compareByName);
	}

	private static Function<Person, String> mapper() {
		return p -> p.getEmailAddress();
	}

	private static Consumer<String> action() {
		return (String s) -> System.out.println(s);
	}

	private static Predicate<Person> testMale25() {
		return (Person p) -> p.getGender() == Person.Sex.MALE && p.getAge() > 25;
	}

	private static void prepareData() {
		Person p = new Person("AAA", new Date(1971, 01, 01), Person.Sex.MALE, "aaa@d.c");
		roster.add(p);

		p = new Person("BBB", new Date(1978, 01, 01), Person.Sex.FEMALE, "bbb@d.c");
		roster.add(p);
		p = new Person("CCC", new Date(2006, 01, 01), Person.Sex.MALE, "ccc@d.c");
		roster.add(p);
		p = new Person("DDD", new Date(1995, 01, 01), Person.Sex.MALE, "ddd@d.c");
		roster.add(p);
	}
}
