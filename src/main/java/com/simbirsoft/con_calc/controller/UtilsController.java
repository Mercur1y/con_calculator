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

    final
    PasswordEncoder passwordEncoder;

    @PersistenceContext
    private EntityManager em;

    public UtilsController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    static Map<String, String> getErrors(BindingResult bindingResult) {
        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                fieldError -> fieldError.getField() + "Error",
                FieldError::getDefaultMessage
        );
        return bindingResult.getFieldErrors().stream().collect(collector);
    }

    @Transactional
    public void initDB() {

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

        MaterialType materialType = new MaterialType();
        materialType.setId(1L);
        materialType.setName("Дерево");
        em.merge(materialType);

        MaterialType materialType2 = new MaterialType();
        materialType2.setId(2L);
        materialType2.setName("OSB");
        em.merge(materialType2);

        MaterialType materialType3 = new MaterialType();
        materialType3.setId(3L);
        materialType3.setName("Утеплитель");
        em.merge(materialType3);

        MaterialType materialType4 = new MaterialType();
        materialType4.setId(4L);
        materialType4.setName("Пароизоляция");
        em.merge(materialType4);

        MaterialType materialType5 = new MaterialType();
        materialType5.setId(5L);
        materialType5.setName("Ветрозащита");
        em.merge(materialType5);

        MaterialType materialType6 = new MaterialType();
        materialType6.setId(6L);
        materialType6.setName("Сваи");
        em.merge(materialType6);

        MaterialType materialType7 = new MaterialType();
        materialType7.setId(7L);
        materialType7.setName("Бетон");
        em.merge(materialType7);

        MaterialType materialType8 = new MaterialType();
        materialType8.setId(8L);
        materialType8.setName("Арматура");
        em.merge(materialType8);

        Material material = new Material();
        material.setId(1L);
        material.setName("Доска 50*100*3000");
        material.setType(materialType);
        material.setLength(3000);
        material.setWidth(100);
        material.setHeight(50);
        material.setPrice((double) 12000);
        em.merge(material);

        material = new Material();
        material.setId(2L);
        material.setName("Доска 50*150*3000");
        material.setType(materialType);
        material.setLength(3000);
        material.setWidth(150);
        material.setHeight(50);
        material.setPrice((double) 12000);
        em.merge(material);

        material = new Material();
        material.setId(3L);
        material.setName("Доска 50*200*3000");
        material.setType(materialType);
        material.setLength(3000);
        material.setWidth(200);
        material.setHeight(50);
        material.setPrice((double) 12000);
        em.merge(material);

        material = new Material();
        material.setId(4L);
        material.setName("Доска 50*250*3000");
        material.setType(materialType);
        material.setLength(3000);
        material.setWidth(250);
        material.setHeight(50);
        material.setPrice((double) 12000);
        em.merge(material);

        material = new Material();
        material.setId(5L);
        material.setName("Доска 50*300*3000");
        material.setType(materialType);
        material.setLength(3000);
        material.setWidth(300);
        material.setHeight(50);
        material.setPrice((double) 12000);
        em.merge(material);

        material = new Material();
        material.setId(6L);
        material.setName("Доска 50*100*6000");
        material.setType(materialType);
        material.setLength(6000);
        material.setWidth(100);
        material.setHeight(50);
        material.setPrice((double) 12000);
        em.merge(material);

        material = new Material();
        material.setId(7L);
        material.setName("Доска 50*150*6000");
        material.setType(materialType);
        material.setLength(6000);
        material.setWidth(150);
        material.setHeight(50);
        material.setPrice((double) 12000);
        em.merge(material);

        material = new Material();
        material.setId(8L);
        material.setName("Доска 50*200*6000");
        material.setType(materialType);
        material.setLength(6000);
        material.setWidth(200);
        material.setHeight(50);
        material.setPrice((double) 12000);
        em.merge(material);

        material = new Material();
        material.setId(9L);
        material.setName("Доска 50*250*6000");
        material.setType(materialType);
        material.setLength(6000);
        material.setWidth(250);
        material.setHeight(50);
        material.setPrice((double) 12000);
        em.merge(material);

        material = new Material();
        material.setId(10L);
        material.setName("Доска 50*300*6000");
        material.setType(materialType);
        material.setLength(6000);
        material.setWidth(300);
        material.setHeight(50);
        material.setPrice((double) 12000);
        em.merge(material);

        material = new Material();
        material.setId(11L);
        material.setName("OSB 9 мм");
        material.setType(materialType2);
        material.setWidth(9);
        material.setPrice((double) 256);
        em.merge(material);

        material = new Material();
        material.setId(12L);
        material.setName("OSB 10 мм");
        material.setType(materialType2);
        material.setWidth(10);
        material.setPrice((double) 288);
        em.merge(material);

        material = new Material();
        material.setId(13L);
        material.setName("OSB 15 мм");
        material.setType(materialType2);
        material.setWidth(15);
        material.setPrice((double) 384);
        em.merge(material);

        material = new Material();
        material.setId(14L);
        material.setName("OSB 18 мм");
        material.setType(materialType2);
        material.setWidth(18);
        material.setPrice((double) 480);
        em.merge(material);

        material = new Material();
        material.setId(15L);
        material.setName("Кнауф 100 мм");
        material.setType(materialType3);
        material.setWidth(100);
        material.setPrice((double) 3000);
        em.merge(material);

        material = new Material();
        material.setId(16L);
        material.setName("Технониколь 100 мм");
        material.setType(materialType3);
        material.setWidth(100);
        material.setPrice((double) 3500);
        em.merge(material);

        material = new Material();
        material.setId(17L);
        material.setName("Эковер 100 мм");
        material.setType(materialType3);
        material.setWidth(100);
        material.setPrice((double) 2800);
        em.merge(material);

        material = new Material();
        material.setId(18L);
        material.setName("Эковер 150 мм");
        material.setType(materialType3);
        material.setWidth(150);
        material.setPrice((double) 2800);
        em.merge(material);

        material = new Material();
        material.setId(19L);
        material.setName("Эковер 200 мм");
        material.setType(materialType3);
        material.setWidth(200);
        material.setPrice((double) 2800);
        em.merge(material);

        material = new Material();
        material.setId(20L);
        material.setName("Эковер 250 мм");
        material.setType(materialType3);
        material.setWidth(250);
        material.setPrice((double) 2800);
        em.merge(material);

        material = new Material();
        material.setId(21L);
        material.setName("Фасад 200 мм");
        material.setType(materialType3);
        material.setWidth(200);
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
        material.setLength(3000);
        material.setWidth(100);
        material.setHeight(30);
        material.setPrice((double) 7800);
        em.merge(material);

        material = new Material();
        material.setId(30L);
        material.setName("Брус 50*50*3000");
        material.setType(materialType);
        material.setLength(3000);
        material.setWidth(50);
        material.setHeight(50);
        material.setPrice((double) 9100);
        em.merge(material);

        material = new Material();
        material.setId(31L);
        material.setName("Бетонные сваи 150*150*3000");
        material.setType(materialType6);
        material.setLength(3000);
        material.setWidth(150);
        material.setHeight(150);
        material.setPrice((double) 1500);
        em.merge(material);

        material = new Material();
        material.setId(32L);
        material.setName("Бетонные сваи 200*200*3000");
        material.setType(materialType6);
        material.setLength(3000);
        material.setWidth(200);
        material.setHeight(200);
        material.setPrice((double) 1900);
        em.merge(material);

        material = new Material();
        material.setId(33L);
        material.setName("M150(B10)");
        material.setType(materialType7);
        material.setPrice((double) 2760);
        em.merge(material);

        material = new Material();
        material.setId(34L);
        material.setName("M200(B15)");
        material.setType(materialType7);
        material.setPrice((double) 2910);
        em.merge(material);

        material = new Material();
        material.setId(35L);
        material.setName("Арматура 8мм");
        material.setType(materialType8);
        material.setWidth(8);
        material.setPrice((double) 23);
        em.merge(material);

        material = new Material();
        material.setId(36L);
        material.setName("Арматура 14мм");
        material.setType(materialType8);
        material.setWidth(14);
        material.setPrice((double) 69);
        em.merge(material);
    }
}
