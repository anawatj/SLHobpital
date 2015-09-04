/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository;

import com.arg.arsoft.siantluis.domains.claim.ClaimUpload;
import java.util.List;

/**
 *
 * @author anawatj
 */
public interface IClaimUploadRepository extends Repository<ClaimUpload,Integer> {

    
    @Override
    public List<ClaimUpload> findAll();
    
    @Override
    public ClaimUpload findByKey(Integer key);
    
    @Override 
    public ClaimUpload save(ClaimUpload entity);
    
    @Override
    public void remove(Integer key);
    
    public ClaimUpload findByCode(String code);
    
    
}
