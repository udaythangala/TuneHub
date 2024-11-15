package com.tunehub.tunehub.controller;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.tunehub.tunehub.entities.Users;
import com.tunehub.tunehub.services.UsersService;

import jakarta.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PaymentController {

    @Autowired
    UsersService service;

    @GetMapping("/pay")
    public String pay() {
        return "pay";
    }

    @SuppressWarnings("finally")
    @PostMapping("/createOrder")
    @ResponseBody
    public String createOrder(HttpSession session) {

        int  amount  = 5000;
        Order order=null;
        try {
            RazorpayClient razorpay = new RazorpayClient("rzp_test_1cLh7DhwgnfgoI", "9DjYEJrxR2RH5VX0wLvP5gNu");

            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", amount*100); // amount in the smallest currency unit
            orderRequest.put("currency", "INR");
            orderRequest.put("receipt", "order_rcptid_11");

            order = razorpay.orders.create(orderRequest);

            String mail =  (String) session.getAttribute("email");

            Users user = service.getUser(mail);
            user.setPremium(true);
            service.updateUser(user);

        } catch (RazorpayException e) {
            e.printStackTrace();
        }
        finally {
            return order.toString();
        }
    }
}
