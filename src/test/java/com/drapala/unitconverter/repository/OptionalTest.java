package com.drapala.unitconverter.repository;

import com.drapala.unitconverter.UnitConverterApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UnitConverterApplication.class)
public class OptionalTest {

    @Test
    public void nullPointer(){
        Character character = new Character();
        Optional name = character.getName();
        if (name.equals("Kuba")) {
            log.info("Name = {}", name);
        } else {
            log.info("Hello Null");
        }
    }


    private class Character{

        private String name;

        public Character() {
        }

        public Character(String name) {
            this.name = name;
        }


        public Optional<String> getName() {
            return  Optional.ofNullable(this.name);
        }
    }

}
