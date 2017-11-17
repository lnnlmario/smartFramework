package com.wingwang.chapter2.service;

import com.wingwang.chapter2.helper.DatabaseHelper;
import com.wingwang.chapter2.model.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * 提供客户数据服务
 *
 * 标准的MVC架构中是没有服务层的, 我们将该层作为衔接控制器层与数据库层之间的桥梁, 可以使用接口和实现类来表达,
 * 在简单情况下, 无需使用接口, 直接使用类就可以了.
 */
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    @Deprecated
    public List<Customer> getCustomerList(/*String keyword*/){

        Connection conn = null;

        try {
            String sql = "SELECT * FROM custom";
            return DatabaseHelper.queryEntityList(Customer.class, conn, sql);
        } finally {
            DatabaseHelper.closeConnection(conn);
        }
    }

    /**
     * 获取客户
     */
    public Customer getCustomer(long id){
        // TODO
        return null;
    }

    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String, Object> fieldMap){
        // TODO
        boolean retVal = false;

        return  retVal;
    }

    /**
     * 更新客户
     */
    public boolean updateCustomer(long id, Map<String, Object> fieldMap){
        // TODO
        boolean retVal = false;

        return retVal;
    }

    /**
     * 删除客户
     */
    public boolean deleteCustomer(long id){
        // TODO
        boolean retVal = false;

        return retVal;
    }
}
