package com.atguigu.atcrowdfunding.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.bean.AJAXResult;
import com.atguigu.atcrowdfunding.bean.Permission;
import com.atguigu.atcrowdfunding.service.PermissionService;

@Controller
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	@ResponseBody
	@RequestMapping("/delete")
	public Object delete( Permission permission ) {
		AJAXResult result = new AJAXResult();
		
		try {
			permissionService.deletePermission(permission);
			result.setSuccess(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public Object update( Permission permission ) {
		AJAXResult result = new AJAXResult();
		
		try {
			permissionService.updatePermission(permission);
			result.setSuccess(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/insert")
	public Object insert( Permission permission ) {
		AJAXResult result = new AJAXResult();
		
		try {
			permissionService.insertPermission(permission);
			result.setSuccess(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}

	@RequestMapping("/add")
	public String add() {
		return "permission/add";
	}
	
	@RequestMapping("/edit")
	public String edit( Integer id, Model model ) {
		
		Permission permission = permissionService.queryById(id);
		model.addAttribute("permission", permission);
		
		return "permission/edit";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "permission/index";
	}
	
	
	@ResponseBody
	@RequestMapping("/loadAssignData")
	public Object loadAssignData( Integer roleid ) {
		List<Permission> permissions = new ArrayList<Permission>();
		List<Permission> ps = permissionService.queryAll();
		
		// ?????????????????????????????????????????????
		List<Integer> permissionids = permissionService.queryPermissionidsByRoleid(roleid);
		
		Map<Integer, Permission> permissionMap = new HashMap<Integer, Permission>();
		for (Permission p : ps) {
			if ( permissionids.contains(p.getId()) ) {
				p.setChecked(true);
			} else {
				p.setChecked(false);
			}
			permissionMap.put(p.getId(), p);
		}
		for ( Permission p : ps ) {
			Permission child = p;
			if ( child.getPid() == 0 ) {
				permissions.add(p);
			} else {
				Permission parent = permissionMap.get(child.getPid());
				parent.getChildren().add(child);
			}
		}
		
		return permissions;
	}
	
	@ResponseBody
	@RequestMapping("/loadData")
	public Object loadData() {
		List<Permission> permissions = new ArrayList<Permission>();
		
//		Permission root = new Permission();
//		root.setName("????????????");
//		
//		Permission child = new Permission();
//		child.setName("?????????");
//		
//		root.getChildren().add(child);
//		permissions.add(root);
		
		// ????????????????????????
		/*
		Permission root = permissionService.queryRootPermission();		
		
		List<Permission> childPermissions = permissionService.queryChildPermissions(root.getId());
		
		for ( Permission childPermission : childPermissions ) {
			List<Permission> childChildPermissions = permissionService.queryChildPermissions(childPermission.getId());
			childPermission.setChildren(childChildPermissions);
		}
		
		root.setChildren(childPermissions);
		
		permissions.add(root);
		*/
		
		// ??????????????????
		/*
		Permission parent = new Permission();
		parent.setId(0);
		queryChildPermissions(parent);
		//permissions.
		return parent.getChildren();
		*/
		
		// ???????????????????????????
		List<Permission> ps = permissionService.queryAll();
		
		/*
		for ( Permission p : ps ) {
			// ?????????
			Permission child = p;
			if ( p.getPid() == 0 ) {
				permissions.add(p);
			} else {
				for ( Permission innerPermission : ps ) {
					if ( child.getPid().equals(innerPermission.getId()) ) {
						// ?????????
						Permission parent = innerPermission;
						// ???????????????????????????
						parent.getChildren().add(child);
						break;
					}
				}
			}
		}
		*/
		
		Map<Integer, Permission> permissionMap = new HashMap<Integer, Permission>();
		for (Permission p : ps) {
			permissionMap.put(p.getId(), p);
		}
		for ( Permission p : ps ) {
			Permission child = p;
			if ( child.getPid() == 0 ) {
				permissions.add(p);
			} else {
				Permission parent = permissionMap.get(child.getPid());
				parent.getChildren().add(child);
			}
		}
		
		return permissions;
	}
	
	/**
	 * ????????????????????????
	 * 1??? ????????????????????????
	 * 2????????????????????????????????????
	 * 3????????????????????????????????????????????????
	 * 4??? ??????????????????????????????
	 * @param parent
	 */
	private void queryChildPermissions( Permission parent ) {
		List<Permission> childPermissions = permissionService.queryChildPermissions(parent.getId());
		
		for ( Permission permission : childPermissions ) {
			queryChildPermissions(permission);
		}
		
		parent.setChildren(childPermissions);
	}
}
