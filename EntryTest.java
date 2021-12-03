package Calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * These are several tests in Junit that test the Entry class methods and constructors.
 * 
 * @author Alin Mican ID:100947751
 *
 */

class EntryTest {

  private Entry Test_Float;
  private Entry Test_String;
  private Entry Test_Symbol;


  /**
   * Testing the constructor for float value by passing a float value.
   */
  @Test
  void testEntryFloat() {
    Test_Float = new Entry(64.9235f);
  }

  /**
   * Testing the constructor for symbol by passing a symbol entry.
   */
  @Test
  void testEntrySymbol() {
    Test_Symbol = new Entry(Symbol.MINUS);

  }

  /**
   * Testing the constructor for string by passing a string entry.
   */
  void testEntryString() {
    Test_String = new Entry("This is a string");
  }

  /**
   * Testing that the method getType returns a type enum.
   */
  @Test
  void testGetType() {
    assertEquals("INVALID", Type.INVALID.name());
  }

  /**
   * Checking that the getString method returns a string.
   * 
   * @throws BadType Throws a custom badType exception if the entry is not that of a string.
   */
  @Test
  void testGetString() throws BadType {
    Test_String = new Entry("pass");
    assertEquals(Test_String.getString(), "pass");
    assertNotSame(Test_String.getString(), "notpass");


  }

  /**
   * Testing the badType exception by entering multiple wrong entries.
   * 
   * @throws BadType Throws a badType exception since the inputs are incorrect.
   */
  @Test
  void testWrongInputString() throws BadType {
    Test_String = new Entry(22.1233443f);
    assertThrows(BadType.class, () -> Test_String.getString(), "bad input");
    Entry Test_String1 = new Entry(Symbol.INVALID);
    assertThrows(BadType.class, () -> Test_String1.getString(), "another bad input");
  }

  /**
   * Testing that the getSymbol method returns a Symbol entry.
   * 
   * @throws BadType Throws a badType in case the entries are not that of a symbol.
   */
  @Test
  void testGetSymbol() throws BadType {
    Test_Symbol = new Entry(Symbol.LEFT_BRACKET);
    assertEquals(Test_Symbol.getSymbol(), Symbol.LEFT_BRACKET, "Testing the symbols are the same.");
    assertNotSame(Test_Symbol.getSymbol(), Symbol.RIGHT_BRACKET,
        "Testing the symbols are not the same.");

  }

  /**
   * Testing the badtype exception by adding incorrect values.
   * 
   * @throws BadType This throws a badType as inputs are incorrect.
   */
  @Test
  void testWrongInputSymbol() throws BadType {
    Test_Symbol = new Entry("INVALID");
    assertThrows(BadType.class, () -> Test_Symbol.getSymbol(), "bad input");
  }


  /**
   * Testing that the getValue method returns a float value.
   * 
   * @throws BadType throws badType exception in case the input is wrong.
   */
  @Test
  void testGetValue() throws BadType {
    Test_Float = new Entry(123.45f);
    assertEquals(Test_Float.getValue(), 123.45f, "Testing the values are the same.");
    assertNotSame(Test_Float.getValue(), 123.456f, "Testing the values are not the same.");

  }

  /**
   * This tests the badType exception by adding incorrect entries.
   * 
   * @throws BadType This will throw a badType exception as the inputs are incorrect.
   */
  @Test
  void testWrongInputValue() throws BadType {
    Test_Float = new Entry("hi");
    assertThrows(BadType.class, () -> Test_Float.getValue(), "bad input");
  }

}
