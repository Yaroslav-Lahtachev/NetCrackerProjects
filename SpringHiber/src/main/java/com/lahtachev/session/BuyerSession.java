package com.lahtachev.session;

import com.lahtachev.config.SpringConfig;
import com.lahtachev.dao.buyerDAO.IBuyerDAO;
import com.lahtachev.entity.Buyer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class BuyerSession {

    static AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static IBuyerDAO service = (IBuyerDAO) context.getBean("buyerDAO");

    public static void deleteBookById(int idBuyer) {
        service.deleteBuyerById(idBuyer);
    }

    public static Buyer updateBuyer(int idBuyer, String name, String region, double sale) {
        service.updateBuyer(idBuyer, name, region, sale);
        return findBuyerById(idBuyer);
    }

    public static Buyer saveBuyer(Buyer entity) {
        service.saveBuyer(entity);
        return entity;
    }

    public static void findAllBuyer() {
        System.out.println(service.findAllBuyer());
    }

    public static void rowCount() {
        System.out.println(service.rowCount());
    }

    public static Buyer findBuyerById(int idBuyer) {
        System.out.println(service.findBuyerById(idBuyer));
        return service.findBuyerById(idBuyer);
    }

    public static void task2b() {
        System.out.println("BuyerSession.task2b");
        System.out.println(service.task2b());
    }

    public static void task3a(String region) {
        System.out.println("BuyerSession.task3a");
        System.out.println(service.task3a(region));
    }

}
