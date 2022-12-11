package leecode.dataStructure.hashTable;

import java.util.Scanner;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class HashTableDemo {
    public static void main(String[] args) {
        EmpHashTable empHashTable = new EmpHashTable(7);

        String key ;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: add an employee");
            System.out.println("list: list all employee");
            System.out.println("find: search employee by id");
            System.out.println("quit: quit this program");
            key = scanner.next();
            switch (key) {
                case "add" -> {
                    System.out.println("Enter an employee id:");
                    int id = scanner.nextInt();
                    System.out.println("Enter an employee name:");
                    String name = scanner.next();
                    Employee employee = new Employee(id, name);
                    empHashTable.add(employee);
                }
                case "list" -> empHashTable.list();
                case "find" -> {
                    System.out.println("Please enter employee's id:");
                    int id = scanner.nextInt();
                    empHashTable.findEmployeeById(id);
                }
                case "quit" -> {
                    scanner.close();
                    System.exit(0);
                }
            }
        }

    }
}

class EmpHashTable {

    private final EmpLinkedList[] empLinkedListArray;
    private final int size; //表示有多少條鏈表

    public EmpHashTable(int size) {
        this.size = size;
        this.empLinkedListArray = new EmpLinkedList[size];
        //重要，初始化每一條鏈表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    /**
     * 添加員工
     * 1. 根據員工id，得到該員工應添加到哪條鏈表
     *
     * @param employee 新增的員工
     */
    public void add(Employee employee) {
        int empLinkedListNo = hash(employee.id);
        //將員工添加到對應的鏈表中
        empLinkedListArray[empLinkedListNo].add(employee);
    }

    /**
     * 遍歷所有的HashTable
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    /**
     * 根據id查找員工
     * 1. 根據員工id，得到該員工應添加到哪條鏈表
     *
     * @param id 員工編號
     */
    public void findEmployeeById(int id) {
        int employeeListNo = hash(id);
        Employee employee = empLinkedListArray[employeeListNo].findEmployeeById(id);
        if (employee != null) {
            System.out.println("This employee is in " + (employeeListNo + 1) + " list.");
            System.out.printf("id = %d, name = %s.\n", employee.id, employee.name);
        } else {
            System.out.println("This employee is not existing in this hash table.");
        }
    }

    private int hash(int id) {
        return id % size;
    }
}

class Employee {
    public int id;
    public String name;
    public Employee next;

    public Employee(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

//創建EmpLinkedList，表示鏈表
class EmpLinkedList {
    //頭指針，指向第一個Emp，因此這個鏈表的head是直接指向低一個Emp
    private Employee head;

    /**
     * 添加員工到鏈表
     * 說明：
     * 1. 假定，當添加員工時id是自動增加，即id的分配總是從小到大
     * 因此我們將該員工直接加入到鏈表最後即可
     *
     * @param employee 想要新增的員工
     */
    public void add(Employee employee) {
        if (head == null) {
            head = employee;
        } else {
            Employee temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = employee;
        }
    }

    /**
     * 遍歷鏈表訊息
     */
    public void list(int no) {
        if (head == null) {
            System.out.println("The " + (no + 1) + " linkedList is null.");
            return;
        }
        Employee temp = head;
        while (true) {
            System.out.printf("=> id = %d, name = %s ", temp.id, temp.name);
            if (temp.next == null) {
                System.out.println();
                //表示temp已經是最後節點
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 根據id查找員工
     *
     * @param id 員工編號
     * @return 員工，若找不到該員工則返回null
     */
    public Employee findEmployeeById(int id) {
        //判斷鏈表是否為空
        if (head == null) {
            System.out.println("This Linked List is empty");
            return null;
        }
        Employee temp = head;
        while (true) {
            if (temp.id == id) {
                return temp;
            } else if (temp.next == null) {
                return null;
            } else {
                temp = temp.next;
            }
        }
    }
}

