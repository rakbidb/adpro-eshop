package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.enums.PaymentMethods;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Map;

@Getter
public class Payment {
    private String id;
    private String method;
    private String status;
    private Order order;
    private Map<String, String> paymentData;

    public Payment(String id, String method, Order order, Map<String, String> paymentData) {
        this.id = id;
        this.setMethod(method);
        this.setOrder(order);
        this.setPaymentData(paymentData);
        this.setStatus(PaymentStatus.PENDING.getValue());
    }

    public Payment(String id, String method, Order order, Map<String, String> paymentData, String status) {
        this.id = id;
        this.setMethod(method);
        this.setOrder(order);
        this.setPaymentData(paymentData);
        this.setStatus(status);
    }

    public void setStatus(String status) {
        if (PaymentStatus.contains(status)) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid status");
        }
    }

    private void setOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        this.order = order;
    }

    private void setPaymentData(Map<String, String> paymentData) {
        if (paymentData.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.paymentData = paymentData;
        }
    }

    private void setMethod(String method){
        if (PaymentMethods.contains(method)) {
            this.method = method;
        } else {
            throw new IllegalArgumentException("Invalid Status");
        }
    }
}