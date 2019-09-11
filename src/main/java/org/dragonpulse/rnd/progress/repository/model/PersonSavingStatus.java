package org.dragonpulse.rnd.progress.repository.model;

import org.dragonpulse.rnd.progress.constants.AppConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import java.io.Serializable;
import java.util.Objects;

@KeySpace(AppConstants.PERSON_SAVING_STATUS_MAP)
public class PersonSavingStatus implements Serializable {

    @Id
    private String requestId;

    private String status;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public PersonSavingStatus() {
    }

    public PersonSavingStatus(String requestId, String status) {
        this.requestId = requestId;
        this.status = status;
    }

    @Override
    public String toString() {
        return "PersonSavingStatus{" +
                "requestId='" + requestId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonSavingStatus)) return false;
        PersonSavingStatus that = (PersonSavingStatus) o;
        return Objects.equals(getRequestId(), that.getRequestId()) &&
                Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRequestId(), getStatus());
    }
}
