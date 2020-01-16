package com.me.ordinarycloud.order.dao;

import java.sql.PreparedStatement;
import java.util.List;

import com.me.ordinarycloud.entity.Order;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository{

	private final JdbcTemplate jdbcTemplate;

	public OrderRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Integer save(Order order) {
		String sql = "insert into tb_order(user_id, commodity_id) values(?, ?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(conn -> {
			// 预处理 注意参数 PreparedStatement.RETURN_GENERATED_KEYS
			PreparedStatement ps = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, order.getUserId());
			ps.setInt(2, order.getCommodityId());
			return ps;
		}, keyHolder);
		return  keyHolder.getKey().intValue();
	}

	@Override
	public Order selectOrderByOrderId(Integer orderId) {
		List<Order> orderList = jdbcTemplate.query("select order_id as orderId, user_id as userId, commodity_id as commodityId from tb_order where order_id = " + orderId +" limit 1", new BeanPropertyRowMapper<Order>(Order.class));
        return orderList.get(0);
	}

	@Override
	public List<Order> selectOrderByUserId(Integer userId) {
		List<Order> orderList = jdbcTemplate.query("select order_id as orderId, user_id as userId, commodity_id as commodityId from tb_order where user_id = " + userId, new BeanPropertyRowMapper<Order>(Order.class));
		return orderList;
	}

}
