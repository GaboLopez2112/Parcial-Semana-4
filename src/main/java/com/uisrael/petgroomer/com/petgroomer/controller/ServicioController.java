package com.uisrael.petgroomer.com.petgroomer.controller;

import com.uisrael.petgroomer.com.petgroomer.model.ModelServicio;
import com.uisrael.petgroomer.com.petgroomer.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ServicioController {
    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/servicio")
    public String listarServicio(Model model) {
        List<ModelServicio> servicios = servicioRepository.findAll();
        model.addAttribute("servicio", servicios);
        return "servicio";
    }
    @GetMapping("/servicio/nuevo")
    public String agregarServicio(Model model) {
        model.addAttribute("servicio", new ModelServicio());
        return "servicio_form";
    }
    @PostMapping("/servicio/guardar")
    public String guardarServicio(@ModelAttribute ModelServicio servicio, RedirectAttributes redirectAttributes) {
        try {
            servicioRepository.save(servicio);
            redirectAttributes.addFlashAttribute("message", "El servicio ha sido guardado con éxito");
        } catch (Exception e) {
            redirectAttributes.addAttribute("message", e.getMessage());
        }
        return "redirect:/servicio";
    }
    @GetMapping("/servicio/editar/{id}")
    public String editarServicio(@PathVariable Long id, Model model) {
        ModelServicio servicio = servicioRepository.findById(id).orElse(null);
        if(servicio == null) {
            return  "redirect:/servicio";
        }
        model.addAttribute("servicio", servicio);
        return "servicio_form";
    }
    @PostMapping("servicio/actualizar/{id}")
    public String actualizarServicio(@PathVariable Long id, @ModelAttribute ModelServicio servicio, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return  "servicio_form";
        }
        ModelServicio servicioE = servicioRepository.findById(id).orElse(null);
        if(servicioE != null) {
            servicioE.setNombre(servicio.getNombre());
            servicioE.setPrecio(servicio.getPrecio());

            servicioRepository.save(servicioE);
            redirectAttributes.addFlashAttribute("message", "El servicio ha sido actualizado con éxito");
        } else {
            redirectAttributes.addFlashAttribute("error", "Servicio no encontrado");
        }
        return "redirect:/servicio";
    }
    @PostMapping("/servicio/eliminar/{id}")
    public String eliminarServico(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            servicioRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "El Servicio ha sido eliminado con éxito");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "El Servicio no se encontró");
        }
        return "redirect:/servicio";
    }
}
