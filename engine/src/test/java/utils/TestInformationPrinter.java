package utils;

import annotations.TestClassInformation;
import java.lang.reflect.Method;
import java.util.Optional;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import annotations.TestMethodInformation;

/**
 * @author o.le
 * @version 1.5
 * @since 1.2.4
 */
public final class TestInformationPrinter implements BeforeEachCallback, TestWatcher {

	@Override
	public void beforeEach(ExtensionContext context) throws Exception {

                final Class<?> testClass = context.getRequiredTestClass();
		
		if (testClass.isAnnotationPresent(TestClassInformation.class)) {

			final TestClassInformation info = testClass.getAnnotation(TestClassInformation.class);

			System.out.println("Target Class: " + info.targetClass());
		}

		final Method testMethod = context.getRequiredTestMethod();

		if (testMethod.isAnnotationPresent(TestMethodInformation.class)) {

			final TestMethodInformation info = testMethod.getAnnotation(TestMethodInformation.class);

			System.out.println("Target Method: " + info.targetMethod());
			System.out.println("Expected behavior: " + info.behavior());
			if (info.isStatic()) System.out.println("Is static");
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
