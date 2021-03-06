package stepdefs;

import static org.junit.Assert.assertEquals;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PostRequest {
	
	String url;
	HttpResponse<JsonNode> jsonResponse1 ;
	
	@Given("^I have a URL for post request$")
	public void i_have_a_URL_for_post_request() throws Exception {
	   
	  
		url ="http://restapi.demoqa.com/customer";
	}

	@When("^I send a request with the parameters$")
	public void i_send_a_request_with_the_parameters() throws Exception {
	   
		jsonResponse1 
	      = Unirest.post("http://restapi.demoqa.com/customer")
	      .header("accept", "application/json")
	      .field("FirstName", "Virender")
	      .field("LastName", "Singh")
	      .field("UserName", "simpleuser001")
	      .field("Password", "password1")
	      .field("Email",  "someuser@gmail.com")
	      .asJson();
	  
	}

	@Then("^I should get a success response with a body$")
	public void i_should_get_a_success_response_with_a_body() throws Exception {
		 assertEquals(200, jsonResponse1.getStatus());
		    System.out.println(jsonResponse1.getBody());
	   
	}

}
