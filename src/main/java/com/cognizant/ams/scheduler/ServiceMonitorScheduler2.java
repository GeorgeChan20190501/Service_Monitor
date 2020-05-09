package com.cognizant.ams.scheduler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.cognizant.ams.service.ServiceMonitorService;
import okhttp3.*;

@Component
public class ServiceMonitorScheduler2 {

	private static Logger logger = LoggerFactory.getLogger(ServiceMonitorService.class);
	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static  OkHttpClient client;

	public static void Demo() {
	    client = new OkHttpClient.Builder()
	            .authenticator(new Authenticator() {
	                @Override
	                public Request authenticate(Route route, Response response) {
	                    System.out.println("Authenticating for response: " + response);
	                    System.out.println("Challenges: " + response.challenges());
	                    String credential = Credentials.basic("change", "Hello002");
	                    return response.request().newBuilder()
	                            .header("Authorization", credential)
	                            .build();
	                }
	            })
	            .build();
	}

	public static void  run() throws Exception {
	    Request request = new Request.Builder()
	            .url("https://metlifeprod.service-now.com/sys_attachment.do?sys_id=8a5ad1af1be050107a7fb8c11a4bcbe7")
	            .build();

	    Response response = client.newCall(request).execute();
	    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

	    System.out.println(response.body().string());
	}
	public void SMonitorScheduler() {
		// 获取邮箱配置信息
		
		
					String urlString="https://metlifeprod.service-now.com/incident_list.do?sysparm_query=incident_stateIN1%2C-6%2C2%5Eassignment_group%3Djavascript:getMyGroups()%5EORassignment_group%3Dfda186410fc80f80d5937d4ce1050ef9%5EORDERBYDESCnumber&sysparm_first_row=1&sysparm_view=";
					Request request = new Request.Builder().url(urlString).build();
					client.newCall(request).enqueue(new Callback() {

						@Override
						public void onFailure(Call call, IOException e) {
						
							logger.info("异步线程异常结束" );
							

						}

						@Override
						public void onResponse(Call call, Response response) throws IOException {
							
				
							if (!response.isSuccessful()) {
								throw new IOException("Unexpected code " + response);
							}
							
							System.out.println("success=="+response.code() );
							System.out.println(response.body().string());
						}

					});
	}

	public static void main(String[] args) throws Exception {
		Demo() ;
		run();
		  }
}
