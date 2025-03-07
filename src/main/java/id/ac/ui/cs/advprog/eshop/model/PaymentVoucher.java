package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;

import java.util.Map;

public class PaymentVoucher extends Payment {
    public PaymentVoucher(String id, String method, Order order, Map<String, String> paymentData) {
        super(id, method, order, paymentData);
    }

    public PaymentVoucher(String id, String method, Order order, Map<String, String> paymentData, String status) {
        super(id, method, order, paymentData, status);
    }

    @Override
    public void setPaymentData(Map<String, String> paymentData) {
        if (paymentData.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            int numericalChar = 0;
            for (char c : paymentData.get("voucherCode").toCharArray()) {
                if (Character.isDigit(c)) {
                    numericalChar++;
                }
            }
            this.paymentData = paymentData;
            if (paymentData.get("voucherCode").length() == 16 && paymentData.get("voucherCode").startsWith("ESHOP") && numericalChar == 8) {
                this.setStatus("SUCCESS");
            } else {
                this.setStatus("REJECTED");
            }
        }
    }
}