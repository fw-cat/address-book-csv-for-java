import java.util.Scanner;

import jp.ac.ohara.AddressBook;
import jp.ac.ohara.AddressBookManager;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    AddressBookManager bookManager = new AddressBookManager();

    while(true) {
      System.out.println("メニュー一覧 --------------------");
      System.out.println("1. 連絡先の一覧を表示");
      System.out.println("2. 連絡先の詳細を表示");
      System.out.println("3. 連絡先の追加");
      System.out.println("4. 連絡先の削除");
      System.out.println("9. システムの終了");
      System.out.print("実行するメニューを選択してください：：");

      int menu = Integer.parseInt(scanner.nextLine());
      if (menu == 1) {
        // 一覧表示
        bookManager.list();

      } else if(menu == 2) {
        // 詳細表示
        System.out.print("表示する連絡先の番号を指定してください：：");
        int index = Integer.parseInt(scanner.nextLine());
        bookManager.detail(index);

      } else if(menu == 3) {
        // 追加
        System.out.print("名前を入力してください：：");
        String name = scanner.nextLine();

        System.out.print("メールアドレスを入力してください：：");
        String mailAddress = scanner.nextLine();

        System.out.print("電話番号を入力してください：：");
        String phoneNumber = scanner.nextLine();

        System.out.print("住所を入力してください：：");
        String address = scanner.nextLine();

        bookManager.add(new AddressBook(name, mailAddress, phoneNumber, address));
        System.out.println("追加が完了しました");

      } else if(menu == 4) {
        System.out.print("削除する連絡先の番号を指定してください：：");
        int index = Integer.parseInt(scanner.nextLine());
        bookManager.delete(index);

      } else if (menu == 9) {
        // システムの終了
        bookManager.save();
        break;

      } else {
        System.out.println("選択したメニューは存在しません");
      }
      System.out.println();
    }
    scanner.close();
  }
}