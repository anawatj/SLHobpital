/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.web.controllers;

import com.arg.arsoft.siantluis.domains.MasterDataObject;
import com.arg.arsoft.siantluis.domains.master.Amphur;
import com.arg.arsoft.siantluis.domains.master.AttachmentType;
import com.arg.arsoft.siantluis.domains.master.Branch;
import com.arg.arsoft.siantluis.domains.master.Department;
import com.arg.arsoft.siantluis.domains.master.EducationLevel;
import com.arg.arsoft.siantluis.domains.master.Hobby;
import com.arg.arsoft.siantluis.domains.master.ITEquipment;
import com.arg.arsoft.siantluis.domains.master.Language;
import com.arg.arsoft.siantluis.domains.master.MotorEquipment;
import com.arg.arsoft.siantluis.domains.master.Position;
import com.arg.arsoft.siantluis.domains.master.ProductGroup;
import com.arg.arsoft.siantluis.domains.master.Province;
import com.arg.arsoft.siantluis.domains.master.RoomEquipment;
import com.arg.arsoft.siantluis.domains.master.Service;
import com.arg.arsoft.siantluis.domains.master.Shipper;
import com.arg.arsoft.siantluis.domains.master.Title;
import com.arg.arsoft.siantluis.domains.purchase.PurchaseStatusBean;
import com.arg.arsoft.siantluis.repository.imp.AddressRepository;
import com.arg.arsoft.siantluis.repository.imp.MasterDataObjectRepository;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author wongskont
 */
@Controller
@RequestMapping(value = "/master")
public class MasterController {

    @Autowired
    private MasterDataObjectRepository mRepository;
    @Autowired
    private AddressRepository aRepository;

    @RequestMapping(value = "/title/getAll", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    List<MasterDataObject> getAllTitle() {

        List<MasterDataObject> result = mRepository.findAll(Title.class);
        return result;

    }

    @RequestMapping(value = "/educationLevel/getAll", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    List<MasterDataObject> getAllEducationLevel() {

        List<MasterDataObject> result = mRepository.findAll(EducationLevel.class);
        return result;
    }

    @RequestMapping(value = "/hobby/getAll", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    List<MasterDataObject> getAllHobby() throws Exception {

        List<MasterDataObject> result = mRepository.findAll(Hobby.class);
        return result;
    }

    @RequestMapping(value = "/position/getAll", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    List<MasterDataObject> getAllPosition() {

        List<MasterDataObject> result = mRepository.findAll(Position.class);
        return result;
    }

    @RequestMapping(value = "/address/province/getAll", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    List<Province> getAllProvince() {

        List<Province> result = aRepository.findAllProvince();
        return result;

    }

    @RequestMapping(value = "/address/amphur/getAll", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    List<Amphur> getAllAmphur(@RequestParam Integer provinceId) {

        List<Amphur> result = aRepository.findAllAmphur(provinceId);
        return result;
    }

    @RequestMapping(value = "/productGroup/getAll", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    List<MasterDataObject> getAllProductGroup() throws Exception {

        List<MasterDataObject> result = mRepository.findAll(ProductGroup.class);
        return result;
    }

    @RequestMapping(value = "/language/getAll", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    List<MasterDataObject> getAllLanguage() {

        List<MasterDataObject> result = mRepository.findAll(Language.class);
        return result;
    }

    @RequestMapping(value = "/branch/getAll", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    List<MasterDataObject> getAllBranch() {

        List<MasterDataObject> result = mRepository.findAll(Branch.class);
        return result;
    }

    @RequestMapping(value = "/department/getAll", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    List<MasterDataObject> getAllDepartment() {

        List<MasterDataObject> result = mRepository.findAll(Department.class);
        return result;
    }

    @RequestMapping(value = "/service/getAll", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    List<MasterDataObject> getAllService() {

        List<MasterDataObject> result = mRepository.findAll(Service.class);
        return result;
    }

    @RequestMapping(value = "/purchaseStatus/getAll", method = RequestMethod.GET)
    public @ResponseBody
    List<PurchaseStatusBean> getAllPurchaseStatus(HttpServletRequest request) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(request.getRealPath("/WEB-INF/configs.xml")));
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList nodeList = (NodeList) xPath.compile("/configs/purchaseStatuses/purchaseStatus").evaluate(doc, XPathConstants.NODESET);
        List<PurchaseStatusBean> list = new ArrayList<PurchaseStatusBean>();
        for (int index = 0; index < nodeList.getLength(); index++) {
            Node node = nodeList.item(index);
            PurchaseStatusBean item = new PurchaseStatusBean();
            item.setCode(node.getAttributes().getNamedItem("code").getNodeValue());
            item.setDesc(node.getAttributes().getNamedItem("desc").getNodeValue());
            list.add(item);
        }
        return list;
    }

    @RequestMapping(value = "/shipper/getAll", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    List<MasterDataObject> getAllShipper() {

        List<MasterDataObject> result = mRepository.findAll(Shipper.class);
        return result;
    }

    @RequestMapping(value = "/equipment/room/getAll", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    List<MasterDataObject> getAllRoomEquipment() {
        List<MasterDataObject> result = mRepository.findAll(RoomEquipment.class);
        return result;
    }

    @RequestMapping(value = "/equipment/motor/getAll", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    List<MasterDataObject> getAllMotorEquipment() {
        List<MasterDataObject> result = mRepository.findAll(MotorEquipment.class);
        return result;
    }

    @RequestMapping(value = "/equipment/it/getAll", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    List<MasterDataObject> getAllITEquipment() {
        List<MasterDataObject> result = mRepository.findAll(ITEquipment.class);
        return result;
    }
     @RequestMapping(value = "/attachmentType/getAll", method = RequestMethod.GET)
    @Transactional
     public @ResponseBody List<MasterDataObject> getAllAttachmentType()
     {
         List<MasterDataObject> result = mRepository.findAll(AttachmentType.class);
         return result;
     }
}
