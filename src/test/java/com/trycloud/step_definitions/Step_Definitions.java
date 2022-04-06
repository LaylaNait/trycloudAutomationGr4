package com.trycloud.step_definitions;

import com.trycloud.pages.*;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.TrycloudUtililities;
import com.trycloud.utilities.Waiter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

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

 //US2_Mikael
 @When("user enter invalid {string} and {string}")
 public void user_enter_invalid_and(String string, String string2) {
  loginPage.login(string, string2);

 }

 @Then("verify {string} message should be displayed")
 public void verify_message_should_be_displayed(String string) {
  String actualMessage = loginPage.errorMessage.getText();

  Assert.assertEquals(string, actualMessage);
 }

 //US3_Karina
 @Then("Verify the user see the following modules:")
 public void verify_the_user_see_the_following_modules(List<String> expectedModules) {
  Actions actions = new Actions(Driver.getDriver());
  actions.moveToElement(landingPages.topMenuWithAllModules.get(0)).perform();
  List<String> actualModules = new ArrayList<>();

  for (WebElement each : landingPages.topMenuWithAllModules) {
   actualModules.add(each.getText());
  }
  System.out.println("actualModules = " + actualModules);
  Assert.assertEquals(expectedModules, actualModules);

 }


 @And("close browser")
 public void closeBrowser() {
  Driver.closeDriver();
 }

    //US4_Badmaa
    @Given("user on the dashboard page")
    public void userOnTheDashboardPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        loginPage.loginWithConfigurationProp();
    }

    @When("user clicks the {string} module")
    public void userClicksTheModule(String mainModuleName) {
        TrycloudUtililities.clickItem(Driver.getDriver(), wait, landingPages.topMenuWithAllModules, mainModuleName);
    }

    @Then("verify title is {string}")
    public void verifyTitleIs(String title) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(title));
    }

    @And("user click the top-left checkbox of the table")
    public void userClickTheTopLeftCheckboxOfTheTable() {
        filesModulePage.topCheckbox.click();
    }

    @Then("verify all the files are selected")
    public void verifyAllTheFilesAreSelected() {
        for (int i = 0; i < filesModulePage.firstTableColumn.size(); i++) {

            TrycloudUtililities.sleep(2);
            Assert.assertTrue(filesModulePage.firstTableColumn.get(i).isSelected());
        }

      /*  for (WebElement checkBox : filesModulePage.firstTableColumn) {
            wait.waitForElement(checkBox, 4);
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

            js.executeScript("window.scrollBy(10000, 0);");
            js.executeScript("window.scrollBy(10000, 0);");
            Assert.assertTrue(checkBox.isSelected());
        }*/

    }
}
