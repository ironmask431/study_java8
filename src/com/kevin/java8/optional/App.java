package com.kevin.java8.optional;

import com.kevin.java8.stream.OnlineClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 10. Optional 소개
 * 자바 프로그래밍에서 NullPointerException을 종종 보게 되는 이유
 *
 * ● null을 리턴하니까! && null 체크를 깜빡했으니까!
 * 메소드에서 작업 중 특별한 상황에서 값을 제대로 리턴할 수 없는 경우 선택할 수 있는 방법
 *
 * ● 예외를 던진다. (비싸다, 스택트레이스를 찍어두니까.)
 *
 * ● null을 리턴한다. (비용 문제가 없지만 그 코드를 사용하는 클리어인트 코드가 주의해야
 * 한다.)
 *
 * ● (자바 8부터) Optional을 리턴한다. (클라이언트에 코드에게 명시적으로 빈 값일 수도
 * 있다는 걸 알려주고, 빈 값인 경우에 대한 처리를 강제한다.)
 * Optional
 *
 * ● 오직 값 한 개가 들어있을 수도 없을 수도 있는 컨네이너.
 * 주의할 것
 *
 * ● 리턴값으로만 쓰기를 권장한다. (메소드 매개변수 타입, 맵의 키 타입, 인스턴스 필드
 * 타입으로 쓰지 말자.)
 *
 * ● Optional을 리턴하는 메소드에서 null을 리턴하지 말자.
 *
 * ● 프리미티브 타입용 Optional을 따로 있다. OptionalInt, OptionalLong,...
 *
 * ● Collection, Map, Stream Array, Optional은 Opiontal로 감싸지 말 것.
 */

public class App {
    public static void main(String[] args) {
       OnlineClass spring_boot = new OnlineClass(1,"spring boot", true);
//       Progress progress = spring_boot.getProgress();
//       System.out.println(progress.getStudyDuration()); // 이상태에선 .getProgress() 에서 npe 발생

        //npe를 방지하기 위해 기존 에는 아래와 같이 if문으로 null 체크를 했다.
        //하지만 이런방식은 에러유발 위험이 큼. null체크를 빼먹을 수 있기때문에.
//        if(spring_boot.getProgress() != null){
//            Progress progress2 = spring_boot.getProgress();
//            System.out.println(progress2.getStudyDuration());
//        }

        //Optional 타입을 사용해 null 체크 없이 아래와 같이 사용가능
        Optional<Progress> progress = spring_boot.getProgress();
        progress.ifPresent(duration -> System.out.println(duration));
    }
}
