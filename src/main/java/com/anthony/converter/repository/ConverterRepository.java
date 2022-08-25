package com.anthony.converter.repository;


import com.anthony.converter.entity.ConversionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("ConverterRepository")
public interface ConverterRepository extends CrudRepository<ConversionEntity, Long> {

    public ConversionEntity save(ConversionEntity entity);

    public List<ConversionEntity> findAll();


}
