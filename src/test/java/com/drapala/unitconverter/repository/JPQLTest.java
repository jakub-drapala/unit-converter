package com.drapala.unitconverter.repository;

import com.drapala.unitconverter.UnitConverterApplication;
import com.drapala.unitconverter.entity.Converted;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
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
    public void geLastThreeConverted() {
        Query query = em.createQuery("Select c From Converted c order by c.id desc");
        List resultList = query.setMaxResults(3).getResultList();
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

/*    @Test
    public void useParameterGetString() {
        Long a = 10001L;
        Query query = em.createQuery("Select c.result From Converted c where id = :a").
                setParameter("a", a);
        String resultList = (String) query.getSingleResult();
        logger.info("Result: {}", resultList);

    }*/

    @Test
    public void checkArrayList() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = arrayList.size();
        logger.info("Size: {}", size );
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        int index = arrayList.indexOf("3");
        logger.info("Index = {}", index);
    }

    @Transactional
    @Test
    public void checkStack() {
        ArrayList<String> resultList = new ArrayList<>();
        em.persist(new Converted("1", "aaa"));
        em.persist(new Converted("2", "aaa"));
        em.persist(new Converted("3", "aaa"));
        Query query = em.createQuery("Select c.result From Converted c");
        List<String>result = query.getResultList();
        resultList.addAll(result);
        ArrayDeque <String>arrayDeque = new ArrayDeque(result);
        for (String entity: arrayDeque) {
            logger.info("Entity {}", entity);
        }

        ArrayDeque <String> arrayDeque1 = new ArrayDeque<>();
        arrayDeque1.add("1");
        arrayDeque1.add("2");
        arrayDeque1.add("3");

        for (String entity: arrayDeque1) {
            logger.info("Entity1 {}", entity);
        }
    }








}
