package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.HepsiBuradaPage;
import utilities.ConfigReader;

import java.util.Set;

import static utilities.Driver.*;
import static utilities.ReusableMethods.*;


public class HepsiBuradaStepDefinitions {

    HepsiBuradaPage hepsiBuradaPage = new HepsiBuradaPage();
    String firstPageId;
    String secondPageId;

    @Given("go to {string}")
    public void goTo(String url) {
        getDriver().get(ConfigReader.getProperty(url));
    }

    @When("search for {string}")
    public void search_for(String string) {
        try {
            click(hepsiBuradaPage.cookieAccept);
        } catch (Exception ignored) {

        }
        waitFor(1);
        click(hepsiBuradaPage.searchBoxParent);
        sendKeys(hepsiBuradaPage.searchBox, string, String.valueOf(Keys.ENTER));
    }


    @Then("go to product and click it")
    public void goToProductAndClickIt() {
        firstPageId = getDriver().getWindowHandle();

        scroll(hepsiBuradaPage.firstResult);
        click(hepsiBuradaPage.firstResult);

    }

    @And("add to cart")
    public void addToCart() {
        Set<String> AllPagesId = getDriver().getWindowHandles();

        for (String w : AllPagesId) {
            if (w.equals(firstPageId)) {
                continue;
            }
            secondPageId = w;
        }
        getDriver().switchTo().window(secondPageId);

        click(hepsiBuradaPage.addToCart);

    }

    @And("click go to cart")
    public void clickGoToCart() {
        click(hepsiBuradaPage.goToCart);
    }

    @And("click the {string} section")
    public void clickTheSection(String text) {
        WebElement element = getDriver().findElement(By.xpath("//span[contains(text(),'" + text + "')]"));
        click(element);
    }

    @Then("verify {string}")
    public void verify(String text) {
        String str = getDriver().findElement(By.xpath("//*[contains(text(),'" + text + "')]")).getText();
        Assert.assertTrue(str.contains(text));
        click(hepsiBuradaPage.closeButton);
    }

    @And("click the Alışverişi tamamla button")
    public void clickTheAlışverişiTamamlaButton() {
        click(hepsiBuradaPage.continueToShopping);
    }

    @And("close driver")
    public void closeTheDriver() {
        closeDriver();
    }
}
