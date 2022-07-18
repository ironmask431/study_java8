package com.kevin.java8.optional;

import com.kevin.java8.stream.OnlineClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        OnlineClass spring_boot = new OnlineClass(1,"spring boot", true);
//        Progress progress = spring_boot.getProgress();
//        System.out.println(progress.getStudyDuration()); // 이상태에선 .getProgress() 에서 npe 발생

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
