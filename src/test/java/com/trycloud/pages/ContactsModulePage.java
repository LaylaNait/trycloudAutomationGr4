package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactsModulePage {
    public ContactsModulePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //13
    @FindBy(xpath = "//div[@class='vue-recycle-scroller__item-view']")
   public List<WebElement> contactList;


}
