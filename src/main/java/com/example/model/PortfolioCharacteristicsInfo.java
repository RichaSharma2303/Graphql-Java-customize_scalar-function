package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PortfolioCharacteristicsInfo {

    private int accountNumber;
    private String asofDate;
    private String calendarDate;
    private String ISIN;
    private String sourceCharacteristicsType;
    private String fundId;

}
