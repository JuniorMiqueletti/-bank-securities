package com.juniormiqueletti.service;

import com.juniormiqueletti.model.Securities;
import com.juniormiqueletti.model.Status;
import com.juniormiqueletti.repository.SecuritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 * Created by junio on 01/04/2017.
 */
@Service
public class SecuritiesRegisterService {

    @Autowired
    private SecuritiesRepository securitiesRespository;

    public void save(Securities securities){
        try {
            securitiesRespository.save(securities);
        }catch (DataIntegrityViolationException e){
            throw new IllegalArgumentException("Invalid Date format!");
        }
    }

    public void delete(Long codigo){
        securitiesRespository.delete(codigo);
    }

    public String receive(Long codigo) {
        Securities securities = securitiesRespository.findOne(codigo);
        securities.setStatus(Status.RECEIVED);

        securitiesRespository.save(securities);

        return Status.RECEIVED.getDescription();
    }
}
