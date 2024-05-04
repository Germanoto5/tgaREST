package kairya.tga.tgaREST.service;

import java.util.ArrayList;

import kairya.tga.tgaREST.model.Oferta;

public interface IOfertaService {
	Oferta findOferta(int id);
	ArrayList<Oferta> listOfertas();
}
