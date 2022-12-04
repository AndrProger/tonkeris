package com.java.tonkeris.repository;

import com.java.tonkeris.model.BasicAnalysis;
import com.java.tonkeris.model.GrainReception;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BasicAnalysisRepository extends CrudRepository<BasicAnalysis,Long> {
        @Query( "SELECT new com.java.tonkeris.model.BasicAnalysis(b.humidity,b.natura,b.vitreous,b.classGrain,b.type) from BasicAnalysis b where b.id=?1")
        public BasicAnalysis findByIdOnlyOne(Long id);
        @Query ( "SELECT new com.java.tonkeris.model.BasicAnalysis(b.humidity,b.natura,b.vitreous,b.classGrain,b.type) " +
                "from BasicAnalysis b where ((b.humidity>=?1  and b.humidity<=?2) or b.humidity=null ) and ((b.natura>=?3 and b.natura<=?4) or  b.natura=null)and  (b.vitreous LIKE %?5% or b.vitreous=null) and ((b.classGrain>=?6 and b.classGrain<=?7) or b.classGrain =null ) and (b.type like %?8% or b.type=null )")
        public List<BasicAnalysis> findParamFilt(
                Double byhumidity,
                 Double tohumidity,
                Double bynatura,
                Double tonatura,
                String vitreous,
                Integer toclass,
                Integer byclass,
                String type
        );

}
