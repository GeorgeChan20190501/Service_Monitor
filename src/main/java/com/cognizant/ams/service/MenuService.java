package com.cognizant.ams.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.ams.bean.SysMenu;
import com.cognizant.ams.bean.SysMenuExample;
import com.cognizant.ams.dao.SysMenuMapper;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MenuService {

	@Autowired
	private SysMenuMapper sysMenuMapper;

    /**
     * 根据用户查询菜单列表
     * @param username
     * @return
     */
	public List<SysMenu> getUserMenu(String username){
		List<SysMenu> list=sysMenuMapper.getUserMenu(username);
		return list;
	}

    /**
     * 查询所有有效菜单（页面默认加载）
     * @return
     */
	public List<SysMenu> getAllMenu(){
		SysMenuExample sysMenuExample =new SysMenuExample();
		SysMenuExample.Criteria criteria=sysMenuExample.createCriteria();
		criteria.andIsDeletedEqualTo("0");//标志：1删除 0 未删除
		List<SysMenu> list=sysMenuMapper.selectByExample(sysMenuExample);
		return list;
	}


    /**
     * 根据参数查询菜单
     * @param menu
     * @return
     */
	public List<SysMenu> getMenu(SysMenu menu){
		SysMenuExample example=new SysMenuExample();
		SysMenuExample.Criteria criteria=example.createCriteria();
        String nodecode=menu.getNodeCode();
        String nodename=menu.getNodeName();
        String isdeleted=menu.getIsDeleted();
        if (!"".equals(nodecode)){
            criteria.andNodeCodeEqualTo(nodecode);
        }
        if (!"".equals(nodename)){
            criteria.andNodeNameEqualTo(nodename);
        }
        if (!"".equals(isdeleted)){
            criteria.andIsDeletedEqualTo(isdeleted);
        }
        List<SysMenu> SysMenuList=sysMenuMapper.selectByExample(example);

        return  SysMenuList;
    }

    public int insertMenu(SysMenu newMenu){
	    int result=sysMenuMapper.insert(newMenu);
	    return result;
    }

    public int deteteMenu(String nodecode){
    	SysMenuExample example=new SysMenuExample();
    	SysMenuExample.Criteria criteria=example.createCriteria();
	    criteria.andNodeCodeEqualTo(nodecode);
	    int result=sysMenuMapper.deleteByExample(example);
	    return result;
    }


    public int updateMenu(SysMenu menu){
        SysMenuExample example=new SysMenuExample();
        SysMenuExample.Criteria criteria=example.createCriteria();//创建更新的条件
        criteria.andNodeCodeEqualTo(menu.getNodeCode());
	    int result=sysMenuMapper.updateByExample(menu,example);
	    return result;
    }

	public List<SysMenu> queryMenu(SysMenu sysMenu) {
		List<SysMenu> list=sysMenuMapper.queryMenu(sysMenu);
		return list;
	}

	public int addMenu  (SysMenu sysMenu) {
	   int result = sysMenuMapper.addMenu(sysMenu);
	   return result;
	    
	}

	public void deleteMenu(List<String> list) {
		sysMenuMapper.deleteMenu(list);
	}

	public void updateMenu(List<SysMenu> list) {
		sysMenuMapper.updateMenu(list);
	}

	 
}
