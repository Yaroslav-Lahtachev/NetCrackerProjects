package com.lahtachev.service;

import com.lahtachev.dao.IBuyerDAO;
import com.lahtachev.entity.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("buyerService")
public class BuyerServiceImpl implements IBuyerService {
    @Autowired
    private IBuyerDAO iBuyerDAO;

    public boolean deleteBuyerById(int idBuyer) {
        if (iBuyerDAO.findBuyerById(idBuyer) == null)
            return false;
        iBuyerDAO.deleteBuyerById(idBuyer);
        return true;
    }

    public void deleteBuyersAll() {
        iBuyerDAO.deleteBuyersAll();
    }

    public void saveBuyer(Buyer buyer) {
        iBuyerDAO.saveBuyer(buyer);
    }

    public List<Buyer> findAllBuyer() {
        return iBuyerDAO.findAllBuyer();
    }

    public Buyer findBuyerById(int idBuyer) {
        return iBuyerDAO.findBuyerById(idBuyer);
    }

}
