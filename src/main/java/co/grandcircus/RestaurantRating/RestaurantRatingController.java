package co.grandcircus.RestaurantRating;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.RestaurantRating.RestaurantDao;
import co.grandcircus.RestaurantRating.Restaurant;


@Controller
public class RestaurantRatingController {

	
	@Autowired
	private RestaurantDao dao;
	
	@RequestMapping("/")
	public ModelAndView index() {
		List<Restaurant> items = dao.findAll();
		return new ModelAndView("index", "items", items);
	}
	
	@RequestMapping("/restaurant/uprate")
	public ModelAndView upRate(@RequestParam("id") Long id) {
		dao.upRate(id);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/restaurant/downrate")
	public ModelAndView downRate(@RequestParam("id") Long id) {
		dao.downRate(id);
		return new ModelAndView("redirect:/");
	}
	
}


