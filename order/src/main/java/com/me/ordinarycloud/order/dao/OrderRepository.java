package com.me.ordinarycloud.order.dao;

import com.me.ordinarycloud.entity.Order;

import java.util.List;

public interface OrderRepository{
	
	Integer save(Order order);
	
	Order selectOrderByOrderId(Integer orderId);

	List<Order> selectOrderByUserId(Integer userId);

}
