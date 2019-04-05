package com.sb.test.mockito;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class Test1 {

	@Mock
	ExceptionTest test;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAssert() {
		ExceptionTest test = new ExceptionTest(); 

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
	        test.getPositiveInteger(-3);
	    });
		
		assert(exception.getMessage()).equals("Only positive needed");
	}

	@Test
	void testMock() {
		ExceptionTest test = mock(ExceptionTest.class);
		when(test.getPositiveInteger(5)).thenReturn(5);
		when(test.getPositiveInteger(3)).thenThrow(IllegalArgumentException.class);
	}

}
