/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2.Operands;

import hw2.MainDisplay;
import hw2.RegisterLookup;
import java.util.Arrays;
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
    private int rsValue = 0;
    private int immAddress;
    private int rtValue;

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
                rsValue = (int) operand.getSource1();
                String rawMemory = registerTable.getModel().getValueAt(rsValue, MainDisplay.REGISTER_TABLE_VALUE).toString();
                operand.setSource1(Integer.parseInt(rawMemory));
                if (!operand.hasOneSource()) {
                    rtValue = (int) operand.getSource2();
                    rawMemory = registerTable.getModel().getValueAt(rtValue, MainDisplay.REGISTER_TABLE_VALUE).toString();
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

    public String byteArrayConverter(int value, int length) {
        boolean[] bits = new boolean[length];
        char[] sequence = new char[length];
        for (int i = 0; i < length; i++) {
            bits[i] = (value & (1 << i)) != 0;
            sequence[i] = bits[i] ? '1' : '0';
        }
        String result = new String(sequence);
        return result;
    }

    public String getInstructionString() {
        StringBuilder builder = new StringBuilder();
        builder.append(byteArrayConverter(opcode, 6));
        builder.append(" ");
        if (null != getInstructionType()) {
            switch (getInstructionType()) {
                case J:
                    builder.append(byteArrayConverter(immAddress, 26));
                    break;
                case R:
                    builder.append(byteArrayConverter(rsValue, 5));
                    builder.append(" ");
                    builder.append(byteArrayConverter(rtValue, 5));
                    builder.append(" ");
                    builder.append(byteArrayConverter(destination, 5));
                    builder.append(" ");
                    builder.append(String.format("%05d", 0));
                    builder.append(" ");
                    builder.append(String.format("%06d", 0));
                    break;
                case I:
                    builder.append(byteArrayConverter(destination, 5));
                    builder.append(" ");
                    builder.append(byteArrayConverter(rsValue, 5));
                    builder.append(" ");
                    builder.append(byteArrayConverter(immAddress, 16));
                    break;
                default:
                    break;
            }
        }

        return builder.toString();
    }

}
