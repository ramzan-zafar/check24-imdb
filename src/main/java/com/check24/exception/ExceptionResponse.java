package com.check24.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class ExceptionResponse {

  private String errorCode;
  
  private String errorMessage;
}
