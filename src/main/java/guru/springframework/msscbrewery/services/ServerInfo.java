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
    public static final String LOCALHOST = "localhost";
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
            hostname = LOCALHOST;
        }
        ip = InetAddress.getLoopbackAddress().toString();
        if (environment.getProperty("server.port") != null) {
         if (!environment.getProperty("server.port").equals("-1")) {
                port = environment.getProperty("server.port");
                return;
            }
        }
        port = DEFAULT_PORT;
    }

}
