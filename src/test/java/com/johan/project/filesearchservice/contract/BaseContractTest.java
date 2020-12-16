package com.johan.project.filesearchservice.contract;

import com.johan.project.filesearchservice.service.FileSearchService;
import io.restassured.config.EncoderConfig;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.config.RestAssuredMockMvcConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith({ SpringExtension.class })
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class BaseContractTest {

  @Autowired
  private WebApplicationContext context;

  @MockBean
  private FileSearchService fileSearchService;

  @BeforeEach
  void setup() {
    final EncoderConfig encoderConfig = new EncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false);
    RestAssuredMockMvc.config = new RestAssuredMockMvcConfig().encoderConfig(encoderConfig);
    RestAssuredMockMvc.webAppContextSetup(this.context);

    when(fileSearchService.searchForKeyword(eq("text"))).thenReturn("Lorem ips text lorem ips");
  }
}