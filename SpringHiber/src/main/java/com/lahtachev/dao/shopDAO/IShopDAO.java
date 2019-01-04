package com.lahtachev.dao.shopDAO;

import com.lahtachev.entity.Shop;

import java.util.List;

public interface IShopDAO {

    void deleteShopById(int idShop);

    void updateShop(int idShop, String name, String region, double commission);

    void saveShop(Shop entity);

    List<Shop> findAllShop();

    long rowCount();

    Shop findShopById(int idShop);

    List<Shop> task3b(String[] regions);

}
