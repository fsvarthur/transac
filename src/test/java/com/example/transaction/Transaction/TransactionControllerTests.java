package com.example.transaction.Transaction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation.document;
import static org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation.documentationConfiguration;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TransactionController.class)
public class TransactionControllerTests {

    @Rule
    public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

    @Autowired
    ApplicationContext context;

    private WebTestClient webTestClient;

    @Before
    public void setUp(){
        this.webTestClient = WebTestClient.bindToApplicationContext(context)
                .configureClient().baseUrl("https://api.example.com")
                .filter(documentationConfiguration(restDocumentation))
                .build();
    }

    @Test
    public void Transaction(){
        this.webTestClient.get().uri("/").exchange()
                .expectStatus().isOk().expectBody()
                .consumeWith(document("transaction"));
    }
}
