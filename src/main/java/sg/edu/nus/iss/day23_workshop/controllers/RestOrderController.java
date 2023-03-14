package sg.edu.nus.iss.day23_workshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.day23_workshop.models.Order;
import sg.edu.nus.iss.day23_workshop.services.OrderService;

@RestController
@RequestMapping("/api/orders")
public class RestOrderController {

    @Autowired
    OrderService orderSvc;
    
    @GetMapping("/{order-id}")
    public ResponseEntity<List<Order>> findOrderById(@PathVariable("order-id") Integer id) {
        List<Order> orders = orderSvc.findOrderById(id);

        if (orders.size() > 0) {
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

    }
}
