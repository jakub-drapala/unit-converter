package com.drapala.unitconverter.repository;

import com.drapala.unitconverter.entity.Converted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ConvertedRepository {

    @Autowired
    EntityManager em;

    public Converted save(Converted converted) {
        em.persist(converted);
        return converted;
    }

}
