package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    private static Scanner sc;
    private static int wiseSayingLastIndexId;
    private static List<WiseSaying> wiseSayings;
    private static WiseSayingService wiseSayingService;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayingService = new WiseSayingService();
    }

    public static void write() {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = wiseSayingService.write(content, author);
        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying.getId());
    }

    public static void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        List<WiseSaying> wiseSayings = wiseSayingService.findAll();

        for(int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);

            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
        }
    }

    public static void modify(Rq rq) {
        int id = rq.getIntParam("id", 0);

        if(id == 0) {
            System.out.println("번호를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if(wiseSaying == null) {
            System.out.printf("%d번 명언이 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("명언(기존) : %s\n", wiseSaying.getContent());
        System.out.print("명언 : ");
        String content = sc.nextLine();

        System.out.printf("작가(기존) : %s\n", wiseSaying.getAuthor());
        System.out.print("작가 : ");
        String author = sc.nextLine();

        wiseSayingService.modify(id, content, author);
        System.out.printf("%d번 명언이 수정되었습니다.\n", wiseSaying.getId());
    }

    public static void delete(Rq rq) {
        int id = rq.getIntParam("id", 0);

        if(id == 0) {
            System.out.println("번호를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if(wiseSaying == null) {
            System.out.printf("%d번 명언이 존재하지 않습니다.\n", id);
            return;
        }

        wiseSayingService.delete(id);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }
}
