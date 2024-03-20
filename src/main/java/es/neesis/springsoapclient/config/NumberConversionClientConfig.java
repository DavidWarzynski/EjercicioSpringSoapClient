package es.neesis.springsoapclient.config;

import es.neesis.springsoapclient.client.NumberConversionClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
@Configuration
public class NumberConversionClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("es.neesis.springsoapclient.ws.numberconversion");
        return marshaller;
    }

    @Bean
    public NumberConversionClient numberConversionClient(Jaxb2Marshaller marshaller) {
        NumberConversionClient client = new NumberConversionClient();
        client.setDefaultUri("https://www.dataaccess.com/webservicesserver/NumberConversion.wso");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
