package org.dragonpulse.rnd.progress.repository.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;
import java.io.Serializable;


@Getter
@Setter
@ApiModel(description = "Person Object.")
public class Person implements Serializable {
    @ApiModelProperty(value = "Person Name")
    private String name;

    @ApiModelProperty(value = "Age")
    private String age;


    @ApiModelProperty(value = "Phone Number")
    private String phoneNumber;


    @Transient
    private String requestId;

}

