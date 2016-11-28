package by.dorosinec.traning.miniframework.Command;

import by.dorosinec.traning.miniframework.Instruction;

import java.math.BigDecimal;

/**
 *
 */
public class InstructionFinal {
    private boolean canExecution;
    private Instruction instruction;
    private BigDecimal finalTime;
    private BigDecimal totalTime;

    public InstructionFinal(boolean canExecution, Instruction instruction , BigDecimal finalTime) {
        this.canExecution = canExecution;
        this.instruction = instruction;
        this.finalTime = finalTime;
    }

    public InstructionFinal() {

    }
    public boolean isCanExecution() {
        return canExecution;
    }

    public Instruction getInstruct() {
        return instruction;
    }

    public BigDecimal getFinalTime() {
        return finalTime;
    }
}
