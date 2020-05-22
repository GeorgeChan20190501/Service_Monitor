package com.cognizant.ams.controller.fun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONArray;
import com.cognizant.ams.bean.SmFun;
import com.cognizant.ams.bean.common.JsonReqObject;
import com.cognizant.ams.service.FunService;

@RestController
public class FunController {
	@Autowired
	private FunService funService;

	/*
	 * @Autowired private RoleService roleService;
	 * 
	 * @PutMapping("/addRole") public String addRole(@RequestBody String param) {
	 * System.out.println("添加角色参数===" + param); JsonReqObject jsonReqObject =
	 * JSONArray.parseObject(param, JsonReqObject.class); String jsonParam =
	 * jsonReqObject.getMsg(); System.out.println(jsonParam); SysRole sysRole =
	 * JSONArray.parseObject(jsonParam, SysRole.class); // 查询菜单 try {
	 * roleService.addRole(sysRole); } catch (Exception e) { return "操作异常"; } return
	 * "角色添加成功"; }
	 * 
	 * @DeleteMapping("/deleteRole") public String deleteRole(@RequestBody String
	 * param) { System.out.println("删除角色参数===" + param); JsonReqObject jsonReqObject
	 * = JSONArray.parseObject(param, JsonReqObject.class); String jsonParam =
	 * jsonReqObject.getMsg(); String ids[] = jsonParam.replace("[",
	 * "").replace("]", "").split(","); List<String> list = new ArrayList<String>();
	 * for (String id : ids) { list.add(id); } System.out.println(list); try {
	 * roleService.deleteRole(list); } catch (
	 * 
	 * Exception e) { return "操作异常"; } return "角色删除成功"; }
	 * 
	 * @PostMapping("/updateRole") public String updateRole(@RequestBody String
	 * param) { JsonReqObject jsonReqObject = JSONArray.parseObject(param,
	 * JsonReqObject.class); String jsonParam = jsonReqObject.getMsg();
	 * System.out.println("修改角色参数===" + jsonParam); String Roles[] =
	 * jsonReqObject.getMsg().replace("\\", "").replace("}\",",
	 * "}\";").replace("[\"", "") .replace("\"]", "").split("\";\""); List<SysRole>
	 * list = new ArrayList<SysRole>(); SysRole sysRole; for (String Role : Roles) {
	 * sysRole = JSONArray.parseObject(Role, SysRole.class); list.add(sysRole); }
	 * try { roleService.updateRole(list); } catch (Exception e) { return "操作异常"; }
	 * return "角色更新成功"; }
	 * 
	 * 
	 * @PostMapping("/fenyeQueryRole") public Map<String, Object>
	 * fenyeQueryRole(@RequestBody String param) { System.out.println("角色分页查询参数==="
	 * + param); JsonReqObject jsonReqObject = JSONArray.parseObject(param,
	 * JsonReqObject.class); String jsonParam = jsonReqObject.getMsg(); SysRole
	 * sysRole = JSONArray.parseObject(jsonParam, SysRole.class); // 查询菜单
	 * List<SysRole> list = roleService.queryRole(sysRole);
	 * 
	 * // 上述拿到完整list，现在进行分页返回当前页面数据。 System.out.println("总条数为===" +
	 * Rolelist.size()); Map<String, Object> map = new HashMap<String, Object>();
	 * map.put("list", list); return map; }
	 * 
	 * @PostMapping("/roleGrant") public String roleGrant(@RequestBody String param)
	 * { JsonReqObject jsonReqObject = JSONArray.parseObject(param,
	 * JsonReqObject.class); String roleId [] = jsonReqObject.getMsg().replace("[",
	 * "").replace("]", "").split(","); //根据角色ID查询角色编码 List<String> listId =new
	 * ArrayList<String>(); for (String rId : roleId) { listId.add(rId); } //查询
	 * String [] roleCode=roleService.getRoleCode(listId);
	 * System.out.println("角色ID参数===" + roleId);
	 * System.out.println(jsonReqObject.getMsg1()); String msg1[] =
	 * jsonReqObject.getMsg1().replace("[\"", "").replace("\"]",
	 * "").replace("\",\"", ";").split(";"); System.out.println(msg1);
	 * List<SysRoleMenu> list =new ArrayList<SysRoleMenu>(); Set<String> set =new
	 * HashSet<String>();
	 * 
	 * SysRoleMenu sysRoleMenu; //组装role_menu for (String nodecode : msg1) {
	 * //遍历选中的菜单 System.out.println(nodecode);
	 * 
	 * for (String rolecode : roleCode) { sysRoleMenu = new SysRoleMenu();
	 * sysRoleMenu.setNodeCode(nodecode); sysRoleMenu.setRoleCode(rolecode);
	 * list.add(sysRoleMenu); set.add(rolecode); } } try { List<String> rolelist
	 * =new ArrayList<String>(set); roleService.deleteUserRole(rolelist);
	 * roleService.roleGrant(list); } catch (Exception e) { return "操作异常"; } return
	 * "角色授权成功"; }
	 */
	@PostMapping("/getPrePeriod")
	public Map<String, Object> getPrePeriod(@RequestBody String param) {
		System.out.println("预查询参数===" + param);
		JsonReqObject jsonReqObject = JSONArray.parseObject(param, JsonReqObject.class);
		String jsonParam = jsonReqObject.getMsg();
		SmFun smFun = JSONArray.parseObject(jsonParam, SmFun.class);
		smFun.setType("DLT");
		smFun.setFval8("sys");
		List<SmFun> list = funService.getPrePeriod(smFun);

		// 上述拿到完整list，现在进行分页返回当前页面数据。 System.out.println("总条数为===" + Rolelist.size());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		return map;
	}
	
	@PostMapping("/touzhu")
	public String touzhu(@RequestBody String param,HttpServletRequest request) {
		System.out.println("投注参数===" + param);
		JsonReqObject jsonReqObject = JSONArray.parseObject(param, JsonReqObject.class);
		String jsonParam = jsonReqObject.getMsg();
		int currentPeriod = Integer.parseInt(jsonReqObject.getMsg1())+1;
		String username = jsonReqObject.getMsg2();
		String touzhu [] =jsonParam.replace("[[", "[").replace("]]", "]").replace("],[", "];[").split(";"); 
		SmFun smFun =null;
		List<SmFun> list =new ArrayList<SmFun>();
		for (String tz : touzhu) {
			smFun=new SmFun();
			String haoma [] =tz.replace("[", "").replace("]", "").split(",");
			for (int i=0;i<haoma.length;i++) {
				if (i==0) {
					smFun.setFval1(haoma[0]);
				}
				if (i==1) {
					smFun.setFval2(haoma[1]);
				}
				if (i==2) {
					smFun.setFval3(haoma[2]);
				}
				if (i==3) {
					smFun.setFval4(haoma[3]);
				}
				if (i==4) {
					smFun.setFval5(haoma[4]);
				}
				if (i==5) {
					smFun.setFval6(haoma[5]);
				}
				if (i==6) {
					smFun.setFval7(haoma[6]);
				}
			}
			smFun.setFkey(currentPeriod+"");
			smFun.setFval8(username);
			list.add(smFun);
		}
		try {
			funService.touzhu(list);
			return "投注成功！";
		} catch (Exception e) {
			return "投注异常！";
		}
	}
}
