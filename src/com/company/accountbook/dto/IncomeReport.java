package com.company.accountbook.dto;

import com.company.accountbook.vo.IncomeCategory;

public class IncomeReport extends Report {
    IncomeCategory category;

    @Override
    public String toString() {
        return "금액: " + price + "\n" +
                "카테고리: " + category + "\n" +
                "내용: " + content + "\n" +
                "메모: " + memo + "\n";
    }
}
