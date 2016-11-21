package by.dorosinec.traning.miniframework.Command;


import java.util.ArrayList;

/**
 *
 */
public class InstructionBuilder {
    ArrayList<InstructionImplementation> instructionBuild;

    public InstructionBuilder() {
        instructionBuild = new ArrayList<>();
        instructionBuild.add(new InstructionOpen());
        instructionBuild.add(new InstructionCheckLinkPresentByHref());
        instructionBuild.add(new InstructionCheckLinkPresentByName());
        instructionBuild.add(new InstructionCheckPageContains());
        instructionBuild.add(new InstructionCheckPageTitle());
    }

    public ArrayList<InstructionImplementation> getInstructionBuild() {
        return instructionBuild;
    }
}
