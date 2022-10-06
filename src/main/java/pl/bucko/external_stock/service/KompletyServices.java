package pl.bucko.external_stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bucko.external_stock.dto.KompletyDtoInterface;
import pl.bucko.external_stock.dto.KopmletyDto;
import pl.bucko.external_stock.entity.Artykul;
import pl.bucko.external_stock.repository.ArtykulRepository;
import pl.bucko.external_stock.repository.KompletyDtoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class KompletyServices {

    @Autowired
    private ArtykulRepository artykulRepository;

    private KompletyDtoRepository kompletyDtoRepository;

    public List<Long> pobierzIdKompetow() {
        List<Artykul> komplety = artykulRepository.znajdzKomplety();
        List<Long> listaId = new ArrayList<>();
        for(Artykul komplet : komplety){
            listaId.add(komplet.getIdArtykulu());
        }
//        artykulRepository.findAllByIdIn(listaId);
        return listaId;
    }

    public List<KompletyDtoInterface> produktykompletow(){
        return artykulRepository.pobierzProduktyKompletow();
    }


}
