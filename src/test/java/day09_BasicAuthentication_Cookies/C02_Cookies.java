package day09_BasicAuthentication_Cookies;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C02_Cookies extends TestBase {
    @Test
    public void test01() {

        //1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");


        //2-tum cookie'leri listeleyin
        Set<Cookie> cookieSet = driver.manage().getCookies();
        int sayac = 1;
        for (Cookie c : cookieSet) {
            System.out.println(sayac + ". cookie : " + c);
            System.out.println(sayac + ". cookie Name : " + c.getName());
            System.out.println(sayac + ". cookie Value : " + c.getValue());
            sayac++;
        }
        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        System.out.println("Cookilerin Sayisi = "+cookieSet.size());
        Assert.assertTrue(cookieSet.size()>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();//-->USD
        Assert.assertEquals("USD",actualCookieValue);


        //5-ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        System.out.println("**********************************");
        cookieSet = driver.manage().getCookies();
        int sayac1 = 1;
        for (Cookie c:cookieSet) {
            System.out.println(sayac1+". cookie : "+c);
            System.out.println(sayac1+". cookie Name : "+c.getName());
            System.out.println(sayac1+". cookie Value : "+c.getValue());
            sayac1++;
        }
      bekle(1);

    //6-eklediginiz cookie'nin sayfaya eklendigini test
        Assert.assertTrue(cookieSet.contains(cookie));

        //7-ismi skin olan cookie’yi silin ve silindigini test edin
         driver.manage().getCookieNamed("skin");
        cookieSet = driver.manage().getCookies();
        System.out.println("***************************");
        int sayac2 = 1;
        for (Cookie c:cookieSet) {
            System.out.println(sayac2+". cookie : "+c);
            System.out.println(sayac2+". cookie Name : "+c.getName());
            System.out.println(sayac2+". cookie Value : "+c.getValue());
            sayac2++;
        }
       bekle(2);

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSet = driver.manage().getCookies();
        Assert.assertTrue(cookieSet.isEmpty());

    }
}