package com.lahtachev.service;

import com.lahtachev.entity.Buyer;

import java.util.List;

public interface IBuyerService {

    boolean deleteBuyerById(int idBuyer);

    void deleteBuyersAll();

    void saveBuyer(Buyer entity);

    List<Buyer> findAllBuyer();

    Buyer findBuyerById(int idBuyer);


}
