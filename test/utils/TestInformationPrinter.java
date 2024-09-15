package utils;

import annotations.TestInformation;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * @author o.le
 * @version 1.0
 * @since 1.2.4
 */
public class TestInformationPrinter implements BeforeEachCallback {

	@Override
	public void beforeEach(ExtensionContext context) throws Exception {
		Method method = context.getRequiredTestMethod();

		if (method.isAnnotationPresent(TestInformation.class)) {

			TestInformation info = method.getAnnotation(TestInformation.class);

			System.out.println("Current test: " + method.getName());
			System.out.println("Tested class: " + info.testedClass());
			System.out.println("Tested method: " 
								+ info.testedClass() 
								+ "." + info.testedMethod());
			System.out.println("Expected behavior: " + info.behavior());
			System.out.println("Is static: " + info.isStatic());

			System.out.println("----------------------------------------");
		}
	}
}
