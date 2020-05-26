package com.jmsoftware.datastructuresandalgorithms;

import com.jmsoftware.datastructuresandalgorithms.common.configuration.ProjectProperty;
import com.jmsoftware.datastructuresandalgorithms.common.configuration.ServerConfiguration;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.Instant;
import java.util.TimeZone;

/**
 * <h1>DataStructuresAndAlgorithmsApplication</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), e-mail: johnnysviva@outlook.com
 * @date 5/25/20 7:50 PM
 **/
@Slf4j
@SpringBootApplication
public class DataStructuresAndAlgorithmsApplication {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static ProjectProperty projectProperty;
    private static ServerConfiguration serverConfiguration;

    public DataStructuresAndAlgorithmsApplication(ProjectProperty projectProperty,
                                                  ServerConfiguration serverConfiguration) {
        DataStructuresAndAlgorithmsApplication.projectProperty = projectProperty;
        DataStructuresAndAlgorithmsApplication.serverConfiguration = serverConfiguration;
    }

    public static void main(String[] args) {
        val startInstant = Instant.now();
        SpringApplication.run(DataStructuresAndAlgorithmsApplication.class, args);
        val endInstant = Instant.now();
        val duration = Duration.between(startInstant, endInstant);
        log.info("🥳 Congratulations! 🎉");
        log.info("🖥 {}@{} started!", projectProperty.getProjectArtifactId(), projectProperty.getVersion());
        log.info("⏳ Deployment duration: {} seconds ({} ms)", duration.getSeconds(), duration.toMillis());
        log.info("⏰ App started at {} (timezone - {})", endInstant, TimeZone.getDefault().getDisplayName());
        log.info("{}  App running at{}  - Local:   http://localhost:{}{}/{}  - Network: {}/",
                 LINE_SEPARATOR, LINE_SEPARATOR, serverConfiguration.getServerPort(), projectProperty.getContextPath(),
                 LINE_SEPARATOR, serverConfiguration.getBaseUrl());
    }
}
