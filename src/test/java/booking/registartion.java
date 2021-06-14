package booking;

import com.github.javafaker.Faker;
import com.google.common.base.CharMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class registartion extends baseTest
{
    @Test(priority = 1)
    public void register() throws InterruptedException {
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys(first_name);

        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys(last_name);

        WebElement phone = driver.findElement(By.name("phone"));
        phone.clear();
        phone.sendKeys(phone_number);

        WebElement Email = driver.findElement(By.id("userName"));
        Email.sendKeys(first_name+last_name+"@gmail.com");

        WebElement Adress = driver.findElement(By.name("address1"));
        Adress.sendKeys(adress);

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys(City);

        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys(State);

        WebElement postalCode = driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("11815");

        WebElement Country = driver.findElement(By.name("country"));
        Select countryvalue = new Select(Country);
        countryvalue.selectByValue("56");

        String user = first_name+last_name;
        WebElement username = driver.findElement(By.name("email"));
        username.sendKeys(user);
        String user_name = username.getText();
        System.out.println(user_name);


        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("123456789");

        WebElement confirmPassword = driver.findElement(By.name("confirmPassword"));
        confirmPassword.sendKeys("123456789");

        WebElement register = driver.findElement(By.name("register"));
        register.click();


        WebElement element = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b"));
        String strText = element.getText();

        if (strText.contains(user_name)) {
            System.out.println(" text is found ");
        } else
            System.out.println(" text is not found ");
    }

    @Test(priority = 2)
    public void signIn() throws InterruptedException
    {
        driver.findElement(By.linkText("sign-in")).click();

        WebElement signin_username = driver.findElement(By.name("userName"));
        signin_username.sendKeys(user);

        WebElement signin_password = driver.findElement(By.name("password"));
        signin_password.sendKeys("123456789");

        driver.findElement(By.name("login")).click();
    }

    @Test(priority = 3)
    public void booking()
    {
        WebElement passCount = driver.findElement(By.name("passCount"));
        Select passCount_value = new Select(passCount);
        passCount_value.selectByValue("2");
        WebElement passCount_selected = passCount_value.getFirstSelectedOption();
        String passCount_selected_value = passCount_selected.getText();
        String theDigits = CharMatcher.inRange('0', '9').retainFrom(passCount_selected_value); // 123

        WebElement fromPort = driver.findElement(By.name("fromPort"));
        Select fromPort_value = new Select(fromPort);
        fromPort_value.selectByValue("Zurich");
        WebElement option = fromPort_value.getFirstSelectedOption();
        String depart_value = option.getText();

        WebElement fromMonth = driver.findElement(By.name("fromMonth"));
        Select fromMonth_value = new Select(fromMonth);
        fromMonth_value.selectByValue("3");

        WebElement fromDay = driver.findElement(By.name("fromDay"));
        Select fromDay_value = new Select(fromDay);
        fromDay_value.selectByValue("13");

        WebElement toPort = driver.findElement(By.name("toPort"));
        Select toPort_value = new Select(toPort);
        toPort_value.selectByValue("Paris");
        WebElement option2 = toPort_value.getFirstSelectedOption();
        String return_value = option2.getText();

        WebElement toMonth = driver.findElement(By.name("toMonth"));
        Select toMonth_value = new Select(toMonth);
        toMonth_value.selectByValue("9");

        WebElement toDay = driver.findElement(By.name("toDay"));
        Select toDay_value = new Select(toDay);
        toDay_value.selectByValue("3");

        WebElement airline = driver.findElement(By.name("airline"));
        Select airline_value = new Select(airline);
        airline_value.selectByVisibleText("Pangea Airlines");

        driver.findElement(By.name("findFlights")).click();

        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[7]/td[1]/input")).click();
        WebElement depart = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[7]/td[2]/font/b"));
        String depart_str = depart.getText();
        WebElement depart_fees = driver.findElement(By.xpath("//html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[8]/td/font/font/b"));
        String depart_fees_str = depart_fees.getText();
        WebElement depart_Date = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[1]/td/table/tbody/tr[2]/td[2]/b/font"));
        String depart_Date_str = depart_Date.getText();

        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[7]/td[1]/input")).click();
        WebElement Return = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[7]/td[2]/font/b"));
        String return_str = Return.getText();
        WebElement Return_fees = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[8]/td/font/font/b"));
        String return_fees_str = Return_fees.getText();
        System.out.println(return_str);
        WebElement Return_Date = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[1]/td/table/tbody/tr[2]/td[2]/b/font"));
        String Return_Date_str = Return_Date.getText();

        String Depart_Flight = depart_value+" to "+return_value;
        String Return_Flight = return_value+" to "+depart_value;

        driver.findElement(By.name("reserveFlights")).click();

        //Assert

        WebElement Depart_info = driver.findElement(By.className("frame_header_info"));
        String Depart_info_str = Depart_info.getText();

        softAssertion.assertEquals(Depart_info_str,Depart_Flight);

        WebElement data_left = driver.findElement(By.className("data_left"));
        String data_left_text = data_left.getText();


        WebElement depart_date = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]"));
        String depart_date_str = depart_date.getText();

        softAssertion.assertEquals(depart_date_str,depart_Date_str);

        WebElement return_info = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td[1]"));
        String return_info_str = return_info.getText();

        softAssertion.assertEquals(return_info_str,Return_Flight);

        WebElement return_date = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]"));
        String return_date_str = return_date.getText();

        softAssertion.assertEquals(return_date_str,Return_Date_str);

        WebElement passengers = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[7]/td[2]"));
        String passengers_count = passengers.getText();

        softAssertion.assertEquals(passengers_count,theDigits);
        softAssertion.assertAll();


        softAssertion.assertEquals(data_left_text,depart_str);

            softAssertion.assertAll();

    }

    @Test(priority = 4)
    public void tripCost()
    {
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]/font/a")).click();


        WebElement table = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody"));

        String table_text = table.getText();

        String first_row = table_text.substring(0,25);
        String second_row = table_text.substring(26,54);
        String third_row = table_text.substring(55,82);
        String forth_row = table_text.substring(83,107);
        String fifth_row = table_text.substring(108,137);

        String first_row_num = CharMatcher.inRange('0', '9').retainFrom(first_row);
        String second_row_num = CharMatcher.inRange('0', '9').retainFrom(second_row);
        String third_row_num = CharMatcher.inRange('0', '9').retainFrom(third_row);
        String forth_row_num = CharMatcher.inRange('0', '9').retainFrom(forth_row);
        String fifth_row_num = CharMatcher.inRange('0', '9').retainFrom(fifth_row);

        List<Integer> list = new ArrayList<Integer>();
        list.add(Integer.parseInt(first_row_num));
        list.add(Integer.parseInt(second_row_num));
        list.add(Integer.parseInt(third_row_num));
        list.add(Integer.parseInt(forth_row_num));
        list.add(Integer.parseInt(fifth_row_num));
        System.out.println("Minimum element : " + Collections.min(list));
    }
}
