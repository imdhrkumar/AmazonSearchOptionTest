package TestQuestion;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomateAmazonSearchOption {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/dhruv-kumar/Documents/Selenium/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.amazon.in/");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement searchOption = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        searchOption.sendKeys("wrist watch");
        searchOption.submit();
        ;

//        Thread.sleep(100);
//        WebElement searchForEnteredText = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
//        Thread.sleep(100);
//        searchForEnteredText.click();

        System.out.println("###############");
        System.out.println("############ Select Analogue from Display Option ############");

        String actualDisplayName = null;
        try {
            WebElement selectAnalogueOption = driver.findElement(By.xpath("//span[text()='Analogue']"));
            actualDisplayName = selectAnalogueOption.getText();
            System.out.println("Display Option: "+ actualDisplayName);
            selectAnalogueOption.click();

            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("Analogue Option is not visible.");
        }

        System.out.println("###############");
        System.out.println("############ Select Brand Material as Leather ############");
        System.out.println("\n");

        String actualBrandFilter = null;
        try {
            WebElement selectLeatherOption = driver.findElement(By.xpath("//span[text()='Leather']"));
            actualBrandFilter = selectLeatherOption.getText();
            System.out.println("Brand Name: " + actualBrandFilter);
            selectLeatherOption.click();

            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("Leather Option is not visible.");
        }

        System.out.println("###############");
        System.out.println("############ Select Brands as Titan ############");
        System.out.println("\n");

        List<WebElement> captureAllBrandOption = driver.findElements(By.xpath("//div[@id='brandsRefinements']"));
        String allBrandName = null;
        for (WebElement allBrand : captureAllBrandOption) {
            allBrandName = allBrand.getText();
            driver.findElement(By.xpath("//li[@id='p_89/Titan']//span[@class='a-list-item']//span[text()='Titan']")).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.navigate().refresh();
        }

        System.out.println("###############");
        System.out.println(" ############ Select Discounts as 25% Off or more ############");
        System.out.println("\n");

        String discountName = null;
        try {
            WebElement selectDiscountOption = driver.findElement(By.xpath("//li[@id='p_n_pct-off-with-tax/2665400031']//span//span[text()='25% Off or more']"));
            discountName = selectDiscountOption.getText();
            System.out.println(discountName);
            selectDiscountOption.click();

            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println("Discount Option is not visible.");
            driver.navigate().refresh();
        }

        System.out.println("###############");
        System.out.println("############ Capture 5Th Elements ############");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("\n");

//        List<WebElement> resultsList = driver.findElements(By.xpath("//div[@class='s-desktop-width-max s-desktop-content s-opposite-dir sg-row']"));
//        System.out.println("total no of value"+resultsList.size());
//        for(WebElement totalResult:resultsList){
//          System.out.println(totalResult.getText());
//
//        }
//        int size = resultsList.size();
//        System.out.println("Size of list = " + size);
//        resultsList.get(2).click();

        System.out.println("Click on the 5th Product and Capture all the basic details");

        WebElement clickOn5ThProduct = driver.findElement(By.linkText("Classique Retrogrades Analog Silver Dial Men's Watch-NL90101SL01"));
        clickOn5ThProduct.click();

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        WebElement product5thTitle = driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println("Title of the product: " + product5thTitle.getText());

        if (product5thTitle.isDisplayed()) {
            System.out.println("5Th Product has been matched successfully: " + product5thTitle.getText());
        } else {
            System.out.println("5Th Product has not been matched successfully");
        }

        WebElement product5thPrice = driver.findElement(By.xpath("//span[@class='a-price aok-align-center']//span[@class='a-price-whole']"));
        System.out.println("Price of the product: " + product5thPrice.getText());
        System.out.println("###############");

        WebElement product5thProductDetails = driver.findElement(By.xpath("//div[@id='featurebullets_feature_div']"));
        System.out.println("Product Details: \n" + product5thProductDetails.getText());
        System.out.println("###############");

        String actual5ThFreeDelivery = null;
        WebElement product5thFreeDelivery = driver.findElement(By.xpath("//a[normalize-space()='FREE delivery']"));
        actual5ThFreeDelivery = product5thFreeDelivery.getText();
        System.out.println("Product 5th Free Delivery: " + actual5ThFreeDelivery);
        System.out.println("###############");

        System.out.println("############ Validation Started from here ############");
        System.out.println("############ Validate Display Name ############");
        System.out.println("\n");

        if (actualDisplayName.contains("Analogue")) {
            System.out.println("Display Name has been Matched Successfully");
        } else {
            System.out.println("Display Name has not been Matched Successfully");
        }

        System.out.println("###############");
        System.out.println("############ Validate Brand Material Name ############");

        if (actualBrandFilter.contains("Leather")) {
            System.out.println("Brand Material has been Matched Successfully");
        } else {
            System.out.println("Brand Material has not been Matched Successfully");
        }
        System.out.println("############ Validate Brand Name ############");

        if (allBrandName.contains("Titan")) {
            System.out.println("Brand Name has been Matched Successfully");
        } else {
            System.out.println("Brand Name has not been Matched Successfully");
        }

        System.out.println("###############");
        System.out.println("############ Validate Discounts as 25% Off or more ############");

        if (discountName.contains("25% Off or more")){
            System.out.println("Discount Name has been Matched Successfully");
        }
        else{
            System.out.println("Discount Name has not been Matched Successfully");
        }

        System.out.println("###############");
        System.out.println("############ Fre Delivery is avaliable or not ############");

        if(actual5ThFreeDelivery.contains("FREE delivery")){
            System.out.println("Yes! Free Delivery is available");
        }
        else {
            System.out.println("No! Free Delivery is not available");
        }

        driver.close();
        driver.switchTo().window(tabs2.get(0));

        System.out.println("\n");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        System.out.println("###############");
        System.out.println("Click on 10th Product and Capture all the basic details");

        WebElement clickOn10ThProduct = driver.findElement(By.linkText("Purple Upgrades Analog Off-White Dial Men's Watch-NK1585SL05 / NK1585SL05"));
        clickOn10ThProduct.click();

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs3.get(1));

        WebElement product10thTitle = driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println("Title of the product: " + product10thTitle.getText());

        if (product10thTitle.isDisplayed()) {
            System.out.println("10Th Product has been matched successfully: " + product10thTitle.getText());
        } else {
            System.out.println("10Th Product has not been matched successfully");
        }

        WebElement product10thPrice = driver.findElement(By.xpath("//span[@class='a-price aok-align-center']//span[@class='a-price-whole']"));
        System.out.println("Price of the product: " + product10thPrice.getText());
        System.out.println("###############");

        WebElement product10thProductDetails = driver.findElement(By.xpath("//div[@id='featurebullets_feature_div']"));
        System.out.println("Product Details: \n" + product10thProductDetails.getText());
        System.out.println("###############");

        WebElement product10thFreeDelivery = null;
        product10thFreeDelivery = driver.findElement(By.xpath("//a[normalize-space()='FREE delivery']"));
        String actual10ThFreeDelivery = product10thFreeDelivery.getText();

        System.out.println("Product 10th Free Delivery: " +actual10ThFreeDelivery);
        System.out.println("###############");

        System.out.println("############ Fre Delivery is avaliable or not ############");
        if(actual10ThFreeDelivery.contains("FREE delivery")){
            System.out.println("Yes! Free Delivery is available");
        }
        else {
            System.out.println("No! Free Delivery is not available");
        }

        driver.close();
        driver.switchTo().window(tabs3.get(0));



        System.out.println("\n");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        System.out.println("###############");
        System.out.println("Click on 15th Product and Capture all the basic details");

        WebElement clickOn15ThProduct = driver.findElement(By.linkText("Analog Brown Dial Men's Watch-NL90054WL01 / NL90054WL01"));
        clickOn15ThProduct.click();

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        ArrayList<String> tabs4 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs4.get(1));

        WebElement product15thTitle = driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println("Title of the product: " + product15thTitle.getText());

        if (product15thTitle.isDisplayed()) {
            System.out.println("15Th Product has been matched successfully: " + product15thTitle.getText());
        } else {
            System.out.println("15Th Product has not been matched successfully");
        }

        WebElement product15thPrice = driver.findElement(By.xpath("//span[@class='a-price aok-align-center']//span[@class='a-price-whole']"));
        System.out.println("Price of the product: " + product15thPrice.getText());
        System.out.println("###############");

        WebElement product15thProductDetails = driver.findElement(By.xpath("//div[@id='featurebullets_feature_div']"));
        System.out.println("Product Details: \n" + product15thProductDetails.getText());
        System.out.println("###############");

        WebElement product15thFreeDelivery = null;
        product15thFreeDelivery = driver.findElement(By.xpath("//a[normalize-space()='FREE delivery']"));
        String actual15ThFreeDelivery = product15thFreeDelivery.getText();

        System.out.println("Product 15th Free Delivery: " +actual15ThFreeDelivery);
        System.out.println("###############");

        System.out.println("############ Fre Delivery is avaliable or not ############");
        if(actual15ThFreeDelivery.contains("FREE delivery")){
            System.out.println("Yes! Free Delivery is available");
        }
        else {
            System.out.println("No! Free Delivery is not available");
        }

        driver.close();
        driver.switchTo().window(tabs4.get(0));




    }
    }
