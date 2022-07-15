package com.ll.exam;

import java.util.Scanner;

public class App {

    private static Scanner sc;

    public App() {
        sc = new Scanner(System.in);
    }

    public App(Scanner sc) {
        this.sc = sc;
    }

    public static void run() {
        System.out.println("== 명언 SSG ==");

        outer:
        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            switch(cmd) {
                case "종료" :
                    break outer;
            }
        }
    }
}
