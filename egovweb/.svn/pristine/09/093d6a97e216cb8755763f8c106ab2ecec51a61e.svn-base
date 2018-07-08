/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.example.parkType.web;

import java.util.List;

import egovframework.example.parkType.service.ParkTypeDefaultVO;
import egovframework.example.parkType.service.ParkTypeService;
import egovframework.example.parkType.service.ParkTypeVO;
import egovframework.example.sample.service.EgovSampleService;
import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.example.sample.service.SampleVO;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

/**
 * @Class Name : EgovSampleController.java
 * @Description : EgovSample Controller Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class ParkTypeController {

	/** ParkTypeService */
	@Resource(name = "parkTypeService")
	private ParkTypeService parkTypeService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	/**
	 * 글 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 ParkTypeDefaultVO
	 * @param model
	 * @return "parkTypeList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/parkTypeList.do")
	public String selectParkTypeList(@ModelAttribute("searchVO") ParkTypeDefaultVO searchVO, ModelMap model) throws Exception {

		/** EgovPropertyService.parkType */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List<?> parkTypeList = parkTypeService.selectParkTypeList(searchVO);
		model.addAttribute("resultList", parkTypeList);

		int totCnt = parkTypeService.selectParkTypeListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "parkType/parkTypeList";
	}

	/**
	 * 글 등록 화면을 조회한다.
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param model
	 * @return "parkTypeRegister"
	 * @exception Exception
	 */
	@RequestMapping(value = "/addParkType.do", method = RequestMethod.GET)
	public String addParkTypeView(@ModelAttribute("searchVO") ParkTypeDefaultVO searchVO, Model model) throws Exception {
		model.addAttribute("parkTypeVO", new ParkTypeVO());
		return "parkType/parkTypeRegister";
	}

	/**
	 * 글을 등록한다.
	 * @param parkTypeVO - 등록할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/parkTypeList.do"
	 * @exception Exception
	 */
	@RequestMapping(value = "/addParkType.do", method = RequestMethod.POST)
	public String addParkType(@ModelAttribute("searchVO") ParkTypeDefaultVO searchVO, ParkTypeVO parkTypeVO, BindingResult bindingResult, Model model, SessionStatus status)
			throws Exception {

		// Server-Side Validation
		beanValidator.validate(parkTypeVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("parkTypeVO", parkTypeVO);
			return "parkType/parkTypeRegister";
		}

		parkTypeService.insertParkType(parkTypeVO);
		status.setComplete();
		return "forward:/parkTypeList.do";
	}

	/**
	 * 글 수정화면을 조회한다.
	 * @param id - 수정할 글 id
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param model
	 * @return "parkTypeRegister"
	 * @exception Exception
	 */
	@RequestMapping("/updateParkTypeView.do")
	public String updateParkTypeView(@RequestParam("selectedCode") String code, @ModelAttribute("searchVO") ParkTypeDefaultVO searchVO, Model model) throws Exception {
		ParkTypeVO parkTypeVO = new ParkTypeVO();
		parkTypeVO.setCode(code);
		// 변수명은 CoC 에 따라 parkTypeVO
		model.addAttribute(selectParkType(parkTypeVO, searchVO));
		return "parkType/parkTypeRegister";
	}

	/**
	 * 글을 조회한다.
	 * @param parkTypeVO - 조회할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return @ModelAttribute("parkTypeVO") - 조회한 정보
	 * @exception Exception
	 */
	public ParkTypeVO selectParkType(ParkTypeVO parkTypeVO, @ModelAttribute("searchVO") ParkTypeDefaultVO searchVO) throws Exception {
		return parkTypeService.selectParkType(parkTypeVO);
	}

	/**
	 * 글을 수정한다.
	 * @param parkTypeVO - 수정할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/parkTypeList.do"
	 * @exception Exception
	 */
	@RequestMapping("/updateParkType.do")
	public String updateParkType(@ModelAttribute("searchVO") ParkTypeDefaultVO searchVO, ParkTypeVO parkTypeVO, BindingResult bindingResult, Model model, SessionStatus status)
			throws Exception {

		beanValidator.validate(parkTypeVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("parkTypeVO", parkTypeVO);
			return "parkType/parkTypeRegister";
		}

		parkTypeService.updateParkType(parkTypeVO);
		status.setComplete();
		return "forward:/parkTypeList.do";
	}

	/**
	 * 글을 삭제한다.
	 * @param parkTypeVO - 삭제할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/parkTypeList.do"
	 * @exception Exception
	 */
	@RequestMapping("/deleteParkType.do")
	public String deleteParkType(ParkTypeVO parkTypeVO, @ModelAttribute("searchVO") ParkTypeDefaultVO searchVO, SessionStatus status) throws Exception {
		parkTypeService.deleteParkType(parkTypeVO);
		status.setComplete();
		return "forward:/parkTypeList.do";
	}

}
