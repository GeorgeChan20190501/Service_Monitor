package com.cognizant.ams.scheduler;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cognizant.ams.bean.SmApplist;
import com.cognizant.ams.bean.SmConfig;
import com.cognizant.ams.bean.SmResult;
import com.cognizant.ams.service.ServiceMonitorService;
import okhttp3.*;

@Component
public class ServiceMonitorScheduler {

	@Autowired
	private ServiceMonitorService serviceMonitorService;
	private static Logger logger = LoggerFactory.getLogger(ServiceMonitorService.class);
	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private final OkHttpClient client = new OkHttpClient.Builder().readTimeout(20, TimeUnit.SECONDS).
	// authenticator(authenticator).
			build();
	String subjectFail="";
	String tail="";
	String subjectSuccess="";
	public  void SMonitorScheduler() {
		//获取邮箱配置信息
		
		List<SmConfig>smConfiglist=serviceMonitorService.getEmailConfigInfo();
		for (SmConfig smConfig : smConfiglist) {
			if(smConfig.getCkey().equals("subjectFail")) {
				subjectFail=smConfig.getCval1();
			}
			if(smConfig.getCkey().equals("tail")) {
				tail=smConfig.getCval1();
			}
			if(smConfig.getCkey().equals("subjectSuccess")) {
				subjectSuccess=smConfig.getCval1();
			}
		}
		List<SmApplist> list = serviceMonitorService.getAppList();
		String date = simpleDateFormat.format(new Date());
		SmResult [] smResult = new SmResult[1];
		String[] message = new String[3];
		for (SmApplist smApplist : list) {
			String url1 = smApplist.getAppUrl1();
			String url2 = smApplist.getAppUrl2();
			String url3 = smApplist.getAppUrl3();
			String urls[] = new String[3];
			urls[0] = url1;
			urls[1] = url2;
			urls[2] = url3;
			String app_id = smApplist.getAppId();
			String app_name = smApplist.getAppName();
			String app_owner = smApplist.getAppOwner();
			String app_describ = smApplist.getAppDescrib();
			String ownerEmail = smApplist.getOwnerEmail();
			String maintenanceEmail = smApplist.getMaintenanceEmail();
			String appMaintenance = smApplist.getAppMaintenance();
			
			for (String url : urls) {
				if (url != null && !url.equals("")) {
					
					logger.info("应用系统：" + app_name + ",URL=" + url);
					Request request = new Request.Builder().url(url).build();
					client.newCall(request).enqueue(new Callback() {
						
						@Override
						public void onFailure(Call call, IOException e) {
							smResult[0] = new SmResult();
							smResult[0].setAppId(app_id);
							smResult[0].setAppName(app_name);
							smResult[0].setAppOwner(app_owner);
							smResult[0].setAppDescrib(app_describ);
							message[0] = "Response{protocol=http/1.1, code=000, message=" + e.fillInStackTrace()
									+ ", url=" + url + "}";
							// logger.info(app_name + "异常原因=" + e.fillInStackTrace());
							logger.info("异步线程异常结束" + date);
							smResult[0].setResult(message[0]);
							smResult[0].setStatus("false");
							smResult[0].setCreateTime(date);
							smResult[0].setChk("false");
							serviceMonitorService.saveResult(smResult[0]);
							//一旦服务器无响应调用邮件报警
							serviceMonitorService.sendEmail(maintenanceEmail,subjectFail, "Hi "+appMaintenance+",<p/>&nbsp;&nbsp;"+"卧槽！！！您所运维的系统：《"+app_name+"》,EAI编号为：《"+app_id+"》<span style='color:red'>宕机了！！！</span>,请尽快排查，并通知您的Owner："+app_owner+"，邮箱是：《"+ownerEmail+"》。祝您好运！"+tail);
							
						}

						@Override
						public void onResponse(Call call, Response response) throws IOException {
							smResult[0] = new SmResult();
							smResult[0].setAppId(app_id);
							smResult[0].setAppName(app_name);
							smResult[0].setAppOwner(app_owner);
							smResult[0].setAppDescrib(app_describ);
							message[0] = response.networkResponse() + "";
							message[1] = response.isSuccessful() + "";
							System.out.println("message[0]=="+message[0]+"message[1]=="+message[1]);
							if (!response.isSuccessful()) {
								throw new IOException("Unexpected code " + response);
							}
							logger.info(app_name + "异步检查线程正常结束" + date);
							smResult[0].setResult(message[0]);
							smResult[0].setStatus(message[1]);
							smResult[0].setCreateTime(date);
							smResult[0].setChk("false");

							serviceMonitorService.saveResult(smResult[0]);
						}
						
					});
				}

			} // URL遍历结束
		} // 系统遍历结束
	}

	/*
	 * fsService.sendEmail(subjectSuccess, hello + simpleDateFormat.format(new
	 * Date()) + "基金交易记录应上传"+arr[0]+"条，实际上传"+arr[1]
	 * +"条！<span style='color:green'>基金文件生成成功！</span>"); logger.info("文件生成正常");
	 */
}
