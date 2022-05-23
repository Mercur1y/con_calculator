package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class UtilsController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @PersistenceContext
    private EntityManager em;
    private boolean addOnce = true;

    static Map<String, String> getErrors(BindingResult bindingResult) {
        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                fieldError -> fieldError.getField() + "Error",
                FieldError::getDefaultMessage
        );
        return bindingResult.getFieldErrors().stream().collect(collector);
    }

    @Transactional
    public void initDB() {

        if (addOnce) {
            Role role = new Role();
            role.setId(1L);
            role.setName("ADMIN");
            em.merge(role);

            Role role2 = new Role();
            role2.setId(2L);
            role2.setName("USER");
            em.merge(role2);

            User user = new User();
            user.setId(1L);
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("admin"));
            user.setRoles(Collections.singleton(new Role(1L, "ADMIN")));
            user.setLast_name("Фамилия");
            user.setFirst_name("Имя");
            user.setSecond_name("Отчество");
            user.setEmail("some@some.ru");
            user.setPhone("899992229");
            em.merge(user);

            MaterialUnit materialUnit = new MaterialUnit();
            materialUnit.setId(1L);
            materialUnit.setUnit("шт");
            em.merge(materialUnit);

            MaterialUnit materialUnit2 = new MaterialUnit();
            materialUnit2.setId(2L);
            materialUnit2.setUnit("м");
            em.merge(materialUnit2);

            MaterialUnit materialUnit3 = new MaterialUnit();
            materialUnit3.setId(3L);
            materialUnit3.setUnit("м2");
            em.merge(materialUnit3);

            MaterialUnit materialUnit4 = new MaterialUnit();
            materialUnit4.setId(4L);
            materialUnit4.setUnit("м3");
            em.merge(materialUnit4);

            MaterialType materialType = new MaterialType();
            materialType.setId(1L);
            materialType.setName("Дерево");
            materialType.setUnit(materialUnit4);
            em.merge(materialType);

            MaterialType materialType2 = new MaterialType();
            materialType2.setId(2L);
            materialType2.setName("OSB");
            materialType2.setUnit(materialUnit3);
            em.merge(materialType2);

            MaterialType materialType3 = new MaterialType();
            materialType3.setId(3L);
            materialType3.setName("Утеплитель");
            materialType3.setUnit(materialUnit4);
            em.merge(materialType3);

            MaterialType materialType4 = new MaterialType();
            materialType4.setId(4L);
            materialType4.setName("Пароизоляция");
            materialType4.setUnit(materialUnit3);
            em.merge(materialType4);

            MaterialType materialType5 = new MaterialType();
            materialType5.setId(5L);
            materialType5.setName("Ветрозащита");
            materialType5.setUnit(materialUnit3);
            em.merge(materialType5);

            MaterialType materialType6 = new MaterialType();
            materialType6.setId(6L);
            materialType6.setName("Сваи");
            materialType6.setUnit(materialUnit);
            em.merge(materialType6);

            MaterialType materialType7 = new MaterialType();
            materialType7.setId(7L);
            materialType7.setName("Бетон");
            materialType7.setUnit(materialUnit4);
            em.merge(materialType7);

            MaterialType materialType8 = new MaterialType();
            materialType8.setId(8L);
            materialType8.setName("Арматура");
            materialType8.setUnit(materialUnit2);
            em.merge(materialType8);

            MaterialType materialType9 = new MaterialType();
            materialType9.setId(9L);
            materialType9.setName("Опалубка");
            materialType9.setUnit(materialUnit4);
            em.merge(materialType9);

            Material material = new Material();
            material.setId(1L);
            material.setName("Доска 50*100*3000");
            material.setType(materialType);
            material.setLength((short) 3000);
            material.setWidth((short) 100);
            material.setHeight((short) 50);
            material.setPrice((double) 12000);
            em.merge(material);

            material = new Material();
            material.setId(2L);
            material.setName("Доска 50*150*3000");
            material.setType(materialType);
            material.setLength((short) 3000);
            material.setWidth((short) 150);
            material.setHeight((short) 50);
            material.setPrice((double) 12000);
            em.merge(material);

            material = new Material();
            material.setId(3L);
            material.setName("Доска 50*200*3000");
            material.setType(materialType);
            material.setLength((short) 3000);
            material.setWidth((short) 200);
            material.setHeight((short) 50);
            material.setPrice((double) 12000);
            em.merge(material);

            material = new Material();
            material.setId(4L);
            material.setName("Доска 50*250*3000");
            material.setType(materialType);
            material.setLength((short) 3000);
            material.setWidth((short) 250);
            material.setHeight((short) 50);
            material.setPrice((double) 12000);
            em.merge(material);

            material = new Material();
            material.setId(5L);
            material.setName("Доска 50*300*3000");
            material.setType(materialType);
            material.setLength((short) 3000);
            material.setWidth((short) 300);
            material.setHeight((short) 50);
            material.setPrice((double) 12000);
            em.merge(material);

            material = new Material();
            material.setId(6L);
            material.setName("Доска 50*100*6000");
            material.setType(materialType);
            material.setLength((short) 6000);
            material.setWidth((short) 100);
            material.setHeight((short) 50);
            material.setPrice((double) 12000);
            em.merge(material);

            material = new Material();
            material.setId(7L);
            material.setName("Доска 50*150*6000");
            material.setType(materialType);
            material.setLength((short) 6000);
            material.setWidth((short) 150);
            material.setHeight((short) 50);
            material.setPrice((double) 12000);
            em.merge(material);

            material = new Material();
            material.setId(8L);
            material.setName("Доска 50*200*6000");
            material.setType(materialType);
            material.setLength((short) 6000);
            material.setWidth((short) 200);
            material.setHeight((short) 50);
            material.setPrice((double) 12000);
            em.merge(material);

            material = new Material();
            material.setId(9L);
            material.setName("Доска 50*250*6000");
            material.setType(materialType);
            material.setLength((short) 6000);
            material.setWidth((short) 250);
            material.setHeight((short) 50);
            material.setPrice((double) 12000);
            em.merge(material);

            material = new Material();
            material.setId(10L);
            material.setName("Доска 50*300*6000");
            material.setType(materialType);
            material.setLength((short) 6000);
            material.setWidth((short) 300);
            material.setHeight((short) 50);
            material.setPrice((double) 12000);
            em.merge(material);

            material = new Material();
            material.setId(11L);
            material.setName("OSB 9 мм");
            material.setType(materialType2);
            material.setWidth((short) 9);
            material.setPrice((double) 256);
            em.merge(material);

            material = new Material();
            material.setId(12L);
            material.setName("OSB 10 мм");
            material.setType(materialType2);
            material.setWidth((short) 10);
            material.setPrice((double) 288);
            em.merge(material);

            material = new Material();
            material.setId(13L);
            material.setName("OSB 15 мм");
            material.setType(materialType2);
            material.setWidth((short) 15);
            material.setPrice((double) 384);
            em.merge(material);

            material = new Material();
            material.setId(14L);
            material.setName("OSB 18 мм");
            material.setType(materialType2);
            material.setWidth((short) 18);
            material.setPrice((double) 480);
            em.merge(material);

            material = new Material();
            material.setId(15L);
            material.setName("Кнауф 100 мм");
            material.setType(materialType3);
            material.setWidth((short) 100);
            material.setPrice((double) 3000);
            em.merge(material);

            material = new Material();
            material.setId(16L);
            material.setName("Технониколь 100 мм");
            material.setType(materialType3);
            material.setWidth((short) 100);
            material.setPrice((double) 3500);
            em.merge(material);

            material = new Material();
            material.setId(17L);
            material.setName("Эковер 100 мм");
            material.setType(materialType3);
            material.setWidth((short) 100);
            material.setPrice((double) 2800);
            em.merge(material);

            material = new Material();
            material.setId(18L);
            material.setName("Эковер 150 мм");
            material.setType(materialType3);
            material.setWidth((short) 150);
            material.setPrice((double) 2800);
            em.merge(material);

            material = new Material();
            material.setId(19L);
            material.setName("Эковер 200 мм");
            material.setType(materialType3);
            material.setWidth((short) 200);
            material.setPrice((double) 2800);
            em.merge(material);

            material = new Material();
            material.setId(20L);
            material.setName("Эковер 250 мм");
            material.setType(materialType3);
            material.setWidth((short) 250);
            material.setPrice((double) 2800);
            em.merge(material);

            material = new Material();
            material.setId(21L);
            material.setName("Фасад 200 мм");
            material.setType(materialType3);
            material.setWidth((short) 200);
            material.setPrice((double) 3200);
            em.merge(material);

            material = new Material();
            material.setId(22L);
            material.setName("Ондутис");
            material.setType(materialType4);
            material.setPrice((double) 33);
            em.merge(material);

            material = new Material();
            material.setId(23L);
            material.setName("Axton");
            material.setType(materialType4);
            material.setPrice((double) 20);
            em.merge(material);

            material = new Material();
            material.setId(24L);
            material.setName("пленка Ютафол");
            material.setType(materialType4);
            material.setPrice((double) 21);
            em.merge(material);

            material = new Material();
            material.setId(25L);
            material.setName("Пароизоляция B");
            material.setType(materialType4);
            material.setPrice((double) 11);
            em.merge(material);

            material = new Material();
            material.setId(26L);
            material.setName("мембрана Brane А");
            material.setType(materialType5);
            material.setPrice((double) 57);
            em.merge(material);

            material = new Material();
            material.setId(27L);
            material.setName("A Optima");
            material.setType(materialType5);
            material.setPrice((double) 21);
            em.merge(material);

            material = new Material();
            material.setId(28L);
            material.setName("Тип А");
            material.setType(materialType5);
            material.setPrice((double) 53);
            em.merge(material);

            material = new Material();
            material.setId(29L);
            material.setName("Доска 30*100*3000");
            material.setType(materialType);
            material.setLength((short) 3000);
            material.setWidth((short) 100);
            material.setHeight((short) 50);
            material.setPrice((double) 7800);
            em.merge(material);

            material = new Material();
            material.setId(30L);
            material.setName("Брус 50*50*3000");
            material.setType(materialType);
            material.setLength((short) 3000);
            material.setWidth((short) 50);
            material.setHeight((short) 50);
            material.setPrice((double) 9100);
            em.merge(material);

            material = new Material();
            material.setId(31L);
            material.setName("Бетонные сваи 150*150*3000");
            material.setType(materialType6);
            material.setLength((short) 3000);
            material.setWidth((short) 150);
            material.setHeight((short) 150);
            material.setPrice((double) 1500);
            em.merge(material);

            material = new Material();
            material.setId(32L);
            material.setName("Бетонные сваи 200*200*3000");
            material.setType(materialType6);
            material.setLength((short) 3000);
            material.setWidth((short) 200);
            material.setHeight((short) 200);
            material.setPrice((double) 1900);
            em.merge(material);

        }
    }
}
