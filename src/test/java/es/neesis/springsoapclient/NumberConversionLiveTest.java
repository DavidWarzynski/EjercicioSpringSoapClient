package es.neesis.springsoapclient;

import es.neesis.springsoapclient.client.NumberConversionClient;
import es.neesis.springsoapclient.config.NumberConversionClientConfig;
import es.neesis.springsoapclient.ws.numberconversion.NumberToDollarsResponse;
import es.neesis.springsoapclient.ws.numberconversion.NumberToWordsResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NumberConversionClientConfig.class, loader = AnnotationConfigContextLoader.class)
public class NumberConversionLiveTest {

    @Autowired
    private NumberConversionClient numberConversionClient;

    @Test
    public void testNumberToDollarValid(){
        NumberToDollarsResponse testNumberToDollars =
                numberConversionClient.numberToDollars(BigDecimal.valueOf(100.50));
        assertEquals(testNumberToDollars.getNumberToDollarsResult(),"100.50$");
    }

    @Test
    public void testNumberToWordsValid(){
        NumberToWordsResponse testNumberToWords =
                numberConversionClient.numberToWords(BigInteger.valueOf(100));
        assertEquals(testNumberToWords.getNumberToWordsResult(),"one hundred");
    }
}
