package HomeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01 extends TestBase {
    @Test
    public void test01() {

        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");


        //Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin oldugunu test edelim
        WebElement anaSayfadakiText=driver.findElement(By.xpath("//*[.='An iframe with a thin black border:']"));
        Assert.assertTrue(anaSayfadakiText.getText().contains("black border"));


        //Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
      driver.switchTo().frame(0);
      WebElement iframYazisi=driver.findElement(By.xpath("//h1"));
      Assert.assertTrue(iframYazisi.getText().equals("Applications lists"));



      //Son olarak footer daki 'Povered By' yazisini varligini test edilip

driver.switchTo().defaultContent();
WebElement sayfaninAltindakiText=driver.findElement(By.xpath("//*[text()='Povered By']"));
Assert.assertTrue(sayfaninAltindakiText.getText().contains("Povered By"));
    }


}

