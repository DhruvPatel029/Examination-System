package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ExamDAO;
import com.project.dao.PerformExamDAO;
import com.project.dto.ExamDTO;
import com.project.model.ExamVO;
import com.project.model.ResultVO;
import com.project.model.StreamTypeVO;
import com.project.utils.Basemethods;

@Service
@Transactional
public class PerformExamServiceImpl implements PerformExamService {

	@Autowired
	private PerformExamDAO perfoemExamDao;

	@Autowired
	private ExamDAO examDAO;

	@Autowired
	private LoginService loginService;

	public int verifyAndInsertResult(List<ExamDTO> examDTOs) {
		int streamType = examDTOs.get(0).getStreamType();

		List<ExamVO> examDetail = examDAO.searchCorrectOptionandQuestionByStreamId(streamType);
		ResultVO resultVO = new ResultVO();

		int count = 0;
		for (int i = 0, j = 0; i < examDetail.size(); i++) {
			if (examDTOs.get(j).getQuestionId() == examDetail.get(i).getId()
					&& examDTOs.get(j).getOptionSelected().equals(examDetail.get(i).getCorrectOption())) {
				count++;
				j++;
			}
		}
		StreamTypeVO svo = new StreamTypeVO();
		svo.setId(streamType);

		resultVO.setMarksObtained(count);
		resultVO.setTotalMarks(examDetail.size());
		resultVO.setStreamTypeVO(svo);
		resultVO.setLoginVO(this.loginService.searchLoginID(Basemethods.getUser()).get(0));

		this.perfoemExamDao.insertResult(resultVO);

		return count;
	}
}
