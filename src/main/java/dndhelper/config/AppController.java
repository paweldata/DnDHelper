package dndhelper.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dndhelper.service.interfaces.PlayerService;


@Controller
public class AppController {

  @Autowired
  private PlayerService playerService;
  @RequestMapping("/")
  public String showPage() {
    return "main-menu";
  }

}
