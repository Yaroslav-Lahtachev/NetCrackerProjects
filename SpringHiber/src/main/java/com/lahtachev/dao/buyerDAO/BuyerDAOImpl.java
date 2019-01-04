package com.lahtachev.dao.buyerDAO;

import com.lahtachev.dao.BasicDAO;
import com.lahtachev.entity.Buyer;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("buyerDAO")
@Transactional
public class BuyerDAOImpl extends BasicDAO implements IBuyerDAO {

    @Override
    public void deleteBuyerById(int idBuyer) {
        Buyer entity = (Buyer) getSession().get(Buyer.class, idBuyer);
        if (entity != null)
            getSession().delete(entity);
    }

    @Override
    public void updateBuyer(int idBuyer, String name, String region, double sale) {
        Buyer updatedBuyer = (Buyer) getSession().get(Buyer.class, idBuyer);
        if (updatedBuyer != null) {
            if (name != "")
                updatedBuyer.setName(name);
            if (region != "")
                updatedBuyer.setRegion(region);
            if (sale != -1)
                updatedBuyer.setSale(sale);
        }
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
    public long rowCount() {
        return (long) getSession().createCriteria(Buyer.class).setProjection(Projections.rowCount()).uniqueResult();
    }

    @Override
    public Buyer findBuyerById(int idBuyer) {
        return (Buyer) getSession().get(Buyer.class, idBuyer);
    }

    @Override
    public List<Buyer> task2b() {
        Query query = getSession().createQuery("select distinct region from Buyer");
        return query.list();
    }

    @Override
    public List<Buyer> task3a(String region) {
        return getSession().createCriteria(Buyer.class).add(Restrictions.eq("region", region)).list();
    }
}
