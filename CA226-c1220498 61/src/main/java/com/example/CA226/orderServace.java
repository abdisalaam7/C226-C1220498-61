package com.example.CA226;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class orderServace {
    private final JdbcTemplate jdbcTemplate;

    public orderServace(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addOrder(order order) {
        String sql = "INSERT INTO orders (id, name, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, order.getId(), order.getName(), order.getPrice());
    }

    public order getOneOrder(int id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(order.class));
    }

    public void updateOrder(order order) {
        String sql = "UPDATE orders SET name = ?, price = ? WHERE id = ?";
        jdbcTemplate.update(sql, order.getName(), order.getPrice(), order.getId());
    }
}
