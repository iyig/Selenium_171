package HomeWork;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C09 extends TestBase {
    @Test
    public void test01() {

        // https://ebay.com sayfasına gidiniz
        driver.get("https://ebay.com");
        bekle(2);

        // electronics bolumune tıklayınız
        driver.findElement(By.xpath("(//a[text()='Electronics'])[2]")).click();


        // genisligi 225 ve uzunlugu 225 olan resimlerin hepsine sırasıyla tıklayınız ve sayfa baslıgını yazdırınız
        List<WebElement> resimler = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));


        for (int i = 0; i < resimler.size(); i++) {

            resimler = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));

            resimler.get(i).click();

            System.out.println(i + ". Title : " + driver.getTitle());

            driver.navigate().back();


        }

    }
}
