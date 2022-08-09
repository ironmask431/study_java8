# study_java8

목적 : java8 study

---
A. 소개
 1. JAVA8 소개 

```자바 8
● LTS 버전   
● 출시일: 2014년 3월   
● 최근 업데이트: 2020년 4월, JDK 8u251   
● 현재 자바 개발자 중 약 83%가 사용중.   

LTS(Long-Term-Support)와 비-LTS 버전의 차이   
● 비-LTS는 업데이트 제공 기간이 짧다.   
● 비-LTS 배포 주기 6개월   
● 비-LTS 지원 기간은 배포 이후 6개월   
● LTS 배포 주기 3년 (매 6번째 배포판이 LTS가 된다.)   
● LTS 지원 기간은 5년이상으로 JDK를 제공하는 밴더와 이용하는 서비스에 따라 다르다.   
● 실제 서비스 운영 환경(production)에서는 LTS 버전을 권장한다.   
● 다음 LTS: 자바 17   
● 매년 3월과 9월에 새 버전 배포   

주요 기능   
● 람다 표현식   
● 메소드 레퍼런스   
● 스트림 API   
● Optional<T>   
● ...
```
 
 
 2. 함수형 인터페이스와 람다 표현식 소개 
 ```
 함수형 인터페이스 (Functional Interface)
● 추상 메소드를 딱 하나만 가지고 있는 인터페이스
● SAM (Single Abstract Method) 인터페이스
● @FuncationInterface 애노테이션을 가지고 있는 인터페이스

람다 표현식 (Lambda Expressions)
● 함수형 인터페이스의 인스턴스를 만드는 방법으로 쓰일 수 있다.
● 코드를 줄일 수 있다.
● 메소드 매개변수, 리턴 타입, 변수로 만들어 사용할 수도 있다.

자바에서 함수형 프로그래밍
● 함수를 First class object로 사용할 수 있다.
● 순수 함수 (Pure function)
○ 사이드 이팩트가 없다. (함수 밖에 있는 값을 변경하지 않는다.)
○ 상태가 없다. (함수 밖에 있는 값을 사용하지 않는다.)
● 고차 함수 (Higher-Order Function)
○ 함수가 함수를 매개변수로 받을 수 있고 함수를 리턴할 수도 있다.
● 불변
 ```
 
 3. 자바에서 제공하는 함수형 인터페이스
 4. 람다 표현식
 5. 메소드 레퍼런스
 
--- 
B.인터페이스의 변화
  1. 인터페이스 기본 메소드와 스태틱 메소드 
  2. 자바 8 API의 기본 메소드와 스태틱 메소드
  
--- 
C. Stream
  1. Stream 소개
  2. Stream API
  
--- 
D. Optional
  1. Optional 소개
  2. Optional API
  
--- 
E. CompletableFuture
  1. 자바 Concurrent 프로그래밍 소개
  2. Executors
  3. Callable 과 Future
  4. CompletableFuture-1
  5. CompletableFuture-2

--- 
F. 그 밖에
  1. 애노테이션의 변화
  2. 배열 Parallel 정렬
  3. Metaspace
  
--- 
G. 마무리
  1. 요약 
  

