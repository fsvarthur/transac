package com.example.transaction.Transaction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation.document;
import static org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation.documentationConfiguration;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TransactionController.class)
@WebFluxTest(controllers = TransactionController.class)
public class TransactionControllerTests {

    @Rule
    public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

    @Autowired
    ApplicationContext context;

    private WebTestClient webTestClient;

    @Before
    public void setUp(){
        this.webTestClient = WebTestClient.bindToApplicationContext(this.context)
                .configureClient()
                .filter(documentationConfiguration(this.restDocumentation))
                .build();
    }

    @Test
    public void Transaction(){
        this.webTestClient.get().uri("/").accept(MediaType.APPLICATION_JSON)
                .exchange().expectStatus().isOk()
                .expectBody().consumeWith(document("index"));
    }
}
