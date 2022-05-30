package br.com.ifce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ifce.Service.GamesService;
import br.com.ifce.model.Games;

@Controller
public class GamesController {

	@Autowired
	private GamesService gamesService;
	
	@GetMapping("/olaMundo")
	public String olaMundo() {
		
		return "OlaMundo";
	}
	
	@GetMapping("/games/formulario")
	public String formularioGames() {
		return "formulario";
	}
	
	@GetMapping("/games/salvar")
	public String salvar(Games jogo) {
		gamesService.cadastrarGame(jogo);
		
		return "Sucesso";
	}
	
	@GetMapping("/games/listar")
	public ModelAndView listarGames() {
		List<Games> jogos = gamesService.listarGames();
		//Faz Conecção com o View/front
		ModelAndView ponteView = new ModelAndView("listagem");
		
		ponteView.addObject("keyGames", jogos);
		return ponteView;
	}
}
