package com.min.fresh.utils;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TossAPI {
	
	private String apiKey;
	private String retUrl;
	private String retCancelUrl;
	
	
	@SuppressWarnings("unchecked")
	public JSONObject doToss(Map<String, Object> map) {
		URL url = null;
		URLConnection connection = null;
		StringBuilder responseBody = new StringBuilder();
		try {
			url = new URL("https://pay.toss.im/api/v1/payments");
			connection = url.openConnection();
			connection.addRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			System.out.println(map.toString()+"맵쩜 투스트링");
			org.json.simple.JSONObject jsonBody = new JSONObject();
			jsonBody.put("orderNo", String.valueOf(map.get("orderNo"))); // 거래 주문번호 임의로 설정하면 됨 최대 50자
			jsonBody.put("amount", String.valueOf(map.get("amount"))); // 결제 금액 (입력 받아야함)
			jsonBody.put("amountTaxFree", 0); // 결제금액 중 비과세금액(?)
			jsonBody.put("productDesc", String.valueOf(map.get("productDesc"))); // 상품 설명
			jsonBody.put("apiKey", apiKey); // 가맹점 키 (추후 실 거래시 발급받은 키 사용)
		    jsonBody.put("autoExecute", true); // 자동 승인 여부 (true 를 사용하는 경우, 구매자 인증이 완료되면 토스가 알아서 승인을 진행합니다. 가맹점의 판매 상품에 따라 활용해 주시면 됩니다.)
		    jsonBody.put("resultCallback", "http://YOUR-SITE.COM/callback");
		    jsonBody.put("retUrl", retUrl); // Web 결제 완료 후 연결할 웹페이지의 URL
		    jsonBody.put("retCancelUrl", retCancelUrl); // 토스 브릿지 페이지에서 사용자가 결제를 중단할때 사용자를 이동시킬 가맹점 페이지

			BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
			
		    bos.write(jsonBody.toJSONString().getBytes(StandardCharsets.UTF_8));
			bos.flush();
			bos.close();

			
		    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
			String line = null;
			while ((line = br.readLine()) != null) {
				responseBody.append(line);
			}
			br.close();
		} catch (Exception e) {
			responseBody.append(e);
		}
		JSONParser jsonpar = new JSONParser();
		JSONObject json = null;
		try {
			 json = (JSONObject) jsonpar.parse(responseBody.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return json;
	}


	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}


	public void setRetUrl(String retUrl) {
		this.retUrl = retUrl;
	}


	public void setRetCancelUrl(String retCancelUrl) {
		this.retCancelUrl = retCancelUrl;
	}


	public String getApiKey() {
		return apiKey;
	}


	public String getRetUrl() {
		return retUrl;
	}


	public String getRetCancelUrl() {
		return retCancelUrl;
	}

	
	
	
}
