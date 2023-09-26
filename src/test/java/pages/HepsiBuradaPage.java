package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HepsiBuradaPage {

    public HepsiBuradaPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//button[text()='Kabul et']")
    public WebElement cookieAccept;

    @FindBy(xpath = "//div[@class='searchBoxOld-M1esqHPyWSuRUjMCALPK']")
    public WebElement searchBoxParent;

    @FindBy(xpath = "//div[@role='combobox']/input")
    public WebElement searchBox;

    @FindBy(id = "i0")
    public WebElement firstResult;

    @FindBy(id = "addToCart")
    public WebElement addToCart;

    @FindBy(xpath = "//button[normalize-space()='Sepete git']")
    public WebElement goToCart;
    @FindBy(xpath = "//a[@class='close_2kUgV']")
    public WebElement closeButton;
    @FindBy(xpath = "//button[@id='continue_step_btn']")
    public WebElement continueToShopping;



}
