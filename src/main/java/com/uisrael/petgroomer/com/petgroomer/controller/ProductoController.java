package com.uisrael.petgroomer.com.petgroomer.controller;

import com.uisrael.petgroomer.com.petgroomer.model.ModelProducto;
import com.uisrael.petgroomer.com.petgroomer.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public String home() {
        return "redirect:/producto";
    }

    @GetMapping("/producto")
    public String listarProducto(Model modelo) {
        List<ModelProducto> productos = productoRepository.findAll();
        modelo.addAttribute("producto", productos);
        return "producto";
    }


    @GetMapping("/producto/nuevo")
    public String agregarProducto(Model model) {
        model.addAttribute("producto", new ModelProducto()); // Crea un nuevo objeto
        return "producto_form"; // Devuelve el formulario para agregar
    }

    @PostMapping("/producto/guardar")
    public String guardarProducto(@ModelAttribute ModelProducto producto, RedirectAttributes redirectAttributes) {
        productoRepository.save(producto); // Guarda el producto
        redirectAttributes.addFlashAttribute("message", "El producto ha sido guardado con éxito");
        return "redirect:/producto"; // Redirige a la lista de productos
    }

    @GetMapping("/producto/editar/{id}")
    public String editarProducto(@PathVariable Long id, Model model) {
        ModelProducto producto = productoRepository.findById(Math.toIntExact(id)).orElse(null);
        if (producto == null) {
            return "redirect:/producto"; // Redirige si no se encuentra
        }
        model.addAttribute("producto", producto); // Agrega el producto a la vista
        return "producto_form"; // Devuelve el formulario para editar
    }
    @PostMapping("/producto/actualizar/{id}")
    public String actualizarProducto(@PathVariable Long id, @ModelAttribute ModelProducto producto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "producto_form"; // Devuelve al formulario si hay errores
        }

        // Busca el producto existente por ID
        ModelProducto productoExistente = productoRepository.findById(Math.toIntExact(id)).orElse(null);
        if (productoExistente != null) {
            // Actualiza solo los atributos que han cambiado
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setPrecio(producto.getPrecio());
            productoExistente.setStock(producto.getStock());

            // Guarda el producto actualizado
            productoRepository.save(productoExistente);
            redirectAttributes.addFlashAttribute("message", "El Producto ha sido actualizado con éxito");
        } else {
            redirectAttributes.addFlashAttribute("error", "Producto no encontrado");
        }

        return "redirect:/producto"; // Redirige al listado de productos
    }


    @PostMapping("/producto/eliminar/{id}")
    public String eliminarProducto(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            productoRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "El Producto ha sido eliminado con éxito");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "El Producto no se encontró");
        }
        return "redirect:/producto";
    }
}

