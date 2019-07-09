package com.bawei.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;




import com.alibaba.fastjson.JSON;
import com.bawei.bean.Area;
import com.bawei.bean.Course;
import com.bawei.service.CourseService;
import com.bawei.utils.FileUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
public class CourseController {

	@Resource
	private CourseService service;
	
	@RequestMapping("/findSheng.do")
	@ResponseBody
	public String findSheng(){
		List<Area> list=service.findSheng();
		String jsonString = JSON.toJSONString(list);
		return jsonString;
	}
	
	@RequestMapping("/findShi.do")
	@ResponseBody
	public String findShi(String shi){
		List<Area> list=service.findShi(shi);
		String jsonString = JSON.toJSONString(list);
		return jsonString;
	}
	
	@RequestMapping("/findXian.do")
	@ResponseBody
	public String findXian(String xian){
		List<Area> list=service.findXian(xian);
		String jsonString = JSON.toJSONString(list);
		return jsonString;
	}
	
	@RequestMapping("/add.do")
	public String add(Course course,MultipartFile photo,HttpSession session) throws IllegalStateException, IOException{
		String upload = FileUtils.upload(photo, session);
		course.setImages(upload);
		int num=service.add(course);
		return "redirect:list.do";
	}
	
	@RequestMapping("/list.do")
	public String findAll(ModelMap model,String cname,String label,Integer sheng,Integer shi,Integer xian,@RequestParam(required=false,defaultValue="1")Integer pageNum){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("cname", cname);
		map.put("label", label);
		map.put("sheng", sheng);
		map.put("xian", xian);
		map.put("shi", shi);
		Page<Course> page = PageHelper.startPage(pageNum, 2);
	    List<Course> list=service.findAll(map);
	    model.put("page", page);
	    model.put("pageNum", pageNum);
	    model.put("zong", page.getPages());
		return "list";
	}
	
	@RequestMapping("/findbyid.do")
	@ResponseBody
	public Map<String,Object> findbyid(String cid){
		Map<String,Object> map=new HashMap<String, Object>();
		Course course=service.findbyid(cid);
		List<Area> list=service.findSheng();
		List<Area> list1=new ArrayList<Area>();
		for (Area area : list) {
			list1.add(new Area(area.getAid(), area.getAname(), area.getSid()));
		}
		map.put("course", course);
		map.put("list", list1);
		return map;
	}
	
	@RequestMapping("/showImg.do")
	public void showImg(String path,HttpServletRequest request,HttpServletResponse response){
		FileUtils.lookImg(path, request, response);
	}
	
	@RequestMapping("/del.do")
	@ResponseBody
	public Integer del(String ids){
		int num=service.del(ids);
		return num;
	}
	
	@RequestMapping("/addCourse.do")
	@ResponseBody
	public Integer addCourse(String cid,String uid){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("cid", cid);
		map.put("uid", uid);
		int num=service.addCourse(map);
		return num;
	}
}
