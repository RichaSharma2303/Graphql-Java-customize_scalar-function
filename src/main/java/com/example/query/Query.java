package com.example.query;

import com.example.model.PortfolioCharacteristicsInfo;
import com.example.service.PortfolioCharacteristicsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

	@Autowired
	private PortfolioCharacteristicsService portfolioCharacteristicsService;

	public String firstQuery () {
		return "First Query";
	}
	public String secondQuery () {
		return "Second Query";
	}

	/*public String thirdQuery(){

		   ObjectMapper mapper = new ObjectMapper();
		try {

			//Test classObject=new Test();
			//String simpleJSON = mapper.writeValueAsString(portfolioCharacteristicsService.getPortfolioCharacteristicsInfo(account_number));
			return mapper.writeValueAsString("{\"key\":\"1\",\"value\":\"2\"}");
		}catch(Exception e){
			System.out.println("Exception e:"+e);
			return "Hello";
		}
	}*/

	/*public String thirdQuery(){
		ObjectMapper mapper = new ObjectMapper();
		PortfolioCharacteristicsInfo p = new PortfolioCharacteristicsInfo(100,"31-01-2023","31-01-2023","ISIN10000","Average Quality","10000");
		String portfolioCharacteristicsInfo = null;
		try {
			portfolioCharacteristicsInfo = mapper.writeValueAsString(p);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		return portfolioCharacteristicsInfo;
	}*/

	public List<PortfolioCharacteristicsInfo> portfolioCharacteristicsInfoList (List<Integer> account_number) {
		return portfolioCharacteristicsService.getPortfolioCharacteristicsInfo(account_number);
	}


	/*public String portfolioCharacteristicsInfoList (List<Integer> account_number) {
		String simpleJSON = "";
		try {
			 ObjectMapper mapper = new ObjectMapper();
			 simpleJSON = mapper.writeValueAsString(portfolioCharacteristicsService.getPortfolioCharacteristicsInfo(account_number));
		 }catch(Exception e){
			System.out.print(" Exception" +e);
		}
		return simpleJSON;
	}*/
}
