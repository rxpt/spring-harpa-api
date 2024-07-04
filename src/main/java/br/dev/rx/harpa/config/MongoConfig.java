package br.dev.rx.harpa.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.dev.rx.harpa.repositories")
public class MongoConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Value("${spring.data.mongodb.database}")
    private String mongoDbName;

    @Bean
    public MongoClient mongoClient() {
        if (mongoUri == null || mongoUri.isEmpty()) {
            throw new IllegalStateException("Variável de ambiente 'spring.data.mongodb.uri' não definida.");
        }
        return MongoClients.create(mongoUri);
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, mongoDbName);
    }
}
