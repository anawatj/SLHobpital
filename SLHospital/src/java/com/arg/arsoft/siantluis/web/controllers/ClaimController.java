/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.web.controllers;

import com.arg.arsoft.siantluis.domains.claim.ClaimUpload;
import com.arg.arsoft.siantluis.repository.IClaimUploadRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author anawatj
 */
@Controller
@RequestMapping(value = "/claim")
public class ClaimController {
    
    
    @Autowired
    private IClaimUploadRepository cuRepository;
    
    
    
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    @Transactional
    public @ResponseBody String upload(MultipartFile  file) throws Exception
    {
        
        if(file!=null)
        {
            System.out.println(file.getOriginalFilename());
            
            Workbook workbook = new XSSFWorkbook(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0);
            for(int index=1;index<sheet.getPhysicalNumberOfRows();index++)
            {
                Row row = sheet.getRow(index);
                String code = row.getCell(0).getStringCellValue();
                ClaimUpload entity = cuRepository.findByCode(code);
               
                if(entity==null)
                {
                    entity= new ClaimUpload();
                    entity.setId(0);
                    entity.setCode(code);
                }
                 System.out.print(entity.getId());
                entity.setDesc(row.getCell(1).getStringCellValue());
                entity.setClaimDate(row.getCell(2).getStringCellValue());
                entity.setClaimTime(row.getCell(3).getStringCellValue());
                entity.setClaimLocation(row.getCell(4).getStringCellValue());
                entity.setClaimReason(row.getCell(5).getStringCellValue());
                cuRepository.save(entity);
                
            }
            
        }
        return "Success";
    }
}
