package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo1 {

    public static void main(String[] args) throws InterruptedException {

//        String str = "    MemFree:          556620 kB".toLowerCase()
//                .replaceAll("memfree:","")
//                .replaceAll("kb","")
//                .replaceAll(" ", "");
//        System.out.println(str);


        String format = "%02d";
        System.out.println(String.format(format, 100));
    }
}
