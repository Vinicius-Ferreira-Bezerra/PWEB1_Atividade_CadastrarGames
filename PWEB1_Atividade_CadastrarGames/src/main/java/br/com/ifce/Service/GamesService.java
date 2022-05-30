package br.com.ifce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifce.model.Games;
import br.com.ifce.repository.GamesRespository;

@Service
public class GamesService {
	
	@Autowired
	private GamesRespository gamesResitory;
	
	public void cadastrarGame(Games jogo) {
		gamesResitory.save(jogo);
	}
	
	public List<Games> listarGames() {
		return gamesResitory.findAll();
	}
	
}