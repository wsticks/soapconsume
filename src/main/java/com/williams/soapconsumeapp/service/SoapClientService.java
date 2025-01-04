package com.williams.soapconsumeapp.service;

import com.williams.soapconsumeapp.model.request.FindByIdRequest;
import com.williams.soapconsumeapp.model.request.PingRequest;
import com.williams.soapconsumeapp.model.response.FindByIdResponse;
import com.williams.soapconsumeapp.model.response.PingResponse;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class SoapClientService {

//    @Autowired
    private final WebServiceTemplate webServiceTemplate;

    public SoapClientService(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    private static final String PING_URL = "http://www.yourwsdlservice.com/wsdl/ping";
    private static final String FIND_BY_ID_URL = "http://www.yourwsdlservice.com/wsdl/findById";

    public String ping(String message) {
        PingRequest request = new PingRequest();
        request.setMessage(message);

        try {
            PingResponse response = (PingResponse) webServiceTemplate.marshalSendAndReceive(PING_URL, request);
            return response.getResponse();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String findById(int id) {
        FindByIdRequest request = new FindByIdRequest();
        request.setId(id);

        try {
            FindByIdResponse response = (FindByIdResponse) webServiceTemplate.marshalSendAndReceive(FIND_BY_ID_URL);
            return response.getResult();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
