package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesModulePage {
    public FilesModulePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//ul[@id='appmenu']/li[@data-id='files']")
    public WebElement filesModule;

    @FindBy(xpath = "//label[@for='select_all_files']")
    public WebElement topCheckbox;

    @FindBy(xpath = "//td[@class='selection']")
   public List<WebElement> firstTableColumn;

    @FindBy(xpath = "//div[@id='app-content-files']")
    public WebElement filesContentSection;

    public By pageFooter = By.xpath("//tfoot");
    //5
    @FindBy(xpath = "//div[@id='app-content-files']//div[contains(@class, 'fileActionsMenu')]")
    public WebElement filesActionsMenu;

    @FindBy(xpath = "//div[@id='app-content-files']//td//a[@data-action='menu']")
    public List<WebElement> actionIcon;

    @FindBy(xpath = "//a//span[contains(.,'Add to favorites')]")
   public WebElement addToFavorites;
    //6
    @FindBy(xpath = "//a//span[contains(.,'Remove from favorites')]")
   public WebElement removeFromFavorites;

    @FindBy(xpath = "//a[contains(.,'Favorites')]")
   public WebElement favorite;
    //6
    @FindBy(xpath = "//div[@id='app-content-files']//*[@class='innernametext']")

    public List <WebElement> actualNamesOfFiles;
    //6 /7 /8 /9
    @FindBy(xpath = "//span[@class='icon icon-add']")
    public WebElement addIcon;
    @FindBy(xpath = "//div[@class='newFileMenu popovermenu bubble menu open menu-left']")
    public WebElement addIconMenu;

    @FindBy(xpath = "//a[@data-templatename='New folder']")
    public WebElement newFolder;

    @FindBy(xpath = "//input[contains(@value,'New folder')]")
    public WebElement inputFolderName;
    //6 /7 /8 /9

    //7
    @FindBy(xpath = "//span[.='Upload file']")
   public WebElement uploadFiles;

    @FindBy(xpath = "//tr[@data-file='EugeneFileAdded']")
    public WebElement newFolderLocation;

    @FindBy(xpath = "//input[@class='icon-confirm']")
   public WebElement submitIcon;

    //8
    @FindBy(xpath = "//span[contains(.,'Delete file')]")
   public WebElement deleteFile;

    @FindBy(xpath = "//div[@id='app-content-trashbin']//*[@class='innernametext']")
    public List<WebElement> allTrashBinFiles;

    @FindBy(xpath = "//*[contains(@id, 'app-navigation')]/ul")
    public WebElement filesLeftSideSubmodulesList;


    @FindBy(xpath = "//a[contains(.,'Deleted files')]")
   public WebElement deletedFiles;
    //9
    @FindBy(xpath = "//span[.='Details']")
    public WebElement detailsOption;

    @FindBy(xpath = "//a[contains(@id,'commentsTabView')]")
   public WebElement commentsBtn;

    @FindBy(xpath = "//div[@class='message']")
   public WebElement commentsInput;

    @FindBy(xpath = "//input[@class='submit icon-confirm has-tooltip']")
   public WebElement commentSubmitBtn;

    @FindBy(xpath = "//button[contains(.,'Settings')]")
    //10
   public WebElement settingBtn;
    @FindBy(xpath = "//div[@id='app-settings-content']//input[@type='checkbox']")
   public List<WebElement> settingOptions;
    @FindBy(xpath = "//a[@class='icon-quota svg']/p")
   public WebElement usedStorageParagraph;
    @FindBy(xpath = "//div[@id='uploadprogressbar']")
    public WebElement uploadProgressBar;


    //5
    @FindBy(xpath = "//span[@class='fileactions']/a[@href='#' and @data-action='menu']")
    public List<WebElement> threeDots;

    @FindBy(xpath = "//span[contains(text(), 'favorites')]")
    public WebElement removeOrAdd;

    @FindBy(xpath = "//a[@class='action action-menu permanent' and @data-action='menu']")
    public List <WebElement> threeDotsUnderFavorite;

    @FindBy(xpath = "//span[@class='innernametext']")
    public List <WebElement> nameOfFile;

    @FindBy(xpath = "//a[.='Favorites']")
    public WebElement favoritesTab;

}
