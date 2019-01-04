package com.lahtachev.dao.purchaseDAO;

import com.lahtachev.entity.Book;
import com.lahtachev.entity.Buyer;
import com.lahtachev.entity.Purchase;
import com.lahtachev.entity.Shop;

import java.util.Date;
import java.util.List;

public interface IPurchaseDAO {

    void savePurchase(Purchase entity);

    void updatePurchase(int idPurchase, Date date, Shop shop, Buyer buyer, Book book, int qty, double total);

    List<Purchase> findAllPurchase();

    Purchase findPurchaseById(int idPurchase);

    void deletePurchaseById(int idPurchase);

    long rowCount();

    List<Purchase> task2c();

    List<Purchase> task4a();

    List<Purchase> task4b();

    List<Purchase> task5a(double total);

    List<Purchase> task5b(int month);

    List<Purchase> task5c(String region);

    List<Purchase> task5d();

}
