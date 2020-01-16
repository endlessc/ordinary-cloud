package com.me.ordinarycloud.entity;

import lombok.Data;

@Data
public class Commodity {
	
	/**
	 * 商品id
	 */
	private Integer commodityId;
	
	/**
	 * 商品名称
	 */
	private String commodityName;
	
	/**
	 * 商品价格
	 */
	private Double commodityPrice;

	/**
	 * 库存
	 */
	private Integer commodityStock;

}
