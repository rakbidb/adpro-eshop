package id.ac.ui.cs.advprog.eshop.service;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductServiceImpl productService;
    @Test
    void testCreate() {
        Product product = new Product();
        productService.create(product);
        verify(productRepository, times(1)).create(product);
    }
    @Test
    void testEditProduct() {
        Product product = new Product();
        productService.editProduct(product);
        verify(productRepository, times(1)).edit(product);
    }
    @Test
    void testDeleteProduct() {
        Product product = new Product();
        productService.deleteProduct(product);
        verify(productRepository, times(1)).delete(product);
    }
    @Test
    void testFindALl() {
        List<Product> products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());
        Iterator<Product> iterator = products.iterator();
        when(productRepository.findAll()).thenReturn(iterator);
        List<Product> testResult = productService.findAll();
        assertEquals(2,testResult.size());
    }
    @Test
    void testFindProductById() {
        Product product = new Product();
        when(productRepository.getProductById(product.getProductId())).thenReturn(product);
        Product testFindProduct = productService.findProductById(product.getProductId());
        assertEquals(product, testFindProduct);
    }
    @Test
    void testFindProductById_productNotFound() {
        String nonExistentProductId = "nonExistentId";
        when(productRepository.getProductById(anyString())).thenReturn(null);
        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                () -> productService.findProductById(nonExistentProductId));
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
        assertEquals("Product Not Found", exception.getReason());
    }
}