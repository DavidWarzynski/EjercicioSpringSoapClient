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
                numberConversionClient.numberToDollars(BigDecimal.valueOf(100.00));
        assertEquals("one hundred dollars",testNumberToDollars.getNumberToDollarsResult());
    }

    @Test
    public void testNumberToDollarInvalid(){
        try {
            numberConversionClient.numberToDollars(BigDecimal.valueOf(-100.00));
        }catch (IllegalArgumentException e){
            assertEquals("Number must be greater than 0",e.getMessage());
        }
    }

    @Test
    public void testNumberToWordsValid(){
        NumberToWordsResponse testNumberToWords =
                numberConversionClient.numberToWords(BigInteger.valueOf(100));
        assertEquals("one hundred ",testNumberToWords.getNumberToWordsResult());
    }

    @Test
    public void testNumberToWordsInvalid(){
        try {
            numberConversionClient.numberToWords(BigInteger.valueOf(-100));
        }catch (IllegalArgumentException e){
            assertEquals("Number must be greater than 0",e.getMessage());
        }
    }
}
