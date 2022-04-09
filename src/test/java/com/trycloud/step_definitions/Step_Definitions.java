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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.*;

public class Step_Definitions {
    LoginPage loginPage = new LoginPage();
    LandingPages landingPage = new LandingPages();
    FilesModulePage filesModulePage = new FilesModulePage();
    TalkModulePage talkModulePage = new TalkModulePage();
    ContactsModulePage contactsModulePage = new ContactsModulePage();
    Waiter wait = new Waiter(Driver.getDriver());

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
        landingPage.userBtn.click();
        landingPage.logOutBtn.click();
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
        actions.moveToElement(landingPage.topMenuWithAllModules.get(0)).perform();
        List<String> actualModules = new ArrayList<>();

        for (WebElement each : landingPage.topMenuWithAllModules) {
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
        TrycloudUtililities.clickItem(Driver.getDriver(), wait, landingPage.topMenuWithAllModules, mainModuleName);
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

    List<String> listOfFilesAddedToFavorites = new ArrayList<>();
    List<String> listOfFilesUnderFavoritesTab = new ArrayList<>();
    List<String> listOfRemovedFiles = new ArrayList<>();
    int sizeOfListOfFiles = 0;

    @Given("user on the dashboard page with {string} and {string}")
    public void user_on_the_dashboard_page(String username, String password) {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginBtn.click();
    }

    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String string) {
        landingPage.dashboardModule.get(1).click();
    }

    @When("the user clicks action-icon from any file on the page and user choose the Add to favorites option")
    public void the_user_clicks_action_icon_from_any_file_on_the_page()  {
        //loop through all action icons that are visible and displayed
        sizeOfListOfFiles = filesModulePage.threeDots.size();
        for ( int i=0; i<filesModulePage.threeDots.size(); i++) {
            filesModulePage.threeDots.get(i).click();
            String addOrRemoveText = filesModulePage.removeOrAdd.getText();
            System.out.println("Add or Remove: " + addOrRemoveText);
            if (addOrRemoveText.equals("Add to favorites")) {
                //add to favorites
                filesModulePage.removeOrAdd.click();
                String file = filesModulePage.nameOfFile.get(i).getText();
                System.out.println(file);
                listOfFilesAddedToFavorites.add(file);
            } else {
                //remove from favorites
                filesModulePage.removeOrAdd.click();
                Driver.getDriver().navigate().refresh();
                String file = filesModulePage.nameOfFile.get(i).getText();
                System.out.println(file);
                listOfRemovedFiles.add(file);

            }
        }
    }

    @And("user click the Favorites sub-module on the left side")
    public void user_click_the_favorites_sub_module_on_the_left_side() {
        filesModulePage.favoritesTab.click();
    }

    @When("the user clicks the Files module")
    public void the_user_clicks_the_files_module() {
        landingPage.dashboardModule.get(1).click();
    }
    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() throws InterruptedException {

        for ( int i= 0; i<filesModulePage.threeDots.size(); i++) {
            Thread.sleep(1000);
            if ( filesModulePage.threeDotsUnderFavorite.get(i).isDisplayed()) {
                WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
                wait.until(ExpectedConditions.elementToBeClickable(filesModulePage.nameOfFile.get(i)));
                String file = filesModulePage.nameOfFile.get(i).getText();
                System.out.println("file name under favorite: " + file);
                Thread.sleep(1000);
                listOfFilesUnderFavoritesTab.add(file);
            }
        }
        System.out.println(listOfFilesUnderFavoritesTab);
        System.out.println(listOfFilesAddedToFavorites);

        Assert.assertTrue(listOfFilesUnderFavoritesTab.containsAll(listOfFilesAddedToFavorites));
    }
}
