package com.lahtachev;

import com.lahtachev.entity.Book;
import com.lahtachev.entity.Buyer;
import com.lahtachev.entity.Purchase;
import com.lahtachev.entity.Shop;
import com.lahtachev.session.BookSession;
import com.lahtachev.session.BuyerSession;
import com.lahtachev.session.PurchaseSession;
import com.lahtachev.session.ShopSession;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(final String[] args) {
        //fillDB();  //заполняет бд тестовыми данными


        /*ShopSession.saveShop(new Shop("a","a",1));
        ShopSession.findAllShop();
        ShopSession.deleteShopById(1);
        ShopSession.findShopById(1);
        ShopSession.rowCount();
        ShopSession.updateShop(1,"b","", 2);*/
        String[] regions = {"Sormovo", "Sovetsky"};
        ShopSession.task3b(regions);

        /*BuyerSession.saveBuyer(new Buyer("a","a",1));
        BuyerSession.findAllBuyer();
        BuyerSession.findBuyerById(1);
        BuyerSession.findBuyerById(1);
        BuyerSession.rowCount();
        BuyerSession.updateBuyer(1,"b", "", 22);*/
        BuyerSession.task2b();
        BuyerSession.task3a("Nizhegorod");

        /*BookSession.saveBook(new Book("g",3,"g",3));
        BookSession.findAllBooks();
        BookSession.deleteBookById(1);
        BookSession.findBookById(1);
        BookSession.rowCount();
        BookSession.updateBook(1,"b",-1,"", 20);*/
        BookSession.task2a();
        BookSession.task3c("Windows", 3);

        /*PurchaseSession.savePurchase(new Purchase(new Date(), ShopSession.findShopById(1),BuyerSession.findBuyerById(1),BookSession.findBookById(1),1,1));
        PurchaseSession.findAllPurchase();
        PurchaseSession.deletePurchaseById(1);
        PurchaseSession.findPurchaseById(1);
        PurchaseSession.rowCount();
        Date date = new Date();
        date.setTime(-1);
        PurchaseSession.updatePurchase(1,date,null,null,BookSession.saveBook(new Book("newBook",9,"someRegion",9)),2,-1);*/
        PurchaseSession.task2c();
        PurchaseSession.task4a();
        PurchaseSession.task4b();
        PurchaseSession.task5a(60000);
        PurchaseSession.task5b(3);
        PurchaseSession.task5c("Avtozavod");
        PurchaseSession.task5d();
    }

    public static void fillDB() {
        System.out.println("filling buyers...");
        BuyerSession.saveBuyer(new Buyer("buyer1", "Moskovsky", 11));
        BuyerSession.saveBuyer(new Buyer("buyer2", "Sormovo", 15));
        BuyerSession.saveBuyer(new Buyer("buyer3", "Sovetsky", 10));
        BuyerSession.saveBuyer(new Buyer("buyer4", "Avtozavod", 5));
        BuyerSession.saveBuyer(new Buyer("buyer5", "Sormovo", 7.5));
        BuyerSession.saveBuyer(new Buyer("buyer6", "Nizhegorod", 7.5));
        BuyerSession.saveBuyer(new Buyer("buyer7", "Sovetsky", 10));
        BuyerSession.saveBuyer(new Buyer("buyer8", "Sormovo", 5));
        BuyerSession.saveBuyer(new Buyer("buyer9", "Nizhegorod", 5));
        BuyerSession.saveBuyer(new Buyer("buyer10", "Sovetsky", 15));

        System.out.println("filling shops...");
        ShopSession.saveShop(new Shop("shop1", "Sormovo", 10));
        ShopSession.saveShop(new Shop("shop2", "Avtozavod", 12));
        ShopSession.saveShop(new Shop("shop3", "Sormovo", 10));
        ShopSession.saveShop(new Shop("shop4", "Avtozavod", 15));
        ShopSession.saveShop(new Shop("shop5", "Nizhegorod", 10));
        ShopSession.saveShop(new Shop("shop6", "Sovetsky", 18));
        ShopSession.saveShop(new Shop("shop7", "Sovetsky", 15));
        ShopSession.saveShop(new Shop("shop8", "Moskovsky", 10));
        ShopSession.saveShop(new Shop("shop9", "Sormovo", 12));
        ShopSession.saveShop(new Shop("shop10", "Nizhegorod", 15));

        System.out.println("filling books...");
        BookSession.saveBook(new Book("aWindowsBook",5000,"Sormovo",10));
        BookSession.saveBook(new Book("someBook1",2500,"Avtozavod",100));
        BookSession.saveBook(new Book("someBook2",50000,"Avtozavod",5));
        BookSession.saveBook(new Book("someBook3",30000,"Sovetsky",1));
        BookSession.saveBook(new Book("someBook4",1000,"Sormovo",20));
        BookSession.saveBook(new Book("someBook5",3000,"Sormovo",200));
        BookSession.saveBook(new Book("someBook6",1599,"Sovetsky",3));
        BookSession.saveBook(new Book("someBook7",2000,"Nizhegorod",1));
        BookSession.saveBook(new Book("someBook8",500,"Avtozavod",30));
        BookSession.saveBook(new Book("Windows",3000,"Moskovsky",10));

        System.out.println("filling purchases...");
        PurchaseSession.savePurchase(new Purchase(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-01", new ParsePosition(0)), ShopSession.findShopById(10),BuyerSession.findBuyerById(1),BookSession.findBookById(3),2,100000));
        PurchaseSession.savePurchase(new Purchase(new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-02", new ParsePosition(0)), ShopSession.findShopById(1),BuyerSession.findBuyerById(2),BookSession.findBookById(1),10,50000));
        PurchaseSession.savePurchase(new Purchase(new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-15", new ParsePosition(0)), ShopSession.findShopById(9),BuyerSession.findBuyerById(3),BookSession.findBookById(1),13,65000));
        PurchaseSession.savePurchase(new Purchase(new SimpleDateFormat("yyyy-MM-dd").parse("2018-02-05", new ParsePosition(0)), ShopSession.findShopById(2),BuyerSession.findBuyerById(4),BookSession.findBookById(3),1,50000));
        PurchaseSession.savePurchase(new Purchase(new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-18", new ParsePosition(0)), ShopSession.findShopById(8),BuyerSession.findBuyerById(6),BookSession.findBookById(8),2,4000));
        PurchaseSession.savePurchase(new Purchase(new SimpleDateFormat("yyyy-MM-dd").parse("2018-09-11", new ParsePosition(0)), ShopSession.findShopById(3),BuyerSession.findBuyerById(5),BookSession.findBookById(4),2,60000));
        PurchaseSession.savePurchase(new Purchase(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-27", new ParsePosition(0)), ShopSession.findShopById(2),BuyerSession.findBuyerById(8),BookSession.findBookById(9),4,4500));
        PurchaseSession.savePurchase(new Purchase(new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-01", new ParsePosition(0)), ShopSession.findShopById(4),BuyerSession.findBuyerById(7),BookSession.findBookById(10),1,3000));
        PurchaseSession.savePurchase(new Purchase(new SimpleDateFormat("yyyy-MM-dd").parse("2018-06-03", new ParsePosition(0)), ShopSession.findShopById(5),BuyerSession.findBuyerById(10),BookSession.findBookById(8),1,2000));
        PurchaseSession.savePurchase(new Purchase(new SimpleDateFormat("yyyy-MM-dd").parse("2018-06-30", new ParsePosition(0)), ShopSession.findShopById(6),BuyerSession.findBuyerById(9),BookSession.findBookById(6),1,3000));
    }
}