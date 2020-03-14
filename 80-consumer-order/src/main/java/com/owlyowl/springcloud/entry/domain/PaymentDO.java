package com.owlyowl.springcloud.entry.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDO {

    private Long id;
    private String serial;
}
