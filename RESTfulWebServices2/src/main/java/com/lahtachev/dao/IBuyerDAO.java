package com.lahtachev.dao;

import com.lahtachev.entity.Buyer;

import java.util.List;

public interface IBuyerDAO {

    void deleteBuyerById(int idBuyer);

    void deleteBuyersAll();

    void saveBuyer(Buyer entity);

    List<Buyer> findAllBuyer();

    Buyer findBuyerById(int idBuyer);

}