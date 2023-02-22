package me.whiteship.java8to11.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        List<me.whiteship.java8to11.optional.OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));


        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
        /**
         * Optional 을 사용하기 전 null check
         * null 을 return 하는 것도 문제점이 됨
         */
//        Progress progress = spring_boot.getProgress();
//        if (progress != null) {
//            System.out.println(progress.getStudyDuration());
//        }
        /**
         * map 에서 key null 아님, 키타입에는 쓰지 말것
         * 인스턴스 타입에서 안쓰는 게 좋음
         */

        /**
         * Optional.of(10); -> 박싱, 언박싱이 이루어짐, 성능면에서 좋지 않음
         * OptionalInt.of(10); -> 이러게 쓰는걸 권장(프리미티브 타입용)
         */

        /**
         * Collection, Map, Steam, Array, Optional 은 Optional 로 감싸지 말 것!
         */

    }
}
