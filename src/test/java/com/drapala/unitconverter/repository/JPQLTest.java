package com.drapala.unitconverter.repository;

import com.drapala.unitconverter.UnitConverterApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by maczi on 2018-09-15.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UnitConverterApplication.class)
public class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void getAllConverted() {
        Query query = em.createQuery("Select c From Converted c");
        List resultList = query.getResultList();
        logger.info("Select c From Course c -> {}", resultList);
    }

    @Test
    public void getOneConverted() {

        Query query = em.createQuery("Select c.result From Converted c where id = 10001");
        List resultList = query.getResultList();
        logger.info("Result: {}", resultList);
    }

    @Test
    public void useParameter() {
        Long a = 10001L;
        Query query = em.createQuery("Select c.result From Converted c where id = :a").
                setParameter("a", a);
        List resultList = query.getResultList();
        logger.info("Result: {}", resultList);

    }

    @Test
    public  void  getSize() {
        Query query = em.createQuery("Select c From Converted c");
        List resultList = query.getResultList();
        logger.info("Result: {}", resultList.size());
    }

    @Test
    public void useParameterGetString() {
        Long a = 10001L;
        Query query = em.createQuery("Select c.result From Converted c where id = :a").
                setParameter("a", a);
        String resultList = (String) query.getSingleResult();
        logger.info("Result: {}", resultList);

    }



}
