package dndhelper.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dndhelper.entity.Character;
import dndhelper.entity.Monster;
import dndhelper.entity.Player;
import dndhelper.entity.enums.AllignmentEnum;
import dndhelper.entity.enums.ClassEnum;
import dndhelper.entity.enums.RaceEnum;
import dndhelper.service.interfaces.CampaignService;
import dndhelper.service.interfaces.CharacterService;
import dndhelper.service.interfaces.DungeonMasterService;
import dndhelper.service.interfaces.MonsterService;
import dndhelper.service.interfaces.PlayerService;


@Controller
@RequestMapping("/admin")
public class AdminAppController {

	@Autowired
	private PlayerService playerService;
	@Autowired
	private CharacterService characterService;
	
	@Autowired
	private DungeonMasterService dungeonMasterService;
	@Autowired
	private CampaignService campaignService;
	
	@Autowired
	private MonsterService monsterService;
	
	@RequestMapping("/menu")
	public String showPlayerMainPage(Model theModel) {
		theModel.addAttribute(playerService.getPlayers());
		theModel.addAttribute(dungeonMasterService.getDungeonMasters());
		return "admin/admin-main";
	}
	
	@RequestMapping("/monster_manual")
	public String showMonsterManualPage(Model theModel) {
		theModel.addAttribute(monsterService.getMonsters());
		return "admin/monster-manual";
	}
	
	@RequestMapping("/monster_manual/create")
	public String showCreateMonsterPage(Model theModel) {
		Monster monster = new Monster();
		theModel.addAttribute(monster);
		return "admin/show-monster-form";
	}
	
	@RequestMapping("/monster_manual/show")
	public String showShowMonsterPage(@ModelAttribute("monsterId") int monsterId, Model theModel) {
		Monster monster = monsterService.getMonsterById(monsterId);
			if(monster != null) {
				theModel.addAttribute(monster);
				return "admin/show-monster-form";
			}
		return "redirect:/admin/monster_manual";
	}
	
	@PostMapping("/monster_manual/save_monster")
	public String saveMonster(@ModelAttribute("monster") Monster monster) {
		this.monsterService.saveMonster(monster);
		return "redirect:/admin/monster_manual";
	}
	
	@RequestMapping("/monster_manual/delete_monster")
	public String deleteMonster(@ModelAttribute("monsterId") int monsterId, Model theModel) {
		monsterService.deleteMonster(monsterId);
		return "redirect:/admin/monster_manual";
	}
	
	@RequestMapping("/item_list")
	public String showItemListPage(Model theModel) {
		return "admin/admin-main";
	}
	
	@RequestMapping("/options")
	public String showOptionsPage(Model theModel) {
		return "admin/options";
	}
	
	@RequestMapping("/options/backup")
	public String backupDatabase(Model theModel) {
		DatabaseManager.Backupdbtosql();
		return "redirect:/admin/options";
	}
	
	@RequestMapping("/options/restore")
	public String restoreDatabase(Model theModel) {
		DatabaseManager.Restoredbfromsql();
		return "redirect:/admin/options";
	}

	@RequestMapping("/login")
	public String showPlayerLoginPage(Model theModel) {
		Player player = new Player();
		theModel.addAttribute("player", player);
		return "admin/admin-login";
	}

	@PostMapping("/login_validate")
	public String loginValidate(@ModelAttribute("player") Player player) {
		if (playerService.loginValidate(player) && player.getNick().equals("admin"))
		{
			return "redirect:/admin/menu";
		} // TODO otw�rz menu dla gracza zalogowanego
		return "redirect:/admin/login";
	}

}
