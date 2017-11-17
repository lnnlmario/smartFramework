package com.wingwang.chapter2.service;

import com.wingwang.chapter2.helper.DatabaseHelper;
import com.wingwang.chapter2.model.Customer;
import com.wingwang.chapter2.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

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
            List<Customer> customerList = new ArrayList<Customer>();
            String sql = "SELECT * FROM customer";
            conn = DatabaseHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setContact(rs.getString("contact"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
                customer.setRemark(rs.getString("remark"));
                customerList.add(customer);
            }
            return customerList;
        } catch (SQLException e) {
             LOGGER.error("execute sql failure", e);
        } finally {
            if (null != conn){
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.error("close connection failure", e);
                }
            }
        }
        return null;
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
