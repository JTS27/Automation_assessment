package pack1;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class ClassT {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = TestSetup.getDriver();
    }

    @AfterAll
    public static void tearDown() {
      TestSetup.quitDriver();
    }

    @Test
    public void Test_01() {
      driver.manage().window().maximize();
      
        ClassA classA = new ClassA();
        
        String currentUrl = classA.website(ClassA.url);

        assertEquals(ClassA.url, currentUrl);
    }
    
    @Test
    public void Test_02() {
      TestSetup.ThreadS();
      
        WebElement AcceptButton = driver.findElement(By.xpath("//button[text()='السعودية، ريال سعودي']"));
        TestSetup.highlightElement(AcceptButton);
        TestSetup.ThreadS();
        AcceptButton.click();
    }
    
    @Test
    public void Test_03() {
      TestSetup.ThreadS();
      
        WebElement ChaletsButton = driver.findElement(By.xpath("//a[@id='uncontrolled-tab-example-tab-chalets']"));
        TestSetup.highlightElement(ChaletsButton);
        ChaletsButton.click();
        ClassA.AssertElement("//input[@placeholder='اختر مدينة']");
    }
    
    @Test
    public void Test_04() {
      TestSetup.ThreadS();

        WebElement CityList = driver.findElement(By.xpath("//input[@placeholder='اختر مدينة']"));
        TestSetup.highlightElement(CityList);
        CityList.click();
        
        
        WebElement CityButton = driver.findElement(By.xpath("//button[contains(., 'المدينة المنورة') and @class='MuiButtonBase-root sc-cmUJln jCAsMp']"));
        TestSetup.highlightElement(CityButton);
        TestSetup.ThreadS();
        CityButton.click();
      ClassA.verifySelectedCity("المدينة المنورة");
}
    
    @Test
    public void Test_05() {
      TestSetup.ThreadS();
      
        WebElement SearchButton = driver.findElement(By.xpath("//button[@data-testid='searchBox_searchChaletsButton']"));
        TestSetup.highlightElement(SearchButton);
        SearchButton.click();
        
    }
    
    @Test
    public void Test_06() {
      TestSetup.ThreadS();
      
        WebElement ChaletsChooseButton = driver.findElement(By.xpath("//div[2]/div[2]/div[2]/div[2]"));
        TestSetup.highlightElement(ChaletsChooseButton);
        ChaletsChooseButton.click();
        ClassA.verifySelectedChalet();
        
    }
    
    @Test
    public void Test_07() {
      TestSetup.ThreadS();
      
      WebElement InDateButton = driver.findElement(By.xpath("//div[2]/div[2]/div[2]/div[1]/div/div/div[1]/div[2]"));
      TestSetup.highlightElement(InDateButton);
      TestSetup.scrollElement(InDateButton);
        InDateButton.click();
        ClassA.SelectRandomMonth();
        ClassA.SelectRandomDay();
    }
    
    @Test
    public void Test_08() {
      TestSetup.ThreadS();
      
      WebElement OutDateButton = driver.findElement(By.xpath("//div[2]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[2]"));
      TestSetup.highlightElement(OutDateButton);
        OutDateButton.click();
        ClassA.SelectRandomDay();
        
    }
    
    @Test
    public void Test_09() {
      TestSetup.ThreadS();
      
      WebElement Bookbutton = driver.findElement(By.xpath("//div/div[2]/div[2]/div[2]/div[2]/button"));
      TestSetup.highlightElement(Bookbutton);
        Bookbutton.click();
        TestSetup.ThreadS();
        TestSetup.ThreadS();
        TestSetup.ThreadS();
        ClassA.AssertElement("//div/div[2]/div[1]/div/div[1]/div[2]/div");

    }
    
}