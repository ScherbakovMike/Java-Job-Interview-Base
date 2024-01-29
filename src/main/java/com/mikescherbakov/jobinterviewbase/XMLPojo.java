package com.mikescherbakov.jobinterviewbase;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class XMLPojo {

  private final String address;

  @Getter @Setter
  private Integer flatNumber;

}
