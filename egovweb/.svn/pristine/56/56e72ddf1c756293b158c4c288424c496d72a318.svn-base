package egovframework.example.green.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.example.green.service.GreenService;
import egovframework.example.sample.service.EgovSampleService;
import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.example.sample.service.impl.EgovSampleServiceImpl;
import egovframework.example.sample.service.impl.SampleDAO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

@Service("greenService")
public class GreenServiceImpl extends EgovAbstractServiceImpl implements GreenService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GreenServiceImpl.class);

	@Resource(name = "greenDAO")
	private GreenDAO greenDAO;

	@Resource(name = "egovIdGnrService")
	private EgovIdGnrService egovIdGnrService;

	
	
	
	
	@Override
	public List<?> greenList(SampleDefaultVO searchVO) throws Exception {
		return greenDAO.greenList(searchVO);
	}

	@Override
	public int greenListTotCnt(SampleDefaultVO searchVO) {
		return greenDAO.greenListTotCnt(searchVO);
	}
	
	
	
}
