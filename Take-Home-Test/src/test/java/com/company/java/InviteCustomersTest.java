package com.company.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.company.exception.ApplicationException;

@RunWith(MockitoJUnitRunner.class)
public class InviteCustomersTest {

	private static final String FILE_LOCATION = "resources/customer.json";
	private static final String INVALID_FILE_LOCATION = "resources/customer.js";
	private static final String INVALID_JSON_FILE = "resources/invalidCustomer.json";
	private static final String OUTPUT_FILE = "resources/output.txt";

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testFileNotFoundException() throws ApplicationException {
		exception.equals(ApplicationException.class);
		exception.expectMessage("File does not exist");
		InviteCustomers.readJsonFile(new File(INVALID_FILE_LOCATION));
	}

	@Test
	public void testInvalidJsonFormat() throws ApplicationException {
		exception.equals(ApplicationException.class);
		exception.expectMessage("Invalid JSON format");
		InviteCustomers.readJsonFile(new File(INVALID_JSON_FILE));
	}

	@Test
	public void testInviteCustomers() throws Exception {
		InviteCustomers.readJsonFile(new File(FILE_LOCATION));
		Map<String, String> output = new HashMap<String, String>();
		BufferedReader in = new BufferedReader(new FileReader(OUTPUT_FILE));
		String line = "";
		while ((line = in.readLine()) != null) {
			String parts[] = line.split("\t");
			output.put(parts[0].trim(), parts[1].trim());
		}
		in.close();
		Assert.assertTrue(output.containsKey("4"));
		Assert.assertTrue(output.containsKey("23"));
		Assert.assertTrue(output.containsKey("31"));
	}
}
