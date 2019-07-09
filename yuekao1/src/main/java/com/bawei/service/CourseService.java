package com.bawei.service;

import java.util.List;
import java.util.Map;

import com.bawei.bean.Area;
import com.bawei.bean.Course;

public interface CourseService {

	List<Area> findSheng();

	List<Area> findShi(String shi);

	List<Area> findXian(String xian);

	int add(Course course);

	List<Course> findAll(Map<String, Object> map);

	Course findbyid(String cid);

	int del(String ids);

	int addCourse(Map<String, Object> map);

}
