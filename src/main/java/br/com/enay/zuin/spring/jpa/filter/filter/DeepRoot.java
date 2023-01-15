package br.com.enay.zuin.spring.jpa.filter.filter;

import javax.persistence.criteria.Path;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeepRoot {
  private Path<Object> path;
  private String lastKey;
}
