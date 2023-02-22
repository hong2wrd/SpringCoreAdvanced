package me.whiteship.java8to11.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        List<me.whiteship.java8to11.optional.OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
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


        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();
        boolean present1 = optional.isPresent();
        boolean present2 = optional.isEmpty();

        //값이 들어 있으면 문제가 없음, 없으면 RunTimeException(NoSuchElementException)
        if(optional.isPresent()) {
            OnlineClass onlineClass = optional.get();
            System.out.println(onlineClass.getTitle());
        }
        //get() 코드 없이 처리가 가능
        optional.ifPresent(oc -> System.out.println(oc.getTitle()));

        //orElse 는 값이 있으면 가져오고 없으면 ()를 해라, 값이 있어도 () 연산은 무조건 실행됨
        OnlineClass onlineClass = optional.orElse(createNewClass());

        //orElseGet 값이 있는 경우에는 () 을 실행 안함
        OnlineClass onlineClass2 = optional.orElseGet(App::createNewClass);

        //orElseThrow() 값이 없으면 에러를 던짐, 기본적으로 NoSuchElementException을 던짐
        OnlineClass onlineClass3 = optional.orElseThrow(() -> {
            return new IllegalStateException();
        });
        OnlineClass onlineClass4 = optional.orElseThrow(IllegalStateException::new);

        //filter 의 결과로 Optional 이 나옴, map도 사용 가능
        Optional<OnlineClass> onlineClass5 =
                optional.filter(OnlineClass::isClosed);
        System.out.println(onlineClass5.isEmpty());
        System.out.println(onlineClass5.isPresent());
        Optional<Integer> integer = onlineClass5.map(OnlineClass::getId);
        //Optional 이 반환타입인걸 받으면 번거로워짐
        Optional<Optional<Progress>> progress = onlineClass5.map(OnlineClass::getProgress);
        Optional<Progress> progress1 = progress.orElseThrow();
        Progress progress2 = progress1.orElseThrow();
        Optional<Progress> progress3 = progress.orElse(Optional.empty());
        //위를 해결하기 위해 flatMap 을 이용, progress3 과 같음
        Optional<Progress> progress4 = onlineClass5.flatMap((OnlineClass::getProgress));
    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
    }
}
