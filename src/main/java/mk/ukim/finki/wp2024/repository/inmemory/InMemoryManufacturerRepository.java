//package mk.ukim.finki.wp2024.repository.inmemory;
//
//import mk.ukim.finki.wp2024.bootstrap.DataHolder;
//import mk.ukim.finki.wp2024.model.Manufacturer;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class InMemoryManufacturerRepository {
//    public List<Manufacturer> findAll() {
//        return DataHolder.manufacturers;
//    }
//
//    public Optional<Manufacturer> findById(Long manufacturerId) {
//        return DataHolder.manufacturers.stream()
//                .filter(i -> i.getId().equals(manufacturerId)).findFirst();
//    }
//
//    public Optional<Manufacturer> save(String name, String address) {
//        Manufacturer manufacturer = new Manufacturer(name, address);
//        DataHolder.manufacturers.add(manufacturer);
//        return Optional.of(manufacturer);
//    }
//
//    public boolean deleteById(Long id) {
//        return DataHolder.manufacturers.removeIf(i -> i.getId().equals(id));
//    }
//
//}

package mk.ukim.finki.wp2024.repository.inmemory;

import mk.ukim.finki.wp2024.bootstrap.DataHolder;
import mk.ukim.finki.wp2024.model.Category;
import mk.ukim.finki.wp2024.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryManufacturerRepository{
    public List<Manufacturer> findall(){
        return DataHolder.manufacturers;
    }

    public Optional<Manufacturer>findById(Long id){
        return DataHolder.manufacturers.stream().filter(i ->i.getId().equals(id)).findFirst();

    }

        public Optional<Manufacturer> save(String name, String address) {
        Manufacturer manufacturer = new Manufacturer(name, address);
        DataHolder.manufacturers.add(manufacturer);
        return Optional.of(manufacturer);
    }

    public void saveAll(List<Manufacturer> list) {
        DataHolder.manufacturers=list;
    }

}

