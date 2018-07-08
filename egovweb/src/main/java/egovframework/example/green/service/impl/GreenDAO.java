package egovframework.example.green.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("greenDAO")
public class GreenDAO extends EgovAbstractDAO {
	
	
	public List<?> greenList(SampleDefaultVO searchVO) throws Exception {
		return list("greenDAO.greenList", searchVO);
	}
	public int greenListTotCnt(SampleDefaultVO searchVO) {
		return (Integer) select("greenDAO.greenListTotCnt", searchVO);
	}

}
