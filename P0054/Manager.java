/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0054;
/**
 *
 * @author FPT
 */
import java.util.ArrayList;


public class Manager {
    // Hiển thị menu
    public static int menu() {
        System.out.println("1. Thêm liên hệ.");
        System.out.println("2. Hiển thị tất cả liên hệ.");
        System.out.println("3. Xóa liên hệ.");
        System.out.println("4. Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
        int choice = Validation.checkInputIntLimit(1, 4);
        return choice;
    }

    // Cho phép người dùng tạo liên hệ
    public static void createContact(ArrayList<Contact> contactList) {
        System.out.print("Nhập id liên hệ: ");
        int contactId = Validation.checkInputInt();
        System.out.print("Nhập họ: ");
        String firstName = Validation.checkInputString();
        System.out.print("Nhập tên: ");
        String lastName = Validation.checkInputString();
        System.out.print("Nhập nhóm: ");
        String group = Validation.checkInputString();
        System.out.print("Nhập địa chỉ: ");
        String address = Validation.checkInputString();
        System.out.print("Nhập số điện thoại: ");
        String phone = Validation.checkInputPhone();
        contactList.add(new Contact(contactId, firstName + lastName, group, address,
                phone, firstName, lastName));
        System.err.println("Thêm thành công.");
    }

    // Cho phép người dùng hiển thị tất cả liên hệ
    public static void printAllContact(ArrayList<Contact> contactList) {
        System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Họ và tên",
                "Họ", "Tên", "Nhóm", "Địa chỉ", "Số điện thoại");
        // In thông tin của các liên hệ từ đầu đến cuối danh sách liên hệ
        for (Contact contact : contactList) {
            System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n",
                    contact.getContactId(), contact.getFullName(),
                    contact.getFirstName(), contact.getLastName(),
                    contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
    }

    // Cho phép người dùng xóa liên hệ
    public static void deleteContact(ArrayList<Contact> contactList) {
        System.out.print("Nhập id: ");
        int idDelete = Validation.checkInputInt();
        Contact contactDelete = getContactById(contactList, idDelete);
        if (contactDelete == null) {
            System.err.println("Không tìm thấy liên hệ.");
            return;
        } else {
            contactList.remove(contactDelete);
        }
        System.err.println("Xóa thành công.");
    }

    // Lấy liên hệ theo id
    public static Contact getContactById(ArrayList<Contact> contactList, int idDelete) {
        for (Contact contact : contactList) {
            if (contact.getContactId() == idDelete) {
                return contact;
            }
        }
        return null;
    }
}





