package HomeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03 extends TestBase {
    @Test
    public void test01() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproWindowHandle = driver.getWindowHandle();

        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education", driver.getTitle());

        //Window 2'de (yeni bir sekmede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();
 bekle(2);

        //Window 3'te (yeni bir sekmede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedWindowHandle=driver.getWindowHandle();
        bekle(2);

        //techproeducation sayfasına geçiniz:
       driver.switchTo().window(techproWindowHandle);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);
bekle(2);
        // linked sayfasına geciniz

        driver.switchTo().window(linkedWindowHandle);
    }


}
