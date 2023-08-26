package day11_Faker_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_fileDownload extends TestBase {
    @Test
    public void test01() {
        String farkliYol= System.getProperty("user.home");
        String ortakYOl="\\Downloads\\b10 all test cases, code.docx";
        String dosyaYOlu= farkliYol+ortakYOl;
        try {
            Files.delete(Paths.get(dosyaYOlu));
        } catch (IOException e) {
            System.out.println("Dosya Bulunamadı");
        }
        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

//b10 all test cases dosyasını indirelim
 driver.findElement(By.xpath("(//a)[3]")).click();
 bekle(5);



          //Dosyanın başarıyla indirilip indirilmediğini test edelim

       // "C:\Users\Lenovo     \Downloads\b10 all test cases, code.docx"
        String farkliAnaYol= System.getProperty("user.home");
        String ortakYOll="\\Downloads\\b10 all test cases, code.docx";
        String path= farkliYol+ortakYOl;
        System.out.println(Files.exists(Paths.get(path)));
        Assert.assertTrue(Files.exists(Paths.get(path)));
    }
}
