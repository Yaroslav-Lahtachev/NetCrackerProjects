package com.lahtachev.applications;

import com.lahtachev.objects.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAutowiringByType {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-autowiring-byType.xml");
        Book book = (Book) context.getBean("Book");
    }
}