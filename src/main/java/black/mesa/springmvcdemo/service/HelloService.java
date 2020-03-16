package black.mesa.springmvcdemo.service;

import org.springframework.stereotype.Service;

public class HelloService implements IHelloService {
    @Override
    public String sayHello() {
        return "你好";
    }
}
