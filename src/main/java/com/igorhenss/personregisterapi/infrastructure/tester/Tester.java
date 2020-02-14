package com.igorhenss.personregisterapi.infrastructure.tester;

import com.igorhenss.personregisterapi.infrastructure.exception.VerificationException;

import java.util.List;
import java.util.Objects;

public class Tester {
	
	public static boolean nonBlank(String subject) {
		return nonNull(subject) && !subject.isBlank();
	}
	
	public static boolean nonNull(Object subject) {
		return Objects.nonNull(subject);
	}
	
	public static boolean nonEmpty(List<?> subjects) {
		return !subjects.isEmpty();
	}
	
	public static void test(Boolean expression, String message) {
		if (!expression) throw new VerificationException(message);
	}
	
	public static void test(Boolean expression, String message, Object... args) {
		if (!expression) throw new VerificationException(message, args);
	}
	
}
