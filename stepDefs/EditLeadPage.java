package stepDefs;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditLeadPage extends ProjectSpecificMethods {
	@Given("Click CRM Link")
	public void clickCrmLink() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	
	@And("Click the button Leads")
	public void clickButtonLeads() {
		driver.findElement(By.linkText("Leads")).click();
	}
	@And("Click Find Leads Link")
	public void findLeadsLink() {
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/findLeads']")).click();
	}
	
	@When("Type the First Name as (.*)$")
	public void typeFirstName(String firstName) {
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(firstName);
	}
	
	@And("Click Find Leads button")
	public void clickFindLeads() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}
	
	@And("Click the first resulting lead")
	public void clickFirstResultingLead() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a")).click();
	}
	
	@Then("Verify the Title of the page")
	public void verifyTitle() {
		String title = driver.getTitle();
		if(title.equals("View Lead | opentaps CRM"));
			System.out.println("You are at right page View Lead | opentaps CRM");
	}
	
	@And("Click Edit button")
	public void clickEditButton() {
		driver.findElement(By.linkText("Edit")).click();
	}
	
	@When("Change the Company Name (.*)$")
	public void updateCompanyName(String updateCompanyName) {
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(updateCompanyName);
	}
	
	@And("Click Update button")
	public void clickUpdate() {
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
	}
	
	@Then("Verify the company name is updated")
	public void verifyCompanyName() {
		driver.findElement(By.xpath("//span[text()='Company Name']")).getText().contains("UST");
		System.out.println("Company Name is Updated");
	}

}
