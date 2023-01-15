package br.com.enay.zuin.spring.jpa.filter.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterCriteria {
  private String key;
  private Object equal;
  private String min;
  private String max;
  private Object like;
}
