package dndhelper.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dndhelper.entity.Campaign;
import dndhelper.entity.Character;
import dndhelper.entity.DungeonMaster;
import dndhelper.entity.Item;
import dndhelper.entity.Location;
import dndhelper.entity.Npc;
import dndhelper.entity.Player;
import dndhelper.entity.enums.AllignmentEnum;
import dndhelper.entity.enums.ClassEnum;
import dndhelper.entity.enums.RaceEnum;
import dndhelper.service.interfaces.CampaignService;
import dndhelper.service.interfaces.CharacterService;
import dndhelper.service.interfaces.ItemService;
import dndhelper.service.interfaces.LocationService;
import dndhelper.service.interfaces.NpcService;
import dndhelper.service.interfaces.PlayerService;
import net.bytebuddy.asm.Advice.This;

@Controller
@RequestMapping("/player")
public class PlayerAppController {

	String nick;
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private CharacterService characterService;
	
	@Autowired
	private CampaignService campaignService;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
  private NpcService npcService;
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/menu")
	public String showPlayerMainPage(Model theModel) {
		List<Character> characters = playerService.getPlayerByNick(nick).getCharacters();
		theModel.addAttribute(characters);
		return "player/player-main";
	}

	@RequestMapping("/login")
	public String showPlayerLoginPage(Model theModel) {
		Player player = new Player();
		theModel.addAttribute("player", player);
		return "player/player-login";
	}

	@PostMapping("/login_validate")
	public String loginValidate(@ModelAttribute("player") Player player) {
		if (playerService.loginValidate(player))
		{
			nick = player.getNick();
			return "redirect:/player/menu";
		} // TODO otw�rz menu dla gracza zalogowanego
		return "redirect:/player/login";
	}

	@RequestMapping("/create")
	public String showPlayerCreatePage(Model theModel) {
		Player player = new Player();
		theModel.addAttribute("player", player);
		return "player/player-create";
	}

	@PostMapping("/create_player")
	public String createAccount(@ModelAttribute("player") Player player) {
		this.playerService.savePlayer(player);
		return "player/player-login";
	}

	@RequestMapping("/character")
	public String showPlayerCharactersPage(Model theModel) {
		return "redirect:/player/menu";
	}
	@RequestMapping("/character/create_character")
	public String showCharacterCreatePage(Model theModel) {
		Character character = new Character();
		theModel.addAttribute(character);
		theModel.addAttribute("items", new ArrayList<Item>());
		theModel.addAttribute("allignments",AllignmentEnum.values());
		theModel.addAttribute("races",RaceEnum.values());
		theModel.addAttribute("classes",ClassEnum.values());
		theModel.addAttribute("items", this.itemService.getItems());
		theModel.addAttribute("item", new Item());
		return "player/show-character-form";
	}
	
	@Transactional
	@RequestMapping("/character/show_character")
	public String showCharacterCreatePage(@ModelAttribute("characterId") int characterId, Model theModel) {
		List <Character> characters = playerService.getPlayerByNick(nick).getCharacters();
		Character character;
		for(Character tempCh : characters) {
			if(characterId == tempCh.getId()) {
				character = tempCh;
				List<Item> items = this.characterService.getItems(character);
				theModel.addAttribute("allignments",AllignmentEnum.values());
				theModel.addAttribute("races",RaceEnum.values());
				theModel.addAttribute("classes",ClassEnum.values());
				theModel.addAttribute(character);
				theModel.addAttribute("items", this.itemService.getItems());
				theModel.addAttribute("characterItems", items);
				theModel.addAttribute("item", new Item());
				return "player/show-character-form";
			}
		}
		return "redirect:/player/menu";
	}
	
	@PostMapping("/character/save_character")
	public String createCharacter(@ModelAttribute("character") Character character) {
		character.setPlayer(playerService.getPlayerByNick(nick));
		this.characterService.saveCharacter(character);
		return "redirect:/player/menu";
	}
	
	@RequestMapping("/character/delete_character")
	public String deletePlayerCharacters(@ModelAttribute("characterId") int characterId) {
		characterService.deleteCharacter(characterId);
		return "redirect:/player/menu";
	}

	@Transactional
	@RequestMapping("/character/show_campaigns")
	public String showCampaignListPage(@ModelAttribute("characterId") int characterId, Model theModel) {
	  Character character = this.characterService.getCharacterById(characterId);
	  List<Campaign> campaigns = character.getCampaigns();

    theModel.addAttribute(campaigns);
    theModel.addAttribute(character);
    return "player/show-campaign-form";
	}
	
	@Transactional
	@RequestMapping("/character/add_item_to_character")
	public String addItemToCharacter(@ModelAttribute("item") Item item,
	    @ModelAttribute("characterId") int characterId) {
	  Character character = this.characterService.getCharacterById(characterId);
	  
	  item.addCharacter(character);
	  this.itemService.saveItem(item);
	  character.addItem(item);
	  this.characterService.saveCharacter(character);
	  
	  return "redirect:/player/character/show_character?characterId" + characterId;
	}
	
	@Transactional
	@RequestMapping("/character/delete_item")
	public String deleteItem(@ModelAttribute("itemName") String itemName,
      @ModelAttribute("characterId") int characterId) {
	  
	  Character character = this.characterService.getCharacterById(characterId);
	  Item item = this.itemService.getItemByName(itemName);
	  
	  List<Item> items = this.characterService.getItems(character);
	  items.remove(item);
	  character.setItems(items);
	  this.characterService.saveCharacter(character);
	  
	  return "redirect:/player/character/show_character?characterId" + characterId;
	}
	
	@Transactional
	@RequestMapping("/campaign")
	public String showCamapignPage(@RequestParam("characterId") int characterId,
	    @RequestParam("campaignId") int campaignId, Model theModel) {
	  
	  Campaign campaign = this.campaignService.getCampaignById(campaignId);
	  List<Character> characters = this.campaignService.getCharacters(campaign);
	  List<Location> locations = this.campaignService.getLocations(campaign);
	  List<Npc> npcs = this.campaignService.getNpcs(campaign);
	  
	  theModel.addAttribute("character", this.characterService.getCharacterById(characterId));
	  theModel.addAttribute("campaign", this.campaignService.getCampaignById(campaignId));
	  theModel.addAttribute("characters", characters);
	  theModel.addAttribute("locations", locations);
	  theModel.addAttribute("npcs", npcs);
	  return "player/show-one-campaign";
	}
	
	@RequestMapping("/campaign/show-character")
	public String showCampaignCharacterPage(@RequestParam("characterShowId") int charactershowId,
      @RequestParam("campaignId") int campaignId, Model theModel,
      @RequestParam("characterId") int characterId) {
	  
	  theModel.addAttribute("characterShow", this.characterService.getCharacterById(charactershowId));
	  theModel.addAttribute("character", this.characterService.getCharacterById(characterId));
	  theModel.addAttribute("campaign", this.campaignService.getCampaignById(campaignId));
	  return "/player/show-campaign-character";
	}
	
	@RequestMapping("/campaign/show-location")
  public String showCampaignLocationPage(@RequestParam("locationId") int locationId,
      @RequestParam("campaignId") int campaignId, Model theModel,
      @RequestParam("characterId") int characterId) {
    
    theModel.addAttribute("location", this.locationService.getLocationById(locationId));
    theModel.addAttribute("character", this.characterService.getCharacterById(characterId));
    theModel.addAttribute("campaign", this.campaignService.getCampaignById(campaignId));
    return "/player/show-campaign-location";
  }
	
	@RequestMapping("/campaign/show-npc")
  public String showCampaignNpcPage(@RequestParam("npcId") int npcId,
      @RequestParam("campaignId") int campaignId, Model theModel,
      @RequestParam("characterId") int characterId) {
    
    theModel.addAttribute("npc", this.npcService.getNpcById(npcId));
    theModel.addAttribute("character", this.characterService.getCharacterById(characterId));
    theModel.addAttribute("campaign", this.campaignService.getCampaignById(campaignId));
    return "/player/show-campaign-npc";
  }
}
