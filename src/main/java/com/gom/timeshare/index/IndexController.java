package com.gom.timeshare.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String indxe() {
		return "/index";
	}

	@GetMapping("/timetable")
	public String timetable() {
		return "/timetable/timetable";
	}

}
