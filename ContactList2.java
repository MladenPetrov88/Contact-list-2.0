import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ContactList2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> contacts = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String line = scanner.nextLine();

        while (!line.equals("Print Normal")&&!line.equals("Print Reversed")){
            String [] token = line.split("\\s+");
            String command = token[0];
            switch (command){
                case "Add":{
                    String contact = token[1];
                    int index = Integer.parseInt(token[2]);
                    if (contacts.contains(contact)){
                        if (index>=0&&index<contacts.size()){
                            contacts.add(index,contact);
                        }
                    }else {
                        contacts.add(contact);
                    }
                    break;
                }
                case "Remove":{
                    int index = Integer.parseInt(token[1]);
                    if (index>=0&&index<contacts.size()){
                        contacts.remove(index);
                    }
                    break;
                }
                case "Export":{
                    int startIndex = Integer.parseInt(token[1]);
                    int count = Integer.parseInt(token[2]);

                    if (startIndex + count<contacts.size()){
                        for (int j = startIndex; j <startIndex + count ; j++) {
                            System.out.print(contacts.get(j) + " ");
                        }
                        System.out.println();
                    }else {
                        for (int i = startIndex; i <contacts.size() ; i++) {
                            System.out.print(contacts.get(i) + " ");
                        }
                        System.out.println();
                    }
                    break;
                }

            }

            line = scanner.nextLine();
        }
        if (line.equals("Print Normal")) {
            System.out.print("Contacts: ");
            for (int i = 0; i < contacts.size(); i++) {
                System.out.print(contacts.get(i) + " ");
            }
        }
        else {
            System.out.print("Contacts: ");
            for (int i = contacts.size()-1; i >=0 ; i--) {
                System.out.print(contacts.get(i) + " ");
            }

        }

    }
}

