package com.sb.test.java8;

import java.util.Set;
import javax.tools.Diagnostic;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

@SupportedAnnotationTypes("com.sb.test.java8.CustomMethodAnnotation")
public class CustomAnnotationProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		for (Element elem : roundEnv.getElementsAnnotatedWith(CustomMethodAnnotation.class)) {
			CustomMethodAnnotation ca = elem.getAnnotation(CustomMethodAnnotation.class);
	        String message = "annotation found in " + elem.getSimpleName()
	                       + " with complexity " + ca.level();
	        processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, message);
	    }
	    return true; // no further processing of this annotation type
	}

}
