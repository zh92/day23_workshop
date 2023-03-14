package sg.edu.nus.iss.day23_workshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.day23_workshop.models.Order;
import sg.edu.nus.iss.day23_workshop.payload.SearchRequest;
import sg.edu.nus.iss.day23_workshop.services.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    OrderService orderService;

    @GetMapping
    public String searchOrder(Model model) {
        
        SearchRequest sr = new SearchRequest();
        model.addAttribute("searchObject", sr);
        return "order";
    }

    @PostMapping("/search")
    public String processSearch(@ModelAttribute("searchObject") SearchRequest searchObj, Model model, BindingResult result) {
        List<Order> orders = orderService.findOrderById(searchObj.getOrderId());
        model.addAttribute("orders", orders);

        return "orderlist";
    }

}
