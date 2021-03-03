package com.onepointgroup.pricing;

import com.onepointgroup.pricing.core.Article;
import com.onepointgroup.pricing.core.Currency;
import com.onepointgroup.pricing.currency.Euro;
import com.onepointgroup.pricing.discount.PayTwoOneFreeDiscount;
import com.onepointgroup.pricing.unit.OunceUnit;
import com.onepointgroup.pricing.unit.OneUnit;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final Currency EURO = new Euro();
        Article bread = new Article(BigDecimal.valueOf(0.15), OneUnit.ONE, EURO);
        bread.setDiscount(new PayTwoOneFreeDiscount());

        System.out.printf("price of %d bread : %f \n", 5,bread.buy(5) );
        System.out.printf("price of %d bread : %f \n", 2,bread.buy(2) );
        System.out.printf("price of %d bread : %f \n", 3,bread.buy(3) );
        System.out.printf("price of %d bread : %f \n", 1,bread.buy(1) );

        Article floor = new Article(BigDecimal.valueOf(0.65), OunceUnit.KG, EURO);

        System.out.printf("price of %.3f %s floor : %f \n", 5d, OunceUnit.KG,floor.buy(5d) );
        System.out.printf("price of %.3f %s floor : %f \n", 5.8, OunceUnit.KG,floor.buy(5.8) );
        System.out.printf("price of %.3f %s floor : %f \n", 5.8, OunceUnit.DIG,floor.buy(5.8, OunceUnit.DIG) );
        System.out.printf("price of %.3f %s floor : %f \n", 5.8, OunceUnit.HG,floor.buy(5.8, OunceUnit.HG) );
    }
}
