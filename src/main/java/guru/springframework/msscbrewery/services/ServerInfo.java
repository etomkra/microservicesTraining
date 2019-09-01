package guru.springframework.msscbrewery.services;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
@Data
public class ServerInfo {
    private static final String DEFAULT_PORT = "8080";
    private String hostname;
    private String ip;
    private String port;

    @Autowired
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Environment environment;

    @PostConstruct
    private void setInfo() {
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            hostname = "localhost";
        }
        ip = InetAddress.getLoopbackAddress().toString();
        port = environment.getProperty("server.port") != null ? environment.getProperty("server.port"): DEFAULT_PORT;
    }

}
