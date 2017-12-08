package com.sb.test.annotations;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Author(author = "JR")
public class Book {

	private String name;

	public Book(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + "]";
	}

	@CustomAnnotationMethod(date = "2014-06-05", description = "annotated method")
	public String annotatedMethod() {
		return "nothing niente";
	}

	public static void main(String[] args) {
		Book b = new Book("HP");
		System.out.println(b);

		// Retrieve all annotations from the class
		Class<? extends Book> c = b.getClass();
		Annotation[] annotations = c.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation);
		}

		// Checks if an annotation is present
		if (c.isAnnotationPresent(Author.class)) {

			// Gets the desired annotation
			Annotation annotation = c.getAnnotation(Author.class);
			System.out.println(annotation);
		}

		// the same for all methods of the class
		for (Method method : c.getDeclaredMethods()) {
			if (method.isAnnotationPresent(CustomAnnotationMethod.class)) {
				Annotation annotation = method.getAnnotation(CustomAnnotationMethod.class);
				System.out.println(annotation);
			}
		}
	}
}
