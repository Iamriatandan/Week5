package com.day2.handsonpracticeproblems.validateemailusingjsonschema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;

public class ValidateEmail {
    public static void main(String[] args) throws Exception {
        String schemaJson = "{"
                + "\"$schema\": \"https://json-schema.org/draft/2020-12/schema\","
                + "\"type\": \"object\","
                + "\"properties\": {"
                + "  \"email\": { \"type\": \"string\", \"format\": \"email\" }"
                + "},"
                + "\"required\": [\"email\"]"
                + "}";

        String validEmailJson = "{ \"email\": \"test@example.com\" }";
        String invalidEmailJson = "{ \"email\": \"invalid-email\" }";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode schemaNode = mapper.readTree(schemaJson);
        JsonNode validEmailNode = mapper.readTree(validEmailJson);
        JsonNode invalidEmailNode = mapper.readTree(invalidEmailJson);

        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonSchema schema = factory.getJsonSchema(schemaNode);

        validateEmail(schema, validEmailNode);
        validateEmail(schema, invalidEmailNode);
    }

    private static void validateEmail(JsonSchema schema, JsonNode emailNode) throws Exception {
        ProcessingReport report = schema.validate(emailNode);
        if (report.isSuccess()) {
            System.out.println("Valid email: " + emailNode.get("email").asText());
        } else {
            System.out.println("Invalid email: " + emailNode.get("email").asText());
            System.out.println(report);
        }
    }
}
