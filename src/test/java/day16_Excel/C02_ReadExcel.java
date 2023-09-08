package day16_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel extends TestBase {


    @Test
    public void test01() throws IOException {
   //BluerentalCar sitesine gidelim

             driver.get("https://www.bluerentalcars.com/");

                //Login butonuna basalım
       driver.findElement(By.xpath("(//a)[1]")).click();


        //Excel dosyasındaki herhangi bir kullanici ile login olalım

        FileInputStream fis=new FileInputStream("src/test/java/resources/mysmoketestdata.xlsx");
       Workbook workbook= WorkbookFactory.create(fis);

       String userName=workbook.getSheet("customer_info").getRow(1).getCell(0).toString();
       String password=workbook.getSheet("customer_info").getRow(1).getCell(1).toString();

        WebElement email=driver.findElement(By.xpath("(//input)[1]"));
        email.sendKeys(userName,Keys.TAB,password, Keys.ENTER);

        //login oldugumuzu doğrulayalim
        driver.findElement(By.xpath("//*[@id='dropdown-basic-button']")).click();
        bekle(2);
        driver.findElement(By.xpath("//*[.='Profile']")).click();
        bekle(2);
        String emailText=driver.findElement(By.xpath("//em")).getText();
        Assert.assertEquals(userName,emailText);
    }
}
