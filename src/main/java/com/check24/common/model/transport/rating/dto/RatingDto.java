package com.check24.common.model.transport.rating.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Validated
@ApiModel(value = "Rating")
public class RatingDto {

	@NotNull(message = "Please enter filmId")
	private Long filmId;

	@NotNull(message = "Please enter rating")
	@Range(min=1, max=5)
	private Integer rating;
}
