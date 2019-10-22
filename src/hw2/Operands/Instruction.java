/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2.Operands;

import hw2.MainDisplay;
import javax.swing.JTable;

/**
 *
 * @author cahn
 */
public class Instruction {

    private Operand operand;
    private int source1;
    private int source2;
    private int destination;
    private int result;
    private byte opcode;
    private JTable registerTable;
    private JTable memoryTable;
    private boolean oneSource;

    public Instruction(String str, JTable registerTable, JTable memoryTable) {
        String[] individualWords = str.split(" ");
        assert (individualWords.length >= 3);

        destination = Integer.parseInt(individualWords[1]);

        individualWords[0] = individualWords[0].toLowerCase();
        switch (individualWords[0]) {
            case "add":
                operand = new Add(source1, source2);
                opcode = operand.getOpcode();
                break;
            case "addr":
                operand = new AddRegisters(source1, source2);
                opcode = operand.getOpcode();
                break;
            case "load":
                operand = new Load(source1);
                opcode = operand.getOpcode();
                break;
            default:
                System.out.println("operation not found");
        }

        source1 = Integer.parseInt(individualWords[2]);
        if (!operand.oneSource()) {
            source2 = Integer.parseInt(individualWords[3]);
        }

        result = operand.action();
    }

    public int getDestination() {
        return destination;
    }

    public int getResult() {
        if (!operand.usesConstants()) {
            source1 = (int) registerTable.getModel().getValueAt(MainDisplay.REGISTER_TABLE_VALUE, source1);
            source2 = (int) registerTable.getModel().getValueAt(MainDisplay.REGISTER_TABLE_VALUE, source2);
            result = operand.action();
        }
        return result;
    }

    public byte getOpcode() {
        return opcode;
    }

}
