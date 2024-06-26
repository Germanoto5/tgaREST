package kairya.tga.tgaREST.serviceimp;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kairya.tga.tgaREST.model.UsuarioOferta;
import kairya.tga.tgaREST.model.UsuarioOfertaId;
import kairya.tga.tgaREST.repository.IUsuarioOfertaRepository;
import kairya.tga.tgaREST.service.IUsuarioOfertaService;

@Service
public class UsuarioOfertaServiceImp implements IUsuarioOfertaService{

    @Autowired
    IUsuarioOfertaRepository repository;

    @Override
    public UsuarioOferta findUsuarioOferta(UsuarioOfertaId id) {
       Optional<UsuarioOferta> usuarioOferta = repository.findById(id);
        return usuarioOferta.isPresent() ? usuarioOferta.get() : new UsuarioOferta();
    }

    @Override
    public UsuarioOferta guardarUsuarioPromocion(UsuarioOferta usuarioPromocion) {
        return repository.save(usuarioPromocion);
    }

    @Override
    public ArrayList<UsuarioOferta> findByCorreo(String correo) {
        return repository.findByCorreo(correo);
    }

    @Override
    public UsuarioOferta findByCodigo(String codigo) {
        Optional<UsuarioOferta> usuarioOferta = repository.findByCodigo(codigo);
        return usuarioOferta.isPresent() ? usuarioOferta.get() : null;
    }
}
