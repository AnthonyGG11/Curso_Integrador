package com.registro.usuario.controlador;

import com.registro.usuario.dto.UsuarioRegistroDTO;
import com.registro.usuario.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    public RegistroUsuarioControlador(UsuarioServicio usuarioServicio) {

        super();
        this.usuarioServicio = usuarioServicio;
    }

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO(){
        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro(){
        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO){
        usuarioServicio.guardar(registroDTO);
        return "redirect:/registro?exito";
    }

}
