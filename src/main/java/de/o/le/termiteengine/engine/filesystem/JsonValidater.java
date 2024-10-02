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
		    	//InstanceNPC.class.getResourceAsStream("dialogueSchema.json"));

	    		final JsonNode jsonNode = mapper.readTree(testedFile);
		    	//TestProj.class.getResourceAsStream("npctemplate.json"));

	    		final Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);

			if (!errors.isEmpty()) {

				errors.stream().forEach((t) -> {
		    			System.out.println(t.toString());
	    			});

				// why must maven throw so many error messages?
				System.exit(1);
			}

			/*
			// load schema
			JsonNode schemaNode = mapper.readTree(testedFile);
			JsonSchemaFactory schemaFactory;
			schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7); // here is a warning.. Why?
			com.networknt.schema.JsonSchema jsonSchema = schemaFactory.getSchema(schemaNode);

			// load file that should be validate
			JsonNode jsonNode = mapper.readTree(schema);

			// validation
			Set<ValidationMessage> validationMessages = jsonSchema.validate(jsonNode);
			// this is always true but I don't know why
			if (validationMessages.isEmpty()) {
				System.out.println("JSON is valid");
				return true;
			} else {
				System.out.println("JSON is not valid");
				validationMessages.forEach(message -> System.out.println(message.getMessage()));
				return false;
			}
			*/
		} catch (IOException e) {

			EngineResources.INSTANCE.OUT.printError(e);
		}
	}
}
