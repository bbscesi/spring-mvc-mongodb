/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exia.web;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 *
 * @author math
 */
public class CustomerDAO {

    static final ApplicationContext ctx
            = new AnnotationConfigApplicationContext(SpringMongoConfig.class);

    static MongoOperations mongoOp = (MongoOperations) ctx.getBean("mongoTemplate");

    public static List<Customers> getAllCustomers() {
        return mongoOp.findAll(Customers.class);
    }

    public static void add(Customers cs) {
        mongoOp.save(cs);
    }

    public static void deleteCustomer(String id) {
        Query firstNameQuery = new Query(Criteria.where("id").is(id));
        mongoOp.remove(firstNameQuery, Customers.class);

    }

}
