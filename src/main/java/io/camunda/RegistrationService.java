package io.camunda;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.common.exception.ZeebeBpmnError;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RegistrationService {

    @JobWorker(type = "registration-service")
    public void handleJobFoo(final ActivatedJob job) {
        // do whatever you need to do
        String guest = (String) job.getVariable("guest");

        if ("Zee".equals(guest)) {
            throw new ZeebeBpmnError("ERR_01", "Backpressure. No more rooms available.", Map.of());
        }

        if ("Activity".equals(guest)) {
            throw new ZeebeBpmnError("ERR_02", "Optimistic-lock-exception. Too many concurrent requests.", Map.of());
        }

        if ("Appian".equals(guest)) {
            throw new ZeebeBpmnError("ERR_03", "Suspicious guest.", Map.of());
        }

        if (guest != null && !guest.isBlank()) {
            throw new ZeebeBpmnError("ERR_04", "VIP guest.", Map.of());
        }

    }

}
