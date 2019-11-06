/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2.Operands;

import hw2.MainDisplay;
import hw2.RegisterLookup;
import javax.swing.JTable;

/**
 *
 * @author cahn
 */
public class Instruction {

    private Operand operand;
    private int destination;
    private Object result;
    private byte opcode;
    private JTable registerTable;
    private JTable memoryTable;
    private final boolean isWriteOperation;
    private INSTRUCTION_TYPE instructionType;
    String[] rTypeNames = {"Opcode", "rs", "rt", "rd", "shamt", "funct"};
    String[] iTypeNames = {"Opcode", "rs", "rt", "IMM"};
    String[] jTypeNames = {"Opcode", "Address"};
    private int rsValue = 0;
    private int immAddress;

    public Instruction(String str, JTable registerTable, JTable memoryTable) {
        this.immAddress = 0;
        String[] individualWords = str.split(" ");
        assert (individualWords.length >= 3);

        this.registerTable = registerTable;
        this.memoryTable = memoryTable;
        assert (this.registerTable != null && this.memoryTable != null);

        destination = new RegisterLookup(individualWords[1]).getRegisterNumber();

        individualWords[0] = individualWords[0].toLowerCase();

        switch (individualWords[0]) {
            case "add":
                operand = new Add(individualWords[2], individualWords[3]);
                opcode = operand.getOpcode();
                instructionType = INSTRUCTION_TYPE.R;
                break;
            case "addr":
                operand = new AddRegisters(individualWords[2], individualWords[3]);
                opcode = operand.getOpcode();
                instructionType = INSTRUCTION_TYPE.R;
                break;
            case "load":
                operand = new Load(individualWords[2]);
                opcode = operand.getOpcode();
                instructionType = INSTRUCTION_TYPE.I;
                break;
            case "loadr":
                operand = new LoadRegister(individualWords[2]);
                opcode = operand.getOpcode();
                instructionType = INSTRUCTION_TYPE.I;
                break;
            case "stor":
                operand = new Store(individualWords[2]);
                opcode = operand.getOpcode();
                instructionType = INSTRUCTION_TYPE.I;
                break;
            case "storr":
                operand = new StoreRegister(individualWords[2]);
                opcode = operand.getOpcode();
                instructionType = INSTRUCTION_TYPE.I;
                break;
            case "loadm":
                operand = new LoadMemory(individualWords[2]);
                opcode = operand.getOpcode();
                instructionType = INSTRUCTION_TYPE.I;
                break;
            case "loadb":
                operand = new LoadByte(individualWords[2]);
                opcode = operand.getOpcode();
                instructionType = INSTRUCTION_TYPE.I;
                break;
            default:
                System.out.println("operation not found");
        }

        this.isWriteOperation = operand.isWriteOperation();
        result = operand.action();
    }

    private void setImmediateAddress(int address) {
        immAddress = address;
    }

    public int getDestination() {
        if (isWriteOperation) {
            Store sr = (Store) operand;
            rsValue = sr.getRegisterNumberToRead();
            String address = registerTable.getModel().getValueAt(sr.getRegisterNumberToRead(), MainDisplay.REGISTER_TABLE_VALUE).toString();
            int parsedAddress = Integer.parseInt(address);
            parsedAddress += sr.getOffset();
            setImmediateAddress(parsedAddress);
            return parsedAddress;
        }
        return destination;
    }

    public Object getResult() {

        if (isWriteOperation) {
            if (operand.usesConstants()) {
                result = getDestination();
            } else {
                String rawMemory = registerTable.getModel().getValueAt(destination, MainDisplay.REGISTER_TABLE_VALUE).toString();
                result = Integer.parseInt(rawMemory);
            }
            return result;
        }

        if (instructionType == INSTRUCTION_TYPE.I) {
            if (operand.loadsMemory()) {
                String rawMemory = memoryTable.getModel().getValueAt((int) operand.getSource1(), MainDisplay.MEMORY_TABLE_VALUE).toString();
                operand.setSource1(Integer.parseInt(rawMemory));
            } else {
                String rawMemory = registerTable.getModel().getValueAt((int) operand.getSource1(), MainDisplay.REGISTER_TABLE_VALUE).toString();
                operand.setSource1(Integer.parseInt(rawMemory));
                if (!operand.hasOneSource()) {
                    rawMemory = registerTable.getModel().getValueAt((int) operand.getSource2(), MainDisplay.REGISTER_TABLE_VALUE).toString();
                    operand.setSource2(Integer.parseInt(rawMemory));
                }
            }
        }
        result = operand.action();
        return result;
    }

    public byte getOpcode() {
        return opcode;
    }

    public boolean getIsWriteOperation() {
        return isWriteOperation;
    }

    public INSTRUCTION_TYPE getInstructionType() {
        return instructionType;
    }

    public String getInstructionString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s: ", rTypeNames[0]));
        builder.append(Integer.toBinaryString(opcode));
        if (null != getInstructionType()) {
            switch (getInstructionType()) {
                case J:
                    builder.append(String.format(" %s: ", jTypeNames[1]));
                    builder.append(String.format("%025d", immAddress));
                    break;
                case R:
                    builder.append(String.format(" %s: ", rTypeNames[1])); //rs
                    builder.append("\t");
                    builder.append(String.format(" %s: ", rTypeNames[2])); //rt

                    builder.append("\t");
                    builder.append(String.format(" %s: ", rTypeNames[3])); //rd
                    builder.append(String.format("%d", destination));
                    builder.append("\t");

                    builder.append(String.format(" %s: ", rTypeNames[4]));
                    builder.append("\t");
                    builder.append(String.format(" %s: ", rTypeNames[5]));
                    break;
                case I:
                    builder.append(String.format(" %s: ", iTypeNames[1])); //rs
                    builder.append(String.format("%d", destination)); //rs
                    builder.append("\t");
                    builder.append(String.format(" %s: ", iTypeNames[2]));
                    builder.append(String.format(" %05d: ", rsValue)); //rs
                    builder.append("\t");
                    builder.append(String.format(" %s: ", iTypeNames[3]));
                    builder.append(String.format("%016d", immAddress));
                    break;
                default:
                    break;
            }
        }

        return builder.toString();
    }

}
