package com.trycloud.step_definitions;

import com.trycloud.pages.*;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.Waiter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_Definitions {
 LoginPage loginPage =new LoginPage();
 LandingPages landingPages=new LandingPages();
 FilesModulePage filesModulePage =new FilesModulePage();
 TalkModulePage talkModulePage =new TalkModulePage();
 ContactsModulePage contactsModulePage =new ContactsModulePage();
 Waiter wait =new Waiter(Driver.getDriver());



}
