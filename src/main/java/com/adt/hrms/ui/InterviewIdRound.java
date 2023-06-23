package com.adt.hrms.ui;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InterviewIdRound implements Serializable {

	private Integer interviewId;

	private Integer rounds;

}
