package id.ac.ui.cs.advprog.eshop.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Iterator;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest{
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private ProductService productService;
    @InjectMocks
    private ProductController productController;
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }
    @Test
    void testGetProductListPage() throws Exception {
        List<Product> allProducts = productService.findAll();
        mockMvc.perform(get("/product/list")).andExpect(status().isOk())
                .andExpect(view().name("productList"))
                .andExpect(model().attribute("products", allProducts));
    }
    @Test
    void testGetCreateProductpage() throws Exception {
        mockMvc.perform(get("/product/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("createProduct"))
                .andExpect(model().attributeExists("product"));
    }
    @Test
    void testPostCreateProduct() throws Exception {
        Product product = new Product();
        mockMvc.perform(post("/product/create")
                        .flashAttr("product", product))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("list"));
    }
    @Test
    void testGetEditProductPage() throws Exception {
        Product product = new Product();
        product.setProductId("5ff2d744-04c8-496b-a752-232d6df01850");
        mockMvc.perform(get("/product/edit/{id}", product.getProductId()))
                .andExpect(status().isOk())
                .andExpect(view().name("editProduct"));
    }
    @Test
    void testPostEditProduct() throws Exception {
        Product product = new Product();
        product.setProductId("5ff2d744-04c8-496b-a752-232d6df01850");
        mockMvc.perform(post("/product/edit/{id}", product.getProductId())
                        .flashAttr("product", product))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/product/list"));
    }
    @Test
    void testPostDeleteProduct() throws Exception {
        Product product = new Product();
        product.setProductId("5ff2d744-04c8-496b-a752-232d6df01850");
        mockMvc.perform(post("/product/delete/{id}", product.getProductId())
                        .flashAttr("product", product))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/product/list"));
    }
}