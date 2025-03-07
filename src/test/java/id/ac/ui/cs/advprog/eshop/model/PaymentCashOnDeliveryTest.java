package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethods;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentCashOndeliveryTest {
    private Map<String, String> paymentData;
    private Order order;

    @BeforeEach
    void setUp() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(1);
        Product product2 = new Product();
        product2.setProductId("a2c62328-4a37-4664-83c7-f32db8620155");
        product2.setProductName("Sabun Cap Usep");
        product2.setProductQuantity(1);
        products.add(product1);
        products.add(product2);

        this.order = new Order("13652556-012a-4c07-b546-54eb1396d79b",
                products, 1708560000L, "Safira Sudrajat");

        this.paymentData = Map.of("voucherCode", "ESHOP1234ABC5678");
        this.paymentData = new HashMap<>();
    }

    @Test
    void testSetPaymentData() {
        this.paymentData.put("bankName", "BCA");
        this.paymentData.put("referenceCode", "1234567890");
        PaymentCashOnDelivery payment = new PaymentCashOnDelivery("13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethods.CASH_ON_DELIVERY.getValue(), order, this.paymentData);
        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testSetPaymentDataWithEmptyBankName() {
        this.paymentData.put("bankName", "");
        this.paymentData.put("referenceCode", "1234567890");
        PaymentCashOnDelivery payment = new PaymentCashOnDelivery("13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethods.CASH_ON_DELIVERY.getValue(), order, this.paymentData);
        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testSetPaymentDataWithEmptyReferenceCode() {
        this.paymentData.put("bankName", "BCA");
        this.paymentData.put("referenceCode", "");
        PaymentCashOnDelivery payment = new PaymentCashOnDelivery("13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethods.CASH_ON_DELIVERY.getValue(), order, this.paymentData);
        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testSetPaymentDataWithEmptyPaymentData() {
        PaymentCashOnDelivery payment = new PaymentCashOnDelivery("13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethods.CASH_ON_DELIVERY.getValue(), order, this.paymentData);
        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }
}