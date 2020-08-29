package com.service.product.resource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.product.JsonUtil;
import com.service.product.entity.Product;
import com.service.product.service.ProductService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

class ProductRestControllerTest {

    private static final String BASE_URL = "http://localhost:8000/api/product";
    @InjectMocks
    ProductRestController productRestController;

    @Mock
    private ProductService productService;

    MockMvc mockMvc;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productRestController).build();
    }

    @Test
    void should_return_all_product_response() throws Exception {
        //Given
        Product p1 = Product.builder().id(1L).build();
        List<Product> productsResponse = Arrays.asList(p1);

        //When
        when(productService.findAllProducts()).thenReturn(productsResponse);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        List<Product> products = JsonUtil.convertStringToList(content, Product.class);

        //Then
        Assertions.assertThat(products).isNotEmpty();
        Assertions.assertThat(products).contains(p1);
    }
}