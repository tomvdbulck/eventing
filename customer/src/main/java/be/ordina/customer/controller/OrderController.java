package be.ordina.customer.controller;

import be.ordina.customer.domain.Order;
import be.ordina.customer.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/new_order/{id}")
    public String showAddOrderForm(@PathVariable("id") long customerId, Model model) {
        Order blankOrder = new Order();
        blankOrder.setCustomerId(customerId);
        model.addAttribute("order", blankOrder);
        return "new-order";
    }


    @PostMapping("/add_order")
    public String addOrder(@Valid Order order, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "new-order";
        }

        orderRepository.save(order);
        return "redirect:/index";
    }
}
