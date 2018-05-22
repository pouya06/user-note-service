package com.activemeasure.note.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "note-service")
public class UserConfigurationProperties {
    private String actuatorUsername;
    private String actuatorPassword;

    public String getActuatorUsername() {
        return actuatorUsername;
    }

    public void setActuatorUsername(String actuatorUsername) {
        this.actuatorUsername = actuatorUsername;
    }

    public String getActuatorPassword() {
        return actuatorPassword;
    }

    public void setActuatorPassword(String actuatorPassword) {
        this.actuatorPassword = actuatorPassword;
    }
}
