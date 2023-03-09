package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV1 {

    private CallServiceV1 callServiceV1;

    //생성자로 자기 자신을 의존관계를 주입할 수 없음! setter를 이용해야함
    @Autowired
    public void setCallServiceV1(CallServiceV1 callServiceV1) {
        this.callServiceV1 = callServiceV1;
    }

    public void external() {
        log.info("call external");
        callServiceV1.internal(); //외부 메스드 호출
    }

    public void internal() {
        log.info("call internal");
    }
}
