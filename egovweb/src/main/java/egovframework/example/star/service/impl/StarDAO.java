package egovframework.example.star.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.example.sample.service.SampleVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("starDAO")
public class StarDAO extends EgovAbstractDAO {

	/**
	 * 글을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SampleVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertStar(SampleVO vo) throws Exception {
		return (String) insert("starDAO.insertStar", vo);
	}

	/**
	 * 글을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateStar(SampleVO vo) throws Exception {
		update("starDAO.updateStar", vo);
	}

	/**
	 * 글을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteStar(SampleVO vo) throws Exception {
		delete("starDAO.deleteStar", vo);
	}

	/**
	 * 글을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SampleVO
	 * @return 조회한 글
	 * @exception Exception
	 */
	public SampleVO selectStar(SampleVO vo) throws Exception {
		return (SampleVO) select("starDAO.selectStar", vo);
	}

	/**
	 * 글 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return 글 목록
	 * @exception Exception
	 */
	public List<?> selectStarList(SampleDefaultVO searchVO) throws Exception {
		return list("starDAO.selectStarList", searchVO);
	}

	/**
	 * 글 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return 글 총 갯수
	 * @exception
	 */
	public int selectStarListTotCnt(SampleDefaultVO searchVO) {
		return (Integer) select("starDAO.selectStarListTotCnt", searchVO);
	}

}
