package techproed.day14_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class C04_Faker   {

    @Test
    public void test01() {

        /*
        faker class'indan sahte verileri kullanabilmek icin obje olusturmamiz gerekir.
         */

        Faker faker = new  Faker();

        //faker objesi kullanarak bir isim yazdirin
        System.out.println(faker.name().firstName());

        System.out.println(faker.name().lastName());

        System.out.println(faker.name().fullName());

        System.out.println(faker.address().fullAddress());

        System.out.println(faker.phoneNumber().phoneNumber());

        System.out.println(faker.job().position());


    }
}
