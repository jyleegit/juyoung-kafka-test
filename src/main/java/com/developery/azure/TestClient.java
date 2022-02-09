package com.developery.azure;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="logic", url="https://prod-29.eastus.logic.azure.com:443/workflows/92c34b205a334b21b963338e462729e5/triggers/manual/paths/invoke?api-version=2016-10-01&sp=%2Ftriggers%2Fmanual%2Frun&sv=1.0&sig=gp9-h6P7Eg3MaijomPfpjUt6jGj7o6ifuJ3Q4un3COw")
public interface TestClient {
	@PostMapping
    ResponseEntity<String> sendMailApp(@RequestBody ParaVO data);
}
