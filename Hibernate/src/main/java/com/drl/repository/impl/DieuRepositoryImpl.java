package com.drl.repository.impl;

import com.drl.pojo.Dieu;
import com.drl.repositories.DieuRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class DieuRepositoryImpl implements DieuRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Dieu> getDieus() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Dieu> query = session.createQuery("SELECT d FROM Dieu d", Dieu.class);
        return query.getResultList();
    }
}
