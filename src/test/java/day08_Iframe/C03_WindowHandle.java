package day08_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C03_WindowHandle extends TestBase {
    @Test
    public void windowHandle() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproWindow = driver.getWindowHandle();

        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education", driver.getTitle());

        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        String youtubeWindow = driver.getWindowHandle();

        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWindow = driver.getWindowHandle();

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproWindow);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindow);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindow);
    }

    @Test
    public void windowHandle2() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproWindow = driver.getWindowHandle();

        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education", driver.getTitle());

        //Window 2'de (yeni bir sekmede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");
        String youtubeWindow = driver.getWindowHandle();

        //Window 3'te (yeni bir sekmede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedinWindow = driver.getWindowHandle();
        bekle(2);
        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproWindow);
        bekle(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindow);
        bekle(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindow);
        bekle(2);
    }


    @Test
    public void windowHandle3() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education",driver.getTitle());

        //Window 2'de (yeni bir sekmede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");

        //Window 3'te (yeni bir sekmede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        bekle(2);
        List<String> pencerelerListesi = new ArrayList<>(driver.getWindowHandles());
        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(pencerelerListesi.get(0));
        bekle(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(pencerelerListesi.get(1));
        bekle(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(pencerelerListesi.get(2));
        bekle(2);
    }
    @Test
    public void test04() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education",driver.getTitle());

        //Window 2'de (yeni bir sekme) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);//-->WindowType.WINDOW yeni pencere
        //-->WindowType.TAB yeni sekme
        driver.get("https://www.youtube.com");


        //Window 3'te (yeni bir sekme) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        bekle(2);


        
        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        bekle(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        bekle(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
    }

    @Test
    public void testo4() {
//  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

//  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",text);

//  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        Assert.assertEquals("The Internet",driver.getTitle());

//  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();

//  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        window(1);
        Assert.assertEquals("New Window",driver.getTitle());

//  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        window(0);
        Assert.assertEquals("The Internet",driver.getTitle());
        bekle(2);

//  ikinci sayfaya tekrar geçin.
        window(1);
        bekle(2);

//  ilk sayfaya tekrar dönün.
        window(0);

    }
}