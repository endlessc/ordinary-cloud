package com.me.ordinarycloud.entity;

import lombok.Data;

@Data
public class Order {

	/**
	 * 订单号
	 */
	private Integer orderId;

	/**
	 * 用户id
	 */
	private Integer userId;

	/**
	 * 商品id
	 */
	private Integer commodityId;

}
