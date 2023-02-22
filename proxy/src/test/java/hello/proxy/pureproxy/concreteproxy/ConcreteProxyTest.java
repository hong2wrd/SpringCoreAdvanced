package hello.proxy.pureproxy.concreteproxy;

import hello.proxy.pureproxy.concreteproxy.code.ConcreteClient;
import hello.proxy.pureproxy.concreteproxy.code.ConcreteLogin;
import hello.proxy.pureproxy.concreteproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteLogin concreteLogin = new ConcreteLogin();
        ConcreteClient client = new ConcreteClient(concreteLogin);
        client.execute();
    }

    @Test
    void addProxy() {
        ConcreteLogin concreteLogin = new ConcreteLogin();
        TimeProxy timeProxy = new TimeProxy(concreteLogin);
        ConcreteClient client = new ConcreteClient(timeProxy);
        client.execute();
    }
}
