package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TalkModulePage {
    public TalkModulePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@type='text']")
   public WebElement searchInputTalk;

    @FindBy(xpath = "//span[@class='acli__content__line-one__title']")
   public List<WebElement> usersNamesChat;

    @FindBy(xpath = "//ul//a[contains(@aria-label,'Conversation, User46')]")
   public WebElement userNameSearchedFor;

   /* @FindBy(xpath = "//div[@class='new-message']")
   public WebElement messageBox;*/

    @FindBy(xpath = "//div[@contenteditable='true']")
    public WebElement messageBox;

    @FindBy(xpath = "//button[@type='submit']")
   public WebElement submitBtnForChat;

    @FindBy(xpath = "//div[@class='message__main__text']//div[@class='rich-text--wrapper']")
   public List<WebElement> messageOnConversationLog;
}
