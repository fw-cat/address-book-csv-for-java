package jp.ac.ohara;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookManager {
  private static final String CSV_FILE = "address.csv";

  private List<AddressBook> addressesBooks = new ArrayList<AddressBook>();

  public AddressBookManager() {
    try (BufferedReader br = new BufferedReader(new FileReader(AddressBookManager.CSV_FILE))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] values = line.split(",");

        // values配列には、CSVの各列の値が含まれます
        this.addressesBooks.add(new AddressBook(values));
      }
    } catch (FileNotFoundException e) {
      // ファイルがない場合は何もしない
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void list() {
    System.out.println("一覧表示 --------------------");
    for (AddressBook address : this.addressesBooks) {
      System.out.println(address.toString());
    }
    System.out.println("----------------------------");
  }

  public void detail(int index) {
    System.out.println("詳細表示 --------------------");
    System.out.println(this.addressesBooks.get(index-1).detail());
    System.out.println("----------------------------");
  }

  public void add(AddressBook address) {
    this.addressesBooks.add(address);
  }

  public void delete(int index) {
    this.addressesBooks.remove(index-1);
  }

  public void save() {
    try (FileWriter writer = new FileWriter(AddressBookManager.CSV_FILE)) {
      // 他のデータを追加する場合は、以下のように行を追加します

      for (AddressBook address : this.addressesBooks) {
        writer.append(address.getCsvLine());
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
