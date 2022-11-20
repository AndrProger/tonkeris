package com.java.tonkeris.repository;

import com.java.tonkeris.model.BasicAnalysis;
import com.java.tonkeris.model.GrainReception;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BasicAnalysisRepository extends CrudRepository<BasicAnalysis,Long> {
        @Query( "SELECT new com.java.tonkeris.model.BasicAnalysis(b.humidity,b.natura,b.vitreous,b.classGrain,b.type) from BasicAnalysis b where b.id=?1")
        public BasicAnalysis findByIdOnlyOne(Long id);

}
