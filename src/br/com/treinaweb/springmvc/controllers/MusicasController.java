package br.com.treinaweb.springmvc.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.treinaweb.springmvc.dominios.Musica;
import br.com.treinaweb.springmvc.repositorios.RepositorioAlbum;
import br.com.treinaweb.springmvc.repositorios.RepositorioMusica;

@Controller
@RequestMapping("/musicas")
public class MusicasController {

	@Autowired
	private RepositorioAlbum repositorioAlbum;
	@Autowired
	private RepositorioMusica repositorioMusica;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {

		List<Musica> musicas = repositorioMusica.findAll();

		model.addAttribute("musicas", musicas);

		return "musica.listar.tiles";

	}

	@RequestMapping(value = "/adicionar", method = RequestMethod.GET)
	public String adicionar(Model model) {

		model.addAttribute("musica", new Musica());
		model.addAttribute("albuns", repositorioAlbum.findAll());
		return "musica.adicionar.tiles";

	}

	@RequestMapping(value = "/adicionar", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("musica") @Valid Musica novaMusica, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("albuns", repositorioAlbum.findAll());
			return "musica.adicionar.tiles";
		}

		repositorioMusica.save(novaMusica);
		return "redirect:/musicas/listar";
	}

	@RequestMapping(value = "/alterar/{id}", method = RequestMethod.GET)
	public String alterar(@PathVariable("id") Long id, Model model) {

		Musica musicaASerAlterada = repositorioMusica.findOne(id);
		model.addAttribute("musica", musicaASerAlterada);
		model.addAttribute("albuns", repositorioAlbum.findAll());
		return "musica.alterar.tiles";

	}

	@RequestMapping(value = "/alterar", method = RequestMethod.POST)
	public String alterar(@ModelAttribute("musica") @Valid Musica musica, BindingResult result, Model model) {

		if (result.hasErrors()) {

			model.addAttribute("albuns", repositorioAlbum.findAll());
			return "musica.alterar.tiles";
		}

		repositorioMusica.save(musica);
		return "redirect:/musicas/listar";
	}

	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.GET)
	public String excluir(@PathVariable("id") Long id) {

		Musica musica = repositorioMusica.findOne(id);
		musica.setAlbum(null);
		repositorioMusica.delete(musica);
		return "redirect:/musicas/listar";
	}

	@InitBinder
	public void dateBinder(WebDataBinder binder) {
		// Define o formato da data
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		// Cria um CustomDateEditor
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		// Registra o editor
		binder.registerCustomEditor(Date.class, "dataCriacao", editor);

	}

}
