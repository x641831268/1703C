package com.bawei.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bawei.bean.Area;
import com.bawei.bean.Course;
import com.bawei.mapper.CourseDao;
@Service
public class CourseServiceImpl implements CourseService{

	@Resource
	private CourseDao dao;
	
	public List<Area> findSheng() {
		// TODO Auto-generated method stub
		return dao.findSheng();
	}

	public List<Area> findShi(String shi) {
		// TODO Auto-generated method stub
		return dao.findShi(shi);
	}

	public List<Area> findXian(String xian) {
		// TODO Auto-generated method stub
		return dao.findXian(xian);
	}

	public int add(Course course) {
		// TODO Auto-generated method stub
		return dao.add(course);
	}

	public List<Course> findAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.findAll(map);
	}

	public Course findbyid(String cid) {
		// TODO Auto-generated method stub
		return dao.findbyid(cid);
	}

	public int del(String ids) {
		// TODO Auto-generated method stub
		return dao.del(ids);
	}

	public int addCourse(Map<String, Object> map) {
		dao.addCourse(map);
		int result=(Integer) map.get("result");
		return result;
	}

}
