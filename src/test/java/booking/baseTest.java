package booking;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public class baseTest
{
    public WebDriver driver ;
    SoftAssert softAssertion= new SoftAssert();
    Faker fakeData = new Faker();
    String first_name = fakeData.name().firstName();
    String last_name = fakeData.name().lastName();
    String phone_number = fakeData.number().digits(11);
    String adress = fakeData.address().fullAddress();
    String City = fakeData.address().city();
    String State = fakeData.address().state();
    String user = first_name+last_name;


    @BeforeSuite
    public void openUrl()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\clt\\Downloads\\New folder\\chromedriver.exe");
        driver =  new ChromeDriver();
        driver.get("http://newtours.demoaut.com/mercuryregister.php");
    }

    @AfterSuite
    public void close()
    {
        driver.close();
    }
}
