package mk.ukim.finki.wp2024.service.impl;

import mk.ukim.finki.wp2024.model.Manufacturer;
import mk.ukim.finki.wp2024.repository.inmemory.InMemoryManufacturerRepository;
//import mk.ukim.finki.wp2024.repository.jpa.ManufacturerRepository;
import mk.ukim.finki.wp2024.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private final InMemoryManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(InMemoryManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findall();
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return this.manufacturerRepository.findById(id);
    }

    @Override
    public Optional<Manufacturer> save(String name, String address) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
//
//    @Override
//    public Optional<Manufacturer> save(String name, String address) {
//        Manufacturer manufacturer = new Manufacturer(name, address);
//        return Optional.of(this.manufacturerRepository.save(manufacturer));
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        this.manufacturerRepository.deleteById(id);
//    }
//
//    @Override
//    public boolean existsById(Long id) {
//        return this.manufacturerRepository.existsById(id);
//    }

}

