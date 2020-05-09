import java.io.Serializable;
import java.util.*;

public class Member implements Serializable {
    private static final long serialVersionUID = 4634143778938791066L;

    private String name;
    private String surname;
    private String patronymic;
    private String birth;
    private String death;
    private final List<Member> children = new ArrayList<>();
    private final List<Member> parents = new ArrayList<>();
    private boolean isRoot = false;

    public Member() {
    }

    public Member(String str) {
        if (str.equals("void")) {
            name = "";
            surname = "";
            patronymic = "";
            birth = "";
            death = "";

        }
    }

    public Member(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public static List<Member> findMember(String name, String surname) {
        List<Member> rsl = new ArrayList<>();
        Queue<Member> data = new LinkedList<>();
        data.offer(Tree.root);
        while (!data.isEmpty()) {
            Member member = data.poll();
            if (member.name.equals(name) && member.surname.equals(surname)) {
                rsl.add(member);
                break;
            }
            data.addAll(member.parents);
        }
        return rsl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(surname).append(" ").append(name).append(" ").append(patronymic);
        sb.append(System.lineSeparator()).append("Дети: ");

        for (Member member : children) {
            sb.append(member.name).append(" ").append(member.surname).append(", ");
        }

        sb.append(System.lineSeparator()).append("Родители: ");
        for (Member member : children) {
            sb.append(member.name).append(" ").append(member.surname).append(", ");
        }
        return sb.toString();
    }

    // public void setData(Map<Data, String> data) {
   //     name = data.get(Data.NAME);
   //     surname = data.get(Data.SURNAME);
   //     patronymic = data.get(Data.PATRONYMIC);
   //     birth = data.get(Data.BIRTH);
   //     death = data.get(Data.DEATH);
   //     if (!data.get(Data.CHILDREN).isEmpty()) {
   //         String[] childrenArray = data.get(Data.CHILDREN).split(",");
   //         for (String child : childrenArray) {
   //             String name = child.substring(0, child.indexOf(" ") - 1);
   //             String surname = child.substring(child.indexOf(" "));
   //             Member member;
   //             if ((member = findMember(name, surname)) == null) {
   //                 member = new Member();
   //                 member.setName(name);
   //                 member.setSurname(surname);
   //                 member.addParent(this);
   //             }
   //             this.children.add(member);
   //         }
   //     }
   //     if (!data.get(Data.PARENTS).isEmpty()) {
   //         String[] parentsArray = data.get(Data.PARENTS).split(",");
   //         for (String parent : parentsArray) {
   //             String name = parent.substring(0, parent.indexOf(" "));
   //             String surname = parent.substring(parent.indexOf(" ") + 1);
   //             Member member;
   //             if ((member = findMember(name, surname)) == null) {
   //                 member = new Member();
   //                 member.setName(name);
   //                 member.setSurname(surname);
   //                 member.addChildren(this);
   //             }
   //             this.parents.add(member);
   //         }
   //     }
   // }

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }

    public void addChildren(List<Member> child) {
        this.children.addAll(child);
    }

    public void addParents(List<Member> parents) {
        this.parents.addAll(parents);
    }

    public List<Member> getChildren() {
        return children;
    }

    public List<Member> getParents() {
        return parents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }
}
