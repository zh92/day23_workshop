package sg.edu.nus.iss.day23_workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import sg.edu.nus.iss.day23_workshop.models.Order;
import sg.edu.nus.iss.day23_workshop.repositories.OrderRepo;

@Service
public class OrderService {
    
    @Autowired
    OrderRepo orderRepo;

    RestTemplate restTemplate = new RestTemplate();

    public List<Order> findOrderById(Integer id){
        return orderRepo.findOrderById(id);
    }

    private static final String GETORDERBYID_ENDPOINT_URL = "http://localhost:4000/api/orders/{order-id}";

}
