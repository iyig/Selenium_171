package HomeWork;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class C011 {

/*

-1.satirdaki 2.hucreye gidelim ve yazdiralim
-1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
-2.satir 4.cell’in afganistan’in baskenti oldugunu test  edelim
-Satir sayisini bulalim
-Fiziki olarak kullanilan satir sayisini bulun
-Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

*/

 @Test
    public void exelOdev1() throws IOException, IOException {
        String exelDosyaYolu = "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(exelDosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
       // Sheet sheet = workbook.getSheet("Sayfa1");

     //1.satirdaki 2.hucreye gidelim ve yazdiralim
     System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(1));
     //1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
      String satırSutun=workbook.getSheet("Sheet1").getRow(0).getCell(1).toString();
     System.out.println(satırSutun);
     //2.satir 4.cell’in afganistan’in baskenti oldugunu test  edelim
  String başkent= workbook.getSheet("Sheet1").getRow(1).getCell(3).toString();
  Assert.assertEquals("Kabil",başkent);
     //-Satir sayisini bulalim
int satirSayisi=workbook.getSheet("Sheet1").getPhysicalNumberOfRows();
System.out.println("satirSayisi = " + satirSayisi);
      //-Fiziki olarak kullanilan satir sayisini bulun

     int sonSatirSayisi=workbook.getSheet("Sheet1").getLastRowNum();
     System.out.println("sonSatirSayisi = " + sonSatirSayisi);

     //-Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

     String dosyaYolu = "src/test/java/resources/Capitals.xlsx";

     Map<String,String> ulkeBaskent = new LinkedHashMap<>();
           for (int i=0; i<workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++){
               String ulke=workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
               String sehir = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
                ulkeBaskent.put(ulke,sehir + "\n");



        }
    }
/*
======================================================
1)Yeni bir Class olusturalim WriteExcel
2)Yeni bir test method olusturalim writeExcelTest()
3)Adimlari takip ederek 1.satira kadar gidelim
4)5.hucreye yeni bir cell olusturalim
5)Olusturdugumuz hucreye “Nufus” yazdiralim
6)2.satir nufus kolonuna 1500000 yazdiralim
7)10.satir nufus kolonuna 250000 yazdiralim
8)15.satir nufus kolonuna 54000 yazdiralim 9)Dosyayi kaydedelim
10)Dosyayi kapatalim
 */

    @Test
    public void exelOdev2() throws IOException {

        String sayfaAdi = "Sayfa1";
        String exelYolu = "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(exelYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sayfaAdi);

        sheet.getRow(0)                  //3)Adimlari takip ederek 1.satira kadar gidelim
                .createCell(4)          //4)5.hucreye yeni bir cell olusturalim
                .setCellValue("Nufus");  //5)Olusturdugumuz hucreye “Nufus” yazdiralim

        //6)2.satir nufus kolonuna 1500000 yazdiralim
        sheet.getRow(1).createCell(4).setCellValue(1500000);

        //7)10.satir nufus kolonuna 250000 yazdiralim
        sheet.getRow(9).createCell(4).setCellValue(250000);

        //8)15.satir nufus kolonuna 54000 yazdiralim
        sheet.getRow(14).createCell(4).setCellValue(54000);

        // 9)Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(exelYolu);
        workbook.write(fos);

        //10)Dosyayi kapatalim
        fos.close();workbook.close();
    }

}
