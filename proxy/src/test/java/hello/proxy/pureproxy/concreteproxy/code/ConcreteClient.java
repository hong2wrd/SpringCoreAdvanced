package hello.proxy.pureproxy.concreteproxy.code;

public class ConcreteClient {

    private ConcreteLogin concreteLogin;

    public ConcreteClient(ConcreteLogin concreteLogin) {
        this.concreteLogin = concreteLogin;
    }

    public void execute() {
        concreteLogin.operation();
    }
}
