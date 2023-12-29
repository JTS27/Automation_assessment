package pack1;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ClassA {
    public static String url = "https://global.almosafer.com/ar/";
    public static WebDriver driver = TestSetup.getDriver();
    
    public String website(String url) {
        WebDriver driver = TestSetup.getDriver();
        driver.get(url);
        System.out.print(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
    

    public static void SelectRandomMonth() {
        WebElement monthDropdown = driver.findElement(By.xpath("//div[2]/div/div/div/div[2]/div[2]/form/div/div[1]/select"));
        List<WebElement> enabledMonths = monthDropdown.findElements(By.xpath("//option[not(@disabled)]"));

        Random rand = new Random();
        int randomIndex = rand.nextInt(enabledMonths.size());
        
        enabledMonths.get(randomIndex).click();
    }

    
    public static void SelectRandomDay() {
      
        List<WebElement> enabledDays = driver.findElements(By.xpath("//div[@class='DayPicker-Day' and not(contains(@class, 'DayPicker-Day--disabled'))]"));
        int randomIndex = new Random().nextInt(enabledDays.size());
      System.out.print(enabledDays.size());
      System.out.print("---");
      System.out.print(randomIndex);
        WebElement randomDay = enabledDays.get(randomIndex);
        randomDay.click();
    }
    

    public static void AssertElement(String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            TestSetup.CheckElement(element);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Couldn't find element");
            e.printStackTrace();
        }
    }
    
    
    public static void verifySelectedCity(String expectedCity) {
        WebElement selectedCityInput = driver.findElement(By.xpath("//input[@placeholder='اختر مدينة']"));

        String displayedCity = selectedCityInput.getAttribute("value").trim();

        assertEquals("Selected city does not match the displayed city in the search results", expectedCity, displayedCity);
        TestSetup.ThreadS();
        System.out.print(displayedCity);

    }

    
    public static void verifySelectedChalet() {
      TestSetup.ThreadS();

      WebElement propertyCardNameElement = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div[1]/div[2]/div"));

      String propertyCardName = propertyCardNameElement.getText().trim();

      String desiredID = "3369";

      System.out.println("Property Card Name: " + propertyCardName);

      assertTrue("Property card name does not contain the desired ID", propertyCardName.contains(desiredID));

    }



}