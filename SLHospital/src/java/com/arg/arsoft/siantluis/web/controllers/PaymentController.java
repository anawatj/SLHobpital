/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.web.controllers;

import com.arg.arsoft.siantluis.domains.payment.Payment;
import com.arg.arsoft.siantluis.domains.payment.PaymentByCheque;
import com.arg.arsoft.siantluis.domains.payment.PaymentByCredit;
import com.arg.arsoft.siantluis.domains.payment.PaymentByTransfer;
import com.arg.arsoft.siantluis.domains.payment.PaymentExpenseItem;
import com.arg.arsoft.siantluis.domains.payment.PaymentPurchaseItem;
import com.arg.arsoft.siantluis.domains.payment.PaymentQuery;
import com.arg.arsoft.siantluis.repository.IPaymentRepository;
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
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private IPaymentRepository paymentRepository;
    
    @RequestMapping(value = "/getByKey",method=RequestMethod.GET)
    @Transactional
    public @ResponseBody Payment getByKey(@RequestParam Integer key)
    {
        
        Payment result = paymentRepository.findByKey(key);
        return result;
    }
    
    @RequestMapping(value = "/save",method=RequestMethod.POST)
    @Transactional
    public @ResponseBody Payment save(@RequestBody Payment entity)
    {
        if(entity.getPaymentBy()!=null && (entity.getPaymentBy().getId()==null || entity.getPaymentBy().getId()==0))
        {
            entity.setPaymentBy(null);
        }
        if(entity.getApproveBy()!=null && (entity.getApproveBy().getId()==null || entity.getApproveBy().getId()==0))
        {
            entity.setApproveBy(null);
        }
        if(entity.getDepartment()!=null && (entity.getDepartment().getId()==null || entity.getDepartment().getId()==0))
        {
            entity.setDepartment(null);
        }
        if(entity.getBranch()!=null && (entity.getBranch().getId()==null || entity.getBranch().getId()==0))
        {
            entity.setBranch(null);
        }
        if(entity.getAttachment()!=null && (entity.getAttachment().getId()==null || entity.getAttachment().getId()==0))
        {
            entity.setAttachment(null);
        }
        for(PaymentExpenseItem item : entity.getExpenses())
        {
            if(item.getExpense()!=null &&(item.getExpense().getId()==null || item.getExpense().getId()==0))
            {
                item.setExpense(null);
            }
        }
        for(PaymentPurchaseItem item : entity.getPurchases())
        {
            if(item.getPurchase()!=null && (item.getPurchase().getId()==null || item.getPurchase().getId()==0))
            {
                item.setPurchase(null);
            }
        }
        for(PaymentByCheque item : entity.getCheques())
        {
            if(item.getBank()!=null &&(item.getBank().getId()==null || item.getBank().getId()==0))
            {
                item.setBank(null);
            }
        }
        for(PaymentByCredit item : entity.getCredits())
        {
              if(item.getBank()!=null &&(item.getBank().getId()==null || item.getBank().getId()==0))
            {
                item.setBank(null);
            }
        }
        for(PaymentByTransfer item : entity.getTransfers())
        {
                 if(item.getBank()!=null &&(item.getBank().getId()==null || item.getBank().getId()==0))
            {
                item.setBank(null);
            }
        }
        Payment result = paymentRepository.save(entity);
        return result;
    }
    
    @RequestMapping(value = "/search",method=RequestMethod.POST)
    @Transactional
    public @ResponseBody Map search(@RequestBody PaymentQuery query)
    {
        Map result = paymentRepository.findByQuery(query);
        return result;
    }
    @RequestMapping(value = "/delete",method=RequestMethod.POST)
    @Transactional
    public void delete(@RequestBody Payment data,HttpServletResponse response) throws Exception
    {
        paymentRepository.remove(data.getId());
        response.getOutputStream().println("success");
        
    }
    

}
