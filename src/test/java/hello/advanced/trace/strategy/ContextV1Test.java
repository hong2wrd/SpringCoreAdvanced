package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.ContextV1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogin1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogin2;
import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void strategy() {
        login1();
        login2();
    }

    private void login1() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void login2() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }


    /**
     * 전략 패턴 사용
     */
    @Test
    void strategyV1() {
        StrategyLogin1 strategyLogin1 = new StrategyLogin1();
        ContextV1 context1 = new ContextV1(strategyLogin1);
        context1.execute();

        StrategyLogin2 strategyLogin2 = new StrategyLogin2();
        ContextV1 context2 = new ContextV1(strategyLogin2);
        context2.execute();
    }

}

