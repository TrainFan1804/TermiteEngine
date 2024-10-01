package de.o.le.termiteengine.engine.filesystem;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * @author o.le
 * @version 1.0
 * @since 1.4.5
 */
public class JsonValidater {

	public boolean isValidJson(File testedFile, File schema) {
		
		ObjectMapper mapper = new ObjectMapper();

		try {

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
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

	/*
		This was generated with chatGPT
	*/
	public void foo() {

		ObjectMapper mapper = new ObjectMapper();

		try {

			// load schema
			JsonNode schemaNode = mapper.readTree(new File("src/main/resources/de/o/le/termiteengine/engine/filesystem/dialogueSchema.json"));
			JsonSchemaFactory schemaFactory;
			schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);
			com.networknt.schema.JsonSchema jsonSchema = schemaFactory.getSchema(schemaNode);

			// load file that should be validate
			JsonNode jsonNode = mapper.readTree(new File("npctemplate.json"));

			// validation
			Set<ValidationMessage> validationMessages = jsonSchema.validate(jsonNode);
			if (validationMessages.isEmpty()) {
				System.out.println("JSON is valid");
			} else {
				System.out.println("JSON is not valid");
				validationMessages.forEach(message -> System.out.println(message.getMessage()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
