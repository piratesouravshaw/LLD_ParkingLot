package org.bnpl.repository;

import org.bnpl.model.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/*
* have every methods which allows to do CRUD operation on gate
* */
public class GateRepository {
    private Map<Long,Gate> gates=new TreeMap<>();
    public Optional<Gate> findGateById(Long id){
        if(gates.containsKey(id)){
            return Optional.of(gates.get(id));
        }
        return Optional.empty();
    }
}
