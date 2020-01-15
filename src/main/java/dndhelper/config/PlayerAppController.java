package dndhelper.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dndhelper.entity.Character;
import dndhelper.entity.DungeonMaster;
import dndhelper.entity.Player;
import dndhelper.entity.enums.AllignmentEnum;
import dndhelper.entity.enums.ClassEnum;
import dndhelper.entity.enums.RaceEnum;
import dndhelper.service.interfaces.CharacterService;
import dndhelper.service.interfaces.PlayerService;

@Controller
@RequestMapping("/player")
public class PlayerAppController {

	String nick;
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private CharacterService characterService;
	
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

	@PostMapping("/create_account")
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
		theModel.addAttribute("allignments",AllignmentEnum.values());
		theModel.addAttribute("races",RaceEnum.values());
		theModel.addAttribute("classes",ClassEnum.values());
		return "player/show-character-form";
	}
	
	@RequestMapping("/character/show_character")
	public String showCharacterCreatePage(@ModelAttribute("characterId") int characterId, Model theModel) {
		List <Character> characters = playerService.getPlayerByNick(nick).getCharacters();
		Character character;
		for(Character tempCh : characters) {
			if(characterId == tempCh.getId()) {
				character = tempCh;
				theModel.addAttribute("allignments",AllignmentEnum.values());
				theModel.addAttribute("races",RaceEnum.values());
				theModel.addAttribute("classes",ClassEnum.values());
				theModel.addAttribute(character);
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
}
