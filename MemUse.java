import java.util.HashMap;


public class MemUse{
  
  private HashMap<String,MinSize> dictionary;
  
  private String _this = "s%.*/%%";
  private String usage = "\n"+
    "$THIS [ parameters ]\n"+
"\n"+
"   This script analyzes the output (IAR .map, NCC .lst, GCC .map) that is\n"+
"    generated during a successful build of an application and prints out the\n"+
"    CODE, ROM and RAM sizes.\n"+
"\n"+
"  PARAMETERS\n"+
"\n"+
"  -i, --input <map-or-list-file>\n"+
"    This parameter specifies the file to parse and extract information from.\n"+
"\n"+
"  -p, --previous <map-or-list-file>\n"+
"    Compare this file to the one specified by the input parameter.\n"+
"    For each value shown for the input file, the change from this previous file\n"+
"    will also be shown.\n"+
"\n"+
"  -c, --csv <output-file>\n"+
"    This specifies that a CSV file should be generated and written to the\n"+
"    output-file location.\n"+
"\n"+
"  --all\n"+
"    Print out detailed information about CODE, ROM and RAM sizes.  This option\n"+
"    is implied if none of the options below are specified.\n"+
"\n"+
"  --code [ <min-size> ]\n"+
"    Print out CODE sizes.  Additionally, a number may be specified to indicate\n"+
"    the minimum CODE size to show details for.  The default is $minSize{CODE}{entry}.\n"+
"\n"+
"  --rom [ <min-size> ]\n"+
"    Print out ROM sizes.  Additionally, a number may be specified to indicate\n"+
"    the minimum ROM size to show details for.  The default is $minSize{ROM}{entry}.\n"+
"\n"+
"  --ram [ <min-size> ]\n"+
"    Print out RAM sizes.  Additionally, a number may be specified to indicate\n"+
"    the minimum RAM size to show details for.  The default is $minSize{RAM}{entry}.\n"+
"\n"+
"  --summary\n"+
"    Print out summary information only.\n"+
"\n"+
"  EXAMPLES:\n"+
"\n"+
"    $THIS -i build/sink-host-avr-atmega-32-em250-dev0470/sink-host.bin.map\n"+
"    $THIS -i build/em260-xap2b-em260-em250-dev0470-null_btl-debug/em260.lst";
  
      
  public MemUse(String[] args){
    this.setupDictionary();
  }
  
  private void setupDictionary(){
    dictionary.put("?FILL1",MinSize.CODE);
    dictionary.put("CODE",MinSize.CODE);
    dictionary.put("CODE_ID",MinSize.CODE);
    dictionary.put("INTVEC",MinSize.CODE);
    dictionary.put("SWITCH",MinSize.CODE);
    dictionary.put("STKINF_CODE",MinSize.CODE);
    dictionary.put("BTLINF_CODE",MinSize.CODE);
    dictionary.put(".text",MinSize.CODE);
    
    dictionary.put("APPINF",MinSize.ROM);
    dictionary.put("CONST",MinSize.ROM);
    dictionary.put("CONSTB",MinSize.ROM);
    dictionary.put("CONSTW",MinSize.ROM);
    dictionary.put("CONST_CODE",MinSize.ROM);
    dictionary.put("CONST_RESERVED",MinSize.ROM);
    dictionary.put("DATA_C",MinSize.ROM);
    dictionary.put("DATA_ID",MinSize.ROM);
    dictionary.put("NEAR_F",MinSize.ROM);
    dictionary.put("FAR_F",MinSize.ROM);
    dictionary.put("INITC",MinSize.ROM);
    dictionary.put("INITCB",MinSize.ROM);
    dictionary.put("INITCW",MinSize.ROM);
    dictionary.put("INITTAB",MinSize.ROM);
    dictionary.put("NEAR_ID",MinSize.ROM);
    dictionary.put("STKINF",MinSize.ROM);
    dictionary.put("ZLIT",MinSize.ROM);
    dictionary.put(".rodata",MinSize.ROM);
    dictionary.put(".data_init",MinSize.ROM);
    dictionary.put("BAT",MinSize.ROM);
    dictionary.put("AAT",MinSize.ROM);
    
    dictionary.put("ABSOLUTE",MinSize.RAM);
    dictionary.put("CODE_I",MinSize.RAM);
    dictionary.put("CSTACK",MinSize.RAM);
    dictionary.put("RSTACK",MinSize.RAM);
    dictionary.put("STACK",MinSize.RAM);
    dictionary.put("DATA_AN",MinSize.RAM);
    dictionary.put("DATA_I",MinSize.RAM);
    dictionary.put("DATA_Z",MinSize.RAM);
    dictionary.put("INIT",MinSize.RAM);
    dictionary.put("INITB",MinSize.RAM);
    dictionary.put("INITW",MinSize.RAM);
    dictionary.put("NEAR_I",MinSize.RAM);
    dictionary.put("NEAR_Z",MinSize.RAM);
    dictionary.put("PCB",MinSize.RAM);
    dictionary.put("PSR",MinSize.RAM);
    dictionary.put("SAV",MinSize.RAM);
    dictionary.put("SIF",MinSize.RAM);
    dictionary.put("VAR",MinSize.RAM);
    dictionary.put("VARB",MinSize.RAM);
    dictionary.put("VARW",MinSize.RAM);
    dictionary.put(".data",MinSize.RAM);
    dictionary.put(".bss",MinSize.RAM);
    dictionary.put(".noinit",MinSize.RAM);
    dictionary.put(".stack",MinSize.RAM);
    dictionary.put("LAREBUFFERS",MinSize.RAM);
    dictionary.put("APP_RAM",MinSize.RAM);
    dictionary.put("DEBUG_CHANNEL",MinSize.RAM);
    dictionary.put("EMHEAP",MinSize.RAM);
    dictionary.put("GAURD_REGION",MinSize.RAM);
    dictionary.put("RESETINFO",MinSize.RAM);
  }
  
  public static void main(String[] args){
    new MemUse(args);
  }
  
  enum MinSize {
    CODE(1000,100),
      ROM(100,10),
      RAM(100,10);
    int module;
    int entry;
    private MinSize(int module, int entry){
      this.module = module;
      this.entry = entry;
    }
    public int getModule(){
      return this.module;
    }
    public int getEntry(){
      return this.module;
    }
  }
}