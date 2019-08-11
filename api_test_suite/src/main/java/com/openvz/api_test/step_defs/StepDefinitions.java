package com.openvz.api_test.step_defs;

import org.testng.Assert;

import com.openvz.api_test.request_manupulations.IRequestManupulation;
import com.openvz.api_test.request_manupulations.XMLRequestManupulation;
import com.openvz.api_test.template_holder.TemplateUpdator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	private IRequestManupulation requestManupulation;
	private String requstMessage;
	private String resposneMessage;
	
	@Given("Test case name is {string}")
	public void test_case_name_is(String testCaseName) {
	    System.out.println("Test case name is "+testCaseName);
	}

	@Given("Test case id is {string}")
	public void test_case_id_is(String testCaseId) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Test case id is "+testCaseId);
}

	@When("I get {string} template of request {string}")
	public void i_get_template_of_request(String messageFormat, String messageTemplateName) {
		this.setMessageFormat(messageFormat);
		requstMessage = new StudentTemplates().basicTemplate;
	}

	private void setMessageFormat(String messageFormat) {
		requestManupulation = new XMLRequestManupulation();
	}

	@When("I update node {string} value to {string}")
	public void i_update_node_value_to(String xpath, String valueToUpdate) {
		requstMessage =  requestManupulation.updateNodeValue(requstMessage, xpath, valueToUpdate);
	}

	@Then("I verify response value of node {string} is {string}")
	public void i_verify_response_value_of_node_is(String xpath, String valueToVerify) {
	    Assert.assertEquals(requestManupulation.getNodeValue(requstMessage, xpath),valueToVerify);
	}

}
