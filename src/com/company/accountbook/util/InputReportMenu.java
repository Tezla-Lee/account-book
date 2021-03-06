package com.company.accountbook.util;

import com.company.accountbook.service.ReportService;
import com.company.accountbook.vo.ExpenseCategory;
import com.company.accountbook.vo.IncomeCategory;
import com.company.accountbook.vo.PayCategory;

import java.time.LocalDate;
import java.util.Scanner;

public class InputReportMenu {
    ReportService reportService = new ReportService();
    InputDateMenu inputDateMenu = InputDateMenu.getInstance();
    Scanner sc = new Scanner(System.in);
    private String number;
    private String category;
    private String content;


    // 싱글톤
    private static InputReportMenu instance;

    private InputReportMenu() {
    }

    public static InputReportMenu getInstance() {
        if (instance == null) {
            instance = new InputReportMenu();
        }
        return instance;
    }

    public void inputReportMenuPrint() {
        System.out.println("1. 지출 입력");
        System.out.println("2. 수입 입력");
        System.out.println("0. 나가기");
        System.out.print(">> ");
        number = sc.nextLine();
        System.out.println();

        while (!number.equals("1") && !number.equals("2") && !number.equals("0")) {
            System.out.println("다시 입력하세요.");
            System.out.print(">> ");
            number = sc.nextLine();
            System.out.println();
        }

        if (number.equals("1")) {
            inputExpenseReport();
        } else if (number.equals("2")) {
            inputIncomeReport();
        } else {
            MainMenu.getInstance().mainMenuPrint();
        }
        System.out.println();
        inputReportMenuPrint();
    }

    public void inputExpenseReport() {
        inputDateMenu.inputReportDate();
        System.out.println("카테고리를 선택하세요.");
        System.out.println("1. " + ExpenseCategory.CLOTH.toString());
        System.out.println("2. " + ExpenseCategory.FOOD.toString());
        System.out.println("3. " + ExpenseCategory.TAX.toString());
        System.out.print(">> ");
        number = sc.nextLine();

        while (!number.equals("1") && !number.equals("2") && !number.equals("3")) {
            System.out.println("다시 입력하세요.");
            System.out.print(">> ");
            number = sc.nextLine();
            System.out.println();
        }

        if (number.equals("1")) {
            category = ExpenseCategory.CLOTH.name();
        } else if (number.equals("2")) {
            category = ExpenseCategory.FOOD.name();
        } else{
            category = ExpenseCategory.TAX.name();
        }

        System.out.print("지출 내역: ");
        content = sc.nextLine();
        System.out.print("금액: ");
        int price = Integer.parseInt(sc.nextLine());
        System.out.println("지불 수단을 선택하세요.");
        System.out.println("1. " + PayCategory.CARD.name());
        System.out.println("2. " + PayCategory.MONEY.name());
        System.out.println("3. " + PayCategory.GIFT_CARD.name());
        System.out.print(">> ");
        number = sc.nextLine();

        while (!number.equals("1") && !number.equals("2") && !number.equals("3")) {
            System.out.println("다시 입력하세요.");
            System.out.print(">> ");
            number = sc.nextLine();
            System.out.println();
        }

        String paymentMethod;
        if (number.equals("1")) {
            paymentMethod = PayCategory.CARD.name();
        } else if (number.equals("2")) {
            paymentMethod = PayCategory.MONEY.name();
        } else{
            paymentMethod = PayCategory.GIFT_CARD.name();
        }
        reportService.addReport(false, paymentMethod, category, price, content, LocalDate.of(inputDateMenu.year, inputDateMenu.month, inputDateMenu.day));
    }

    public void inputIncomeReport() {
        inputDateMenu.inputReportDate();
        System.out.println("카테고리를 선택하세요.");
        System.out.println("1. " + IncomeCategory.SALARY.name());
        System.out.println("2. " + IncomeCategory.POCKET_MONEY.name());
        System.out.println("3. " + IncomeCategory.FINANCIAL_MONEY.name());
        System.out.println("4. " + IncomeCategory.ETC.name());
        System.out.print(">> ");
        number = sc.nextLine();
        while (!number.equals("1") && !number.equals("2") && !number.equals("3") && !number.equals("4")) {
            System.out.println("다시 입력하세요.");
            System.out.print(">> ");
            number = sc.nextLine();
            System.out.println();
        }

        if (number.equals("1")) {
            category = IncomeCategory.SALARY.name();
        } else if (number.equals("2")) {
            category = IncomeCategory.POCKET_MONEY.name();
        }else if (number.equals("3")) {
            category = IncomeCategory.FINANCIAL_MONEY.name();
        } else{
            category = IncomeCategory.ETC.name();
        }

        System.out.print("수입 내역: ");
        content = sc.nextLine();
        System.out.print("금액: ");
        int price = Integer.parseInt(sc.nextLine());
        reportService.addReport(true, null, category, price, content, LocalDate.of(inputDateMenu.year, inputDateMenu.month, inputDateMenu.day));
    }
}