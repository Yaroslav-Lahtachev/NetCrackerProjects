package com.lahtachev.applications;

import com.lahtachev.objects.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSI {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-SI.xml");
        Book book = (Book) context.getBean("Book");
    }
}
