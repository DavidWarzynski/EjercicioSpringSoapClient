package es.neesis.springsoapclient.client;

import es.neesis.springsoapclient.ws.numberconversion.NumberToDollars;
import es.neesis.springsoapclient.ws.numberconversion.NumberToDollarsResponse;
import es.neesis.springsoapclient.ws.numberconversion.NumberToWords;
import es.neesis.springsoapclient.ws.numberconversion.NumberToWordsResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberConversionClient  extends WebServiceGatewaySupport {

    public NumberToDollarsResponse numberToDollars(BigDecimal number){
        NumberToDollars numberToDollars = new NumberToDollars();
        numberToDollars.setDNum(number);

        return (NumberToDollarsResponse) getWebServiceTemplate().marshalSendAndReceive(numberToDollars);
    }

    public NumberToWordsResponse numberToWords(BigInteger number){
        NumberToWords numberToWords = new NumberToWords();
        numberToWords.setUbiNum(number);

        return (NumberToWordsResponse) getWebServiceTemplate().marshalSendAndReceive(numberToWords);
    }
}
