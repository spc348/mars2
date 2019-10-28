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
    private int result;
    private byte opcode;
    private JTable registerTable;
    private JTable memoryTable;

    public Instruction(String str, JTable registerTable, JTable memoryTable) {
        String[] individualWords = str.split(" ");
        assert (individualWords.length >= 3);

        this.registerTable = registerTable;
        this.memoryTable = memoryTable;
        assert (this.registerTable != null && this.memoryTable != null);

        destination = new RegisterLookup(individualWords[1].substring(1)).getRegisterNumber();

        individualWords[0] = individualWords[0].toLowerCase();

        switch (individualWords[0]) {
            case "add":
                operand = new Add(individualWords[2], individualWords[3]);
                opcode = operand.getOpcode();
                break;
            case "addr":
                operand = new AddRegisters(individualWords[2], individualWords[3]);
                opcode = operand.getOpcode();
                break;
            case "load":
                operand = new Load(individualWords[2]);
                opcode = operand.getOpcode();
                break;
            case "loadr":
                operand = new LoadRegister(individualWords[2]);
                opcode = operand.getOpcode();
                break;
            case "stor":
                operand = new Store(individualWords[2]);
                opcode = operand.getOpcode();
                break;
            case "storr":
                operand = new StoreRegister(individualWords[2]);
                opcode = operand.getOpcode();
                break;
            default:
                System.out.println("operation not found");
        }

        result = operand.action();
    }

    public int getDestination() {
        return destination;
    }

    public int getResult() {

        if (operand.isWriteOperation()) {
            Store sr = (Store) operand;
            String address = registerTable.getModel().getValueAt(sr.getRegisterNumberToRead(), MainDisplay.REGISTER_TABLE_VALUE).toString();
            byte parsedAddress = Byte.parseByte(address);
            parsedAddress += (byte) (sr.getOffset() & 0xFF);
            int row = ((int) parsedAddress) / memoryTable.getModel().getRowCount();
            int col = ((int) parsedAddress) % memoryTable.getModel().getColumnCount();

            int valueToInsert = 0;
            if (!operand.usesConstants()) {
                String rawMemory = registerTable.getModel().getValueAt(destination, MainDisplay.REGISTER_TABLE_VALUE).toString();
                valueToInsert = Integer.parseInt(rawMemory);
            } else {
                destination = valueToInsert;
            }
            memoryTable.getModel().setValueAt(valueToInsert, row, col);
        } else {
            if (!operand.usesConstants()) {
                String rawMemory = registerTable.getModel().getValueAt(operand.getSource1(), MainDisplay.REGISTER_TABLE_VALUE).toString();
                operand.setSource1(Integer.parseInt(rawMemory));
                if (!operand.hasOneSource()) {
                    rawMemory = registerTable.getModel().getValueAt(operand.getSource2(), MainDisplay.REGISTER_TABLE_VALUE).toString();
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

}
