package com.biss.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//Test Case
/******* Step#1-start********/
//Mock Container
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
//Stubs(Proxies) 
@AutoConfigureMockMvc
//properties file
@TestPropertySource("classpath:application-test.properties")
public class TestStudentRestController {
	@Autowired
	private MockMvc mockMvc;

	@Test
	@Disabled
	public void testSave()throws Exception{
		//Buid reQuest
		MockHttpServletRequestBuilder req=
				MockMvcRequestBuilders.post("/rest/std/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"stdName\":\"K\",\"stdFee\":9.3,\"grade\":\"B++\"}");

		MvcResult res=mockMvc.perform(req).andReturn();

		MockHttpServletResponse resp=res.getResponse();

		/**************JUnit Test Response*****************/
		//d. Validate Using JUnit API
		assertEquals(200, resp.getStatus());
		if(!resp.getContentAsString().contains("saved")) {
			fail("Data is Not Saved");
		}
	}
	@Test
	public void testAll() throws Exception {
		MockHttpServletRequestBuilder request=
				MockMvcRequestBuilders.get("/rest/std/all");
		MvcResult result=mockMvc.perform(request).andReturn();
		MockHttpServletResponse resp=result.getResponse();
		assertEquals(200, resp.getStatus());
		assertEquals("application/json", resp.getContentType());
		assertNotNull(resp.getContentAsString());
	}
	// test one operation
	@Test
	public void testOne() throws Exception {
		MockHttpServletRequestBuilder request=
				MockMvcRequestBuilders.get("/rest/std/one/1");
		MvcResult result=mockMvc.perform(request).andReturn();
		MockHttpServletResponse resp=result.getResponse();
		assertEquals(200, resp.getStatus());
		assertNotNull(resp.getContentAsString());
		assertEquals("application/json", resp.getContentType());
	}
	// test remove operation
	@Test
	public void testRemove() throws Exception {
		MockHttpServletRequestBuilder request=
				MockMvcRequestBuilders.delete("/rest/std/remove/4");
		MvcResult result=mockMvc.perform(request).andReturn();
		MockHttpServletResponse resp=result.getResponse();
		assertEquals(200, resp.getStatus());
		if(!resp.getContentAsString().contains("removed")) {
			fail("Not Removed");
		}
	}
}