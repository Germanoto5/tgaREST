package kairya.tga.tgaREST.service;

import kairya.tga.tgaREST.model.UsuarioOferta;
import kairya.tga.tgaREST.model.UsuarioOfertaId;

public interface IUsuarioOfertaService {
UsuarioOferta findUsuarioOferta(UsuarioOfertaId id);
UsuarioOferta guardarUsuarioPromocion(UsuarioOferta usuarioOferta);
}