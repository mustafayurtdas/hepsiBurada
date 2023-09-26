package utilities;

import org.openqa.selenium.*;

public class ReusableMethods {


    //Click Method
    public static void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", element);
        }
    }

    //JS Scroll
    public static void scroll(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    //SendKeys Method
    public static void sendKeys(WebElement element,String... text) {
        for (String t : text) {
            try {
                element.sendKeys(t);
            } catch (Exception e) {
                JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
                js.executeScript("arguments[0].value='" + t + "'", element);
            }
        }
    }


    //   HARD WAIT WITH THREAD.SLEEP
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}