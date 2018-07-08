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
package egovframework.example.park.web;

import java.util.List;

import egovframework.example.park.service.ParkDefaultVO;
import egovframework.example.park.service.ParkService;
import egovframework.example.park.service.ParkVO;
import egovframework.example.parkType.service.ParkTypeDefaultVO;
import egovframework.example.parkType.service.ParkTypeService;
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
public class ParkController {

	/** ParkService */
	@Resource(name = "parkService")
	private ParkService parkService;
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
	 * @param searchVO - 조회할 정보가 담긴 ParkDefaultVO
	 * @param model
	 * @return "parkList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/parkList.do")
	public String selectParkList(@ModelAttribute("searchVO") ParkDefaultVO searchVO, ModelMap model) throws Exception {

		/** EgovPropertyService.park */
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

		List<?> parkList = parkService.selectParkList(searchVO);
		model.addAttribute("resultList", parkList);

		int totCnt = parkService.selectParkListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "park/parkList";
	}

	/**
	 * 글 등록 화면을 조회한다.
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param model
	 * @return "parkRegister"
	 * @exception Exception
	 */
	@RequestMapping(value = "/addPark.do", method = RequestMethod.GET)
	public String addParkView(@ModelAttribute("searchVO") ParkDefaultVO searchVO, Model model) throws Exception {
		
		List<?> listParkType = parkTypeService.selectParkTypeList(new ParkTypeDefaultVO());
		model.addAttribute("listParkType", listParkType);

		model.addAttribute("parkVO", new ParkVO());

		return "park/parkRegister";
	}

	/**
	 * 글을 등록한다.
	 * @param parkVO - 등록할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/parkList.do"
	 * @exception Exception
	 */
	@RequestMapping(value = "/addPark.do", method = RequestMethod.POST)
	public String addPark(@ModelAttribute("searchVO") ParkDefaultVO searchVO, ParkVO parkVO, BindingResult bindingResult, Model model, SessionStatus status)
			throws Exception {

		// Server-Side Validation
		beanValidator.validate(parkVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("parkVO", parkVO);
			return "park/parkRegister";
		}

		parkService.insertPark(parkVO);
		status.setComplete();
		return "forward:/parkList.do";
	}

	/**
	 * 글 수정화면을 조회한다.
	 * @param id - 수정할 글 id
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param model
	 * @return "parkRegister"
	 * @exception Exception
	 */
	@RequestMapping("/updateParkView.do")
	public String updateParkView(@RequestParam("selectedId") Integer id, @ModelAttribute("searchVO") ParkDefaultVO searchVO, Model model) throws Exception {
		ParkVO parkVO = new ParkVO();
		parkVO.setId(id);
		// 변수명은 CoC 에 따라 parkVO
		model.addAttribute(selectPark(parkVO, searchVO));

		List<?> listParkType = parkTypeService.selectParkTypeList(new ParkTypeDefaultVO());
		model.addAttribute("listParkType", listParkType);
		
		return "park/parkRegister";
	}

	/**
	 * 글을 조회한다.
	 * @param parkVO - 조회할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return @ModelAttribute("parkVO") - 조회한 정보
	 * @exception Exception
	 */
	public ParkVO selectPark(ParkVO parkVO, @ModelAttribute("searchVO") ParkDefaultVO searchVO) throws Exception {
		return parkService.selectPark(parkVO);
	}

	/**
	 * 글을 수정한다.
	 * @param parkVO - 수정할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/parkList.do"
	 * @exception Exception
	 */
	@RequestMapping("/updatePark.do")
	public String updatePark(@ModelAttribute("searchVO") ParkDefaultVO searchVO, ParkVO parkVO, BindingResult bindingResult, Model model, SessionStatus status)
			throws Exception {

		beanValidator.validate(parkVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("parkVO", parkVO);
			return "park/parkRegister";
		}

		parkService.updatePark(parkVO);
		status.setComplete();
		return "forward:/parkList.do";
	}

	/**
	 * 글을 삭제한다.
	 * @param parkVO - 삭제할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/parkList.do"
	 * @exception Exception
	 */
	@RequestMapping("/deletePark.do")
	public String deletePark(ParkVO parkVO, @ModelAttribute("searchVO") ParkDefaultVO searchVO, SessionStatus status) throws Exception {
		parkService.deletePark(parkVO);
		status.setComplete();
		return "forward:/parkList.do";
	}

}
