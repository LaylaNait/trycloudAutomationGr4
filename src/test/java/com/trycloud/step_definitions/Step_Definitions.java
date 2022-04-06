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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Step_Definitions {
 LoginPage loginPage =new LoginPage();
 LandingPages landingPages=new LandingPages();
 FilesModulePage filesModulePage =new FilesModulePage();
 TalkModulePage talkModulePage =new TalkModulePage();
 ContactsModulePage contactsModulePage =new ContactsModulePage();
 Waiter wait =new Waiter(Driver.getDriver());

 String addToFavorites;

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

    //US5
    @When("user clicks action-icon from any file on the page and user chooses the \"Add to favorites\" option")
    public void user_clicks_action_icon_from_any_file_on_the_page(String option) {
        TrycloudUtililities.sleep(3);
        for (int i = 0; i < filesModulePage.actionIcon.size(); i++) {
            TrycloudUtililities.sleep(2);
            addToFavorites = filesModulePage.actualNamesOfFiles.get(0).getText();
            filesModulePage.actionIcon.get(0).click();
        }

    }
    @When("user clicks the {string} sub-module on the left side")
    public void user_clicks_the_sub_module_on_the_left_side(String subModule) {

        Map<String, WebElement> map = new HashMap<>(){{
            put("Favorites", filesModulePage.favorite);
            put("Deleted files", filesModulePage.deletedFiles);
            put("Settings", filesModulePage.settingBtn);
        }};

        map.get(subModule).click();

    }
    @Then("user verifies the chosen file is listed on the table")
    public void user_verifies_the_chosen_file_is_listed_on_the_table() {
        List<String> favorites = new ArrayList<>();
        for (WebElement eachFile : filesModulePage.actualNamesOfFiles){
            favorites.add(eachFile.getText());
        }
        Assert.assertTrue(favorites.contains(addToFavorites));

    }
}
