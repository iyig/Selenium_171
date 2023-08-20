package HomeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04 extends TestBase {
    @Test
    public void test01() {
   // Amazon git
        driver.get("https://amazon.com");

     Set<Cookie> cookieSet= driver.manage().getCookies();
       int sayac=1;
        for (Cookie w:cookieSet
             ) {
            System.out.println(sayac+" . cookie" + w);
            System.out.println(sayac+" .cookie Name " + w.getName());
            System.out.println(sayac+" .cookie Value " + w.getValue());
            sayac++ ;
        }

        Assert.assertTrue(cookieSet.size()>5);
String actualCookieValue=driver.manage().getCookieNamed("i18n-prefs").getValue();
Assert.assertEquals("USD",actualCookieValue);
Cookie cookie=new Cookie("en sevdigim","cikolatali");
driver.manage().addCookie(cookie);
        System.out.println("******************************************");
         cookieSet= driver.manage().getCookies();
        int sayac1=1;
        for (Cookie w:cookieSet
        ) {
            System.out.println(sayac1+" . cookie" + w);
            System.out.println(sayac1+" .cookie Name " + w.getName());
            System.out.println(sayac1+" .cookie Value " + w.getValue());
            sayac1++ ;
        }
      Assert.assertTrue(cookieSet.contains(cookie));

   driver.manage().deleteCookieNamed("Skin");
        cookieSet= driver.manage().getCookies();
        int sayac2=1;
        for (Cookie w:cookieSet
        ) {
            System.out.println(sayac2+" . cookie" + w);
            System.out.println(sayac2+" .cookie Name " + w.getName());
            System.out.println(sayac2+" .cookie Value " + w.getValue());
            sayac2++ ;
        }
        //8-tum cookie’leri silin ve silindigini test edin
    driver.manage().deleteAllCookies();
        cookieSet= driver.manage().getCookies();
        Assert.assertTrue(cookieSet.isEmpty());
    }
}
