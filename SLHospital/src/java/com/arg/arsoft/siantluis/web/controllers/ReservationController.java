/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.web.controllers;

import com.arg.arsoft.siantluis.domains.reservation.Reservation;
import com.arg.arsoft.siantluis.domains.reservation.ReservationITItem;
import com.arg.arsoft.siantluis.domains.reservation.ReservationMotorItem;
import com.arg.arsoft.siantluis.domains.reservation.ReservationQuery;
import com.arg.arsoft.siantluis.domains.reservation.ReservationRoomItem;
import com.arg.arsoft.siantluis.repository.IAttachmentRepository;
import com.arg.arsoft.siantluis.repository.IReservationRepository;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Tao
 */
@Controller
@RequestMapping(value = "/reservation")
public class ReservationController {

    @Autowired
    private IReservationRepository rRepository;

    @RequestMapping(value = "/getByKey", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    Reservation getByKey(@RequestParam Integer key) {
        Reservation result = rRepository.findByKey(key);
        if (result == null) {
            result = new Reservation();
        }
        return result;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Transactional
    public @ResponseBody
    Reservation save(@RequestBody Reservation entity) {
        if (entity.getReservationBy() != null && (entity.getReservationBy().getId() == null || entity.getReservationBy().getId() == 0)) {
            entity.setReservationBy(null);
        }
        if (entity.getApproveBy() != null && (entity.getApproveBy().getId() == null || entity.getApproveBy().getId() == 0)) {
            entity.setApproveBy(null);
        }
        if (entity.getAttachment() != null && (entity.getAttachment().getId() == null || entity.getAttachment().getId() == 0)) {
            entity.setAttachment(null);
        }
        for (ReservationRoomItem item : entity.getRooms()) {
            if (item.getEquipment() != null && (item.getEquipment().getId() == null || item.getEquipment().getId() == 0)) {
                item.setEquipment(null);
            }

        }
        for (ReservationMotorItem item : entity.getMotors()) {
            if (item.getEquipment() != null && (item.getEquipment().getId() == null || item.getEquipment().getId() == 0)) {
                item.setEquipment(null);
            }

        }
        for (ReservationITItem item : entity.getIts()) {
            if (item.getEquipment() != null && (item.getEquipment().getId() == null || item.getEquipment().getId() == 0)) {
                item.setEquipment(null);
            }

        }
        Reservation result = rRepository.save(entity);
        return result;
    }

    
    @RequestMapping(value = "/search",method=RequestMethod.POST)
    @Transactional
    public @ResponseBody 
    Map search(@RequestBody ReservationQuery query)
    {
        Map result = rRepository.findByQuery(query);
        return result;
    }
    @RequestMapping(value = "/delete",method=RequestMethod.POST)
    @Transactional
    public void delete(@RequestBody Reservation data,HttpServletResponse response) throws Exception
    {
        rRepository.remove(data.getId());
        response.getOutputStream().print("Success");
        
    }
}
