package com.example.backend.controller;

import com.example.backend.dto.CompraDTO;
import com.example.backend.dto.DetalleCompraDTO;
import com.example.backend.model.Compra;
import com.example.backend.model.DetalleCompra;
import com.example.backend.model.Product;
import com.example.backend.model.User;
import com.example.backend.repository.CompraRepository;
import com.example.backend.repository.DetalleCompraRepository;
import com.example.backend.repository.ProductRepository;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/compras")
@CrossOrigin(origins = "http://localhost:3000") // Permite React en localhost:3000
public class CompraController {

    @Autowired
    private CompraRepository compraRepository;
    
    @Autowired
    private DetalleCompraRepository detalleCompraRepository;
    
    @Autowired
    private ProductRepository productoRepository;
    
    @Autowired
    private UserRepository userRepository;

@PostMapping("/realizar")
public ResponseEntity<?> realizarCompra(@RequestBody CompraDTO compraDTO) {
    try {
        User usuario = userRepository.findById(compraDTO.getUsuarioId())
                .orElseThrow(() -> new Exception("Usuario no encontrado"));

        Compra nuevaCompra = new Compra();
        nuevaCompra.setUsuario(usuario);
        nuevaCompra.setTotal(compraDTO.getTotal());
        nuevaCompra.setDescuento(compraDTO.getDescuento());

        Compra compraGuardada = compraRepository.save(nuevaCompra);

        for (DetalleCompraDTO detalleDTO : compraDTO.getDetalles()) {
            Product producto = productoRepository.findById(detalleDTO.getProductoId())
                    .orElseThrow(() -> new Exception("Producto no encontrado"));

            DetalleCompra detalleCompra = new DetalleCompra();
            detalleCompra.setCantidad(detalleDTO.getCantidad());
            detalleCompra.setPrecio(producto.getPrice());
            detalleCompra.setCompra(compraGuardada);

            detalleCompraRepository.save(detalleCompra);
        }

        return new ResponseEntity<>(compraGuardada, HttpStatus.CREATED);
    } catch (Exception e) {
        return new ResponseEntity<>("Hubo un error al procesar la compra: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}


    @GetMapping("/todos")
    public List<Compra> obtenerCompras() {
        return compraRepository.findAll();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Compra> obtenerComprasPorUsuario(@PathVariable Long usuarioId) {
        User usuario = userRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return compraRepository.findByUsuario(usuario);
    }
}
