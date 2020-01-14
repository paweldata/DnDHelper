package dndhelper.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dndhelper.entity.Campaign;
import dndhelper.entity.DungeonMaster;
import dndhelper.service.interfaces.CampaignService;
import dndhelper.service.interfaces.DungeonMasterService;

@Controller
@RequestMapping("/dungeon-master")
public class DungeonMasterAppController {
	
	@Autowired
	private DungeonMasterService dungeonMasterService;
	@Autowired
	private CampaignService campaignService;
	private String nick;

	@RequestMapping("/login")
	public String showDungeonMasterLoginPage(Model theModel) {
		DungeonMaster dungeonMaster = new DungeonMaster();
		theModel.addAttribute("dungeon_master", dungeonMaster);
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
		DungeonMaster dungeonMaster = new DungeonMaster();
		theModel.addAttribute("dungeon_master", dungeonMaster);
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
	  Campaign campaign = new Campaign();
    theModel.addAttribute("dungeonMaster", this.dungeonMasterService.getDungeonMasterByNick(this.nick));
    theModel.addAttribute("campaign", campaign);
    return "dungeon-master/dungeon-master-campaign-create";
  }
	
	@PostMapping("/campaign/campaign-create")
  public String createCampaign(@ModelAttribute("campaign") Campaign campaign) {
	  campaign.setDungeonMaster(this.dungeonMasterService.getDungeonMasterByNick(this.nick));
    this.campaignService.saveCampaign(campaign);
    return "redirect:/dungeon-master/campaigns";
  }
	
	@RequestMapping("/campaigns")
	public String showDungeonMasterCampaignPage(Model theModel) {
	  List<Campaign> campaigns = this.dungeonMasterService.getDungeonMasterByNick(nick).getCampaigns();
	  theModel.addAttribute(campaigns);
	  return "dungeon-master/show-campaigns";
	}
	
	@RequestMapping("/show-campaign")
	public String showCampaignPage(
	    @RequestParam("campaignId") int campaignId, Model theModel) {
	  
	  Campaign campaign = this.campaignService.getCampaignById(campaignId);
	  theModel.addAttribute(campaign);
	  return "dungeon-master/show-campaign";
	}
	
	@PostMapping("/campaign/characters")
	public String showCampainCharacterPage(@ModelAttribute("campaign") Campaign campaignWithId, 
	    Model theModel) {
	  Campaign campaign = this.campaignService.getCampaignById(campaignWithId.getId());
	  theModel.addAttribute("campaign", campaign);
	  return "dungeon-master/campaign-characters";
	}
	
	@RequestMapping("/campaign/character/add")
	public String showCampaignCharacterAddPage() {
	   //TODO
	  return "";
	}
}
