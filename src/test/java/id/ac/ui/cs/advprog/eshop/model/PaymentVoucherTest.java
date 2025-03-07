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
import static org.junit.jupiter.api.Assertions.assertThrows;

class PaymentVoucherTest {
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

        this.paymentData = new HashMap<>();
    }

    @Test
    void testSetPaymentDataWithEmptyPaymentData() {
        PaymentVoucher payment = new PaymentVoucher("13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethods.VOUCHER.getValue(), order, Map.of("voucherCode", "ESHOP1234ABC5678"));
        assertThrows(IllegalArgumentException.class, () -> payment.setPaymentData(new HashMap<>()));
    }

    @Test
    void testSetPaymentDataWithValidVoucherCode() {
        this.paymentData.put("voucherCode", "ESHOP1234ABC5678");
        PaymentVoucher payment = new PaymentVoucher("13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethods.VOUCHER.getValue(), order, this.paymentData);
        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testSetPaymentDataWithInvalidVoucherCodeWithShortLength() {
        this.paymentData.put("voucherCode", "ESHOP1234ABC567");
        PaymentVoucher payment = new PaymentVoucher("13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethods.VOUCHER.getValue(), order, this.paymentData);
        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testSetPaymentDataWithInvalidVoucherCodeWithoutEshop() {
        this.paymentData.put("voucherCode", "1234ABC5678");
        PaymentVoucher payment = new PaymentVoucher("13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethods.VOUCHER.getValue(), order, this.paymentData);
        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testSetPaymentDataWithInvalidVoucherCodeWithoutEightNumericalCharacters() {
        this.paymentData.put("voucherCode", "ESHOPABCDEFGH");
        PaymentVoucher payment = new PaymentVoucher("13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethods.VOUCHER.getValue(), order, this.paymentData);
        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }
}