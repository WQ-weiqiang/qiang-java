package qiang.web.config;


import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import java.nio.charset.Charset;

/**
 * @author Qiang.wei
 * @date 2019/12/11 11:30
 * @Description server config
 */

@SpringBootConfiguration
public class WebServerConfiguiation {
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setUriEncoding(Charset.forName("utf-8"));//编码
        factory.addConnectorCustomizers(new MyTomcatConnectorCustomizer());
        factory.addInitializers(servletContext -> {
            System.out.println("哦吼，测试server 配置");
        });
        return factory;
    }

    class MyTomcatConnectorCustomizer implements TomcatConnectorCustomizer {
        @Override
        public void customize(Connector connector) {
            // TODO Auto-generated method stub
            Http11NioProtocol handler = (Http11NioProtocol) connector.getProtocolHandler();
            handler.setAcceptCount(2000);//排队数
            handler.setMaxConnections(500);//最大连接数
            handler.setMaxThreads(200);//线程池的最大线程数
            handler.setMinSpareThreads(10);//最小线程数
            handler.setConnectionTimeout(3000);//超时时间                    
        }

    }

}
