package com.sb.test.guice;

import com.google.inject.AbstractModule;
import com.sb.test.guice.student.Registrar;
import com.sb.test.guice.student.StudentStore;
import com.sb.test.guice.student.register.LenientRegistrar;
import com.sb.test.guice.student.store.DummyStudentStore;

public class SimpleModule extends AbstractModule {

	@Override
	protected void configure() {

		bind(StudentStore.class).to(DummyStudentStore.class);

		bind(Registrar.class).to(LenientRegistrar.class);
	}

}
