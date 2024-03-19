package org.swasth.hcx.v1.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.swasth.hcx.utils.Constants;
import org.swasth.hcx.v1.BaseController;

import java.util.Map;

@RestController
@RequestMapping(value = "/"+ "${hcx_application.api_version}" +"/claim")
public class ClaimController extends BaseController {

    @RequestMapping(value = "/on_submit", method = RequestMethod.POST)
    public ResponseEntity<Object> claimOnSubmit(@RequestBody Map<String, Object> requestBody) throws Exception {
        return processAndValidateRequest(requestBody, Constants.CLAIM_SUBMIT,Constants.CLAIM_ONSUBMIT, "");
    }
}
