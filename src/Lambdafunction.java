public class Lambdafunction {

    /*
    [람다식 ( 간결한 코드를 위해서 사용)]
      고전적 방식인 객체지향적인 프로그래밍 방식이 아닌 함수식 프로그래밍을 위한 기법으로 사용.
      람다는 익명함수를 위한 방식. 람다는 기존방식보다 자바코드를 간결하게 표현할 수 있음.
      이런 장점을 가지고 있다. 다만, 처음에는 익숙치 않아서 혼란스러울 수 있음.

      람다식은 함수적 인터페이스를 자료형으로 사용.
      함수적 인터페이스? 추상 메서드가 한개만 존재하는 인터페이스를 가리킴.

    [람다식의 표현]
      (타입 매개변수) -> { 실행문들... }
      매개변수가 없는 경우에는 () -> {} 식으로 표현 가능.
      매개변수가 한개 라면 ()를 생략하여 표현하는 것도 가능함.

    ==>> 람다식은 함수적 인터페이스를 사용하여
         인터페이스 변수 = 람다식; 같은 구조로 처리를 한다.

    */

    public static void main(String[] args) {
        // 첫번째 람다식
        InterfaceEx ie = (int a, int b) -> a + b; // {} 생략 이유는 한줄이어서, return 생략 이유는 한줄이어서..
        System.out.println(ie.sum(10, 20));

        // 함수적 인터페이스
        LambdaInterface1 l1 = () -> {
            String str = "메서드 출력";
            System.out.println(str);
        };
        l1.print();

        Runnable r = () -> {System.out.println("출력");};
        r.run();

        // 람다식 표현
        // 표준
//        LambdaInterface2 li1 = (String name) -> {
//            System.out.println("제 이름은 : " + name + " 입니다.");
//        };
        // () 생략 & String 타입 생략
//        LambdaInterface2 li1  = name -> {
//            System.out.println("제 이름은 : " + name + " 입니다.");
//        };
        // {} 생략 - 결과가 하나의 실행문인 경우
        LambdaInterface2 li1 = name -> System.out.println("제 이름은 : " + name + " 입니다.");
        li1.print("홍길동");

        // 매개 변수가 2개 이상인 경우에는 () 생략 불가..
        // 반환 값이 존재하는 경우
        LambdaInterface3 li2 = (a,b) -> {
            return a * b;
        };
        System.out.println("두 수의 곱 : " + li2.calc(3,2));
        li2 = (a,b) -> a + b;
        System.out.println("두 수의 합 : " + li2.calc(3,2));
        li2 = (a,b) -> {return a - b;};
        System.out.println("두 수의 차 : " + li2.calc(3,2));
    }

}

// 람다식 테스트를 위한 인터페이스(함수적 인터페이스)
interface InterfaceEx {
    public int sum(int a, int b);
//    public int sub(int a, int b);
}

@FunctionalInterface        // 해당 인터페이스는 함수적 인터페이스 임을 알림...
interface LambdaInterface1 {
    void print();
//    void print2();
}

@FunctionalInterface
interface LambdaInterface2 {
    void print(String name);    // 매개 변수 존재하고, 반환 타입이 없는 경우
}

@FunctionalInterface
interface LambdaInterface3 {
    int calc(int a, int b);
}