package com.cognizant.ams.common.ldap;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.Properties;

public class LdapADHelper {
	public static void main(String[] args) {
		getADInfo("change", "Hello001");   //测试入口
	}

	@SuppressWarnings("rawtypes")
	public static String getADInfo(String userName, String password) {
		Properties env = new Properties();
		String host = "10.164.5.1";// AD域IP
		String domain = "alicocorp";// 域名后缀xuzhib Hello004
		String port = "389"; // 端口，一般默认389
		String ldapURL = new String("ldap://" + host + ":" + port);// 固定写法
		String user = domain + "\\" + userName;
		String finalJson = "";
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");// LDAP访问安全级别："none","simple","strong"
		env.put(Context.SECURITY_PRINCIPAL, user);
		env.put(Context.SECURITY_CREDENTIALS, password);
		env.put(Context.PROVIDER_URL, ldapURL);

		try {
			LdapContext ctx = new InitialLdapContext(env, null);   	//这里用于登录，若登录失败直接抛出异常
			// 搜索控制器
			SearchControls searchCtls = new SearchControls();
			// 创建搜索控制器
			searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			// LDAP搜索过滤器类，此处只获取AD域用户，所以条件为用户user或者person均可
			String searchFilter = "(&(objectClass=user)(sAMAccountName=" + userName + "))";
			// AD域节点结构
			String searchBase = "DC=alico,DC=corp";

			String returnedAtts[] = { "displayName", "sAMAccountName", "mail",  "mobile"}; // 定制返回属性
			searchCtls.setReturningAttributes(returnedAtts);
			NamingEnumeration<SearchResult> answer = ctx.search(searchBase, searchFilter, searchCtls);

			//获取域信息
			while (answer.hasMoreElements()) {
				SearchResult sr = (SearchResult) answer.next();				
				Attributes Attrs = sr.getAttributes();
				StringBuffer stringBuffer = new StringBuffer("{");
				if (Attrs != null) {
					for (NamingEnumeration ne = Attrs.getAll(); ne.hasMore();) {
						Attribute Attr = (Attribute) ne.next();								// 得到下一个属性
						String attr =  Attr.getID().toString() ;
						String att = "\"" + Attr.getID().toString() + "\":";				// 取出定制的属性
						if (attr.equals("mail")||attr.equals("mobile")) {
							stringBuffer.append(att);
						}
						else {
							if (attr.equals("displayName")) {
								stringBuffer.append("\"username\":");
							}
							if (attr.equals("sAMAccountName")) {
								stringBuffer.append("\"account\":");
							}	
						}
						
						// 读取属性值
						StringBuffer stringBuffer_value = new StringBuffer();
						String userInfo ="";
						for (NamingEnumeration e = Attr.getAll(); e.hasMore();) {
							 userInfo = e.next().toString().toLowerCase();										// 取出定制的属性对应的值
							stringBuffer_value.append(userInfo);
						}
						String uString = "\"" + stringBuffer_value.toString() + "\",";
						stringBuffer.append(uString);
					}
				}
				String jsonString = stringBuffer.toString();
				int length = jsonString.length();
				finalJson = jsonString.substring(0, length - 1) + "}";
				finalJson=finalJson.replaceAll("\\\\", "");
				System.out.println("域控信息：" + finalJson);
			}
			ctx.close();
		} catch (NamingException e) {
			//LDAP访问异常
			return "LADPERROR";
		}
		return finalJson;
	}
}
