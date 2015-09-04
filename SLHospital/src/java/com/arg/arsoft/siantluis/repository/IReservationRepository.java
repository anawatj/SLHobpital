/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository;

import com.arg.arsoft.siantluis.domains.reservation.Reservation;
import com.arg.arsoft.siantluis.domains.reservation.ReservationQuery;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tao
 */
public interface IReservationRepository extends Repository<Reservation,Integer>{

    @Override
    public List<Reservation> findAll();

    @Override
    public Reservation findByKey(Integer key);

    @Override
    public Reservation save(Reservation entity);

    @Override
    public void remove(Integer key);
    
    public Map findByQuery(ReservationQuery query);
    
    
    
}
