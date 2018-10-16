package com.drapala.unitconverter.repository;

import com.drapala.unitconverter.entity.Converted;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Repository
@Transactional
public class ConvertedRepository {

    @Autowired
    EntityManager em;

    public Converted save(Converted converted) {
        em.persist(converted);
        log.info("Result has been saved to the database: {}", converted);

        return converted;
    }



    public ArrayList<String> getHistory() {
        ArrayList<String> resultList = new ArrayList<>();
        Query query = em.createQuery("Select c.result From Converted c order by c.id desc");
        List<String>result = query.setMaxResults(4).getResultList();
        resultList.addAll(result);
        return resultList;
    }

}
