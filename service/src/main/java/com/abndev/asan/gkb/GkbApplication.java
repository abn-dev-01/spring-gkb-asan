package com.abndev.asan.gkb;

import com.abndev.asan.gkb.soap.SOAPConnector;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.util.Objects;

@SpringBootApplication
public class GkbApplication {

    public static void main(String[] args) {
        SpringApplication.run(GkbApplication.class, args);
    }

}
