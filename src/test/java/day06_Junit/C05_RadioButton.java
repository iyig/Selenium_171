package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioButton {

    WebDriver driver;
/*
    //https://www.facebook.com adresine gidin
    //Url'in facebook içerdiğini test(assertion ile)
    //“Create an Account” button’una basin
    //Çıkan formu doldurunuz
    //kaydol butonuna tıklayınız
    Not: Before methodda driver ayarlarını yapınız
        After ile sayfayı kapatınız
     */



    @Test
    public void radioButton() {
        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        /*
        Eğer cookie çıkıyorsa locate'ini alıp kapatmamız gerekir
         */



        //"Create an Account" button'una basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

        //"radio buttons" elementlerini locate edin

        WebElement kadin = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement erkek = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement ozel = driver.findElement(By.xpath("//input[@value='-1']"));



        //Secili degilse cinsiyet butonundan size uygun olani secin
        if (!erkek.isSelected()){
            erkek.click();
        }

    }

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    }

