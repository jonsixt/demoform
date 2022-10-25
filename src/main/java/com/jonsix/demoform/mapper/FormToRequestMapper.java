package com.jonsix.demoform.mapper;

import com.jonsix.demoform.data.SavedRequest;
import com.jonsix.demoform.form.DemoForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "SPRING")
public interface FormToRequestMapper {
    @Mapping(target = "created", expression = "java(new java.util.Date())" )
    SavedRequest toSavedRequest(DemoForm form);
}
