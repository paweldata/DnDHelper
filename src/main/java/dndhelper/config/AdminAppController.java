package dndhelper.config;

import java.awt.Image;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dndhelper.entity.Character;
import dndhelper.entity.Item;
import dndhelper.entity.Monster;
import dndhelper.entity.Player;
import dndhelper.entity.enums.AllignmentEnum;
import dndhelper.entity.enums.ClassEnum;
import dndhelper.entity.enums.RaceEnum;
import dndhelper.service.interfaces.CampaignService;
import dndhelper.service.interfaces.CharacterService;
import dndhelper.service.interfaces.DungeonMasterService;
import dndhelper.service.interfaces.ItemService;
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
  private ItemService itemService;
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
	
	@RequestMapping("/logout")
  public String logout() {
    return "redirect:/";
  }
	
	@RequestMapping("/player/delete_player")
	public String deletePlayer(@ModelAttribute("playerNick") String playerNick, Model theModel) {
		playerService.deletePlayer(playerNick);
		return "redirect:/admin/menu";
	}
	
	@RequestMapping("/dm/delete_dm")
	public String deleteDm(@ModelAttribute("dmNick") String dmNick, Model theModel) {
		dungeonMasterService.deleteDungeonMaster(dmNick);
		return "redirect:/admin/menu";
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
				String image = monster.getImage();
				if(!image.isEmpty()) {
					theModel.addAttribute("statImage", monster.getImage());
				}
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
	  theModel.addAttribute("items", this.itemService.getItems());
		return "admin/item-list";
	}
	
	@RequestMapping("/item/create_item")
	public String showItemCreatePage(Model theModel) {
	  theModel.addAttribute("item", new Item());
	  return "admin/show-item-form";
	}
	
	@RequestMapping("/item/show_item")
	public String showItemCreatePage(@ModelAttribute("itemName") String itemName, Model theModel) {
	  theModel.addAttribute("item", this.itemService.getItemByName(itemName));
	  return "admin/show-item-form";
	}
	
	@PostMapping("/item/save_item")
	public String saveItem(@ModelAttribute("item") Item item) {
	  this.itemService.saveItem(item);
	  return "redirect:/admin/item_list";
	}
	
	@RequestMapping("/item/delete_item")
	public String deleteItem(@ModelAttribute("itemName") String itemName) {
	  this.itemService.deleteItem(itemName);
	  return "redirect:/admin/item_list";
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
