package com.SpringBoot.SpringBoot.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class EducationVO {
    private String school;
    private String remark;
    private String education_year;
}
