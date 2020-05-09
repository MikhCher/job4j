import javax.swing.*;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Tree {
    private static final Tree tree = new Tree();
    public static Member root = new Member("void");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    Tree.tree.fillTree();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void fillTree() {

        loadAllMembers();
        Member newMember = createMember();
        addMemberToBase(newMember);
    }

    private Member createMember() {
        Scanner sc = new Scanner(System.in);
        Member member = new Member();

        System.out.println("Имя");
        member.setName(sc.nextLine());

        System.out.println("Фамилия");
        member.setSurname(sc.nextLine());

        System.out.println("Отчество");
        member.setPatronymic(sc.nextLine());

        System.out.println("Дата рождения");
        member.setBirth(sc.nextLine());

        System.out.println("Дата смерти");
        member.setDeath(sc.nextLine());

        System.out.println("Дети (имя, фамилия) через запятую");
        String str = sc.nextLine();
        if (!str.isEmpty()) {
            String[] child = str.split(",");
            for (String ch : child) {
                List<Member> found = Member.findMember(ch.substring(0, ch.indexOf(" ")), ch.substring(ch.indexOf(" ") + 1));
                if (found.size() == 0) {
                    member.addChildren(List.of(new Member(ch.substring(0, ch.indexOf(" ")), ch.substring(ch.indexOf(" ") + 1))));
                } else {
                    int i = 1;
                    System.out.println("Добавить в список родителей для:");
                    for (Member mem : found) {
                        System.out.printf("%d. %s\n\n", i++, mem.toString());
                    }
                    System.out.printf("%d. Создать новую запись\n", i);
                    int choose = sc.nextInt();
                    sc.nextLine();
                    if (choose == i) {
                        member.addChildren(List.of(new Member(ch.substring(0, ch.indexOf(" ")), ch.substring(ch.indexOf(" ") + 1))));
                    } else {
                        found.get(choose - 1).addParents(List.of(member));
                        member.addChildren(List.of(found.get(choose - 1)));
                    }
                }
            }
        }

        System.out.println("Родители (имя фамилия) через запятую");
        str = sc.nextLine();
        if (!str.isEmpty()) {
            String[] parents = str.split(",");
            for (String parent : parents) {
                List<Member> found = Member.findMember(parent.substring(0, parent.indexOf(" ")), parent.substring(parent.indexOf(" ") + 1));
                if (found.size() == 0) {
                    member.addChildren(List.of(new Member(parent.substring(0, parent.indexOf(" ")), parent.substring(parent.indexOf(" ") + 1))));
                } else {
                    int i = 1;
                    System.out.println("Добавить в список детей для:\n");
                    for (Member mem : found) {
                        System.out.printf("%d. %s\n\n", i++, mem.toString());
                    }
                    System.out.printf("%d. Создать новую запись", i);
                    int choose = sc.nextInt();
                    sc.nextLine();
                    if (choose == i) {
                        member.addChildren(List.of(new Member(parent.substring(0, parent.indexOf(" ")), parent.substring(parent.indexOf(" ") + 1))));
                    } else {
                        found.get(choose - 1).addChildren(List.of(member));
                        member.addParents(List.of(found.get(choose - 1)));
                    }
                }
            }
        }

        return member;
    }

    private void loadAllMembers()  {
        File file = new File("src\\main\\resources\\familyMembers.txt");
        if (file.length() == 0) {
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Member member;
            try {
                while ((member = (Member) ois.readObject()) != null) {
                    if (member.isRoot()) {
                        root.addParents(List.of(member));
                    }
                }
            } catch (EOFException e) {
                ois.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addMemberToBase(Member member)  {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\main\\resources\\familyMembers.txt", true))) {
            oos.writeObject(member);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
