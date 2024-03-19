package org.swasth.hcx.v1.controllers;

import io.hcxprotocol.utils.Operations;
import kong.unirest.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.swasth.hcx.exception.ClientException;
import org.swasth.hcx.service.ProviderService;
import org.swasth.hcx.utils.Constants;
import org.swasth.hcx.v1.BaseController;

import java.util.Map;

import static org.swasth.hcx.utils.Constants.*;

@RestController
@RequestMapping(Constants.VERSION_PREFIX)
public class ProviderController extends BaseController {

    @Autowired
    private ProviderService providerService;

    @PostMapping(COVERAGE_ELIGIBILITY_CHECK)
    public ResponseEntity<Object> createCoverageEligibility(@RequestHeader HttpHeaders headers, @RequestBody Map<String, Object> requestBody) throws Exception {
        return providerService.createCoverageEligibilityRequest(requestBody, Operations.COVERAGE_ELIGIBILITY_CHECK);
    }

    @PostMapping(CLAIM_SUBMIT)
    public ResponseEntity<Object> createClaimSubmit(@RequestBody Map<String, Object> requestBody) {
        return providerService.createClaimRequest(requestBody, Operations.CLAIM_SUBMIT);
    }

    @PostMapping(PRE_AUTH_SUBMIT)
    public ResponseEntity<Object> createPreAuthSubmit(@RequestBody Map<String, Object> requestBody) {
        return providerService.createClaimRequest(requestBody, Operations.PRE_AUTH_SUBMIT);
    }

    @PostMapping(COVERAGE_ELIGIBILITY_ONCHECK)
    public ResponseEntity<Object> coverageEligibilityOnCheck(@RequestBody Map<String, Object> requestBody) {
        return processAndValidateRequest(requestBody, Constants.COVERAGE_ELIGIBILITY_CHECK, Constants.COVERAGE_ELIGIBILITY_ONCHECK);
    }

    @PostMapping(CLAIM_ONSUBMIT)
    public ResponseEntity<Object> claimOnSubmit(@RequestBody Map<String, Object> requestBody) {
        return processAndValidateRequest(requestBody, CLAIM_SUBMIT, CLAIM_ONSUBMIT);
    }

    @PostMapping(PRE_AUTH_ONSUBMIT)
    public ResponseEntity<Object> preAuthOnSubmit(@RequestBody Map<String, Object> requestBody) {
        return processAndValidateRequest(requestBody, PRE_AUTH_SUBMIT, PRE_AUTH_ONSUBMIT);
    }

//    @PostMapping(REQUEST_LIST)
//    public ResponseEntity<Object> requestList(@RequestBody Map<String, Object> requestBody) {
//        try {
//            if (requestBody.containsKey("mobile")) {
//                return beneficiaryService.getRequestListFromDatabase(requestBody);
//            } else if (requestBody.containsKey("workflow_id")) {
//                return beneficiaryService.getDataFromWorkflowId(requestBody);
//            } else if (requestBody.containsKey("sender_code")) {
//                return beneficiaryService.getRequestListFromSenderCode(requestBody);
//            } else {
//                throw new ClientException("Please provide valid request body");
//            }
//        } catch (Exception ex) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + ex.getMessage());
//        }
//    }
}
