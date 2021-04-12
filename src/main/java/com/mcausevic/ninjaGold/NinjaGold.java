package com.mcausevic.ninjaGold;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.sql.Timestamp;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class NinjaGold {
	public ArrayList<String> activities = new ArrayList<String>();
	
	@GetMapping("/")
	public String root(Model model, HttpSession session) {
		if( session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		
		model.addAttribute("activities", activities);
		model.addAttribute("time", new Date());
		return "index.jsp";
	}
	@PostMapping("/") 
	public String process(@RequestBody() String postData, HttpSession session) {
		String location = postData.substring(0, postData.indexOf("="));
		Random random = new Random();
		int n =0;
		int gold = (int) session.getAttribute("gold");
		String text = "You entered a " ;
		String gained = "gained";
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		
		switch(location) {
			case "farm":
				n = random.nextInt(10)+10;
				break;
			case "house":
				n = random.nextInt(2)+3;
				break;
			case "cave":
				n = random.nextInt(5)+5;
				break;
			case "casino":
				n = random.nextInt(50);
				
				if(random.nextInt(2) == 1) {
					n = -n;
					gained = "lost";
				}
				break;
		}
		text += location + " and "+ gained + n  + " gold: " + " created at: " + ts;
		gold += n;
		session.setAttribute("gold", gold);
		
		activities.add( text );
		return "redirect:/";
		
	}
	@PostMapping("/destroy")
	public String destroy(HttpSession session) {
		session.setAttribute("gold", 0);
		activities = new ArrayList<String>();
		return "redirect:/";
	}
	
	
}
