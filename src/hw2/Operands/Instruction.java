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
   private boolean isWriteOperation;

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
         case "loadm":
            operand = new LoadMemory(individualWords[2]);
            opcode = operand.getOpcode();
         default:
            System.out.println("operation not found");
      }

      this.isWriteOperation = operand.isWriteOperation();
      result = operand.action();
   }

   public int getDestination() {
      if (isWriteOperation) {
         Store sr = (Store) operand;
         String address = registerTable.getModel().getValueAt(sr.getRegisterNumberToRead(), MainDisplay.REGISTER_TABLE_VALUE).toString();
         byte parsedAddress = Byte.decode(address);
         parsedAddress += (byte) sr.getOffset();
         return parsedAddress;
      }
      return destination;
   }

   public Object getResult() {
      if (isWriteOperation) {
         if (operand.usesConstants()) { // write operation and does use constants
            result = destination;
         } else {
            String rawMemory = registerTable.getModel().getValueAt(destination, MainDisplay.REGISTER_TABLE_VALUE).toString();
            result = Integer.parseInt(rawMemory);
         }
      } else {
         if (operand.usesConstants()) {
            result = operand.action();
         } else {
            if (operand.loadsMemory()) {
               int row = (int) operand.getSource1() / memoryTable.getModel().getColumnCount();
               int col = (int) operand.getSource1() % memoryTable.getModel().getColumnCount();
               String rawMemory = memoryTable.getModel().getValueAt(row, col).toString();
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
      }
      return result;
   }

   public byte getOpcode() {
      return opcode;
   }

   public boolean getIsWriteOperation() {
      return isWriteOperation;
   }

}
