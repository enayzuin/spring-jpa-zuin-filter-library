package br.com.enay.zuin.spring.jpa.filter.responses.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@JsonInclude(Include.ALWAYS)
public class ResponseDTO<Z> {

  private String message;
  private List<Z> content;

  public ResponseDTO(String message) {
    this.message = message;
  }
}
