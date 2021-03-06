package br.ufscar.dc.dsw.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Compra;
import br.ufscar.dc.dsw.domain.Livro;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.security.UsuarioDetails;
import br.ufscar.dc.dsw.service.spec.ICompraService;
import br.ufscar.dc.dsw.service.spec.ILivroService;

@Controller
@RequestMapping("/compras")
public class CompraController {
	
	@Autowired
	private ICompraService service;
	
	@Autowired
	private ILivroService livroService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Compra compra) {
		compra.setUsuario(this.getUsuario());
		compra.setData("31/08/2020");
		//compra.setValor(compra.getLivro().getPreco());
		return "compra/cadastro";
	}
	
	private Usuario getUsuario() {
		UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return usuarioDetails.getUser();
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
					
		model.addAttribute("compras",service.buscarTodos(this.getUsuario()));
		
		return "compra/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Compra compra, BindingResult result, RedirectAttributes attr) {
		
		String data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		compra.setUsuario(this.getUsuario());
		compra.setData(data);
		compra.setValor(compra.getLivro().getPreco());
		
		service.salvar(compra);
		attr.addFlashAttribute("sucess", "Compra inserida com sucesso.");
		return "redirect:/compras/listar";
	}
	
	@ModelAttribute("livros")
	public List<Livro> listaLivros() {
		return livroService.buscarTodos();
	}
}
