import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx1 {
    public static void main(String[] args) {
        // 배열을 이용한 스트림 생성
        // 배열
        String[] arr = new String[] {"A", "B", "C", "D", "E", "F", "G", "H"};

        // 배열 전체 Stream 객체로 변환 : Arrays.stream()
        // 1. Stream 객체 생성
        Stream<String> stream = Arrays.stream(arr);
        // 2. 가공, 결과
        stream.forEach(s -> System.out.print(s + " "));
        System.out.println();

        // 배열의 일부를 추출하여 Stream 객체 생성
        Stream<String> stream2 = Arrays.stream(arr, 2, 7);
        stream2.forEach(s -> System.out.print(s + " "));
        System.out.println();

        // 문자열 배열을 컬렉션을 만들고, 스트림 만들기
        List<String> list = Arrays.asList(arr);   // 문자열 배열 -> List
        // List 객체를 stream() 메서드를 이용하여 Stream 객체 생성
        Stream<String> stream3 = list.stream();
        stream3.forEach(s -> System.out.print(s + " "));
        System.out.println();

        // 스트림 객체 생성: 1. build() 메서드를 이용하는 방법
        // builder() 메서드로 builder 객체 생성한 후에 add()메서드로 리턴타입이
        // builder 객체이므로 메서드 체이닝으로 작업을 진행...
        Stream stream4 = Stream.builder()
                .add("무궁화")
                .add("삼천리")
                .add("화려강산")
                .add("대한사람")
                .build();   // builder 객체를 통한 Stream 객체 생성
        stream4.forEach(s -> System.out.print(s + " "));
        System.out.println();

        // 스트림 객체 생성: 2. generate() 메서드를 이용하는 방법
        //  람다에서 Supplier<T> 인터페이스를 이용하여 값을 추가 생성...
        Stream<String> stream5 = Stream.generate(() -> "애국가").limit(10); //limit로 제한 설정
        stream5.forEach(s -> System.out.print(s + " "));
        System.out.println();

        // 스트림 객체 생성: 3. iterate() 메서드를 이용하는 방법
        Stream<Integer> stream6 = Stream.iterate(1, n -> n + 1).limit(10);
        // 1, 1 -> 1 + 1(2), ...
        stream6.forEach(s -> System.out.print(s + " "));
        System.out.println();

    }
}

