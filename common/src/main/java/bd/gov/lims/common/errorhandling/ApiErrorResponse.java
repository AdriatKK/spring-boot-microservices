package bd.gov.lims.common.errorhandling;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApiErrorResponse {
    private HttpStatusCode httpStatus;
    private String code;
    private String message;
    private Map<String, Object> properties;
    private List<ApiFieldError> fieldErrors;
    private List<ApiGlobalError> globalErrors;
    private List<ApiParameterError> parameterErrors;

    public ApiErrorResponse(HttpStatusCode httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
        this.properties = new HashMap<>();
        this.fieldErrors = new ArrayList<>();
        this.globalErrors = new ArrayList<>();
        this.parameterErrors = new ArrayList<>();
    }

    @JsonIgnore
    public HttpStatusCode getHttpStatus() {
        return httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
    @JsonAnyGetter
    public Map<String, Object> getProperties() {
        return properties;
    }
    public List<ApiFieldError> getFieldErrors() {
        return fieldErrors;
    }
    public List<ApiGlobalError> getGlobalErrors() {
        return globalErrors;
    }
    public List<ApiParameterError> getParameterErrors() {
        return parameterErrors;
    }
    public void addErrorProperties(Map<String, Object> errorProperties) {
        properties.putAll(errorProperties);
    }
    public void addErrorProperty(String propertyName, Object propertyValue) {
        properties.put(propertyName, propertyValue);
    }
    public void addFieldError(ApiFieldError fieldError) {
        fieldErrors.add(fieldError);
    }
    public void addGlobalError(ApiGlobalError globalError) {
        globalErrors.add(globalError);
    }
    public void addParameterError(ApiParameterError parameterError) {
        parameterErrors.add(parameterError);
    }
}
