package com.ncs.kaisquare.ids;

import java.io.BufferedReader;
import java.nio.Buffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamApi {

    public static void main(String[] args) throws Exception{
        //create a stream instance

//        Stream<String> emptyStream = Stream.empty();
//        Stream<String> collectionStream = Arrays.asList("a","b","c","d").stream();
//        Stream<String> arrayStream = Stream.of("e","f","g","h");
//        Stream<String> builderStream = Stream.<String>builder().add("test1").add("test2").build();
//        Stream<String> generateStream = Stream.generate(()->"generate").limit(5);
//        Stream<Integer> iterateStream = Stream.iterate(20,x->x+2).limit(20);

        //iterateStream.forEach(x-> System.out.println(x));

//        Path paths = Paths.get("G:\\test.txt");
//        Stream<String> fileStream = Files.lines(paths);
//        fileStream.filter(x->x.toLowerCase().contains("error"))
//                    .forEach(x-> System.out.println("content:"+x));


        //******Java 8 streams can’t be reused.******
        //Optional<String> any = fileStream.filter(x->x.toLowerCase().contains("error")).skip(1).findAny();
        //System.out.println(any.get());

//        Arrays.asList("abcdefg","hijk","12345","adasd").stream().map(x->x.substring(0,3))
//                .map(e->e.toUpperCase())
//                .sorted()
//                .forEach(System.out::println);

//        Supplier<Stream<String>> supplier = ()->Stream.of("tom,15,male","peter,18,male","jack,29,male","json,20,female","james,25,female");
//        List<String> list = supplier.get().filter(x->x.startsWith("j"))
//                .map(x->x.toUpperCase())
//                .collect(toList());
//        list.forEach(System.out::println);
//
//        supplier.get().flatMap((x)->{
//            String[] values = x.split(",");
//            if(Integer.parseInt(values[1])>=20) {
//                return Arrays.asList(values).stream();
//            }else{
//                return null;
//            }
//        }).forEach(j-> System.out.println(j));

        class Person{
            public String name;
            public String gender;
            public int age;

            public Person(String name, String gender, int age) {
                this.name = name;
                this.gender = gender;
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            @Override
            public String toString() {
                return "Person{" +
                        "name='" + name + '\'' +
                        ", gender='" + gender + '\'' +
                        ", age=" + age +
                        '}';
            }

            @Override
            public boolean equals(Object obj) {
                Person p = (Person)obj;
                System.out.println("invoke equals method");
                if(p.name.equals(this.name) && p.age==this.age){
                    return true;
                }
                return false;
            }
        }

//        List<Person> persons =  new ArrayList<Person>();
//        persons.add(new Person("zhangsan","male",18));
//        persons.add(new Person("zhangsan1","female",18));
//        persons.add(new Person("zhangsan","female",18));
//        persons.add(new Person("lisi","male",18));

//        persons.stream()
//                .distinct()
//                .collect(Collectors.toList())
//                .forEach(x-> System.out.println(x));


//        List<String> stringList = new ArrayList<String>();
//
//        stringList.add("abc");
//        stringList.add("def");
//
//        Stream<String> stream = stringList.stream();
//
//        Stream<String> streamPeeked = stream.peek((value) -> {
//            System.out.println(value);
//        });


//        List<String> stringList = new ArrayList<String>();
//
//        stringList.add("One flew over the cuckoo's nest");
//        stringList.add("To kill a muckingbird");
//        stringList.add("Gone with the wind");
//
//        Supplier<Stream<String>> supplier = ()->stringList.stream();
//        Optional<String> reduced = supplier.get().reduce((value, combinedValue) -> {
//            return combinedValue + " + " + value;
//        });
//
//        Optional<String> result = supplier.get().reduce((item1,item2)->{
//            return item1.length()>item2.length()?item1:item2;
//        });
//
//        System.out.println(reduced.get());
//        System.out.println(result.get());


//        IntStream intStream = IntStream.of(3,4,5,6,7);
//
//        int result = intStream.reduce(2,(item1,item2)->{
//            return item1*item2;
//        });
//        System.out.println(result);
//
//
//        OptionalInt optional = IntStream.range(2, 8)
//                .reduce((num1, num2) -> num1 * num2);
//
//        // Displaying the product
//        System.out.println(optional.orElse(-1));


        ExecutorService executorService =  Executors.newFixedThreadPool(3);
        Future future = executorService.submit(new myThread());
        Future<String> callableFuture = executorService.submit(new TestCallable());
        System.out.println(callableFuture.get(200, TimeUnit.SECONDS));
        executorService.shutdown();

        Path path = Paths.get("G://test.txt");
        BufferedReader buffer = Files.newBufferedReader(path, Charset.defaultCharset());
        String s = null;
        while((s = buffer.readLine())!=null){
            System.out.println(s);
        }

        Files.lines(path).forEach(System.out::println);




    }

    public static int test(int value){
        if(value<=0){
            return 0;
        }else if(value>0 && value<=2){
            return 1;
        }else{
            return test(value-1)+test(value-2);
        }
    }

    static class myThread implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    static class TestCallable implements Callable<String>{
        @Override
        public String call() throws Exception {
            return Thread.currentThread().getName();
        }
    }
}
