package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV2 {

//    private final ApplicationContext applicationContext;
//    public CallServiceV2(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//    }
    //ApplicationContext는 너무 거대하고 기능이 너무 많음. 비추

    //ObjectProvider의 사용을 추천 실제 객체를 사용하는 시점으로 지연하여 사용하는 것(LAZY)
    private final ObjectProvider<CallServiceV2> callServiceV2Provider;

    public CallServiceV2(ObjectProvider<CallServiceV2> callServiceV2Provider) {
        this.callServiceV2Provider = callServiceV2Provider;
    }


    public void external() {
        log.info("call external");
//        CallServiceV2 callServiceV2 = applicationContext.getBean(CallServiceV2.class);
        CallServiceV2 callServiceV2 = callServiceV2Provider.getObject();
        callServiceV2.internal(); //외부 메스드 호출
    }

    public void internal() {
        log.info("call internal");
    }
}
