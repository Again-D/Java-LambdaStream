
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;
/*
   자바의 표준 API에서 한개의 추상 메서드를 가진 인터페이스들은 모두 람다식을 사용할 수 있습니다.
   람다에 사용되는 함수적 인터페이스를 java.util.function 패키지에 설정해서 사용하고 있습니다.
   대표적 인터페이스 종류는 5가지
    - Consumer : 매개변수가 있고, 리턴값이 없는 경우
    - Supplier : 매개변수가 없고, 리턴값이 있는 경우
    - Function : 매개변수도 있고, 리턴값도 있는 경우
    - Operator : 매개변수도 있고, 리턴값도 있는 경우(연산의 결과)
    - Predicate : 매개변수도 있고, 리턴값은 boolean인 경우
 */



public class ConsumerEx {
    // 인터페이스 Consumer
    // Consumer<T>   - 추상메서드 void accept(T t)
    // BiConsumer<T, U> - 추상메서드 void accept(T t, U u)
    // xxxConsumer  - xxx는 데이터 타입. 각 데이터 타입에 따른 Consumer
    //             -> IntConsumer, LongConsumer, DoubleConsumer
    // ObjxxxConsumer - 객체와 기본타이믜 매개변수를 받는 Consumer
    //             -> Obj 객체를 xxx 기본 타입을
    public static void main(String[] args) {
        // Consumer 인터페이스
        Consumer<String> c1 = name ->
                System.out.println("제이름은 '"+ name +"' 입니다.");
        c1.accept("홍길동");

        BiConsumer<String, Integer> c2 = (name, age) -> {
            System.out.println("제 이름은 '"+name+"'이고, 나이는 "+age+"입니다.");
        };
        c2.accept("홍길동", 20);
        DoubleConsumer c3 = (score) -> {
            System.out.println("제 점수는 " + score + "입니다.");
        };
        c3.accept(78.8);
        ObjIntConsumer c4 = (lecture, i) -> {
            System.out.println("제 "+lecture+"의 점수는 "+i+"점 입니다.");
        };
        c4.accept("프로그래밍", 100);

    }


}
