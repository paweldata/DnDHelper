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

import dndhelper.entity.Character;
import dndhelper.entity.Campaign;
import dndhelper.entity.DungeonMaster;
import dndhelper.entity.Location;
import dndhelper.entity.Monster;
import dndhelper.entity.Npc;
import dndhelper.service.interfaces.CampaignService;
import dndhelper.service.interfaces.CharacterService;
import dndhelper.service.interfaces.DungeonMasterService;
import dndhelper.service.interfaces.LocationService;
import dndhelper.service.interfaces.MonsterService;
import dndhelper.service.interfaces.NpcService;

@Controller
@RequestMapping("/dungeon-master")
public class DungeonMasterAppController {
	
	@Autowired
	private DungeonMasterService dungeonMasterService;
	@Autowired
	private CampaignService campaignService;
	@Autowired
	private CharacterService characterService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private NpcService npcService;
	@Autowired
	private MonsterService monsterService;
	
	ArrayList <Monster> savedMonsters = new ArrayList<Monster>();
	private String nick;
	private int campaignId;

	@RequestMapping("/login")
	public String showDungeonMasterLoginPage(Model theModel) {
		theModel.addAttribute("dungeon_master", new DungeonMaster());
		return "dungeon-master/dungeon-master-login";
	}
	
	@PostMapping("/login_validate")
	public String loginValidate(@ModelAttribute("dungeon_master") DungeonMaster dungeonMaster) {
		if (this.dungeonMasterService.loginValidate(dungeonMaster)) {
		  this.nick = dungeonMaster.getNick();
			return "redirect:/dungeon-master/main";
		}
		return "redirect:/dungeon-master/login";
	}
	
	@RequestMapping("/create")
	public String showDungeonMasterCreatePage(Model theModel) {
		theModel.addAttribute("dungeon_master", new DungeonMaster());
		return "dungeon-master/dungeon-master-create";
	}
	
	@PostMapping("/create_account")
	public String createAccount(@ModelAttribute("dungeon_master") DungeonMaster dungeonMaster) {
		this.dungeonMasterService.saveDungeonMaster(dungeonMaster);
		return "dungeon-master/dungeon-master-login";
	}
	
	@RequestMapping("/main")
	public String showDungeonMasterMainPage(Model theModel) {
	  theModel.addAttribute("dungeonMaster", this.dungeonMasterService.getDungeonMasterByNick(this.nick));
	  return "dungeon-master/dungeon-master-main";
	}
	
	@RequestMapping("/campaign/create")
  public String showDungeonMasterCampaignCreatePage(Model theModel) {
    theModel.addAttribute("dungeonMaster", this.dungeonMasterService.getDungeonMasterByNick(this.nick));
    theModel.addAttribute("campaign", new Campaign());
    return "dungeon-master/dungeon-master-campaign-create";
  }
	
	@PostMapping("/campaign/campaign-create")
  public String createCampaign(@ModelAttribute("campaign") Campaign campaign) {
	  campaign.setDungeonMaster(this.dungeonMasterService.getDungeonMasterByNick(this.nick));
    this.campaignService.saveCampaign(campaign);
    return "redirect:/dungeon-master/main";
  }
	
	@RequestMapping("/campaign")
	public String showCampaignPage(
	    @RequestParam("campaignId") int campaignId, Model theModel) {
	  
	  DungeonMaster dungeonMaster = this.dungeonMasterService.getDungeonMasterByNick(this.nick);
    for (Campaign campaign : dungeonMaster.getCampaigns()) {
      if (campaign.getId() == campaignId) {
        theModel.addAttribute(campaign);
        return "dungeon-master/dungeon-master-campaign";
      }  
    }
	  return "redirect:/dungeon-master/main";
	}
	
	@Transactional
	@PostMapping("/campaign/characters")
	public String showCampainCharacterPage(@ModelAttribute("campaign") Campaign campaignWithId, 
	    Model theModel) {
    Campaign campaign = this.campaignService.getCampaignById(campaignWithId.getId());
    
	  theModel.addAttribute("campaign", campaign);
	  theModel.addAttribute("characters", this.campaignService.getCharacters(campaign));
	  
	  return "dungeon-master/campaign-characters";
	}
	
	@Transactional
	@RequestMapping("/campaign/characters")
	public String goBackToCampaigncharacterPage(
	    @ModelAttribute("campaignId") int campaignId, Model theModel) {
	  Campaign campaign = this.campaignService.getCampaignById(campaignId);
    
    theModel.addAttribute("campaign", campaign);
    theModel.addAttribute("characters", this.campaignService.getCharacters(campaign));
    
    return "dungeon-master/campaign-characters";
	}
	
	@Transactional
	@RequestMapping("/campaign/character/add")
	public String showCampaignCharacterAddPage(
	    @RequestParam("campaignId") int campaignId, Model theModel) {

	  Campaign campaign = this.campaignService.getCampaignById(campaignId);
	  
	  List<Character> characterList = this.characterService.getCharacters();
	  List<Character> characterCampaignList = this.campaignService.getCharacters(campaign);
	  
	  for (Character character : characterCampaignList)
	    characterList.remove(character);
	      
	  theModel.addAttribute("campaign", campaign);
	  theModel.addAttribute("characters", characterList);
	  return "dungeon-master/campaign-character-add";
	}
	
	@Transactional
	@RequestMapping("/campaign/character/add-character")
  public String AddCharacterToCampaign(
      @RequestParam("campaignId") int campaignId,
      @RequestParam("characterId") int characterId, Model theModel) {
    
	  Campaign campaign = this.campaignService.getCampaignById(campaignId);
	  Character character = this.characterService.getCharacterById(characterId);
	  character.addCampaign(campaign);
	  this.characterService.saveCharacter(character);
	  
    return "redirect:/dungeon-master/campaign?campaignId=" + campaignId;
  }
	
	@Transactional
	@RequestMapping("/campaign/character/delete")
	public String DeleteCharacterFromCampaign(
	    @RequestParam("campaignId") int campaignId,
      @RequestParam("characterId") int characterId) {
	  Campaign campaign = this.campaignService.getCampaignById(campaignId);
	  Character character = this.characterService.getCharacterById(characterId);
	  
	  List<Character> characterList = this.campaignService.getCharacters(campaign);
	  characterList.remove(character);
	  campaign.setCharacters(characterList);
	  this.campaignService.saveCampaign(campaign);
	  
	  List<Campaign> campaignList = this.characterService.getCampaigns(character);
    campaignList.remove(campaign);
    character.setCampaigns(campaignList);
    this.characterService.saveCharacter(character);
	  
	  return "redirect:/dungeon-master/campaign?campaignId=" + campaignId;
	}
	
	@PostMapping("/campaign/locations")
  public String showCampainLocationPage(@ModelAttribute("campaign") Campaign campaignWithId, 
      Model theModel) {
	savedMonsters = new ArrayList <Monster>();
	  Campaign campaign = this.campaignService.getCampaignById(campaignWithId.getId());
    theModel.addAttribute("campaign", campaign);
    theModel.addAttribute("locations", this.campaignService.getLocations(campaign));
    return "dungeon-master/campaign-locations";
  }
	
	@RequestMapping("/campaign/locations")
  public String gobackToCampainLocationPage(
      @RequestParam("campaignId") int campaignId, Model theModel) {
	savedMonsters = new ArrayList <Monster>();
    Campaign campaign = this.campaignService.getCampaignById(campaignId);
    theModel.addAttribute("campaign", campaign);
    theModel.addAttribute("locations", this.campaignService.getLocations(campaign));
    return "dungeon-master/campaign-locations";
  }
	
	@RequestMapping("/campaign/location/create")
  public String showCampaignLocationAddPage(
      @RequestParam("campaignId") int campaignId, Model theModel) {
	  Location location = new Location();
	  location.setCampaign(this.campaignService.getCampaignById(campaignId));
	  
	theModel.addAttribute("monsters", monsterService.getMonsters());  
	theModel.addAttribute("monster", new Monster());
    theModel.addAttribute("location", location);
    theModel.addAttribute("addedMonsters", savedMonsters);
    theModel.addAttribute(this.campaignService.getCampaignById(campaignId));
    return "dungeon-master/campaign-location-create";
  }
	
	@PostMapping("/campaign/location/location-create")
  public String createLocation(@ModelAttribute("location") Location location) { 
		location.setMonsters((List<Monster>)savedMonsters);
		savedMonsters = new ArrayList <Monster>();
		this.locationService.saveLocation(location);
    return "redirect:/dungeon-master/campaign?campaignId=" + location.getCampaign().getId();
  }
	@RequestMapping("/campaign/location/add_monster")
	  public String addMonsterToLocation(
	      @RequestParam("campaignId") int campaignId,
	      @RequestParam("locationId") int locationId, Model theModel,
	      @ModelAttribute("monster") Monster monster) {
		savedMonsters.add(monsterService.getMonsterById(monster.getId()));
	    return "redirect:/dungeon-master/campaign/location/create?campaignId=" + campaignId;
	  }
	
	@RequestMapping("/campaign/location/edit")
  public String showCampaignLocationEditPage(
      @RequestParam("campaignId") int campaignId,
      @RequestParam("locationId") int locationId, Model theModel) {
		List<Monster> monsters =  (this.locationService.getMonstersByLocation(locationId));
		theModel.addAttribute("monsters", monsterService.getMonsters());  
		theModel.addAttribute("monster", new Monster());
	    theModel.addAttribute("addedMonsters", monsters);
	    theModel.addAttribute(this.campaignService.getCampaignById(campaignId));
    theModel.addAttribute("location", this.locationService.getLocationById(locationId));
    return "dungeon-master/campaign-location-edit";
  }

	
	@RequestMapping("/campaign/location/delete_monster")
	  public String deleteMonsterFromLocationEdit(
	      @RequestParam("campaignId") int campaignId,
	      @RequestParam("locationId") int locationId, Model theModel,
	      @RequestParam("monsterId") int monsterId) {
		Location location = this.locationService.getLocationById(locationId);
		//Monster monster = monsterService.getMonsterById(monsterId);
		Monster monster = null;
		List<Monster> monsters =  (this.locationService.getMonstersByLocation(locationId));
		//List<Location> locations = (this.monsterService.getLocationsByMonsters(monsterId));
		for(Monster tempMonster : monsters) {
			if(tempMonster.getId() == monsterId) {
				monster = tempMonster;
				break;
			}
		}
		monsters.remove(monster);
		//locations.remove(location);
		
		location.setMonsters(monsters);
		//monster.setLocations(locations);
		
		this.locationService.saveLocation(location);
		//this.monsterService.saveMonster(monster);
	    return "redirect:/dungeon-master/campaign/location/edit?locationId="+locationId+"&"+"campaignId=" + campaignId;
	  }
	
	@RequestMapping("/campaign/location/add_monster_edit")
	  public String addMonsterToLocationEdit(
	      @RequestParam("campaignId") int campaignId,
	      @RequestParam("locationId") int locationId, Model theModel,
	      @ModelAttribute("monster") Monster monster) {
		Location location = this.locationService.getLocationById(locationId);
		List<Monster> monsters =  (this.locationService.getMonstersByLocation(locationId));
		monsters.add(monsterService.getMonsterById(monster.getId()));
		location.setMonsters(monsters);
		this.locationService.saveLocation(location);
	    return "redirect:/dungeon-master/campaign/location/edit?locationId="+locationId+"&"+"campaignId=" + campaignId;
	  }
	
	@PostMapping("/campaign/location/location-edit")
	public String editLocation(@ModelAttribute("location") Location location) {
		List<Monster> monsters =  (this.locationService.getMonstersByLocation(location.getId()));
		location.setMonsters(monsters);
		this.locationService.saveLocation(location);
	  return "redirect:/dungeon-master/campaign?campaignId=" + location.getCampaign().getId();
	}
	
	@RequestMapping("/campaign/location/delete")
	public String deleteLocation(
      @RequestParam("campaignId") int campaignId,
      @RequestParam("locationId") int locationId, Model theModel) {
	  this.locationService.deleteLocation(locationId);
    return "redirect:/dungeon-master/campaign?campaignId=" + campaignId;
  }
	
	@RequestMapping("/campaign/npc")
	public String showCampainNpcsPage(@ModelAttribute("campaign") Campaign campaignWithId, 
      Model theModel) {
    theModel.addAttribute("campaign", this.campaignService.getCampaignById(campaignWithId.getId()));
    theModel.addAttribute("npcs", this.campaignService.getNpcs(campaignWithId));
    return "dungeon-master/campaign-npcs";
  }
	
	@RequestMapping("/campaign/npcs")
  public String showCampainNpcsPage(
      @RequestParam("campaignId") int campaignId, Model theModel) {
	  Campaign campaign = this.campaignService.getCampaignById(campaignId);
    theModel.addAttribute("campaign", campaign);
    theModel.addAttribute("npcs", this.campaignService.getNpcs(campaign));
    return "dungeon-master/campaign-npcs";
  }
	
	@RequestMapping("/campaign/npc/create")
  public String showCampaignNpcCreatePage(
      @RequestParam("campaignId") int campaignId, Model theModel) {
    Npc npc = new Npc();
    Campaign campaign = this.campaignService.getCampaignById(campaignId);
    npc.setCampaign(campaign);
    theModel.addAttribute("npc", npc);
    theModel.addAttribute("campaign", campaign);
    return "dungeon-master/campaign-npc-create";
  }
	
	@PostMapping("/campaign/npc/npc-create")
	public String createNpc(@ModelAttribute("npc") Npc npc) {
    this.npcService.saveNpc(npc);
    return "redirect:/dungeon-master/campaign?campaignId=" + npc.getCampaign().getId();
  }
	
	@RequestMapping("/campaign/npc/edit")
  public String showCampaignNpcEditPage(
      @RequestParam("campaignId") int campaignId,
      @RequestParam("npcId") int npcId, Model theModel) {
    theModel.addAttribute("npc", this.npcService.getNpcById(npcId));
    return "dungeon-master/campaign-npc-edit";
  }
	
	@PostMapping("/campaign/npc/npc-edit")
  public String editNpc(@ModelAttribute("npc") Npc npc) {
    this.npcService.saveNpc(npc);
    return "redirect:/dungeon-master/campaign?campaignId=" + npc.getCampaign().getId();
  }
	
	@RequestMapping("/campaign/npc/delete")
	public String deleteNpc(
	    @RequestParam("campaignId") int campaignId,
      @RequestParam("npcId") int npcId, Model theModel) {
    this.npcService.deleteNpc(npcId);
    return "redirect:/dungeon-master/campaign?campaignId=" + campaignId;
  }
	
	@RequestMapping("/campaign/giveExp")
	public String addExp(
	    @RequestParam("campaignId") int campaignId,
	    @RequestParam("exp") int exp, @RequestParam("maxExp") int maxExp) {
	  
	  return "redirect:/dungeon-master/campaign?campaignId=";
	}
}
