package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static Scanner sc;
    private static int wiseSayingLastId;
    private static List<WiseSaying> wiseSayings;

    public App(Scanner sc) {
        this.sc = sc;
        wiseSayingLastId = 0;
        wiseSayings = new ArrayList<>();
    }

    public static void run() {
        System.out.println("== 명언 SSG ==");

        outer:
        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            switch(cmd) {
                case "등록" :
                    int id = ++wiseSayingLastId;
                    System.out.print("명언 : ");
                    String content = sc.nextLine();
                    System.out.print("작가 : ");
                    String author = sc.nextLine();

                    WiseSaying wiseSaying = new WiseSaying(id, content, author);

                    wiseSayings.add(wiseSaying);

                    System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying.getId());
                    break;
                case "목록" :
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");
                    for(int i = wiseSayingLastId - 1; i >= 0; i--) {
                        wiseSaying = wiseSayings.get(i);
                        System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
                    }
                    break;
                case "종료" :
                    break outer;
            }
        }
    }
}
