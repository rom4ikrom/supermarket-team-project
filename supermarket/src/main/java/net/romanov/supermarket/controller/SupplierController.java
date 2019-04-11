package net.romanov.supermarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/supply")
public class SupplierController {
	
	@RequestMapping(value= {"/products"})
	public ModelAndView showSupplierPage() {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", "Supply Products");
		mv.addObject("userClickSupplyProducts", true);
		
		return mv;
		
	}

}
