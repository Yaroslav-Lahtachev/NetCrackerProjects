package com.lahtachev.session;

import com.lahtachev.config.SpringConfig;
import com.lahtachev.dao.purchaseDAO.IPurchaseDAO;
import com.lahtachev.entity.Book;
import com.lahtachev.entity.Buyer;
import com.lahtachev.entity.Purchase;
import com.lahtachev.entity.Shop;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Date;
import java.util.List;

public class PurchaseSession {

    static AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static IPurchaseDAO service = (IPurchaseDAO) context.getBean("purchaseDAO");

    public static void deletePurchaseById(int idPurchase) {
        service.deletePurchaseById(idPurchase);
    }

    public static void updatePurchase(int idPurchase, Date date, Shop shop, Buyer buyer, Book book, int qty, double total) {
        service.updatePurchase(idPurchase, date, shop, buyer, book, qty, total);
    }

    public static void savePurchase(Purchase entity) {
        service.savePurchase(entity);
    }

    public static void findAllPurchase() {
        System.out.println(service.findAllPurchase());
    }

    public static void rowCount() {
        System.out.println(service.rowCount());
    }

    public static void findPurchaseById(int idPurchase) {
        System.out.println(service.findPurchaseById(idPurchase));
    }

    public static void task2c() {
        System.out.println(service.task2c());
    }

    public static void task4a() {
        System.out.println(service.task4a());
    }

    public static void task4b() {
        System.out.println(service.task4b());
    }

    public static void task5a(double total) {
        List<Purchase> list = service.task5a(total);
        for (Purchase p :
                list) {
            System.out.println("Purchase: " + p.getIdPurchase() +
                    " Buyer: " + p.getBuyer().getName()
                    + " DatePurchase: " + p.getDate());
        }
    }

    public static void task5b(int month) {
        List<Purchase> list = service.task5b(month);
        for (Purchase purchase :
                list) {
            System.out.println("Buyer: " + purchase.getBuyer().getName()
                    + " ShopName: " + purchase.getShop().getName()
                    + " DatePurchase: " + purchase.getDate());
        }
    }

    public static void task5c(String region) {
        List<Purchase> list = service.task5c(region);
        for (Purchase purchase :
                list) {
            System.out.println("ShopName: " + purchase.getShop().getName());
        }
    }

    public static void task5d() {
        List<Purchase> list = service.task5d();
        for (Purchase purchase :
                list) {
            System.out.println("BookName: " + purchase.getBook().getName()
                    + " RegionStorage: " + purchase.getBook().getRegion()
                    + " CountBooks: " + purchase.getQty()
                    + " BookPricePerBook: " + purchase.getBook().getPrice()
                    + " TotalPRice: " + purchase.getTotal());
        }
    }

}
