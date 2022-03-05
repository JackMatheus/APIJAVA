package com.dio.livecoding.crud.salasdereuniao.repository;

import com.dio.livecoding.crud.salasdereuniao.model.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TarefaRepository  extends JpaRepository<TarefaModel, Integer> {

}
