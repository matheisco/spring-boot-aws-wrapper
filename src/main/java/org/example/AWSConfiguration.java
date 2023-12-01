package org.example;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.context.annotation.Configuration;
import software.amazon.jdbc.ConnectionProviderManager;
import software.amazon.jdbc.HikariPooledConnectionProvider;
import software.amazon.jdbc.HostSpec;
import software.amazon.jdbc.PropertyDefinition;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Configuration
public class AWSConfiguration {

    @PostConstruct
    void initWrapper() {
        HikariPooledConnectionProvider connProvider =
                new HikariPooledConnectionProvider(
                        AWSConfiguration::getHikariConfig,
                        AWSConfiguration::getPoolKey
                );
        ConnectionProviderManager.setConnectionProvider(connProvider);
    }

    private static String getPoolKey(HostSpec hostSpec, Properties props) {
        final String user = props.getProperty(PropertyDefinition.USER.name);
        return hostSpec.getUrl() + user;
    }

    private static HikariConfig getHikariConfig(HostSpec hostSpec, Properties props) {
        final HikariConfig config = new HikariConfig();
        config.setMaximumPoolSize(10);
        config.setInitializationFailTimeout(75000);
        config.setConnectionTimeout(10000);
        return config;
    }
}
