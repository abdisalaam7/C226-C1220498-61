package com.example.CA226;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class orderController {

    private final orderService orderService;

    public orderController(orderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public order getOneOrder(@PathVariable int id) {
        return orderService.getOneOrder(id);
    }

    @PostMapping("/add")
    public void addOrder(@RequestBody order order) {
        orderService.addOrder(order);
    }

    @PutMapping("/{id}")
    public void updateOrder(@PathVariable int id, @RequestBody order order) {
        order.setId(id);
        orderService.updateOrder(order);
    }
}
