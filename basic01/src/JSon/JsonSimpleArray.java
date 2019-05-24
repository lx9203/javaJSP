package JSon;

import org.json.simple.*;

public class JsonSimpleArray {

	public static void main(String[] args) {
		System.out.println("---------------------------------");
		System.out.println("JSON String 생성");
		JSONObject jObj = new JSONObject();
		
		JSONArray jArray = new JSONArray();
		jArray.add("구겅");
		jArray.add("수악");
		jArray.add("녕어");
		jObj.put("subject", jArray);
		
		System.out.println(jObj.toString());
		
		System.out.println("----------------------------------");
		System.out.println("JSON String 파싱");
		try {
			JSONArray rSub = (JSONArray) jObj.get("subject");
			System.out.println("Size = " + rSub.size());
			for (int i=0; i<rSub.size(); i++) {
				System.out.println("subject[" + i + "] : " + (String)rSub.get(i));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
