package com.jonsix.demoform;

import com.jonsix.demoform.data.RequestType;
import com.jonsix.demoform.data.RequestTypeRepository;
import com.jonsix.demoform.data.SavedRequest;
import com.jonsix.demoform.form.RequestForm;
import com.jonsix.demoform.data.SavedRequestRepository;
import com.jonsix.demoform.mapper.FormToRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DemoFormController {

    @Autowired
    private SavedRequestRepository savedRequestRepository;

    @Autowired
    private RequestTypeRepository requestTypeRepository;

    @Autowired
    private FormToRequestMapper mapper;

    @GetMapping("/form")
    public String formRender(Model model) {
        populateRequestTypes(model);
        model.addAttribute("requestForm", new RequestForm());
        return "requestFormPage";
    }

    private void populateRequestTypes(Model model) {
        List<String> requestTypes = requestTypeRepository.findAll()
                .stream().map(RequestType::getRequestType).collect(Collectors.toList());
        model.addAttribute("requestTypes", requestTypes);
    }

    @PostMapping("/form")
    public String formSubmit(@Valid @ModelAttribute RequestForm requestForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            populateRequestTypes(model);
            return "requestFormPage";
        }
        SavedRequest savedRequest = savedRequestRepository.save(mapper.toSavedRequest(requestForm));
        model.addAttribute("savedRequests", Collections.singletonList(savedRequest));
        return "thankYouPage";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<SavedRequest> savedRequests = savedRequestRepository.findTop10ByCreatedNotNullOrderByCreatedDesc();
        model.addAttribute("savedRequests", savedRequests);
        return "listPage";
    }


}
