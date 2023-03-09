package hello.aop.internalcall;

import hello.aop.internalcall.aop.CallLogAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

//import static org.junit.Assert.*;

@Slf4j
@Import(CallLogAspect.class)
@SpringBootTest
public class CallServiceV2Test {

    @Autowired
    CallServiceV2 callServiceV2;

    @Test
    public void external() {
        callServiceV2.external();
    }
}