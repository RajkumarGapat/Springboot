package com.example.loadapi.service;

import com.example.loadapi.model.Load;
import com.example.loadapi.repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoadService {

    @Autowired
    private LoadRepository loadRepository;

    public Load addLoad(Load load) {
        return loadRepository.save(load);
    }

    public List<Load> getLoadsByShipperId(UUID shipperId) {
        return loadRepository.findByShipperId(shipperId);
    }

    public Optional<Load> getLoadById(UUID loadId) {
        return loadRepository.findById(loadId);
    }

    public Load updateLoad(UUID loadId, Load updatedLoad) {
        return loadRepository.findById(loadId)
                .map(load -> {
                    load.setLoadingPoint(updatedLoad.getLoadingPoint());
                    load.setUnloadingPoint(updatedLoad.getUnloadingPoint());
                    load.setProductType(updatedLoad.getProductType());
                    load.setTruckType(updatedLoad.getTruckType());
                    load.setNoOfTrucks(updatedLoad.getNoOfTrucks());
                    load.setWeight(updatedLoad.getWeight());
                    load.setComment(updatedLoad.getComment());
                    load.setDate(updatedLoad.getDate());
                    return loadRepository.save(load);
                }).orElseThrow(() -> new RuntimeException("Load not found"));
    }

    public void deleteLoad(UUID loadId) {
        loadRepository.deleteById(loadId);
    }
}
