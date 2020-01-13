package dndhelper.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dndhelper.entity.DungeonMaster;
import dndhelper.entity.Player;
import dndhelper.service.interfaces.PlayerService;


@Controller
@RequestMapping("player/")
public class PlayerAppController {

  @Autowired
  private PlayerService playerService;
  
  @RequestMapping("/login")
  public String showPlayerLoginPage(Model theModel) {
    Player player = new Player();
    theModel.addAttribute("player", player);
    return "player/player-login";
  }
  
  @PostMapping("/login_validate")
  public String loginValidate(@ModelAttribute("player") Player player) {
    if(playerService.loginValidate(player))
      return "player/player-main"; // TODO otw�rz menu dla gracza zalogowanego
    return "redirect:/player/login";
  }
  
  @RequestMapping("/create")
  public String showPlayerCreatePage(Model theModel) {
	  Player player = new Player();
	  theModel.addAttribute("player", player);
	  return "player/player-create";
  }
  
  @PostMapping("/create_account")
  public String createAccount(@ModelAttribute("player") Player player) {
    this.playerService.savePlayer(player);
    return "player/player-login";
  }
}
