package com.java.tonkeris.repository;

import com.java.tonkeris.model.TransportNow;
import com.java.tonkeris.model.dopModel.TransportNowDopAnalysis;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransportNowRepository extends CrudRepository<TransportNow,Long> {
    @Query(value = "SELECT new com.java.tonkeris.model.dopModel.TransportNowDopAnalysis(t.id,t.num,t.type,t.numTrail,t.actionDate,t.id_grainReception, g.id_basic)  " +
            "FROM TransportNow t , GrainReception g WHERE t.id_grainReception=g.id"
            )
    public List<TransportNowDopAnalysis> getTransportNowByDopAnalysis();
    @Query("select g.id_basic from GrainReception g,TransportNow t where t.id=?1 and g.id=t.id_grainReception")
    public Long getIdBasicFromIdTransport(Long idIN);
}
