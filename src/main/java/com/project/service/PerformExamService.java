package com.project.service;

import java.util.List;

import com.project.dto.ExamDTO;

public interface PerformExamService {

	public int verifyAndInsertResult(List<ExamDTO> examDTOs);

}
