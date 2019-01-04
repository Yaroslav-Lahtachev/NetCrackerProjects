package com.lahtachev.session;

import com.lahtachev.config.SpringConfig;
import com.lahtachev.dao.shopDAO.IShopDAO;
import com.lahtachev.entity.Shop;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ShopSession {

    static AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static IShopDAO service = (IShopDAO) context.getBean("shopDAO");

    public static void deleteShopById(int idBuyer) {
        service.deleteShopById(idBuyer);
    }

    public static Shop updateShop(int idShop, String name, String region, double commission) {
        service.updateShop(idShop, name, region, commission);
        return findShopById(idShop);
    }

    public static Shop saveShop(Shop entity) {
        service.saveShop(entity);
        return entity;
    }

    public static void findAllShop() {
        System.out.println(service.findAllShop());
    }

    public static void rowCount() {
        System.out.println(service.rowCount());
    }

    public static Shop findShopById(int idShop) {
        System.out.println(service.findShopById(idShop));
        return service.findShopById(idShop);
    }

    public static void task3b(String[] regions) {
        System.out.println("ShopSession.task3b");
        System.out.println(service.task3b(regions));
    }

}
