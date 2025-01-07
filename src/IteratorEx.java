import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorEx {
    /*
        스트림 : 여러 값들을 가지고 있는 배열이나 콜렉션 등 for문이 아닌 함수형 인터페이스를
        이용해서 반복 처리할 수 있는 기능. 자바의 필수 기능은 아니지만, 가독성 좋은 코드를
        생성하기 위해서 알아둬야 합니다.(점점 많이 사용해요)

        스트림은 람다(함수형 인터페이스)를 활용해서 내부반복자를 이용. 시간과 코드의 양을 줄여줌
        또한 스트림을 통해서 간단하게 병렬 처리가 가능함.

        스트림의 처리 단계
        1. 생성 : 스트림 인스턴스 생성
        2. 가공 : 필터링과 매핑 등 원하는 결과를 만들어가는 중간 작업
        3. 결과 : 최종적으로 결과를 얻어내는 작업

        외부 반복자 vs 내부 반복자
         외부 반복자 : 콜렉션 내에서 요소를 반복문을 통해서 하나씩 읽어 처리하는 방식
         내부 반복자 : 스트림의 forEach 메서드를 람다식으로 기술하는 방식을 의미
     */
    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[] {
                "홍길동","김유신","이순신","유관순"
        });
        // for문을 이용
        System.out.println("for문 이용");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        // 외부반복자
        System.out.println("외부 반복자를 이용");
        // 컬렉션 프레임워크에 요소를 읽어오는 표준화 클래스... Iterator
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {   // iterator는 hasNext()-반복값의 존재 유무
            // next()
            System.out.println(iterator.next());
        }

        System.out.println("내부 반복자 이용");
        list.forEach(s -> System.out.println(s));
//        list.forEach(System.out::println);
    }
}
