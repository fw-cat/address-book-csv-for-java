package jp.ac.ohara;

public class AddressBook {
  private String name;
  private String mailAddress;
  private String phoneNumber;
  private String addressString;

  public AddressBook(String name, String mailAddress, String phoneNumber, String addressString) {
    this.name = name;
    this.mailAddress = mailAddress;
    this.phoneNumber = phoneNumber;
    this.addressString = addressString;
  }

  public AddressBook(String[] args) {
    this.name = args[0];
    this.mailAddress = args[1];
    this.phoneNumber = args[2];
    this.addressString = args[3];
  }

  public String getCsvLine() {
    return String.format("%s,%s,%s,%s",
      this.name,
      this.mailAddress,
      this.phoneNumber,
      this.addressString);
  }

  public String detail() {
    return String.format("[名前]::%s\n[メールアドレス]::%s\n[電話番号]::%s\n[住所]::%s",
      this.name,
      this.mailAddress,
      this.phoneNumber,
      this.addressString);
  }

  @Override
  public String toString() {
      return String.format("[%s]::%s", this.name, this.mailAddress);
  }
}
