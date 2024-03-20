package es.neesis.springsoapclient.client;

import es.neesis.springsoapclient.ws.numberconversion.NumberToDollars;
import es.neesis.springsoapclient.ws.numberconversion.NumberToDollarsResponse;
import es.neesis.springsoapclient.ws.numberconversion.NumberToWords;
import es.neesis.springsoapclient.ws.numberconversion.NumberToWordsResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberConversionClient extends WebServiceGatewaySupport {

    public NumberToDollarsResponse numberToDollars(BigDecimal number){
        NumberToDollars numberToDollars = new NumberToDollars();
        if (number!= null && number.doubleValue() > 0.0){
            numberToDollars.setDNum(number);
        }else {
            throw new IllegalArgumentException("Number must be greater than 0");
        }
        return (NumberToDollarsResponse) getWebServiceTemplate().marshalSendAndReceive(numberToDollars);
    }

    public NumberToWordsResponse numberToWords(BigInteger number){
        NumberToWords numberToWords = new NumberToWords();
        if (number!= null && number.doubleValue() > 0.0){
            numberToWords.setUbiNum(number);
        }else {
            throw new IllegalArgumentException("Number must be greater than 0");
        }

        return (NumberToWordsResponse) getWebServiceTemplate().marshalSendAndReceive(numberToWords);
    }
}
