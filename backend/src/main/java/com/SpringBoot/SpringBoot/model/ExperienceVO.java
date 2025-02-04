package com.SpringBoot.SpringBoot.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class ExperienceVO {
    private String company;
    private int experience_year;
}
