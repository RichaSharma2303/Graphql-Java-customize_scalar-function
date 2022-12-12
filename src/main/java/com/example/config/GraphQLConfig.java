package com.example.config;

import com.example.model.PortfolioCharacteristicsInfo;
import com.example.scaler.function.PortfolioCharacteristicsScaler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import graphql.schema.*;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class GraphQLConfig {

    /*@Bean
    public RuntimeWiring runtimeWiringConfigurer() {
        //return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.DateTime);
        return RuntimeWiring.newRuntimeWiring().scalar(PortfolioCharacteristicsScaler.EMAIL).build();
    }*/

    @Bean
    public GraphQLScalarType portfolioType()
    {
        return GraphQLScalarType.newScalar()
                .name("PortfolioCharacteristicsScalar")
                .description("A custom scalar that handles emails")
                .coercing(new Coercing() {
                    @Override
                    public Object serialize(Object dataFetcherResult) {
                        System.out.print("dataFetcherResult :"+dataFetcherResult.toString());
                        return serializePortfolioCharacteristicsInfo(dataFetcherResult);
                    }

                    @Override
                    public Object parseValue(Object input) {
                        return parseCharectristicsFromVariable(input);
                    }

                    @Override
                    public Object parseLiteral(Object input) {
                        return parseCharectristFromAstLiteral(input);
                    }
                })
                .build();
    }

        private static Object parseCharectristicsFromVariable(Object obj)  {
            String json = "";
            if (obj instanceof Collection) {
                //obj = portfolioCharacteristicsInfoList;
                List<PortfolioCharacteristicsInfo> list = new ArrayList<>();
                list = new ArrayList<>((Collection<PortfolioCharacteristicsInfo>)obj);

                System.out.println("list :"+list);
                Map<Integer, PortfolioCharacteristicsInfo> map = new HashMap<>();
                try {
                    map = list.stream().collect(Collectors.toMap(l->l.getAccountNumber(), l-> l));
                    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                    json = ow.writeValueAsString(map);

                    System.out.println("Hello System :"+ json);

                }catch(Exception e){
                    System.out.println("Hello :");
                }
                //return json;
                return map;
            }
            throw new CoercingParseValueException("Unable to parse variable value " + obj + " as an email address");
        }

        private Map<Integer, List<PortfolioCharacteristicsInfo>> convertListIntoMap(Object object){
            Map<Integer, List<PortfolioCharacteristicsInfo>> map = new HashMap<>();
            return map;
        }

        private static Map<Integer, PortfolioCharacteristicsInfo> serializePortfolioCharacteristicsInfo(Object obj) {

            String possibleEmailValue = String.valueOf(obj);
            System.out.print("possibleEmailValue :"+possibleEmailValue);
            Map<Integer, PortfolioCharacteristicsInfo> map = new HashMap<>();
            String json = "";
            if (obj instanceof Collection) {
                //obj = portfolioCharacteristicsInfoList;
                List<PortfolioCharacteristicsInfo> list = new ArrayList<>();
                list = new ArrayList<>((Collection<PortfolioCharacteristicsInfo>)obj);

                System.out.println("list :"+list);

                try {
                    map = list.stream().collect(Collectors.toMap(l->l.getAccountNumber(), l-> l));
                    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                    json = ow.writeValueAsString(map);

                    System.out.println("Hello System :"+ json);

                }catch(Exception e){
                    System.out.println("Hello :");
                }
                return map;
            }else if(null != obj){
                List<PortfolioCharacteristicsInfo> list = new ArrayList<>();
                //PortfolioCharacteristicsInfo[] array = ()
                //list =  (List<PortfolioCharacteristicsInfo>)obj;
                System.out.println(" list :"+list);
            }
            throw new CoercingSerializeException("Unable to serialize " + obj + " as an email address");
        }

        private static Object parseCharectristFromAstLiteral(Object obj) {
            String json = "";
            if (obj instanceof Collection) {
                //obj = portfolioCharacteristicsInfoList;
                List<PortfolioCharacteristicsInfo> list = new ArrayList<>();
                list = new ArrayList<>((Collection<PortfolioCharacteristicsInfo>)obj);

                System.out.println("list :"+list);
                Map<Integer, PortfolioCharacteristicsInfo> map = new HashMap<>();
                try {
                    map = list.stream().collect(Collectors.toMap(l->l.getAccountNumber(), l-> l));
                    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                    json = ow.writeValueAsString(map);

                    System.out.println("Hello System :"+ json);

                }catch(Exception e){
                    System.out.println("Hello :");
                }
                return json;
            }
            throw new CoercingParseLiteralException(
                    "Value is not any email address : '" + String.valueOf(obj) + "'"
            );
        }

    }
