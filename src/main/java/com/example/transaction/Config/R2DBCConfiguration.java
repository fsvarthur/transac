package com.example.transaction.Config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;

@Configuration
@EnableR2dbcRepositories
public class R2DBCConfiguration extends AbstractR2dbcConfiguration {

    @Override
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get(ConnectionFactoryOptions.builder()
                .option(DRIVER, "postqresql")
                .option(HOST,"localhost")
                .option(PORT,5432)
                .option(USER, "postgres")
                .option(PASSWORD, "admin")
                .build());
    }
}
