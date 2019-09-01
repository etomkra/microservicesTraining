package guru.springframework.msscbrewery.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerInfoTest {

    @Autowired
    ServerInfo serverInfo;

    @Test
    public void shouldInstatiateServerInfo() {
        //then
        assertNotNull(serverInfo);
        assertEquals("LAPTOP-OC7GETLC", serverInfo.getHostname());
        assertEquals("8080", serverInfo.getPort());
        assertEquals("localhost/127.0.0.1", serverInfo.getIp());

    }

}