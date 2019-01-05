package com.lahtachev.dao;

import com.lahtachev.entity.Buyer;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("buyerDao")
public class BuyerDAOImpl implements IBuyerDAO {

    @Autowired
    SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void deleteBuyerById(int idBuyer) {
        Buyer entity = (Buyer) getSession().get(Buyer.class, idBuyer);
        if (entity != null)
            getSession().delete(entity);
    }

    @Override
    public void deleteBuyersAll() {
        //getSession().createQuery("delete from buyers");
        SQLQuery sqlQuery = getSession().createSQLQuery("delete from buyers");
        sqlQuery.executeUpdate();
    }

    @Override
    public void saveBuyer(Buyer entity) {
        getSession().persist(entity);
    }

    @Override
    public List<Buyer> findAllBuyer() {
        return getSession().createCriteria(Buyer.class).list();
    }

    @Override
    public Buyer findBuyerById(int idBuyer) {
        return (Buyer) getSession().get(Buyer.class, idBuyer);
    }


}
