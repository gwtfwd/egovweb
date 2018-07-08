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
package egovframework.example.park.service.impl;

import java.util.List;

import egovframework.example.park.service.ParkDefaultVO;
import egovframework.example.park.service.ParkService;
import egovframework.example.park.service.ParkVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Class Name : EgovParkServiceImpl.java
 * @Description : Park Business Implement Class
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

@Service("parkService")
public class ParkServiceImpl extends EgovAbstractServiceImpl implements ParkService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParkServiceImpl.class);

	/** ParkDAO */
	// TODO ibatis 사용
	@Resource(name = "parkDAO")
	private ParkDAO parkDAO;
	// TODO mybatis 사용
	//  @Resource(name="parkMapper")
	//	private ParkMapper parkDAO;

	/** ID Generation */
	@Resource(name = "parkCodeGnrService")
	private EgovIdGnrService parkCodeGnrService;

	/**
	 * 글을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ParkVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Override
	public String insertPark(ParkVO vo) throws Exception {
		LOGGER.debug(vo.toString());

		/** ID Generation Service */
/*		String code = parkCodeGnrService.getNextStringId();
		vo.setCode(code);
		LOGGER.debug(vo.toString());
*/
		return parkDAO.insertPark(vo);
	}

	/**
	 * 글을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ParkVO
	 * @return void형
	 * @exception Exception
	 */
	@Override
	public void updatePark(ParkVO vo) throws Exception {
		parkDAO.updatePark(vo);
	}

	/**
	 * 글을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ParkVO
	 * @return void형
	 * @exception Exception
	 */
	@Override
	public void deletePark(ParkVO vo) throws Exception {
		parkDAO.deletePark(vo);
	}

	/**
	 * 글을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ParkVO
	 * @return 조회한 글
	 * @exception Exception
	 */
	@Override
	public ParkVO selectPark(ParkVO vo) throws Exception {
		ParkVO resultVO = parkDAO.selectPark(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

	/**
	 * 글 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 글 목록
	 * @exception Exception
	 */
	@Override
	public List<?> selectParkList(ParkDefaultVO searchVO) throws Exception {
		return parkDAO.selectParkList(searchVO);
	}

	/**
	 * 글 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 글 총 갯수
	 * @exception
	 */
	@Override
	public int selectParkListTotCnt(ParkDefaultVO searchVO) {
		return parkDAO.selectParkListTotCnt(searchVO);
	}

}
