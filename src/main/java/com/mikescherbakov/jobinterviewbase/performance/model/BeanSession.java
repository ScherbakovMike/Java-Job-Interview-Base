package com.mikescherbakov.jobinterviewbase.performance.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@JsonSerialize(as = BeanSession.class)
public class BeanSession extends CommonProperties {

}
