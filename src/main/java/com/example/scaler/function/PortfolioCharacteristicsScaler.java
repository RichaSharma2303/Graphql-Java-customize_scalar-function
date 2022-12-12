package com.example.scaler.function;

import com.example.model.PortfolioCharacteristicsInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import graphql.language.ScalarTypeDefinition;
import graphql.schema.*;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class PortfolioCharacteristicsScaler {


    public static final GraphQLScalarType EMAIL = GraphQLScalarType.newScalar()
            .name("PortfolioCharacteristicsScaler")
            .description("A custom scalar that handles emails")
            .coercing(new Coercing() {
                @Override
                public Object serialize(Object dataFetcherResult) { return serializePortfolioCharacteristicsInfo(dataFetcherResult); }

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
            return json;
        }
        throw new CoercingParseValueException("Unable to parse variable value " + obj + " as an email address");
    }

    private Map<Integer, List<PortfolioCharacteristicsInfo>> convertListIntoMap(Object object){
        Map<Integer, List<PortfolioCharacteristicsInfo>> map = new HashMap<>();
        return map;
    }

    private static Object serializePortfolioCharacteristicsInfo(Object obj) {

        //String possibleEmailValue = String.valueOf(dataFetcherResult);
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

    /* public PortfolioCharacteristicsScaler(String name, String description, Coercing coercing) {
        super("PortfolioCharacteristicsScaler", "PortfolioCharacteristicsScaler", new Coercing() {
            @Override
            public Object serialize(Object dataFetcherResult) {
                return serializeEmail(dataFetcherResult);
            }

            @Override
            public Object parseValue(Object input) {
                return parseCharectristicsFromVariable(input);
            }

            @Override
            public Object parseLiteral(Object input) {
                return parseCharectristFromAstLiteral(input);
            }
        });
    }*/

   /* Coercing coercingTest=new Coercing() {
        @Override
        public Object serialize(Object dataFetcherResult) {
            return serializeEmail(dataFetcherResult);
        }

        @Override
        public Object parseValue(Object input) {
            return parseCharectristicsFromVariable(input);
        }

        @Override
        public Object parseLiteral(Object input) {
            return parseCharectristFromAstLiteral(input);
        }
    };

    public PortfolioCharacteristicsScaler(String name, String description, Coercing coercing, List<GraphQLDirective> directives, ScalarTypeDefinition definition) {
        super(name, description, coercing, directives, definition);
    }*/

   /* private static Object parseEmailFromAstLiteral(Object input) {
        if (input instanceof StringValue) {
            String possibleEmailValue = ((StringValue) input).getValue();
            if (looksLikeAnEmailAddress(possibleEmailValue)) {
                return possibleEmailValue;
            }
        }
        throw new CoercingParseLiteralException(
                "Value is not any email address : '" + String.valueOf(input) + "'"
        );
    }*




    private static Object parseEmailFromVariable(Object input) {
        if (input instanceof String) {
            String possibleEmailValue = input.toString();
            if (looksLikeAnEmailAddress(possibleEmailValue)) {
                return possibleEmailValue;
            }
        }
        throw new CoercingParseValueException("Unable to parse variable value " + input + " as an email address");
    }


/
    */


}
