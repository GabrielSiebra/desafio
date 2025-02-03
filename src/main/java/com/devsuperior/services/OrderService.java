package com.devsuperior.services;

import com.devsuperior.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Employee order) {

        Double ValueDiscount = order.getBasic() * (1 - order.getDiscount() / 100);
        order.setBasic(ValueDiscount);
        return order.getBasic() + shippingService.shipment(order);

    }



    }
