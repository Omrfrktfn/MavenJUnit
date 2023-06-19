package techproed.day15_FileExist;


import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;


public class C01_FileExist {

    @Test
    public void test01() {

        System.out.println(System.getProperty("user.dir"));//icinde oldugumuz projenin dosya yolunu verir.
        //projenin hangi dosyada oldugunun yolunu verir.

        System.out.println(System.getProperty("user.home"));//herkesin bilgisayarinda farkli olan kismi dinamik olarak verir.
        //C:\Users\Omer bu kisim herkesin bilgisayarinda kendine ait olan yerdir.

        // Desktop(masaustu)'da bir text dosyası olusturun

        // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin

        /*
        Dosyanin bilgisayarimda destop'ta olup olmadigini java ile test edecegim.
        Cunku selenium webtabanli uygulamalar icin kullanilir.Selenium benim bilgisayarimdaki
        desttop'a mudahale edemez.
         */

        // C:\Users\Omer\OneDrive\Masaüstü\Yeni Metin Belgesi.txt

        Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\Omer\\OneDrive\\Masaüstü\\Yeni Metin Belgesi.txt")));

        System.out.println("*********************************************************************************************");

        //daha dinamik hale getirmek ise

        // C:\Users\Omer        \OneDrive\Masaüstü\Yeni Metin Belgesi.txt
        String farkliKisim = System.getProperty("user.home");// herkeste farkli olan kismi veriri
        String ayniKisim = "\\OneDrive\\Masaüstü\\Yeni Metin Belgesi.txt";

        String dosyaYolu = farkliKisim + ayniKisim;
        System.out.println(dosyaYolu);
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
