package com.michelouadria.trotracesimulator.repository;

import com.michelouadria.trotracesimulator.model.TrotRace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrotRaceRepository extends CrudRepository<TrotRace, Integer> {
}
