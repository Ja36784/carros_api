package com.carros.domain;

import com.carros.domain.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired // o spring estara injetando a dependencia CarroRepository
    private CarroRepository rep;
    public List<CarroDTO> getCarros(){

//         Lambda
//       return rep.findAll().stream().map(c -> new CarroDTO(c)).collect(Collectors.toList());
//         sintaxe resumida da lambda acima
        return rep.findAll().stream().map(CarroDTO::create).collect(Collectors.toList());

//      Manualmente
//      List<CarroDTO> list = new ArrayList<>();
//          for (Carro c: carros){
//          list.add(new CarroDTO(c));
//          return list;
//        }
    }
    public Optional<CarroDTO> getCarroById(Long id) {
//        Lambda
       return rep.findById(id).map(CarroDTO::create);
//        Outra forma
//        Optional<Carro> carro = rep.findById(id);
//        return carro.map(c ->Optional.of(new CarroDTO(c))).orElse(null);

//        Manualmente
//        Optional<Carro> carro = rep.findById(id);
//        if(carro.isPresent()){
//            return Optional.of(new CarroDTO(carro.get()));
//        }else{
//            return null;
//        }
    }
    public List<CarroDTO> getCarrosByTipo(String tipo) {
        return rep.findByTipo(tipo).stream().map(CarroDTO::create).collect(Collectors.toList());
    }
    public CarroDTO insert(Carro carro) {
        Assert.isNull(carro.getId(), "Não foi possivel inserir o registro");

        return CarroDTO.create(rep.save(carro));
    }
    public CarroDTO update(Carro carro, Long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");

        // busca o carro no banco de dados
        Optional<Carro> optional = rep.findById(id);
        if (optional.isPresent()) {
            Carro db = optional.get();

            //copiar as propriedade
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            System.out.println("Carro id " + db.getId());

            // atualiza o carro
            rep.save(db);
            return CarroDTO.create(db);
        } else {
            return null;
//            throw new RuntimeException("Não foi possível atuaçizar o registro");
        }
        /*
        // fazendo atraves de Lambda
        getCarroById(id).map(db -> {
            // copiar propriedade
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            System.out.println("Carro id " + db.getId());

            // atualiza o carro
            rep.save(db);
            return db;
        }).orElseThrow() -> new RuntimeException("Não foi possível atuaçizar o registro");

         */
    }
    public boolean delete(Long id) {
        if(getCarroById(id).isPresent()) {
            rep.deleteById(id);
            return true;
        }
        return false;
    }
}