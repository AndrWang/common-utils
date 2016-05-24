package com.stay4it.sample.gsonTest;

import com.google.gson.reflect.TypeToken;
import com.stay4it.utilities.io.GsonUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndWang on 16/5/24.
 */
public class Test {
    public static void main(String[] args) {
        Person p = new Person();
        p.setFirstName("xxx");
        p.setLastName("yyy");

        List<Person> pList = new ArrayList<Person>();
        pList.add(p);

        String jsonStr = GsonUtils.toJsonList(pList);

        System.out.println("Person List as Json Array = " + jsonStr);

        Type collectionType = new TypeToken<List<Person>>() {
        }.getType();
        List<Person> personList = GsonUtils.fromJsonString(jsonStr, collectionType);
        System.out.println("Person List from json String array = " + personList);

        String personJsonStr = GsonUtils.toJsonObj(p);
        System.out.println("Json String from person = " + personJsonStr);

        Person p1 = GsonUtils.fromJsonString(personJsonStr, Person.class);
        System.out.println("Person from json String = " + p1);
    }

    /**
     * 最后输出结果
     * Person List as Json Array = [{"firstName":"xxx","lastName":"yyy"}]
     * Person List from json String array = [Person [firstName=xxx, lastName=yyy]]
     * Json String from person = {"firstName":"xxx","lastName":"yyy"}
     * Person from json String = Person [firstName=xxx, lastName=yyy]
     * */

}
