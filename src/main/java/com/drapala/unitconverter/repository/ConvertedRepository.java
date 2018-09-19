package com.drapala.unitconverter.repository;

import com.drapala.unitconverter.entity.Converted;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
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

    public long getSizeOfRepository() {
        Query query = em.createQuery("Select c From Converted c");
        List resultList = query.getResultList();
        log.info("Select c From Converted c -> {}", resultList);
        return (long) resultList.size();
    }

    public String getLastThreeConverted() {
        Long size =  getSizeOfRepository();
        if (size == 2){
            Query query = em.createQuery("Select c.result From Converted c where id = :i").
                        setParameter("i", size-1);
             String result = (String) query.getSingleResult();
             return result;
        } else if (size == 3) {
            Query query1 = em.createQuery("Select c.result From Converted c where id = :i").
                    setParameter("i", size-1);
            Query query2 = em.createQuery("Select c.result From Converted c where id = :i").
                    setParameter("i", size-2);
            String result1 = (String) query1.getSingleResult();
            String result2 = (String) query2.getSingleResult();
            String result = result1 +" | "+ result2;
            return result;
        } else if (size > 3) {
            Query query1 = em.createQuery("Select c.result From Converted c where id = :i").
                    setParameter("i", size-1);
            Query query2 = em.createQuery("Select c.result From Converted c where id = :i").
                    setParameter("i", size-2);
            Query query3 = em.createQuery("Select c.result From Converted c where id = :i").
                    setParameter("i", size-3);

            String result1 = (String) query1.getSingleResult();
            String result2 = (String) query2.getSingleResult();
            String result3 = (String) query3.getSingleResult();

            String result = result1 +" | "+ result2 + " | "+ result3;

            return result;
        }


        return "";
    }

    public String getActualAndLastTwoConverted() {
        Long size =  getSizeOfRepository();
        if (size == 1){
            Query query = em.createQuery("Select c.result From Converted c where id = :i").
                    setParameter("i", size);
            String result = (String) query.getSingleResult();
            return result;
        } else if (size == 2) {
            Query query1 = em.createQuery("Select c.result From Converted c where id = :i").
                    setParameter("i", size);
            Query query2 = em.createQuery("Select c.result From Converted c where id = :i").
                    setParameter("i", size-1);
            String result1 = (String) query1.getSingleResult();
            String result2 = (String) query2.getSingleResult();
            String result = result1 +" | "+ result2;
            return result;
        } else if (size > 2) {
            Query query1 = em.createQuery("Select c.result From Converted c where id = :i").
                    setParameter("i", size);
            Query query2 = em.createQuery("Select c.result From Converted c where id = :i").
                    setParameter("i", size-1);
            Query query3 = em.createQuery("Select c.result From Converted c where id = :i").
                    setParameter("i", size-2);

            String result1 = (String) query1.getSingleResult();
            String result2 = (String) query2.getSingleResult();
            String result3 = (String) query3.getSingleResult();

            String result = result1 +" | "+ result2 + " | "+ result3;

            return result;
        }


        return "";
    }




}
