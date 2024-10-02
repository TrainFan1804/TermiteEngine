package de.o.le.termiteengine.engine.filesystem;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import de.o.le.termiteengine.engine.core.EngineResources;
import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * @author o.le
 * @version 1.1
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

			final JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);


	    		final JsonSchema jsonSchema = factory.getSchema(schema.toURI());

	    		final JsonNode jsonNode = mapper.readTree(testedFile);

	    		final Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);

			if (!errors.isEmpty()) {

				ErrorLogger.getInstance().log(errors);

				// why must maven throw so many error messages?
				System.exit(1);
			}
		} catch (IOException e) {

			EngineResources.getInstance().OUT.printError(e);
		}
	}
}
