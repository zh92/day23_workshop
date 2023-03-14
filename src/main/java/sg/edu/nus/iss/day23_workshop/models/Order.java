package sg.edu.nus.iss.day23_workshop.models;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    
    private int orderId;
    private Date orderDate;
    private int customerId;
    private int productId;
    private Float totalPrice;
    private Float costPrice;
}
