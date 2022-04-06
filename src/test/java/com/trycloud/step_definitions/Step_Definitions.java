package com.trycloud.step_definitions;

import com.trycloud.pages.*;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.Waiter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Step_Definitions {
 LoginPage loginPage =new LoginPage();
 LandingPages landingPages=new LandingPages();
 FilesModulePage filesModulePage =new FilesModulePage();
 TalkModulePage talkModulePage =new TalkModulePage();
 ContactsModulePage contactsModulePage =new ContactsModulePage();
 Waiter wait =new Waiter(Driver.getDriver());

 //US1_Layla
 @Given("user on the login page")
 public void user_on_the_login_page() {
  Driver.getDriver().get(ConfigurationReader.getProperty("env"));
 }
 @When("user use username {string} and passcode {string} and user click on the login button")
 public void user_use_username_and_passcode_and_user_click_on_the_login_button(String username, String password) {
  loginPage.login(username, password);
 }
 @Then("verify the user should be at the {string} page")
 public void verify_the_user_should_be_at_the_page(String title) {
  Assert.assertTrue(Driver.getDriver().getTitle().contains(title));
 }


 @And("user logout")
 public void userLogout() {
  landingPages.userBtn.click();
  landingPages.logOutBtn.click();
 }

    //US4_Badmaa
    @Given("user on the dashboard page")
    public void userOnTheDashboardPage() {
    }

    @When("user clicks the {string} module")
    public void userClicksTheModule(String arg0) {
    }

    @Then("verify title is {string}")
    public void verifyTitleIs(String arg0) {
    }

    @And("user click the top-left checkbox of the table")
    public void userClickTheTopLeftCheckboxOfTheTable() {
    }

    @Then("verify all the files are selected")
    public void verifyAllTheFilesAreSelected() {
    }
}
