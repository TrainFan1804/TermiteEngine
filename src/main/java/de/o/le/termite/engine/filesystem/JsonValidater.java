package de.o.le.termite.engine.filesystem;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import de.o.le.termite.engine.core.EngineOutputResource;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Set;

/**
 * This class will check if a JSON file match a specific JSON schema.
 * 
 * @author o.le
 * @version 1.2
 * @since 1.4.5
 */
public class JsonValidater {

	/**
	 * Will validate if a json file matches the given schema.
	 * 
	 * @param testedFile The file that is tested.
	 * @param schema The schema that the file should match.
	 */
	public void validateJson(File testedFile, File schema) {
		
		ObjectMapper mapper = new ObjectMapper();

		try {

			final JsonSchemaFactory factory = this.createFactory();

	    		final JsonSchema jsonSchema = factory.getSchema(schema.toURI());

	    		final JsonNode jsonNode = mapper.readTree(testedFile);

	    		final Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);

			if (!errors.isEmpty()) {

				ErrorLogger.getInstance().log(errors);

				// why must maven throw so many error messages?
				System.exit(1);
			}
		} catch (IOException e) {

			EngineOutputResource.getInstance().OUT.printError(e);
		}
	}

	/**
	 * Each time the validator is getting the JsonSchemeFactory a annoying
	 * error message is displayed. To deactivate the message the PrintStream
	 * is delegate to a dummy stream.
	 * <p>
	 * This is bad but there is no simpler workaround because I can't fix the
	 * issue in any other way.
	 * 
	 * @return The JsonSchemeFactory for the validator.
	 */
	private JsonSchemaFactory createFactory() {

		final PrintStream ERROR = System.err;
		final JsonSchemaFactory FACTORY; 

		try {

			// This is the dummy print stream
			final PrintStream DUMMY = new PrintStream(new OutputStream() {
				@Override
				public void write(int i) { }
			});

			System.setErr(DUMMY);

			// This method call cause the error printing
			FACTORY = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);
		} finally {

			System.setErr(ERROR);
		}

		return FACTORY;
	}
}
