# 싱글톤 패턴(singleton pattern)

## 싱글톤 패턴이란?

- 어플리케이션이 시작 될 떄 어떤 클래스가 최초 한번만 할당하고(static) 그 메모리에 인스턴스를 만들어 사용하는 디자인 패턴이다.

- 예를 들어 레지스트리 같은 설정 파일의 경우 개체가 여러 개 생성되면 설정 값이 변경될 위험이 생길 수 있다.

- 인스턴스가 1개만 생성되는 특징을 가진 싱클톤 패턴을 이용하면, 하나의 인스턴스를 공유하여 사용 할 수 있게끔 할 수 있기 때문에 요청이 많은 곳에서 사용하면 효율을 높일 수 있다.

  ![image-20221117112043598](C:\Users\ay612\AppData\Roaming\Typora\typora-user-images\image-20221117112043598.png)

- 주의해야 할 점은 싱클톤을 만들 떄 동시성 문제를 고려하여 사용해야 한다.

  ![image-20221117112116159](C:\Users\ay612\AppData\Roaming\Typora\typora-user-images\image-20221117112116159.png)

### 싱글톤 패턴이 필요한 이유

![image-20221117112211712](C:\Users\ay612\AppData\Roaming\Typora\typora-user-images\image-20221117112211712.png)

사무실에 있는 1대의 프린터를 여러명이 사용하는 경우를 예시로 들어보겠습니다.

- 이러한 상황에서 가장 정상적인 프린터 사용 법은, **1대만 존재하는 프린터를 여러 사람이 함께 공유하며 사용하는 방법이 있다.**

- 하지만 위의 사진에서 오른쪽의 경우 처럼, **프린터를 사용하려는 사람들이 프린터를 각자 생성해서 사용하는것은 불가능 합니다.** 우리의 프린터는 단 1대만 존재하기 때문입니다.

- 정리

  - 프린터는 단 1개만 존재 한다.
  - 여러 사람이 1대의 프린터를 공유하여 사용한다.

  - 이러한 상황은 현실에서도 존재하지만, 우리가 개발하는 프로그램 안에서도 존재할 수 있습니다.

  - 프로그램 내 에서 단 1개만 존재해야 하는 객체가 있으며 이를 프로그램 내부의 여러 부분에서 호출하여 사용하는 경우이다.

  예를들어, 프로그램 내부에서 발생하는 이벤트들을 스케쥴링 하고 처리하는 객체가 있다고 할 때 프로그램 내부의 모든 이벤트는 하나의 같은 스케쥴링 큐 에 들어가서 처리되어야 합니다. 이벤트 발생 마다 스케쥴링 큐를 따로 따로 생성하면 프로그래머의 의도와 어긋나는 일이다.

  싱글톤 패턴을 적용할 수 있을 만한 상황을 정리해보면 다음과 같습니다.

  - 프로그램 내 에서 어떤 객체가 단 1개만 존재해야 한다.
  - 프로그램 내부의 여러 부분에서 이 객체를 공유하며 사용한다.

  위와 같은 상황에서, 싱글톤 패턴은 **객체가 프로그램 내부에서 단 1개만 생성됨 을 보장**하며 **멀티 스레드에서 이 객체를 공유하며 동시에 접근하는 경우에 발생하는 동시성 문제도 해결**해주는 디자인 패턴 입니다.

## 싱글톤 패턴의 장점

- 고정된 메모리 영역을 얻으면서 한 번의 NEW로 인스턴스를 사용하기 때문에 메모리 낭비를 방지 할 수 있다.
- 싱글톤으로 만들어진 클래스의 인스턴스는 전역이기 떄문에 다른 클래스의 인스턴스들이 데이터를 공유하기 쉽다.
- 인그턴스가 절대적으로 한 개만 존재하는 것을 보증하고 싶을 경우 사용 가능하다.
- 두번 째 이용시 객체 로딩 시간이 줄어 성능이 좋아지는 강점이 있다.

## 싱글톤 패턴의 단점

- 싱글톤 인스턴스가 너무 많은 일을 하거나 많은 데이터를 공유시킬 경우에 다른 클래스의 인스턴스가 2개가 생성 될 수 있는 가능성이 생기게 된다.
- 그러므로 수정이 어려워지고 유지보수의 비용이 높아지는 문제가 있어 꼭 필요한 경우가 아니라면 지양해야 한다고 한다.
- 멀티쓰레드 환경에서 동기화 처리를 하지 않으면 인스턴스가 두개가 생성된다던지 하는 경우가 발생할 수 있다.