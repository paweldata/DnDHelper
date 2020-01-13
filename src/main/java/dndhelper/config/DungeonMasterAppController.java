package dndhelper.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dndhelper.entity.DungeonMaster;
import dndhelper.service.interfaces.DungeonMasterService;

@Controller
@RequestMapping("/dungeon-master")
public class DungeonMasterAppController {
	
	@Autowired
	private DungeonMasterService dungeonMasterService;

	@RequestMapping("/login")
	public String showDungeonMasterLoginPage(Model theModel) {
		DungeonMaster dungeonMaster = new DungeonMaster();
		theModel.addAttribute("dungeon_master", dungeonMaster);
		return "dungeon-master/dungeon-master-login";
	}
	
	@PostMapping("/login_validate")
	public String loginValidate(@ModelAttribute("dungeon_master") DungeonMaster dungeonMaster) {
		if (this.dungeonMasterService.loginValidate(dungeonMaster))
			return "dungeon-master/dungeon-master-main";
		return "dungeon-master/dungeon-master-login";
	}
	
	@RequestMapping("/create")
	public String showDungeonMasterCreatePage(Model theModel) {
		DungeonMaster dungeonMaster = new DungeonMaster();
		theModel.addAttribute("dungeon_master", dungeonMaster);
		return "dungeon-master/dungeon-master-create";
	}
	
	@PostMapping("/create_account")
	public String createAccount(@ModelAttribute("dungeon_master") DungeonMaster dungeonMaster) {
		this.dungeonMasterService.saveDungeonMaster(dungeonMaster);
		return "dungeon-master/dungeon-master-login";
	}
}
