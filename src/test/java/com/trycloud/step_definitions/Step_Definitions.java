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
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

import static com.trycloud.utilities.TrycloudUtililities.*;


public class Step_Definitions {
    LoginPage loginPage = new LoginPage();
    LandingPages landingPage = new LandingPages();
    FilesModulePage filesModulePage = new FilesModulePage();
    TalkModulePage talkModulePage = new TalkModulePage();
    ContactsModulePage contactsModulePage = new ContactsModulePage();
    Waiter wait = new Waiter(Driver.getDriver());
    String fileToBeDeleted;

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

    @When("user clicks the {string} module")
    public void userClicksTheModule(String mainModuleName) {
        clickItem(Driver.getDriver(), wait, landingPage.topMenuWithAllModules, mainModuleName);
    }

    @Then("verify title is {string}")
    public void verifyTitleIs(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(expectedTitle.contains(actualTitle));

     


    }

    @And("user click the top-left checkbox of the table")
    public void userClickTheTopLeftCheckboxOfTheTable() {
        filesModulePage.topCheckbox.click();
    }

    @Then("verify all the files are selected")
    public void verifyAllTheFilesAreSelected() {
        for (int i = 0; i < filesModulePage.firstTableColumn.size(); i++) {
            TrycloudUtililities.sleep(2);
            Assert.assertTrue(verifyAllSelected());
        }
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
    public void the_user_clicks_action_icon_from_any_file_on_the_page() {
        //loop through all action icons that are visible and displayed
        sizeOfListOfFiles = filesModulePage.threeDots.size();
        for (int i = 0; i < filesModulePage.threeDots.size(); i++) {
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

        for (int i = 0; i < filesModulePage.threeDots.size(); i++) {
            Thread.sleep(1000);
            if (filesModulePage.threeDotsUnderFavorite.get(i).isDisplayed()) {
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

    //US8
    @And("user clicks action-icon from any file on the page")
    public void userClicksActionIconFromAnyFileOnThePage() {
        for (int i = 0; i < filesModulePage.actionIcon.size(); i++) {
            TrycloudUtililities.sleep(2);
            fileToBeDeleted = filesModulePage.actualNamesOfFiles.get(0).getText();
            filesModulePage.actionIcon.get(0).click();
            break;
        }
    }

    @And("user chooses the {string} option")
    public void userChoosesTheOption(String option) {
        TrycloudUtililities.sleep(3);
        filesModulePage.actionIcon.get(0).findElement(By.xpath("//a[contains(.,'" + option + "')]")).click();
    }

    @When("user clicks the {string} sub-module on the left side")
    public void userClicksTheSubModuleOnTheLeftSide(String subModule) throws InterruptedException {
        filesModulePage.filesLeftSideSubmodulesList.findElement(By.xpath("//a[contains(.,'" + subModule + "')]")).click();
        Thread.sleep(3);
    }

    @Then("verifies the deleted file is displayed on the page")
    public void verifiesTheDeletedFileIsDisplayedOnThePage() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(20000, 0);");
        js.executeScript("window.scrollBy(20000, 0);");


        List<String> filesNameInTrash = new ArrayList<>();
        for (int i = 0; i < filesModulePage.allTrashBinFiles.size(); i++) {
            js.executeScript("arguments[0].scrollIntoView(true);", filesModulePage.allTrashBinFiles.get(i));
            js.executeScript("window.scrollBy(1000, 0);");
            filesNameInTrash.add(filesModulePage.allTrashBinFiles.get(i).getText());

        }
        Assert.assertTrue(filesNameInTrash.contains(fileToBeDeleted));
    }



  
//US9

    @And("user clicks the comments option")
    public void userClicksTheCommentsOption() {
        filesModulePage.commentsBtn.click();
    }
    @And("user writes a {string} inside the input box")
    public void userWritesAInsideTheInputBox(String comment) {
        filesModulePage.commentsInput.sendKeys(comment);
    }

    @And("user clicks the submit button to post it")
    public void userClicksTheSubmitButtonToPostIt() {
        filesModulePage.commentSubmitBtn.click();
    }

    @Then("verifies the {string} is displayed in the comment section")
    public void verifiesTheIsDisplayedInTheCommentSection(String comment) {
        TrycloudUtililities.sleep(3);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 3);
        wait.until(ExpectedConditions.visibilityOf(landingPage.allComment.get(0)));
        List<String> listOfComment = new ArrayList<>();
        for (WebElement comments : landingPage.allComment) {
            listOfComment.add(comments.getText());
        }
        System.out.println("listOfComment = " + listOfComment);
        Assert.assertTrue(isItemDisplayed(Driver.getDriver(), landingPage.allComment,comment));
    }









    //US10 Zaier
    @When("user clicks {string} on the left bottom corner")
    public void user_clicks_on_the_left_bottom_corner(String submodule) {
        FilesModulePage filesModulePage = new FilesModulePage();
        Map<String, WebElement> map = new HashMap<>() {{
            put("Favorites", filesModulePage.favorite);
            put("Deleted f", filesModulePage.deletedFiles);
            put("Settings", filesModulePage.settingBtn);
        }};

        clickModule(submodule, map);
    }

    @Then("user should be able to click any buttons")
    public void user_should_be_able_to_click_any_buttons() {
        for (WebElement e : filesModulePage.settingOptions)
            Assert.assertTrue(e.isEnabled());
    }

    double initialUsage;
    @When("user checks the current storage usage")
    public void user_checks_the_current_storage_usage() {
        initialUsage = Double.parseDouble(filesModulePage.usedStorageParagraph.getText().split(" ")[0]);
    }

    @When("user uploads file with the {string} option")
    public void user_uploads_file_with_the_option(String option) {

        TrycloudUtililities.sleep(2);

        try {
            wait.fluentWaitForElement(getDescendent(filesModulePage.filesContentSection, filesModulePage.pageFooter));
        } catch (TimeoutException e){
            wait.fluentWaitForElement(filesModulePage.filesContentSection);
        }

        filesModulePage.addIcon.click();

        clickItem(filesModulePage.addIconMenu, "span", option);

        String path = "/Users/zaieraouani/Desktop/TestUpload001.png";

        TrycloudUtililities.sleep(2);
        Driver.getDriver().findElement(By.xpath("//input[@id='file_upload_start']")).sendKeys(path);

        //input[@type='file']

        TrycloudUtililities.sleep(2);
        wait.waitForInvisibility(filesModulePage.uploadProgressBar, 10);
        //TrycloudUtililities.sleep(2);
    }

    @When("user refreshes the page")
    public void user_refreshes_the_page() {
        Driver.getDriver().navigate().refresh();
    }

    @Then("user should be able to see storage usage is increased")
    public void user_should_be_able_to_see_storage_usage_is_increased() {
        double current = Double.parseDouble(filesModulePage.usedStorageParagraph.getText().split(" ")[0]);

        Assert.assertTrue(current > initialUsage);

        for (int i = 0; i < filesModulePage.actionIcon.size(); i++) {
            if (filesModulePage.nameOfFile.get(i).getText().equalsIgnoreCase("TestUpload001")) {
                filesModulePage.actionIcon.get(i).click();
                Driver.getDriver().findElement(By.xpath("//span[.='Delete file']")).click();
                break;
            }
        }
    }
    //US11 Anna

    @When("user searches {string} from the search box")
    public void user_search_user_from_the_search_box(String itemToSearch) {
        talkModulePage.usersNamesChat.get(0).findElement(By.xpath("//ul//a[contains(@aria-label,'Conversation, " + itemToSearch + "')]")).click();
    }
    @When("user writes a message {string}")
    public void user_write_a_message(String message) throws InterruptedException {
         Thread.sleep(3000);
        talkModulePage.messageBox.sendKeys(message);
    }
    @When("user clicks to submit button")
    public void user_clicks_to_submit_button() throws InterruptedException {
         Thread.sleep(3000);
        talkModulePage.submitBtnForChat.click();
    }
    @Then("user should be able to see the {string} is displayed on the conversation log")
    public void the_user_should_be_able_to_see_the_message_is_displayed_on_the_conversation_log(String message) {
        List<String> messages = new ArrayList<>();
        for(WebElement e : talkModulePage.messageOnConversationLog){
            messages.add(e.getText());
        }
        Assert.assertTrue(messages.contains(message));

    }


       //US13 Nazar
    @Then("user verifies there are at least {int} contact names in the list")
    public void userVerifiesThereAreAtLeastContactNamesInTheList(int expectedSize) {
        int actualSize = Driver.getDriver().findElements(By.xpath("//div[@id='contacts-list']/div/div")).size();
        System.out.println("actualSize = " + actualSize);
        Assert.assertTrue(actualSize>=expectedSize);



    }

   //US14 madina
   @When("user clicks the magnifier icon on the right top")
   public void user_clicks_the_magnifier_icon_on_the_right_top() {
     landingPage.homePageSearchBtn.click();
   }
    @When("user searches any existing {string} name")
    public void user_searches_any_existing_name(String string) {
        landingPage.homePageSearchBox.sendKeys("Calendar"+ Keys.ENTER);
    }
    @Then("verifies the app displays expected {string} option")
    public void verifies_the_app_displays_expected_option(String string) {
        landingPage.expectedResultOption.isDisplayed();
    }






}


