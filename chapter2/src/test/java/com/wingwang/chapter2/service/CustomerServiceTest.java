package com.wingwang.chapter2.service;

import com.wingwang.chapter2.helper.DatabaseHelper;
import com.wingwang.chapter2.model.Customer;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * CustomerService 单元测试
 */
public class CustomerServiceTest {

    private final CustomerService customerService;

    public CustomerServiceTest(){
        customerService = new CustomerService();
    }

    @Before
    public void init() throws Exception{

      DatabaseHelper.executeSqlFile("sql/customer_init.sql");
    }

    @Test
    public void testGetCustomerList(){
        List<Customer> customerList = customerService.getCustomerList();
        assertThat(customerList.size(), is(2));
    }

    @Test
    public void testGetCustomer(){
        Customer customer = customerService.getCustomer(1L);
        assertThat(customer, notNullValue());
    }

    @Test
    public void testCreateCustomer(){
        Map<String, Object> fieldMap = new HashMap<String, Object>();
        fieldMap.put("name", "customer100");
        fieldMap.put("contact", "John");
        fieldMap.put("telephone", "13512345678");
        assertThat(customerService.createCustomer(fieldMap), is(true));
    }

    @Test
    public void testUpdateCustomer(){
        Map<String, Object> fieldMap = new HashMap<String, Object>();
        fieldMap.put("contact", "Eric");
        assertThat(customerService.updateCustomer(1L, fieldMap), is(true));
    }

    @Test
    public void testDeleteCustomer(){
        assertThat(customerService.deleteCustomer(1L), is(true));
    }

}
