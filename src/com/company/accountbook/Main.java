package com.company.accountbook;

<<<<<<< HEAD
import com.company.accountbook.dao.AccountBookDAO;
import com.company.accountbook.dao.ReportDAO;
import com.company.accountbook.dto.AccountBook;
import com.company.accountbook.dto.Report;

import java.time.LocalDate;
=======
import com.company.accountbook.service.MonthCheckAccountBook;
import com.company.accountbook.util.Menu;

import java.util.Scanner;
>>>>>>> jb

public class Main {
    public static void main(String[] args) {
        MonthCheckAccountBook monthCheckAccountBook = new MonthCheckAccountBook();
        Scanner sc = new Scanner(System.in);
        Menu menu = Menu.getInstance();

        // 초기 화면 출력 (이번달 달력)
        monthCheckAccountBook.printCalendar();

        // 메인 메뉴 출력
        menu.mainMenuPrint();
    }
}