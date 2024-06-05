package com.haihaycode.java5.lab6.controller;

import java.util.List;

import com.haihaycode.java5.lab5.dao.ProductDAO;
import com.haihaycode.java5.lab6.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ReportController {
	@Autowired
	ProductDAO dao;

	@RequestMapping("/report/inventory-by-category")
	public String inventory(Model model) {
		List<Report> items = dao.getInventoryByCategory();
		model.addAttribute("items", items);
		return "lab6/product/inventory-by-category";
	}
}
