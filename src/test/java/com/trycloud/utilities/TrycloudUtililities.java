package com.trycloud.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TrycloudUtililities {

    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedInTitle) {

        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles) {

            driver.switchTo().window(each);

            System.out.println("Current URL: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }

        //5. Assert:Title contains “expectedInTitle”
        String actualTitle = driver.getTitle();
        assertTrue(actualTitle.contains(expectedInTitle));
    }


    public static void verifyTitle(WebDriver driver, String expectedTitle) {

        assertEquals(driver.getTitle(), expectedTitle);

    }

    /**
     * This method will accept a string as expected value and verify actual url contains the value
     *
     * @param expectedInURL
     */

    public static void verifyURLContains(String expectedInURL) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));
    }

    public static List<String> dropDownOptionsAsString(WebElement dropDownElement) {
        Select select = new Select(dropDownElement);
        List<WebElement> actualOptionsAsWebElement = select.getOptions();
        List<String> actualMonths = new ArrayList<>();
        for (WebElement element : actualOptionsAsWebElement) {
            actualMonths.add(element.getText());
        }
        return actualMonths;
    }

    /**
     * This method will accept a group radio buttons as a List of WebElement.
     * It will loop through the List, and click to the radio button with provided attributeValue
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue){

        for (WebElement each : radioButtons) {

            if (each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }
        }
    }
    public static void verifyRemovedFromFavorites(String removed,By locator) {
        String actualFavorite = "";
        for (int i = 0; i < Driver.getDriver().findElements(locator).size(); i++) {
            if (!Driver.getDriver().findElements(locator).get(i).getText().equalsIgnoreCase(removed)) {
                actualFavorite = Driver.getDriver().findElements(locator).get(i).getText();

            }
        }
        System.out.println("removed = " + removed);
        System.out.println("actualFavorite = " + actualFavorite);
        Assert.assertFalse(removed.equalsIgnoreCase(actualFavorite));
    }
    public static boolean isItemDisplayed(WebDriver driver, List<WebElement> wl, String s){

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        List<String> sl = new ArrayList<>();

        for (WebElement e : wl)
            sl.add(e.getText());
        return sl.contains(s);
    }
    /**
     * Clicks an item identified by its name (String) among a list (WebElements)
     * @param driver : WebDriver
     * @param waiter : Waiter
     * @param wl : list of web elements
     * @param name : string identifying the item
     */
    public static void clickItem(WebDriver driver, Waiter waiter, List<WebElement> wl, String name){
        Actions a = new Actions(driver);
        a.moveToElement(wl.get(0)).perform();
        for (int i = 0; i < wl.size(); i++){
            waiter.fluentWaitForElement(wl.get(i));
            a.moveToElement(wl.get(i)).perform();
            if (wl.get(i).getText().equals(name)){
                wl.get(i).click();
                break;
            }
        }
    }
    public static void uploadFile(String filePath, WebElement uploadLink, WebElement progressBar) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
        sleep(5);

        uploadLink.sendKeys(filePath);

        wait.until(ExpectedConditions.invisibilityOf(progressBar));

    }
    public static List<String> getText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public static void clickModule (String subModule,Map<String,WebElement>map){
     try {
         map.get(subModule).click();
     }catch (Exception e){
        e.printStackTrace();
    }}


    public static void searchForUser(String userName,WebElement userSearch) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        userSearch.sendKeys(userName);
        //  Driver.getDriver().findElement(By.xpath("//input[@placeholder='Search conversations or users']")).sendKeys(userName);
        String locatorForUserName = "//a[@aria-label='Conversation, " + userName + "']";
        WebElement searchResultWithUser = Driver.getDriver().findElement(By.xpath(locatorForUserName));

        wait.until(ExpectedConditions.visibilityOf(searchResultWithUser));

        searchResultWithUser.click();

    }

}

