package com.mikescherbakov.jobinterviewbase.performance.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@JsonSerialize(as = BeanApplication.class)
public class BeanApplication extends CommonProperties {

}
