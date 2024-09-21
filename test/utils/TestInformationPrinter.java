package utils;

import annotations.TestInformation;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * @author o.le
 * @version 1.1
 * @since 1.2.4
 */
public class TestInformationPrinter implements BeforeEachCallback {

	@Override
	public void beforeEach(ExtensionContext context) throws Exception {
                Class className = context.getRequiredTestClass();
		Method method = context.getRequiredTestMethod();

		if (method.isAnnotationPresent(TestInformation.class)) {

			TestInformation info = method.getAnnotation(TestInformation.class);

			System.out.println("Current test: " + className.getName() + "." + method.getName() + "()");
			System.out.println("Tested class: " + info.testedClass());

			for (String methodName : info.testedMethod()) {

				System.out.println("Tested method: "
									+ info.testedClass()
									+ "."
									+ methodName);
			}
			System.out.println("Expected behavior: " + info.behavior());
			System.out.println("Is static: " + info.isStatic());

			System.out.println("----------------------------------------");
		}
	}
}
