package egovframework.example.green.service;

import java.util.List;

import egovframework.example.sample.service.SampleDefaultVO;

public interface GreenService {

	List<?> greenList(SampleDefaultVO searchVO) throws Exception;
	int greenListTotCnt(SampleDefaultVO searchVO);

}
