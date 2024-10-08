package utils;

import annotations.TestInformation;
import java.lang.reflect.Method;
import java.util.Optional;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

/**
 * @author o.le
 * @version 1.4
 * @since 1.2.4
 */
public final class TestInformationPrinter implements BeforeEachCallback, TestWatcher {

	@Override
	public void beforeEach(ExtensionContext context) throws Exception {

                final Class<?> testClass = context.getRequiredTestClass();
		final Method testMethod = context.getRequiredTestMethod();

		if (testMethod.isAnnotationPresent(TestInformation.class)) {

			final TestInformation info = testMethod.getAnnotation(TestInformation.class);
			final String methodFullName = String.format("%s.%s()", 
								testClass.getName(), 
								testMethod.getName());

			System.out.println("Current test: " + methodFullName);
			System.out.println("Target: " + info.target());
			System.out.println("Expected behavior: " + info.behavior());
			System.out.println("Is static: " + info.isStatic());
			System.out.println();
		}
	}

	@Override
	public void testFailed(ExtensionContext context, Throwable cause) {

		final Class<?> className = context.getRequiredTestClass();
		final Method method = context.getRequiredTestMethod();
		System.out.println("Something went wrong in test " + className.getName() 
				+ "." + method.getName() +  " while running");
		System.out.println("Cause: " + cause.getLocalizedMessage());
		System.out.println("----------------------------------------");
	}

	@Override
	public void testSuccessful(ExtensionContext context) {

		final Class<?> className = context.getRequiredTestClass();
		final Method method = context.getRequiredTestMethod();
		System.out.println("Test " + className.getName() 
				+ "." + method.getName() +  " run successfully");
		System.out.println("----------------------------------------");
	}

	@Override
	public void testDisabled(ExtensionContext context, Optional<String> reason) {

		final Class<?> className = context.getRequiredTestClass();
		final Method method = context.getRequiredTestMethod();
		System.out.println("Test " + className.getName() 
				+ "." + method.getName() +  " was disabled because: "
					+ reason.stream().toArray()[0]);
		System.out.println("----------------------------------------");
	}
}
