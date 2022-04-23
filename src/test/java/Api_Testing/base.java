package Api_Testing;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;




public class base {
	
	RequestSpecification request;
	
	Response response;
	
	String tok;
	
	int id =5;
	
	int idput;
	
	String basic ="YWRtaW46cGFzc3dvcmQxMjM=";
	
	String payloadpost ="{\"firstname\":\"channaveer\",\"lastname\":\"murud\",\"totalprice\":\"111\",\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2018-01-01\",\"checkout\":\"2019-01-01\"},\"additionalneeds\":\"Breakfast\"}";
	String payloadput ="{\"firstname\":\"anu\",\"lastname\":\"murud\",\"totalprice\":\"111\",\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2018-01-01\",\"checkout\":\"2019-01-01\"},\"additionalneeds\":\"Breakfast\"}";
	String payloadpatch="{\"firstname\":\"James\",\"lastname\":\"Brown\"}";
	
	static Logger logger = LogManager.getLogger(base.class.getName());
	
    	
    }



