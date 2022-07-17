package edu.aluismarte.diplomado.project.week10;

import edu.aluismarte.diplomado.model.project.DemoResponse;
import edu.aluismarte.diplomado.project.week10.command.CommandEvent;
import edu.aluismarte.diplomado.project.week11.saga.model.SagaPayload;
import edu.aluismarte.diplomado.project.week11.saga.model.SagaStep;
import edu.aluismarte.diplomado.project.week11.saga.model.SagaStepCompensator;
import edu.aluismarte.diplomado.project.week11.saga.model.SagaStepHandler;

@CommandEvent
public class SagaDemoStep1 implements SagaStep<DemoResponse> {

    @Override
    public String getName() {
        return "Saga Step 1";
    }

    @Override
    public SagaStepHandler<DemoResponse> getHandler() {
        return new SagaStepHandler<DemoResponse>() {
            @Override
            public void handle(SagaPayload<DemoResponse> sagaPayload) {
                // Create object or something
            }
        };
    }

    @Override
    public SagaStepCompensator<DemoResponse> getCompensator() {
        return new SagaStepCompensator<DemoResponse>() {
            @Override
            public void handle(SagaPayload<DemoResponse> sagaPayload) {
                // delete objects created
            }
        };
    }
}
