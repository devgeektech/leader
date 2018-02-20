package com.leadercoach.rest.services.convert;

import com.leadercoach.rest.services.entity.LTIndicatorsEntity;
import com.leadertype.rest.dao.entity.LTIndicators;

public class LTIndicatorsToEntity {

	public static LTIndicatorsEntity convert(LTIndicators ltIndicator) {
		LTIndicatorsEntity ltIndicatorsEntity = new LTIndicatorsEntity();
		ltIndicatorsEntity.setIndicatorId(ltIndicator.getIndicatorId());
		ltIndicatorsEntity.setColorCode(ltIndicator.getColorCode());
		ltIndicatorsEntity.setTitle(ltIndicator.getTitle());
		ltIndicatorsEntity.setName(ltIndicator.getName());
		ltIndicatorsEntity.setAssessmentCode(ltIndicator.getAssessmentCode());
		ltIndicatorsEntity.setWithLeaderImageId(ltIndicator.getWithLeaderImageId());
		ltIndicatorsEntity.setWithoutLeaderImageId(ltIndicator.getWithoutLeaderImageId());
		ltIndicatorsEntity.setDefaultImageId(ltIndicator.getDefaultImageId());
		ltIndicatorsEntity.setBrand(ltIndicator.getBrand());
		ltIndicatorsEntity.setQuote(ltIndicator.getQuote());
		ltIndicatorsEntity.setValues(ltIndicator.getValues());
		ltIndicatorsEntity.setStrengths(ltIndicator.getStrengths());
		ltIndicatorsEntity.setDevelopmentAreas(ltIndicator.getDevelopmentAreas());
		return ltIndicatorsEntity;
	}
}
