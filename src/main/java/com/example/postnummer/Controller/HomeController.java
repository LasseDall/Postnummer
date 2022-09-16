package com.example.postnummer.Controller;


import com.example.postnummer.Service.PostnummerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

  PostnummerService postnummerService;

  public HomeController(){
    postnummerService = new PostnummerService();
  }
  @GetMapping("/")
  public String index() {
    return "index";
  }

  @PostMapping("/find-by")
  public String by(@RequestParam("postnummer") Integer postnummer, RedirectAttributes redirectAttributes) {
    redirectAttributes.addAttribute("postnummer", postnummer);
    return "redirect:/find-by";
  }

  @GetMapping("/find-by")
  public String by(@RequestParam("postnummer") String postnummer, Model model) {
    model.addAttribute("postnummer", postnummer);
    String by = postnummerService.findBy(postnummer);
    model.addAttribute("by", by);
    return "by";
  }
}
