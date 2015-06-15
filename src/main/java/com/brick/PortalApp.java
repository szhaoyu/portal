package com.brick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.brick.util.RegexValidator;


@SpringBootApplication
public class PortalApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(PortalApp.class);
    }
}
