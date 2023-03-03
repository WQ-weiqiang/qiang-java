package com.qiang.sprintbootdataelasticsearch.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * @author Qiang.wei
 * @date 2019/8/2 10:39
 * @Description
 */

public class Config {
    @Configuration
    public class RestClientConfig extends AbstractElasticsearchConfiguration {

        @Override
        @Bean
        public RestHighLevelClient elasticsearchClient() {

            final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                    .connectedTo("192.168.233.129:9200")
                    .build();

            return RestClients.create(clientConfiguration).rest();
        }
    }
}
