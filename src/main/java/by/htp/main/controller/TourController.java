package by.htp.main.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.htp.main.entity.HashPassword;
//import by.htp.main.entity.Tour;
import by.htp.main.entity.TourManager;
import by.htp.main.service.ManagerService;
//import by.htp.main.service.TourService;


@Controller
@RequestMapping("/tour")
public class TourController {

	
	@Autowired
	private ManagerService managerService;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
				
//		List<Tour> theTours = tourService.getTour();
//						
//		theModel.addAttribute("tourList", theTours);
//		
		return "list-tours";
	}
	
	@RequestMapping("/manager-form")
	public String goToManagerForm(Model theModel) {
					
		return "manager-form";
	}
	
	@PostMapping("/manager-registration")
	public String managerRegistration(HttpServletRequest request, Model model){
				
		if(request.getSession().getAttribute("manager") != null) {
			String errorMessage = "You are allready logged in!!!";
			model.addAttribute("errorMessage", errorMessage);
			return "manager-form";
			
		}
		
		String email = request.getParameter("email").trim();
		String password = HashPassword.makeHashPassword(request.getParameter("password")).trim();
		
		if(email == null || password == null || email.isEmpty() || password.isEmpty()) {
			String errorMessage = "Email and login must be not empty!!!";
			model.addAttribute("errorMessage", errorMessage);
			return "manager-form";
		}
		
		TourManager manager = new TourManager(email, password);
		
		manager = managerService.createManager(manager);
		System.out.println(manager + "line69" +"controller");
		if (manager == null) {
			String errorMessage = "You are allready registrated!!! Yoy need to login";
			model.addAttribute("errorMessage", errorMessage);
			return "manager-form";
		}
		
		request.getSession(true).setAttribute("manager", manager);
		
		return "redirect:/tour/manager-form";
		
	}
	
	@GetMapping("/go-to-manager-options")
	public String goToManagerOptions(Model model){
		
		model.addAttribute("managersList", managerService.getAllManagers());
		System.out.println(managerService.getAllManagers());
		return "manager-option";	
	}
	
	@GetMapping("/go-to-logination")
	public String goToLogination(HttpServletRequest request) {
		return "logination-form";
	}

	@PostMapping("/logination")
	public String logination(HttpServletRequest request, Model model) {
		
		String email = request.getParameter("email").trim();
		String password = HashPassword.makeHashPassword(request.getParameter("password")).trim();
		
		if(email == null || password == null || email.isEmpty() || password.isEmpty()) {
			
			String errorMessage = "Wrong login or password";
			model.addAttribute("errorMessage", errorMessage);
			return "logination-form";			
		}
		TourManager manager = new TourManager(email, password);
		manager = managerService.logination(manager);
		System.out.println(manager + "controller line 105");
		if(manager == null) {			
			String errorMessage = "No such login or wrong password! Try again!";
			model.addAttribute("errorMessage", errorMessage);
			return "logination-form";			
		}else {
			request.getSession().setAttribute("manager", manager);
		}
		
		return "redirect:/tour/manager-form";
	}
	
	@GetMapping("/unlogination")
	public String unlogination(HttpServletRequest request){
		System.out.println("unlogination controller line119");
		
		request.removeAttribute("manager");
		
		System.out.println("unlogination controller line123" + request.getAttribute("manager"));
		
		return "redirect:/tour/manager-form";
	}
	
	@GetMapping("/go-to-delete-manager")
	public String goToDeleteManager(HttpServletRequest request, Model model){
				
		model.addAttribute("id", request.getParameter("id"));
		return "delete-form";	
	}
	
	@PostMapping("/delete-manager")
	public String deleteManager(HttpServletRequest request) {
		String managerId = request.getParameter("id");
		request.getSession().removeAttribute("manager");
		int id = Integer.parseInt(managerId);
		managerService.deleteManager(id);		
		return "manager-form";
		
	}
	
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}	
	
}
