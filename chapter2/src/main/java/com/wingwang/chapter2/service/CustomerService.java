package com.wingwang.chapter2.service;

import com.wingwang.chapter2.helper.DatabaseHelper;
import com.wingwang.chapter2.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 提供客户数据服务
 * <p>
 * 标准的MVC架构中是没有服务层的, 我们将该层作为衔接控制器层与数据库层之间的桥梁, 可以使用接口和实现类来表达,
 * 在简单情况下, 无需使用接口, 直接使用类就可以了.
 */
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList(/*String keyword*/) {

        String sql = "SELECT * FROM customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);

    }

    /**
     * 获取客户
     */
    public Customer getCustomer(long id) {

        String sql = "SELECT * FROM customer WHERE id = ?";
        return DatabaseHelper.queryEntity(Customer.class, sql, id);
    }

    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String, Object> fieldMap) {

        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
    }

    /**
     * 更新客户
     */
    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {

        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    /**
     * 删除客户
     */
    public boolean deleteCustomer(long id) {

        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
