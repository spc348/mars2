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

      destination = new RegisterLookup(individualWords[1].substring(1)).getRegisterNumber();

      individualWords[0] = individualWords[0].toLowerCase();

      switch (individualWords[0]) {
         case "add":
            operand = new Add(individualWords[2],individualWords[3]);
            opcode = operand.getOpcode();
            break;
         case "addr":
            operand = new AddRegisters(individualWords[2],individualWords[3]);
            opcode = operand.getOpcode();
            break;
         case "load":
            operand = new Load(individualWords[2]);
            opcode = operand.getOpcode();
            break;
         case "loadr":
            operand = new Load(individualWords[2]);
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
      if (!operand.usesConstants()) {
         operand.setSource1((int) registerTable.getModel().getValueAt(MainDisplay.REGISTER_TABLE_VALUE, source1));
         operand.setSource2((int) registerTable.getModel().getValueAt(MainDisplay.REGISTER_TABLE_VALUE, source2));
         result = operand.action();
      }
      return result;
   }

   public byte getOpcode() {
      return opcode;
   }

}
