package com.example.service;

import com.example.model.PortfolioCharacteristicsInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    private static List<PortfolioCharacteristicsInfo> portfolioCharacteristicsInfoList = new ArrayList<>();


    public void  ListtoObjectTest(){
        if(portfolioCharacteristicsInfoList.size()==0){
            createPortfolioList();
        }

        Object obj = new Object();
        obj = portfolioCharacteristicsInfoList;
        List<PortfolioCharacteristicsInfo> list = new ArrayList<>();

        if (obj.getClass().isArray()) {
            list = Arrays.asList((PortfolioCharacteristicsInfo[])obj);
        } else if (obj instanceof Collection) {
            list = new ArrayList<>((Collection<PortfolioCharacteristicsInfo>)obj);
        }
        System.out.println("list :"+list);
        Map<Integer, PortfolioCharacteristicsInfo> map = new HashMap<>();
        try {
            map = list.stream().collect(Collectors.toMap(l->l.getAccountNumber(),l-> l));
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(map);

            System.out.println("Hello System :"+ json);
        }catch(Exception e){
            System.out.println("Hello :");
        }

    }

    private List<PortfolioCharacteristicsInfo> createPortfolioList(){

        PortfolioCharacteristicsInfo p = new PortfolioCharacteristicsInfo(100,"31-01-2023","31-01-2023","ISIN10000","Average Quality","10000");
        PortfolioCharacteristicsInfo p1 = new PortfolioCharacteristicsInfo(101,"30-01-2023","30-01-2023","ISIN10001","Average Quality","10001");
        PortfolioCharacteristicsInfo p2 = new PortfolioCharacteristicsInfo(102,"29-01-2023","29-01-2023","ISIN10002","Average Quality Value","10002");
        PortfolioCharacteristicsInfo p3 = new PortfolioCharacteristicsInfo(103,"28-01-2023","28-01-2023","ISIN10003","Average Quality Value","10003");
        PortfolioCharacteristicsInfo p4 = new PortfolioCharacteristicsInfo(104,"27-01-2023","27-01-2023","ISIN10004","Average Quality Value","10004");
        PortfolioCharacteristicsInfo p5 = new PortfolioCharacteristicsInfo(105,"26-01-2023","26-01-2023","ISIN10005","Average Quality Need","10005");
        PortfolioCharacteristicsInfo p6 = new PortfolioCharacteristicsInfo(106,"25-01-2023","25-01-2023","ISIN10006","Average Quality Need","10006");

        portfolioCharacteristicsInfoList.add(p);
        portfolioCharacteristicsInfoList.add(p1);
        portfolioCharacteristicsInfoList.add(p2);
        portfolioCharacteristicsInfoList.add(p3);
        portfolioCharacteristicsInfoList.add(p4);
        portfolioCharacteristicsInfoList.add(p5);
        portfolioCharacteristicsInfoList.add(p6);

        return portfolioCharacteristicsInfoList;
    }

    public static void main(String args[]){
        Test t = new Test();
        t.ListtoObjectTest();
    }
}
