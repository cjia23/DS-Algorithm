package data_structure.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String [] args){
        //testing
        //create node
        HeroNode hero1 = new HeroNode(1,"songjiang","jishiyu");
        HeroNode hero2 = new HeroNode(2,"lujunyi","yuqilin");
        HeroNode hero3 = new HeroNode(3,"wuyong","zhiduoxing");
        HeroNode hero4 = new HeroNode(4,"linchong","baozitou");


        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //singleLinkedList.add(hero1);
        //singleLinkedList.add(hero2);
        //singleLinkedList.add(hero3);
        //singleLinkedList.add(hero4);

        //add by order
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero4);
        //singleLinkedList.addByOrder(hero1);
        //print out

        //singleLinkedList.list();

       // System.out.println("After operation: ");
        //singleLinkedList.del(4);
        singleLinkedList.list();

        //System.out.println("the length of the linked list is " + getLength(singleLinkedList.getHead()));

        //check if found the last k element
        HeroNode res = findLastIndexNode(singleLinkedList.getHead(),1);
        System.out.println("res = "+ res);

        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();
        reversePrint(singleLinkedList.getHead());

    }

    //method to get number of node (if with head node, need to not include head node in the count)
    public static int getLength(HeroNode head){
        if(head.next == null){
            return 0;
        }
        int length = 0;
        //define an assistance
        //node include head node, that's why head.next
        HeroNode cur = head.next;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }

    //get the kth node from the end
    /**
     * 1. method to get head and index
     * 2. index means the index-th of the node staring from the end
     * 3. loop from start to end, get the total length of list. getLength()
     * 4. got the size, loop starting from the beginning (size-index)th, so will get the node
     * 5. if found return the node, else return null
     * **/
    public static HeroNode findLastIndexNode(HeroNode head, int index){
        if (head.next == null ) return null;
        //loop to get total length
        int size = getLength(head);

        //loop second time to size-index position
        //make a index check
        if(index <= 0 || index > size){
            return null;
        }
        //define a temp node
        HeroNode cur = head.next;
        for(int i = 0; i < size - index; i++){
            cur = cur.next;
        }
        return cur;
    }

    //reverse the linked list
    public static void reverseList(HeroNode head){
        //if it it empty or it only has one node, no need to reverse
        if(head.next == null || head.next.next == null) {
            return;
        }

        //define an assistance pointer
        HeroNode cur = head.next;
        HeroNode next = null; //define pointing to the next node of current node
        HeroNode reverseHead = new HeroNode(0,"","");

        //loop the original linked list
        while(cur != null){
            next = cur.next; //store the next node to next
            cur.next = reverseHead.next; // make the cur next node to the head of the new list
            reverseHead.next = cur;
            cur = next;//move backward
        }
        //head.next = reversHead.next;
        head.next = reverseHead.next;
    }

    /**
     * 1. using stack to store all the data. Stack is first in, last out to realize the reverse order printing
     * **/
    public static void reversePrint(HeroNode head){
        if(head.next == null){
            return;//empty list
        }
        //create a Stack, get all the node to the stack
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while(cur != null){
            stack.push(cur);
            cur = cur.next; //move the current backward
        }
        //loop and print the stack
        while(stack.size() > 0){
            System.out.println(stack.pop());//Stack is to first in, last out
        }
    }
}

//Define SingleLinkedlist to manage our heroes
class SingleLinkedList {
    //initialize the head node. head node cannot move; do not store actual node
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    //add node
    //thoughts: when not considering the sequence
    //1. find the last node
    //2. link that node's next to the new node
    public void add(HeroNode heroNode){
        //as head node cannot move, we need a assistance node
        HeroNode temp = head;
        //loop through the linked list
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        //when the while loop ends, temp is pointing to the last node
        temp.next = heroNode;
    }

    //second way to add, add based on order of no.
    public void addByOrder(HeroNode heroNode){
        //because head node cannot move
        //because it is a single liked list, we have to find the temp positioned the previous node of where we want to insert
        //
        HeroNode temp = head;
        boolean flag = false; //mark to detect if the added the no. has existed
        while(true){
            if(temp.next == null ){
                break;
            }
            if(temp.next.no > heroNode.no){
                //found the position, just after the temp
                break;
            } else if (temp.next.no == heroNode.no){
                //the no has already existed
                flag = true;
                break;
            }
            temp = temp.next; // move backward
        }
        //check the value of falg
        if(flag){
            //cannot add, already exist
            System.out.printf("The hero no %d has already existed.\n",heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //based on no, to modify the info
    public void update(HeroNode newHeroNode){
        //based on newHeroNode to update
        if(head.next == null) {
            System.out.println("the linked list is empty");
            return;
        }

        //based on need, find the node to modify
        //define a temp node
        HeroNode temp = head.next;
        boolean flag = false; // check if found
        while (true){
            if (temp == null){
                break; //reaching the end of the list
            }
            if(temp.no == newHeroNode.no){
                //it is the node
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //based on flag to check if found
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else{
            //not found
            System.out.printf("Haven't found the no. %d, cannot modify\n", newHeroNode.no);
        }
    }

    //delete node
    //thoughts. 1. head cannot move, need a temp node to assist to find the previous of the node to be deleted
    //2. when we compare, temp.next.no compared to the no of the node to be deleted
    public void del(int no){
        HeroNode temp = head;
        boolean flag = false; //mark if we find the previous node
        while (true){
            if(temp.next == null){
                //end of the linkedlist
                break;
            }
            if(temp.next.no == no){
                //found
                flag = true;
                break;
            }
            temp = temp.next; //move backward
        }
        if(flag){
            //found
            temp.next = temp.next.next;
        } else{
            System.out.println("The node to be deleted hasn't been found.");
        }
    }


    //show the whole linked list
    public void list(){
        if(head.next == null) {
            System.out.println("the linked list is empty");
            return;
        }
        HeroNode temp = head.next;
        while(true){
            //print out the node value
            System.out.println(temp);
            //check if it is the end of the linkedlist
            if(temp.next == null){
                break;
            }
            //move backward temp.next
            temp = temp.next;
        }
    }

}

//define the HeroNode
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //pointing to the next node

    //constructor
    public HeroNode(int no, String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    //we reconstruct the toString method
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\''+
                '}';
    }
}
