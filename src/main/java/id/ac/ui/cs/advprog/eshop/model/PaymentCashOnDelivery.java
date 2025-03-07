package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;

import java.util.Map;

public class PaymentCashOnDelivery extends Payment {
    public PaymentCashOnDelivery(String id, String method, Order order, Map<String, String> paymentData) {
        super(id, method, order, paymentData);
    }

    public PaymentCashOnDelivery(String id, String method, Order order, Map<String, String> paymentData, String status) {
        super(id, method, order, paymentData, status);
    }

    @Override
    public void setPaymentData(Map<String, String> paymentData) {
        if (paymentData.isEmpty() || paymentData.get("bankName").isEmpty() || paymentData.get("referenceCode").isEmpty()) {
            this.status = PaymentStatus.REJECTED.getValue();
        } else {
            this.paymentData = paymentData;
            this.status = PaymentStatus.SUCCESS.getValue();
        }
    }
}