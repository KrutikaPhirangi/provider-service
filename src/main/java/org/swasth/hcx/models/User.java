package org.swasth.hcx.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    Map<String, Object> requestBody;
    public User(Map<String, Object> requestBody) {
        this.requestBody = requestBody;
    }
    public String name;
    public String address;
    public String mobile;
    public List<Map<String, Object>> insuranceDetails;
    public Map<String, Object> medicalHistory;

    public List<Map<String, Object>> getInsuranceDetails() {
        return (List<Map<String, Object>>) requestBody.getOrDefault("payor_details", new ArrayList<>());
    }

    public void setInsuranceDetails(List<Map<String, Object>> insuranceDetails) {
        this.insuranceDetails = insuranceDetails;
    }

    public Map<String, Object> getMedicalHistory() {
        return (Map<String, Object>) requestBody.getOrDefault("medical_history", new HashMap<>());
    }

    public void setMedicalHistory(Map<String, Object> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getName() {
        return (String) requestBody.getOrDefault("name", "");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return (String) requestBody.getOrDefault("address", "");
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return (String) requestBody.getOrDefault("mobile", "");
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
