package day15_ExtendReport_Webtable_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_Excel {

    @Test
    public void test01() throws IOException {



        /*
        Eger projemizde excel dosyasından veri almak istiyorsak öncelikle mvnrepository.com
        adresinden aram çubuğuna poi yazarak apache poi ve poi_ooxml depenciy'lerini
        pom.xml dosyamıza kopyalamız gerekir. Her iki dependeny nin de versiyonları aynı olmalı
         */

        //1-Projemize resources package altına koydugumuz excel dosyamızın yolunu alırız
        String dosyaYolu="src/test/java/resources/Capitals.xlsx";

        // 2- Dosyayı okuyabilmemiz için javada akışa almamız gerekir

        FileInputStream fis =new FileInputStream(dosyaYolu);

        //3- Java ortamında bir excel dosyaı oluşturabilmek icin
        Workbook workbook= WorkbookFactory.create(fis);

        //4-Oluşturdugumuz excel dosyasında sayfa seçmemiz gerekir
        Sheet sheet= workbook.getSheet("Sheet1");

        // 5-Belirttigimiz sayfadaki satır bilgisini seçmemiz gerekir
        Row row=sheet.getRow(0); // index 'dan başlar

        //6- Belirttigimz satırdaki  hücre bilgisini seçmemiz gerekir
        Cell cell=row.getCell(0);

        //sout içince cell bilgisini yazdırdıgımızda 1.satır 1.hücreddeki bilgiyi verir
        System.out.println(cell);


    /*
    Excel dosyanız açıkken işlem yapmayınız
    Excel dosyasında herhangi bir hücrede degişiklik yaptıysanız excel 'i kapatırken kaydetmeyiniz 
     */


    }

    @Test
    public void test02() throws IOException {
        //***Pratic Çözüm
        //1. Satir ve 1. Sütun bilgisini yazdıralım
        FileInputStream fis = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(0));

    }
}
